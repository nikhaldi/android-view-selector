package com.nikhaldimann.viewselector.robolectric2;

import org.junit.runner.RunWith;

import com.nikhaldimann.viewselector.robolectric2.testutil.Robolectric2ViewFactory;
import com.nikhaldimann.viewselector.test.abstrakt.AbstractViewSelectionAssertTest;
import com.nikhaldimann.viewselector.test.util.ViewFactory;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class ViewSelectionAssertTest extends AbstractViewSelectionAssertTest {

    protected ViewFactory createViewFactory() {
        return new Robolectric2ViewFactory();
    }

}
