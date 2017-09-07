package com.example.eve.customviewdemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Eve on 9/7/17.
 */

public class ColorOptionsView extends android.support.v7.widget.AppCompatTextView {

    private String titleText;
    private boolean color;

    public ColorOptionsView(Context context) {
        super(context);
        setColorOptionsView();
    }

    public ColorOptionsView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs,
                R.styleable.ColorOptionsView);
        int count = typedArray.getIndexCount();
        try {

            for (int i = 0; i < count; ++i) {

                int attr = typedArray.getIndex(i);

                if (attr == R.styleable.ColorOptionsView_title) {

                    titleText = typedArray.getString(attr);
                    setColorOptionsView();
                } else if (attr == R.styleable.ColorOptionsView_setColor) {

                    color = typedArray.getBoolean(attr, false);
                    decorateText();
                }
            }
        } finally {
            typedArray.recycle();
        }
    }

    public ColorOptionsView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setColorOptionsView();
    }

    private void setColorOptionsView() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
        String time = dateFormat.format(Calendar.getInstance().getTime());

        if (this.titleText != null)
            setText(this.titleText + " " + time);
        else
            setText(time);
    }

    private void decorateText() {

        if (this.color == true) {

            setShadowLayer(4, 2, 2, Color.rgb(250, 00, 250));
            setBackgroundColor(Color.CYAN);
        } else {
            setBackgroundColor(Color.RED);
        }
    }

}
