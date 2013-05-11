package com.nikhaldimann.viewselector.robolectric;

import org.junit.runner.RunWith;

import com.nikhaldimann.viewselector.robolectric.testutil.RobolectricViewFactory;
import com.nikhaldimann.viewselector.test.abstrakt.AbstractViewSelectorAssertsTest;
import com.nikhaldimann.viewselector.test.util.ViewFactory;
import com.xtremelabs.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class ViewSelectorAssertsTest extends AbstractViewSelectorAssertsTest {

    protected ViewFactory createViewFactory() {
        return new RobolectricViewFactory();
    }

}
