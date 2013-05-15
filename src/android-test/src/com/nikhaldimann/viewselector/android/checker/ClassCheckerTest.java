package com.nikhaldimann.viewselector.android.checker;

import com.nikhaldimann.viewselector.android.testutil.AndroidTestViewFactory;
import com.nikhaldimann.viewselector.test.abstrakt.checker.AbstractClassCheckerTest;
import com.nikhaldimann.viewselector.test.util.ViewFactory;

public class ClassCheckerTest extends AbstractClassCheckerTest {

    protected ViewFactory createViewFactory() {
        return new AndroidTestViewFactory(getContext());
    }

}
