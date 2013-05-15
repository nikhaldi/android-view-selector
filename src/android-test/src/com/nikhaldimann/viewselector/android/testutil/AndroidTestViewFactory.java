package com.nikhaldimann.viewselector.android.testutil;

import android.content.Context;

import com.nikhaldimann.viewselector.test.util.ProvidedContextViewFactory;

/**
 * A view factory for Android test projects that creates all views with
 * a given context.
 */
public class AndroidTestViewFactory extends ProvidedContextViewFactory {

    public AndroidTestViewFactory(Context context) {
        super(context);
    }

}
