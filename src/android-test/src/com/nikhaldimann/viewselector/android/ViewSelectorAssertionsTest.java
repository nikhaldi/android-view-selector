package com.nikhaldimann.viewselector.android;

import com.nikhaldimann.viewselector.android.testutil.AndroidTestViewFactory;
import com.nikhaldimann.viewselector.test.abstrakt.AbstractViewSelectorAssertionsTest;
import com.nikhaldimann.viewselector.test.util.ViewFactory;

public class ViewSelectorAssertionsTest extends AbstractViewSelectorAssertionsTest {

    protected ViewFactory createViewFactory() {
        return new AndroidTestViewFactory(getContext());
    }

}
