package com.nikhaldimann.viewselector;

import com.nikhaldimann.viewselector.test.abstrakt.AbstractViewSelectionAssertTest;
import com.nikhaldimann.viewselector.test.util.ViewFactory;
import com.nikhaldimann.viewselector.testutil.AndroidTestViewFactory;

public class ViewSelectionAssertTest extends AbstractViewSelectionAssertTest {

    protected ViewFactory createViewFactory() {
        return new AndroidTestViewFactory(getContext());
    }

}
