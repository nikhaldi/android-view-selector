package com.nikhaldimann.viewselector;

import org.fest.assertions.api.Assertions;

import com.nikhaldimann.viewselector.selection.ViewSelection;

import android.app.Activity;
import android.view.View;

public class ViewSelectorAssertions extends Assertions {

    private ViewSelectorAssertions() { }

    public static ViewSelectionAssert assertThat(ViewSelection actual) {
        return new ViewSelectionAssert(actual);
    }

    public static ViewSelectionAssert assertThatSelection(String selector, Activity activity) {
        return assertThat(selection(selector, activity));
    }

    public static ViewSelectionAssert assertThatSelection(String selector, View view) {
        return assertThat(selection(selector, view));
    }

    public static ViewSelection selection(String selector, Activity activity) {
        return selection(selector, activity.findViewById(android.R.id.content));
    }

    public static ViewSelection selection(String selector, View view) {
        return ViewSelector.compile(selector).selectViews(view);
    }

    public static void assertViewExists(String selectorString, View view) {
        assertThatSelection(selectorString, view)
            .overridingErrorMessage(
                    "Expected at least one view to match '%s' but none found", selectorString)
            .isNotEmpty();
    }

    public static void assertViewCount(String selectorString, View view, int expectedCount) {
        ViewSelection selection = selection(selectorString, view);
        assertThat(selection)
            .overridingErrorMessage("Expected to find <%s> views matching '%s' but was <%s>",
                        expectedCount, selectorString, selection.size())
            .hasSize(expectedCount);
    }

    public static void assertViewAttributesEqual(String selectorString, String attributeName,
            View view, Object... expectedValues) {
        assertThatSelection(selectorString, view).hasAttributesEqualTo(attributeName, expectedValues);
    }

}
