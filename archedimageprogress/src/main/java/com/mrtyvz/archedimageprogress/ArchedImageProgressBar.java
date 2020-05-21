package com.mrtyvz.archedimageprogress;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

/**
 * Created by mrtyvz on 04.03.2018.
 */

public class ArchedImageProgressBar extends View {
    private Paint paint = new Paint();
    private Paint bitmapPaint = new Paint();
    private RectF oval = new RectF();
    private RectF bitmapOval = new RectF();

    private int startAngle = 240;
    private int progressAngle = 100;

    private float circleRadius;
    private float archRadius;
    private float mImageRadius;
    private int circleColor;
    private int archColor;
    private int archSpeed = 5;
    private float archStrokeWidth = 10.0f;

    private Paint mTextPaint;
    private String[] mCustomText = null;
    private boolean isClockwise = false;

    private Bitmap mBitmap;

    public ArchedImageProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray defaultValuesArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.ArchedImageProgressBar, 0, 0);

        try {
            circleRadius = defaultValuesArray.getDimension(R.styleable.ArchedImageProgressBar_circle_size, 50.0F);
            circleColor = defaultValuesArray.getColor(R.styleable.ArchedImageProgressBar_circle_color, Color.parseColor("#455a64"));
            archRadius = defaultValuesArray.getDimension(R.styleable.ArchedImageProgressBar_arch_size, 70.0F);
            archColor = defaultValuesArray.getColor(R.styleable.ArchedImageProgressBar_arch_color, Color.parseColor("#004d40"));
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            defaultValuesArray.recycle();
        }
        initPaintText();
        this.post(this.progressAnimator);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        setPaintPropsForCircle(this.paint);
        canvas.drawCircle((float) (this.getWidth() / 2), (float) (this.getHeight() / 2), circleRadius, paint);
        setPaintPropsForArc(this.paint);
        canvas.drawArc(oval, (float) startAngle, (float) progressAngle, false, paint);
        setOvalPropsForArc(this.oval);
        setBitmapOvalProps(this.bitmapOval);
        setProgressImageIfProvided(canvas);
        setProgressTextIfProvided(canvas);
    }

    private void setPaintPropsForCircle(Paint paint) {
        paint.setFlags(1);
        paint.setColor(this.circleColor);
        paint.setStyle(Paint.Style.FILL);
    }

    private void setPaintPropsForArc(Paint paint) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(this.archColor);
        paint.setStrokeWidth(this.archStrokeWidth);
    }

    private void setOvalPropsForArc(RectF oval) {
        oval.set((float) (this.getWidth() / 2) - archRadius,
                (float) (this.getHeight() / 2) - archRadius,
                (float) (this.getWidth() / 2) + archRadius,
                (float) (this.getHeight() / 2) + archRadius);
    }

    private void setBitmapOvalProps(RectF bitmapOval) {
        bitmapOval.set((float) (this.getWidth() / 2) - mImageRadius,
                (float) (this.getHeight() / 2) - mImageRadius,
                (float) (this.getWidth() / 2) + mImageRadius,
                (float) (this.getHeight() / 2) + mImageRadius);
    }

    private void setProgressImageIfProvided(Canvas canvas) {
        if (mBitmap != null) {
            canvas.drawBitmap(mBitmap, null, bitmapOval, bitmapPaint);
        }
    }

    private void setProgressTextIfProvided(Canvas canvas) {
        if (mCustomText != null) {
            drawCustomText(canvas);
        }
    }

    private void initPaintText() {
        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setStyle(Paint.Style.STROKE);
        mTextPaint.setTextAlign(Paint.Align.CENTER);
        mTextPaint.setColor(Color.BLACK);
    }

    private void drawCustomText(Canvas c) {
        float mValue = 0f;
        float mPhase = 0f;
        float mStepSize = 1f;
        int index = (int) ((mValue * mPhase) / mStepSize);
        if (index < mCustomText.length) {
            c.drawText(mCustomText[index], getWidth() / 2,
                    getHeight() / 2 + mTextPaint.descent(), mTextPaint);
        }
    }

    Runnable progressAnimator = new Runnable() {
        public void run() {
            if (startAngle >= 1) {
                if (isClockwise) {
                    startAngle = startAngle + archSpeed;
                } else {
                    startAngle = startAngle - archSpeed;
                }
            } else {
                startAngle = 360;
            }
            ArchedImageProgressBar.this.invalidate();
            ArchedImageProgressBar.this.postDelayed(this, 12L);
        }
    };

    public void setProgressImage(Bitmap bitmap, float imageRadius) {
        this.mImageRadius = Utils.convertDpToPixel(getResources(), imageRadius);
        mBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), null, false);
    }

    public void setProgressText(String[] custom, @Nullable String color) {
        mCustomText = custom;
        if (color != null && mTextPaint != null)
            mTextPaint.setColor(Color.parseColor(color));
    }

    public void setCircleColor(int color) {
        this.circleColor = color;
    }

    public void setArchColor(int color) {
        this.archColor = color;
    }

    public void setArchLength(int length) {
        this.progressAngle = length;
    }

    public void setArchStroke(float stroke) {
        this.archStrokeWidth = stroke;
    }

    public void setProgressTextSize(float textSize) {
        mTextPaint.setTextSize(Utils.convertDpToPixel(getResources(), textSize));
    }

    public void setCircleSize(float size) {
        this.circleRadius =  Utils.convertDpToPixel(getResources(), size);
    }

    public void setArchSize(float size) {
        this.archRadius = Utils.convertDpToPixel(getResources(), size);
    }

    public void setArchSpeed(int speed) {
        this.archSpeed = speed;
    }

    public void setClockwise(boolean isClockwise) {
        this.isClockwise = isClockwise;
    }

    static abstract class Utils {
        static float convertDpToPixel(Resources r, float dp) {
            DisplayMetrics metrics = r.getDisplayMetrics();
            return dp * (metrics.densityDpi / 160f);
        }
    }

}
