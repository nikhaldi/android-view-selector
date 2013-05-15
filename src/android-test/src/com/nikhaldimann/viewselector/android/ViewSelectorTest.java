package com.nikhaldimann.viewselector.android;

import com.nikhaldimann.viewselector.android.testutil.AndroidTestViewFactory;
import com.nikhaldimann.viewselector.test.abstrakt.AbstractViewSelectorTest;
import com.nikhaldimann.viewselector.test.util.ViewFactory;

public class ViewSelectorTest extends AbstractViewSelectorTest {

    protected ViewFactory createViewFactory() {
        return new AndroidTestViewFactory(getContext());
    }

}
