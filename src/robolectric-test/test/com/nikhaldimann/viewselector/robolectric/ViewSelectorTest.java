package com.nikhaldimann.viewselector.robolectric;

import org.junit.runner.RunWith;

import com.nikhaldimann.viewselector.robolectric.testutil.RobolectricViewFactory;
import com.nikhaldimann.viewselector.test.abstrakt.AbstractViewSelectorTest;
import com.nikhaldimann.viewselector.test.util.ViewFactory;
import com.xtremelabs.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class ViewSelectorTest extends AbstractViewSelectorTest {

    protected ViewFactory createViewFactory() {
        return new RobolectricViewFactory();
    }

//    @Test
//    public void simpleSelector() {
//        TextView view = new TextView(null);
//        FrameLayout root = new FrameLayout(null);
//        root.addView(view);
//        assertEquals(0, ViewSelector.compile("FooView").matchView(root).size());
//        assertEquals(1, ViewSelector.compile("TextView").matchView(root).size());
//    }

}
