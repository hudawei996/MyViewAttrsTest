package huyongqiang.com.myviewattrstest;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by huyongqiang on 16/8/11.
 */
public class MyView extends View {
    private Paint mPaint;
    private Context mContext;
    private static final String mString = "Welcome to Mr Wei's blog";

    //构造函数一:上下文
    public MyView(Context context) {
        super(context);
        //画笔
        mPaint = new Paint();
    }

    //构造函数二,上下文+属性集
    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //画笔
        mPaint = new Paint();

        //读取自定义属性集合
        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.MyView);
        //获取单个属性集合,设置默认值.颜色值
        int textColor = a.getColor(R.styleable.MyView_textColor,
                0XFFFFFFFF);
        //获取单个属性集合,设置默认值.距离值
        float textSize = a.getDimension(R.styleable.MyView_textSize, 36);

        //将两个属性使用到画笔上
        mPaint.setTextSize(textSize);
        mPaint.setColor(textColor);

        //属性集回收,节约资源
        a.recycle();
    }

    /**
     * 开始在画板上绘制
     *
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);
        //设置画笔的绘画效果,填充
        //mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStyle(Paint.Style.STROKE);

        //画布调用画矩形方法(定义一个矩形,使用已经设置好各种属性的画笔)
        //画一个矩形,前俩个是矩形左上角坐标，后面俩个是右下角坐标
        canvas.drawRect(new Rect(10, 10, 100, 100), mPaint);

        //设置画笔颜色
        mPaint.setColor(Color.BLUE);
        //再次绘制文字
        canvas.drawText(mString, 10, 110, mPaint);
    }
}