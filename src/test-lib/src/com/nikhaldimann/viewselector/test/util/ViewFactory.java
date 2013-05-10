package com.nikhaldimann.viewselector.test.util;

import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 *  A factory of views to be created in tests. This is needed because
 *  different testing frameworks (i.e., Android test projects and Robolectric)
 *  might need different ways of creating views.
 */
public interface ViewFactory {

    TextView createTextView();

    LinearLayout createLinearLayout();

    FrameLayout createFrameLayout();

}
