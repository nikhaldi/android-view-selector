package com.nikhaldimann.viewselector.robolectric.checker;

import org.junit.runner.RunWith;

import com.nikhaldimann.viewselector.robolectric.testutil.RobolectricViewFactory;
import com.nikhaldimann.viewselector.test.abstrakt.checker.AbstractAttributeSpecifierCheckerTest;
import com.nikhaldimann.viewselector.test.util.ViewFactory;
import com.xtremelabs.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class AttributeSpecifierCheckerTest extends AbstractAttributeSpecifierCheckerTest {

    protected ViewFactory createViewFactory() {
        return new RobolectricViewFactory();
    }

}
