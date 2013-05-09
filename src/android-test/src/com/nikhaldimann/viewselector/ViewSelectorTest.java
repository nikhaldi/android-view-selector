package com.nikhaldimann.viewselector;

import static android.test.MoreAsserts.assertContentsInOrder;

import android.test.AndroidTestCase;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class ViewSelectorTest extends AndroidTestCase {

    private FrameLayout wrapInRoot(View view) {
        FrameLayout root = new FrameLayout(getContext());
        root.addView(view);
        return root;
    }

    public void testMatchViewSimpleSingleView() {
        TextView view = new TextView(getContext());
        View root = wrapInRoot(view);
        assertContentsInOrder(ViewSelector.compile("EditView").matchView(root));
        assertContentsInOrder(ViewSelector.compile("TextView").matchView(root), view);
    }

    public void _testCompileInvalidSelectors() {
        String[] selectors = {"()()))"};
        for (String selector : selectors) {
            try {
                ViewSelector.compile("TextView");
                fail(String.format("Should have failed to compile '%s'", selector));
            } catch (InvalidSelectorException ex) {
                // expected
            }
        }
    }

}
