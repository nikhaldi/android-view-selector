package com.nikhaldimann.viewselector.robolectric.attributes;

import org.junit.runner.RunWith;

import com.nikhaldimann.viewselector.robolectric.testutil.RobolectricViewFactory;
import com.nikhaldimann.viewselector.test.abstrakt.attributes.AbstractViewAttributesTest;
import com.nikhaldimann.viewselector.test.util.ViewFactory;
import com.xtremelabs.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class ViewAttributesTest extends AbstractViewAttributesTest {

    protected ViewFactory createViewFactory() {
        return new RobolectricViewFactory();
    }

}
