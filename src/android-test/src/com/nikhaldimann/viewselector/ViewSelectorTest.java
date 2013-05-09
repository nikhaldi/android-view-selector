package com.nikhaldimann.viewselector;

import static android.test.MoreAsserts.assertContentsInOrder;

import android.test.AndroidTestCase;
import android.widget.TextView;

public class ViewSelectorTest extends AndroidTestCase {

    public void testMatchViewSimpleSingleView() {
        TextView view = new TextView(getContext());
        assertContentsInOrder(ViewSelector.compile("EditView").matchView(view));
        assertContentsInOrder(ViewSelector.compile("TextView").matchView(view), view);
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
