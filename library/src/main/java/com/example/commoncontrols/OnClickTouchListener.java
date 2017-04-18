package com.example.commoncontrols;

import android.view.MotionEvent;
import android.view.View;

/**
 * Custom OnTouchListener which detects if the touch event is actually a click event.
 * This can be used to combine the functionality of OnTouch and OnClick events.
 * Useful to listen for the first click on an edit-text, where edit-text takes focus and does not trigger onClick event.
 */

public abstract class OnClickTouchListener implements View.OnTouchListener {
    private float x;
    private float y;
    private boolean shouldClick;

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            shouldClick = true;
            x = event.getX();
            y = event.getY();
        } else if (event.getAction() == MotionEvent.ACTION_UP && shouldClick) {
            if (x == event.getX() && y==event.getY()) {
                onClick(v);
            }
        }
        return false;
    }

    public abstract void onClick(View v);
}
