package com.nikhaldimann.viewselector;

import java.util.ArrayList;
import java.util.List;

import org.fest.assertions.api.ANDROID;
import org.fest.assertions.api.AbstractIterableAssert;

import android.view.View;

import com.nikhaldimann.viewselector.attributes.AttributeAccessException;
import com.nikhaldimann.viewselector.attributes.ViewAttributes;
import com.nikhaldimann.viewselector.selection.ViewSelection;

/**
 * Custom assertions for {@link ViewSelection}s. Generally, use entry points in
 * {@link ViewSelectorAssertions} to get access to these.
 */
public class ViewSelectionAssert
        extends AbstractIterableAssert<ViewSelectionAssert, ViewSelection, View> {

    public ViewSelectionAssert(ViewSelection actual) {
        super(actual, ViewSelectionAssert.class);
    }

    /**
     * Creates an object for making assertions about an attribute set extracted from
     * each view in the selection. This always fails for an empty selection.
     * @param attributeName name of the attribute to check (e.g., {@code "text"}. The
     *     implementation will call a getter on each view based on this attribute name
     *     (e.g., {@code getText()}.
     * @return a new assert over a set of attributes
     */
    public ViewSelectionAttributeAssert attribute(String attributeName) {
        isNotEmpty();
        String getterMethodName = ViewAttributes.getGetterMethodName(attributeName);
        List<Object> attributeValues = new ArrayList<Object>();
        for (View matched : actual) {
            attributeValues.add(
                    ViewAttributes.callGetterNormalizingStrings(matched, getterMethodName));
        }
        return new ViewSelectionAttributeAssert(attributeValues);
    }

    /**
     * Asserts that every view in the selection has an attribute with the given
     * expected value. This is just a convenience shortcut for
     * {@code attribute(attributeName).containsOnly(expectedValue)}.
     * @param attributeName name of the attribute to check (e.g., {@code "text"}. The
     *     implementation will call a getter on each view based on this attribute name
     *     (e.g., {@code getText()}.
     * @param expectedValue the expected value for the attribute
     * @return self for chaining
     * @throws AttributeAccessException if one of the views in the selection doesn't
     *     have a getter for the given attribute
     */
    public ViewSelectionAssert hasAttributeEqualTo(String attributeName, Object expectedValue) {
        attribute(attributeName).containsOnly(expectedValue);
        return this;
    }

    public ViewSelectionAssert hasTag(Object tag) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasTag(tag);
        }
        return this;
    }
}
