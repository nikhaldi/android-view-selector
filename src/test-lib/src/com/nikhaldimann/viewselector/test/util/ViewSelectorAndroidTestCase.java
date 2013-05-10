package com.nikhaldimann.viewselector.test.util;

import org.junit.Before;

import android.test.AndroidTestCase;

/**
 * A base class for tests that need to interact with Android views.
 */
public abstract class ViewSelectorAndroidTestCase extends AndroidTestCase {

    protected ViewFactory viewFactory;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        viewFactory = createViewFactory();
    }

    /**
     * @return the factory to be used for creating views in this test
     */
    protected abstract ViewFactory createViewFactory();

}
