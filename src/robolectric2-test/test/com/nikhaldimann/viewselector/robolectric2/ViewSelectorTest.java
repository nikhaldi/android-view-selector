package com.nikhaldimann.viewselector.robolectric2;

import org.junit.runner.RunWith;

import com.nikhaldimann.viewselector.robolectric2.testutil.Robolectric2ViewFactory;
import com.nikhaldimann.viewselector.test.abstrakt.AbstractViewSelectorTest;
import com.nikhaldimann.viewselector.test.util.ViewFactory;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class ViewSelectorTest extends AbstractViewSelectorTest {

    protected ViewFactory createViewFactory() {
        return new Robolectric2ViewFactory();
    }

}
