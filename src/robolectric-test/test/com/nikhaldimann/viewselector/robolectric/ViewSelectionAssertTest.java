package com.nikhaldimann.viewselector.robolectric;

import org.junit.runner.RunWith;

import com.nikhaldimann.viewselector.robolectric.testutil.RobolectricViewFactory;
import com.nikhaldimann.viewselector.test.abstrakt.AbstractViewSelectionAssertTest;
import com.nikhaldimann.viewselector.test.util.ViewFactory;
import com.xtremelabs.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class ViewSelectionAssertTest extends AbstractViewSelectionAssertTest {

    protected ViewFactory createViewFactory() {
        return new RobolectricViewFactory();
    }

}
