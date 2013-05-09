package com.nikhaldimann.viewselector.robolectric;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.widget.TextView;

import com.nikhaldimann.viewselector.ViewSelector;
import com.xtremelabs.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class ViewSelectorTest extends Assert {

    @Test
    public void simpleSelector() {
        TextView view = new TextView(null);
        ViewSelector selector = ViewSelector.compile("FooView");
        assertEquals(0, selector.matchView(view).size());
    }

}
