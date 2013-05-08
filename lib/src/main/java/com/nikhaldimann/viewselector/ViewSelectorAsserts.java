package com.nikhaldimann.viewselector;

import static junit.framework.Assert.assertTrue;
import android.view.View;

public class ViewSelectorAsserts {

    private ViewSelectorAsserts() { }

    public static void assertViewExists(String selectorString, View view) {
        ViewSelector selector = ViewSelector.compile(selectorString);
        assertTrue("Expected at least one view to match '%s' but none found",
                selector.matchView(view).size() > 0);
    }

    public static void assertViewCount(String selectorString, View view, int expectedCount) {
        throw new UnsupportedOperationException();
    }

    public static void assertViewAttributesEqual(String selectorString, String attributeName,
            View view, Object... expectedAttributeValues) {
        throw new UnsupportedOperationException();
    }

}
