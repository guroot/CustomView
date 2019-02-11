package com.jonathan.customview.views;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import com.jonathan.customview.R;

public class BarChart extends View {
    private int[] mValues;

    public BarChart(Context context) {
        super(context);
    }

    public BarChart(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.barchart,
                0, 0);

        Resources res = getResources();
        mValues = res.getIntArray(R.array.barchart_values);

        a.recycle();
    }

    public void setValeurs(int[] values) {
        mValues = values;
        invalidate();
        requestLayout();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setColor(getResources().getColor(R.color.colorPrimaryDark));
        for(int i =0;i<mValues.length;i++) {
            // La largeur des barres est de 60 et 10 les séparrent
            canvas.drawRect(
                    new Rect((i*60)+10,
                            canvas.getHeight()-mValues[i],
                            (i*60) + 60,canvas.getHeight()),
                    paint
            );
        }

    }
}
