package com.nikhaldimann.viewselector.robolectric2.checker;

import org.junit.runner.RunWith;

import com.nikhaldimann.viewselector.robolectric2.testutil.Robolectric2ViewFactory;
import com.nikhaldimann.viewselector.test.abstrakt.checker.AbstractClassCheckerTest;
import com.nikhaldimann.viewselector.test.util.ViewFactory;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class ClassCheckerTest extends AbstractClassCheckerTest {

    protected ViewFactory createViewFactory() {
        return new Robolectric2ViewFactory();
    }

}
