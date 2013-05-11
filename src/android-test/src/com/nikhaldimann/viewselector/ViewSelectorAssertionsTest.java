package com.nikhaldimann.viewselector;

import com.nikhaldimann.viewselector.test.abstrakt.AbstractViewSelectorAssertionsTest;
import com.nikhaldimann.viewselector.test.util.ViewFactory;
import com.nikhaldimann.viewselector.testutil.AndroidTestViewFactory;

public class ViewSelectorAssertionsTest extends AbstractViewSelectorAssertionsTest {

    protected ViewFactory createViewFactory() {
        return new AndroidTestViewFactory(getContext());
    }

}
