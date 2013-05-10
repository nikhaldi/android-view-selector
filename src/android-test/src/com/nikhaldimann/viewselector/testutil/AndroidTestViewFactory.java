package com.nikhaldimann.viewselector.testutil;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nikhaldimann.viewselector.test.util.ViewFactory;

/**
 * A view factory for Android test projects that creates all views with
 * a given context.
 */
public class AndroidTestViewFactory implements ViewFactory {

    private final Context context;

    public AndroidTestViewFactory(Context context) {
        this.context = context;
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
