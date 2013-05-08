package com.nikhaldimann.viewselector;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

import java.util.List;

import android.view.View;

public class ViewSelectorAsserts {

    private ViewSelectorAsserts() { }

    public static void assertViewExists(String selectorString, View view) {
        assertTrue("Expected at least one view to match '%s' but none found",
                matchView(selectorString, view).size() > 0);
    }

    public static void assertViewCount(String selectorString, View view, int expectedCount) {
        assertEquals("", expectedCount, matchView(selectorString, view).size());
    }

    public static void assertViewAttributesEqual(String selectorString, String attributeName,
            View view, Object... expectedAttributeValues) {
        throw new UnsupportedOperationException();
    }

    private static List<View> matchView(String selectorString, View view) {
        ViewSelector selector = ViewSelector.compile(selectorString);
        return selector.matchView(view);
    }

}
