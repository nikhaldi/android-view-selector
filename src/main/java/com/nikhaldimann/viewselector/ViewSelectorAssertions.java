package com.nikhaldimann.viewselector;

import org.fest.assertions.api.Assertions;

import com.nikhaldimann.viewselector.selection.ViewSelection;

import android.app.Activity;
import android.view.View;

/**
 * Static assertion entry points for fluent FEST-style assertions. Example usage:
 *
 * <pre>
 *    // Assert that rootView has 5 descendant views that are TextViews
 *    assertThat(selection("TextView", activity)).hasSize(5);
 *
 *    // ... or equivalent:
 *    assertThatSelection("TextView", activity).hasSize(5);
 * </pre>
 */
public class ViewSelectorAssertions extends Assertions {

    private ViewSelectorAssertions() { }

    /**
     * Fluent assertion entry point for {@link ViewSelection}. Often used together
     * with {@link #selection(String, Activity)} to create the selection.
     */
    public static ViewSelectionAssert assertThat(ViewSelection actual) {
        return new ViewSelectionAssert(actual);
    }

    /**
     * Fluent assertion entry point for a selection of views from the given activity
     * based on the given selector. It may be helpful to statically import this rather
     * than {@link #assertThat(ViewSelection)} to avoid conflicts with other statically
     * imported {@code assertThat()} methods.
     */
    public static ViewSelectionAssert assertThatSelection(String selector, Activity activity) {
        return assertThat(selection(selector, activity));
    }

    /**
     * Fluent assertion entry point for a selection of views from the given view
     * based on the given selector. It may be helpful to statically import this rather
     * than {@link #assertThat(ViewSelection)} to avoid conflicts with other statically
     * imported {@code assertThat()} methods.
     */
    public static ViewSelectionAssert assertThatSelection(String selector, View view) {
        return assertThat(selection(selector, view));
    }

    /**
     * @return the selection of views from the given activity based on the given selector
     */
    public static ViewSelection selection(String selector, Activity activity) {
        return selection(selector, activity.findViewById(android.R.id.content));
    }

    /**
     * @return the selection of views from the given view based on the given selector
     */
    public static ViewSelection selection(String selector, View view) {
        return ViewSelector.compile(selector).selectViews(view);
    }

}
