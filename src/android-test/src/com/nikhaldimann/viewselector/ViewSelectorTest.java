package com.nikhaldimann.viewselector;

import com.nikhaldimann.viewselector.test.abstrakt.AbstractViewSelectorTest;
import com.nikhaldimann.viewselector.test.util.ViewFactory;
import com.nikhaldimann.viewselector.testutil.AndroidTestViewFactory;

public class ViewSelectorTest extends AbstractViewSelectorTest {

    protected ViewFactory createViewFactory() {
        return new AndroidTestViewFactory(getContext());
    }

}
