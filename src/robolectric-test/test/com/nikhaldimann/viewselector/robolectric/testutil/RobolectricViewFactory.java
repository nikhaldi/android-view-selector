package com.nikhaldimann.viewselector.robolectric.testutil;

import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nikhaldimann.viewselector.test.util.ViewFactory;

/**
 * A view factory for Robolectric tests that creates all views with
 * a null context.
 */
public class RobolectricViewFactory implements ViewFactory {

    public FrameLayout createFrameLayout() {
        return new FrameLayout(null);
    }

    public LinearLayout createLinearLayout() {
        return new LinearLayout(null);
    }

    public TextView createTextView() {
        return new TextView(null);
    }

}
