package com.nikhaldimann.viewselector.robolectric;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.widget.FrameLayout;
import android.widget.TextView;

import com.nikhaldimann.viewselector.ViewSelector;
import com.xtremelabs.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class ViewSelectorTest extends Assert {

    @Test
    public void simpleSelector() {
        TextView view = new TextView(null);
        FrameLayout root = new FrameLayout(null);
        root.addView(view);
        assertEquals(0, ViewSelector.compile("FooView").matchView(root).size());
        assertEquals(1, ViewSelector.compile("TextView").matchView(root).size());
    }

}
