package com.example.jizhangdemo.login;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class NineSquare extends View {
    // 正常状态的颜色
    private static final int SELECTED_COLOR = 0xFF979797;
    // 正常状态的颜色
    private static final int NORMAL_COLOR = 0xFF70DBDB;
    private Paint mCiclePaint;
    private Paint mLinePoaint;
    private float mRadius;
    //圆心数组
    private PointView[][] mPointViewArray = new PointView[3][3];
    //保存选中点的集合
    private ArrayList<PointView> mSelectedPointViewList;
    //解锁团的边长
    private int mPatternWidth;
    //每个圆圈的下标
    private int mIndex = 1;
    //正在滑动 并且没有任何点选中
    private boolean mIsMovingWithoutCircle = false;
    //是否绘制结束
    private boolean mIsFinsihed;
    private float mCurrentX, mCurrentY;
    //图案监听器
    private OnPatternChangeListener mOnPatternChangeListener;
    //第一个点是否选中
    private boolean mIsSelected;
    public NineSquare(Context context) {
        this(context, null);
    }
    public NineSquare(Context context, AttributeSet attrs) {
        super(context, attrs);
        //圆的画笔
        mCiclePaint = new Paint();
        mCiclePaint.setAntiAlias(true);
        mCiclePaint.setDither(true);
        mCiclePaint.setColor(NORMAL_COLOR);
        mCiclePaint.setStyle(Paint.Style.FILL);
        //线的画笔
        mLinePoaint = new Paint();
        mLinePoaint.setAntiAlias(true);
        mLinePoaint.setDither(true);
        mLinePoaint.setStrokeWidth(20);
        mLinePoaint.setColor(SELECTED_COLOR);
        mLinePoaint.setStyle(Paint.Style.STROKE);

        mRadius = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, getResources().getDisplayMetrics());
        mSelectedPointViewList = new ArrayList<>();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //获取屏幕长和宽中的较小值作为图案的边长
        mPatternWidth = Math.min(getMeasuredHeight(), getMeasuredWidth());
        setMeasuredDimension(mPatternWidth, mPatternWidth);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //画圆
        drawCicle(canvas);
        //将选中的圆 重新绘制一遍  将选中的点和未选中的点区别开来
        for (PointView pointView : mSelectedPointViewList) {
            mCiclePaint.setColor(SELECTED_COLOR);
            canvas.drawCircle(pointView.x, pointView.y, mRadius, mCiclePaint);
            //每重新绘制一个，将画笔的颜色重置 保证不会影响到其他圆的绘制
            mCiclePaint.setColor(NORMAL_COLOR);
        }
        //点与点画线
        if (mSelectedPointViewList.size() > 0) {
            //第一个选中的点为A点
            Point pointViewA = (Point) mSelectedPointViewList.get(0);
            for (int i = 0; i < mSelectedPointViewList.size(); i++) {
                //其余的点为B点
                Point pointViewB = (Point) mSelectedPointViewList.get(i);
                drawLine(canvas, pointViewA, pointViewB);
                pointViewA = pointViewB;
            }
            //点于鼠标当前位置绘制轨迹
            if (mIsMovingWithoutCircle & !mIsFinsihed) {
                drawLine(canvas, pointViewA, new PointView((int) mCurrentX, (int) mCurrentY));
            }
        }
        super.onDraw(canvas);
    }

    private void drawCicle(Canvas canvas) {
        //canvas 画布
        //初始点的位置
        for (int i = 0; i < mPointViewArray.length; i++) {
            for (int j = 0; j < mPointViewArray.length; j++) {
                //圆心坐标
                int cx = mPatternWidth / 4 * (j + 1);
                int cy = mPatternWidth / 4 * (i + 1);
                //将圆心放在一个点数组中
                PointView pointView = new PointView(cx, cy);
                pointView.setIndex(mIndex);
                mPointViewArray[i][j] = pointView;
                canvas.drawCircle(cx, cy, mRadius, mCiclePaint);
                mIndex++;
            }
        }
        mIndex = 1;
    }

    private void drawLine(Canvas canvas, Point pointA, Point pointB) {
        canvas.drawLine(pointA.x, pointA.y, pointB.x, pointB.y, mLinePoaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mCurrentX = event.getX();
        mCurrentY = event.getY();
        PointView selectedPointView = null;
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //重新绘制
                if (mOnPatternChangeListener != null) {
                    mOnPatternChangeListener.onPatternStarted(true);
                }
                mSelectedPointViewList.clear();
                mIsFinsihed = false;
                selectedPointView = checkSelectPoint();
                if (selectedPointView != null) {
                    //第一次按下的位置在圆内，被选中
                    mIsSelected = true;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (mIsSelected) {
                    selectedPointView = checkSelectPoint();
                }
                if (selectedPointView == null) {
                    mIsMovingWithoutCircle = true;
                }
                break;
            case MotionEvent.ACTION_UP:
                mIsFinsihed = true;
                mIsSelected = false;
                break;
        }
        //将选中的点收藏起来
        if (!mIsFinsihed && mIsSelected && selectedPointView != null) {
            if (!mSelectedPointViewList.contains(selectedPointView)) {
                mSelectedPointViewList.add(selectedPointView);
            }
        }
        if (mIsFinsihed) {
            if (mSelectedPointViewList.size() == 1) {
                mSelectedPointViewList.clear();
            } else if (mSelectedPointViewList.size() < 5 && mSelectedPointViewList.size() > 0) {
                //绘制错误
                if (mOnPatternChangeListener != null) {
                    mOnPatternChangeListener.onPatternChange(null);
                }
            } else {
                //绘制成功
                String patternPassword = "";
                if (mOnPatternChangeListener != null) {
                    for (PointView pointView : mSelectedPointViewList) {
                        patternPassword += pointView.getIndex();
                    }
                    if (!TextUtils.isEmpty(patternPassword)) {
                        mOnPatternChangeListener.onPatternChange(patternPassword);
                    }
                }
            }
        }
        invalidate();
        return true;
    }

    private PointView checkSelectPoint() {
        for (int i = 0; i < mPointViewArray.length; i++) {
            for (int j = 0; j < mPointViewArray.length; j++) {
                PointView pointView = mPointViewArray[i][j];
                if (isWithInCircle(mCurrentX, mCurrentY,pointView.x,pointView.y,mRadius)) {
                    return pointView;
                }
            }
        }
        return null;
    }

    private boolean isWithInCircle(float mCurrentX, float mCurrentY, int x, int y, float mRadius) {
        //如果点和圆心的距离 小于半径，则证明在圆内
        if (Math.sqrt(Math.pow(x - mCurrentX, 2) + Math.pow(y - mCurrentY, 2)) < mRadius) {
            return true;
        }
        return false;
    }

    public void setOnPatternChangeListener(OnPatternChangeListener onPatternChangeListener) {
        if (onPatternChangeListener != null) {
            this.mOnPatternChangeListener = onPatternChangeListener;
        }
    }

    public interface OnPatternChangeListener {
        //图案改变 图案密码patternPassword
        void onPatternChange(String patternPassword);
        //图案是否重新绘制
        void onPatternStarted(boolean isStarted);
    }
}
