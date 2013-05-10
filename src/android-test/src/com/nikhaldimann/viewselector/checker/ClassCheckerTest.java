package com.nikhaldimann.viewselector.checker;

import com.nikhaldimann.viewselector.test.abstrakt.checker.AbstractClassCheckerTest;
import com.nikhaldimann.viewselector.test.util.ViewFactory;
import com.nikhaldimann.viewselector.testutil.AndroidTestViewFactory;

public class ClassCheckerTest extends AbstractClassCheckerTest {

    protected ViewFactory createViewFactory() {
        return new AndroidTestViewFactory(getContext());
    }

}
