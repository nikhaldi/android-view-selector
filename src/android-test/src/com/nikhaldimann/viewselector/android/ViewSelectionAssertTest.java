package com.nikhaldimann.viewselector.android;

import com.nikhaldimann.viewselector.android.testutil.AndroidTestViewFactory;
import com.nikhaldimann.viewselector.test.abstrakt.AbstractViewSelectionAssertTest;
import com.nikhaldimann.viewselector.test.util.ViewFactory;

public class ViewSelectionAssertTest extends AbstractViewSelectionAssertTest {

    protected ViewFactory createViewFactory() {
        return new AndroidTestViewFactory(getContext());
    }

}
