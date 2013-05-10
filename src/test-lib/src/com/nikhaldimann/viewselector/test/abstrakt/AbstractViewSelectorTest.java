package com.nikhaldimann.viewselector.test.abstrakt;

import org.junit.Test;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.nikhaldimann.viewselector.ViewSelector;
import com.nikhaldimann.viewselector.test.util.ViewSelectorAndroidTestCase;

public abstract class AbstractViewSelectorTest extends ViewSelectorAndroidTestCase {

    private FrameLayout wrapInRoot(View view) {
        FrameLayout root = viewFactory.createFrameLayout();
        root.addView(view);
        return root;
    }

    @Test
    public void testMatchViewSimpleSingleView() {
        TextView view = viewFactory.createTextView();
        View root = wrapInRoot(view);
        assertEquals(0, ViewSelector.compile("EditView").matchView(root).size());
        assertEquals(1, ViewSelector.compile("TextView").matchView(root).size());
    }

}
