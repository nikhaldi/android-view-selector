package com.nikhaldimann.viewselector.robolectric.testutil;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nikhaldimann.viewselector.test.util.ViewFactory;
import com.xtremelabs.robolectric.Robolectric;

/**
 * A view factory for Robolectric tests that creates all views with
 * a null context.
 */
public class RobolectricViewFactory implements ViewFactory {

    private final Context context;

    public RobolectricViewFactory() {
        context = Robolectric.application;
    }

    public FrameLayout createFrameLayout() {
        return new FrameLayout(context);
    }

    public LinearLayout createLinearLayout() {
        return new LinearLayout(context);
    }

    public TextView createTextView() {
        return new TextView(context);
    }

}
