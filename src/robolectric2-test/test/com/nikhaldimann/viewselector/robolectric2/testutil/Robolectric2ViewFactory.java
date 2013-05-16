package com.nikhaldimann.viewselector.robolectric2.testutil;

import com.nikhaldimann.viewselector.test.util.ProvidedContextViewFactory;
import org.robolectric.Robolectric;

/**
 * A view factory for Robolectric tests that creates all views with
 * the application as created by Robolectric for the context.
 */
public class Robolectric2ViewFactory extends ProvidedContextViewFactory {

    public Robolectric2ViewFactory() {
        super(Robolectric.application);
    }

}
