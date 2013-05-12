package com.nikhaldimann.viewselector.robolectric.testutil;

import com.nikhaldimann.viewselector.test.util.ProvidedContextViewFactory;
import com.xtremelabs.robolectric.Robolectric;

/**
 * A view factory for Robolectric tests that creates all views with
 * the application as created by Robolectric for the context.
 */
public class RobolectricViewFactory extends ProvidedContextViewFactory {

    public RobolectricViewFactory() {
        super(Robolectric.application);
    }

}
