package com.nikhaldimann.viewselector.test.util;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * View factory that creates all views with the given context.
 */
public class ProvidedContextViewFactory implements ViewFactory {

    private final Context context;

    public ProvidedContextViewFactory(Context context) {
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
