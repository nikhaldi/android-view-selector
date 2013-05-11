package com.nikhaldimann.viewselector.robolectric;

import org.junit.runner.RunWith;

import com.nikhaldimann.viewselector.robolectric.testutil.RobolectricViewFactory;
import com.nikhaldimann.viewselector.test.abstrakt.AbstractViewSelectorAssertionsTest;
import com.nikhaldimann.viewselector.test.util.ViewFactory;
import com.xtremelabs.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class ViewSelectorAssertionsTest extends AbstractViewSelectorAssertionsTest {

    protected ViewFactory createViewFactory() {
        return new RobolectricViewFactory();
    }

}
