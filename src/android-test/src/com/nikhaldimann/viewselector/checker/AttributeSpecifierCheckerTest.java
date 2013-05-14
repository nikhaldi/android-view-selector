package com.nikhaldimann.viewselector.checker;

import com.nikhaldimann.viewselector.test.abstrakt.checker.AbstractAttributeSpecifierCheckerTest;
import com.nikhaldimann.viewselector.test.util.ViewFactory;
import com.nikhaldimann.viewselector.testutil.AndroidTestViewFactory;

public class AttributeSpecifierCheckerTest extends AbstractAttributeSpecifierCheckerTest {

    protected ViewFactory createViewFactory() {
        return new AndroidTestViewFactory(getContext());
    }

}
