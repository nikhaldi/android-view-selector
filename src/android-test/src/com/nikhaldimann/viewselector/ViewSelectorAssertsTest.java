package com.nikhaldimann.viewselector;

import com.nikhaldimann.viewselector.test.abstrakt.AbstractViewSelectorAssertsTest;
import com.nikhaldimann.viewselector.test.util.ViewFactory;
import com.nikhaldimann.viewselector.testutil.AndroidTestViewFactory;

public class ViewSelectorAssertsTest extends AbstractViewSelectorAssertsTest {

    protected ViewFactory createViewFactory() {
        return new AndroidTestViewFactory(getContext());
    }

}
