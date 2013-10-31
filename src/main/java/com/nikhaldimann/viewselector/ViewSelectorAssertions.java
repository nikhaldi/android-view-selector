package com.nikhaldimann.viewselector;

import org.fest.assertions.api.Assertions;

import android.app.Activity;
import android.view.View;

import com.nikhaldimann.viewselector.attributes.ViewSelectionAttribute;
import com.nikhaldimann.viewselector.selection.ViewSelection;

/**
 * Static assertion entry points for fluent FEST-style assertions. Example usage:
 *
 * <pre>
 *    // Assert that activity has 5 views that are TextViews
 *    assertThat(selection("TextView", activity)).hasSize(5);
 *
 *    // ... or equivalent:
 *    assertThatSelection("TextView", activity).hasSize(5);
 *
 *    // Assert that all TextViews in activity have the text "Hello World"
 *    assertThatSelection("TextView", activity).attribute("text")
 *        .containsOnly("Hello World");
 *
 *    // ... or equivalent:
 *    assertThat(extractAttribute("text").from(selection("TextView", activity)))
 *        .containsOnly("Hello World");
 *
 *    // Assert that the 3 TextViews in activity have the texts "foo", "bar", "baz",
 *    // in that order
 *    assertThatSelection("TextView", activity).attribute("text")
 *        .containsExactly("foo", "bar", "baz");
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

    /**
     * Fluent assertion entry point for {@link ViewSelectionAttribute}. Often used
     * together with {@link #extractAttribute(String)} to extract attributes from
     * a selection.
     */
    public static ViewSelectionAttributeAssert assertThat(ViewSelectionAttribute actual) {
        return new ViewSelectionAttributeAssert(actual);
    }

    /**
     * Mimics the FEST 2.x API for extracting generic properties from a collection,
     * but here with specific logic for extracting attributes from Android views.
     * @param attributeName name of the attribute to extract
     * @return an attribute extractor which can be passed a selection
     */
    public static Attributes extractAttribute(String attributeName) {
        return new Attributes(attributeName);
    }

}
