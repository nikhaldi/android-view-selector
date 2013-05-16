package com.nikhaldimann.viewselector.robolectric2.attributes;

import org.junit.runner.RunWith;

import com.nikhaldimann.viewselector.robolectric2.testutil.Robolectric2ViewFactory;
import com.nikhaldimann.viewselector.test.abstrakt.attributes.AbstractViewAttributesTest;
import com.nikhaldimann.viewselector.test.util.ViewFactory;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class ViewAttributesTest extends AbstractViewAttributesTest {

    protected ViewFactory createViewFactory() {
        return new Robolectric2ViewFactory();
    }

}
