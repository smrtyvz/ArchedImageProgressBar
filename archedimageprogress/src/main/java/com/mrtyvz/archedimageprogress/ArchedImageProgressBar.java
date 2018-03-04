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
    private int startAngle = 240;
    private int progressAngle = 100;

    private RectF oval = new RectF();
    private RectF bitmapOval = new RectF();
    private float circleRadius;
    private float archRadius;
    private float mImageRadius;
    private int circleColor;
    private int archColor;
    private int arcSpeed = 5;
    private float arcStrokeWidth = 10.0f;

    private Paint mTextPaint;
    private boolean mDrawText = true;
    private float mValue = 0f;
    private float mPhase = 0f;
    private float mStepSize = 1f;
    private float mTextSize;
    private String[] mCustomText = null;

    private Bitmap mBitmap;


    public ArchedImageProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.paint.setStyle(Paint.Style.STROKE);
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

        this.paint.setFlags(1);
        this.paint.setColor(this.circleColor);
        this.paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle((float) (this.getWidth() / 2), (float) (this.getHeight() / 2), this.circleRadius, this.paint);

        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setColor(this.archColor);
        this.paint.setStrokeWidth(this.arcStrokeWidth);
        this.oval.set((float) (this.getWidth() / 2) - this.archRadius, (float) (this.getHeight() / 2) - this.archRadius, (float) (this.getWidth() / 2) + this.archRadius, (float) (this.getHeight() / 2) + this.archRadius);
        canvas.drawArc(this.oval, (float) this.startAngle, (float) this.progressAngle, false, this.paint);

        this.bitmapOval.set((float) (this.getWidth() / 2) - this.mImageRadius, (float) (this.getHeight() / 2) - this.mImageRadius, (float) (this.getWidth() / 2) + this.mImageRadius, (float) (this.getHeight() / 2) + this.mImageRadius);

        if (mBitmap != null)
            canvas.drawBitmap(mBitmap, null, bitmapOval, this.bitmapPaint);

        if (mDrawText) {
            if (mCustomText != null) {
                drawCustomText(canvas);
            }
        }
    }

    private void initPaintText() {
        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setStyle(Paint.Style.STROKE);
        mTextPaint.setTextAlign(Paint.Align.CENTER);
        mTextPaint.setColor(Color.BLACK);
    }

    private void drawCustomText(Canvas c) {
        int index = (int) ((mValue * mPhase) / mStepSize);
        if (index < mCustomText.length) {
            c.drawText(mCustomText[index], getWidth() / 2,
                    getHeight() / 2 + mTextPaint.descent(), mTextPaint);
        }
    }

    Runnable progressAnimator = new Runnable() {
        public void run() {
            if (ArchedImageProgressBar.this.startAngle >= 1) {
                ArchedImageProgressBar.this.startAngle = ArchedImageProgressBar.this.startAngle - arcSpeed;
            } else {
                ArchedImageProgressBar.this.startAngle = 360;
            }

            ArchedImageProgressBar.this.invalidate();
            ArchedImageProgressBar.this.postDelayed(this, 15L);
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

    public void setArcColor(int color) {
        this.archColor = color;
    }

    public void setArcLength(int length) {
        this.progressAngle = length;
    }

    public void setArcStroke(float stroke) {
        this.arcStrokeWidth = stroke;
    }

    public void setProgressTextSize(float textSize) {
        this.mTextSize = textSize;
        mTextPaint.setTextSize(Utils.convertDpToPixel(getResources(), mTextSize));
    }

    public void setCircleSize(float size) {
        this.circleRadius = Utils.convertDpToPixel(getResources(), size);
    }

    public void setArcSize(float size) {
        this.archRadius = Utils.convertDpToPixel(getResources(), size);
    }

    public void setArcSpeed(int speed) {
        this.arcSpeed = speed;
    }

    static abstract class Utils {
        static float convertDpToPixel(Resources r, float dp) {
            DisplayMetrics metrics = r.getDisplayMetrics();
            float px = dp * (metrics.densityDpi / 160f);
            return px;
        }
    }

}
