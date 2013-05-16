package com.nikhaldimann.viewselector.robolectric2.checker;

import org.junit.runner.RunWith;

import com.nikhaldimann.viewselector.robolectric2.testutil.Robolectric2ViewFactory;
import com.nikhaldimann.viewselector.test.abstrakt.checker.AbstractAttributeSpecifierCheckerTest;
import com.nikhaldimann.viewselector.test.util.ViewFactory;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class AttributeSpecifierCheckerTest extends AbstractAttributeSpecifierCheckerTest {

    protected ViewFactory createViewFactory() {
        return new Robolectric2ViewFactory();
    }

}
