package com.nikhaldimann.viewselector.test.util;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;

import android.test.AndroidTestCase;
import android.view.View;
import android.widget.LinearLayout;

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

    /**
     * @return the given views wrapped in a container layout that can act as a root
     *     view in tests
     */
    protected LinearLayout wrapInRoot(View... views) {
        LinearLayout root = viewFactory.createLinearLayout();
        for (View view : views) {
            root.addView(view);
        }
        return root;
    }

    /**
     * Reimplementation of Android's MoreAsserts.assertContentsInOrder() because we
     * can't use MoreAsserts in Robolectric 1.2.
     */
    public static void assertContentsInOrder(Iterable<?> actual, Object... expected) {
        ArrayList<Object> actualList = new ArrayList<Object>();
        for (Object o : actual) {
            actualList.add(o);
        }
        assertEquals(Arrays.asList(expected), actualList);
    }
}
