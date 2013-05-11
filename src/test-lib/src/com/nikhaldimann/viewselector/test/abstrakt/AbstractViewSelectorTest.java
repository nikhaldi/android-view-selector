package com.nikhaldimann.viewselector.test.abstrakt;

import org.junit.Test;

import android.view.View;
import android.widget.TextView;

import com.nikhaldimann.viewselector.ViewSelector;
import com.nikhaldimann.viewselector.test.util.ViewSelectorAndroidTestCase;

public abstract class AbstractViewSelectorTest extends ViewSelectorAndroidTestCase {

    @Test
    public void testMatchViewSimpleSingleView() {
        TextView view = viewFactory.createTextView();
        View root = wrapInRoot(view);
        assertEquals(0, ViewSelector.compile("EditView").matchView(root).size());
        assertEquals(1, ViewSelector.compile("TextView").matchView(root).size());
    }

}
