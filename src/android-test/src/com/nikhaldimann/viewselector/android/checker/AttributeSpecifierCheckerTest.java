package com.nikhaldimann.viewselector.android.checker;

import com.nikhaldimann.viewselector.android.testutil.AndroidTestViewFactory;
import com.nikhaldimann.viewselector.test.abstrakt.checker.AbstractAttributeSpecifierCheckerTest;
import com.nikhaldimann.viewselector.test.util.ViewFactory;

public class AttributeSpecifierCheckerTest extends AbstractAttributeSpecifierCheckerTest {

    protected ViewFactory createViewFactory() {
        return new AndroidTestViewFactory(getContext());
    }

}
