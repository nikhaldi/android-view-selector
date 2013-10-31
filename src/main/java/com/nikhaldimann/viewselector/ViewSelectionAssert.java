package com.nikhaldimann.viewselector;

import static junit.framework.Assert.assertEquals;

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
     * Asserts that every view in the selection has an attribute with the given
     * expected value.
     * @param attributeName name of the attribute to check (e.g., {@code "text"}. The
     *     implementation will call a getter on each view based on this attribute name
     *     (e.g., {@code getText()}.
     * @param expectedValue the expected value for the attribute
     * @return self for chaining
     * @throws AttributeAccessException if one of the views in the selection doesn't
     *     have a getter for the given attribute
     */
    public ViewSelectionAssert hasAttributeEqualTo(String attributeName, Object expectedValue) {
        String getterMethodName = ViewAttributes.getGetterMethodName(attributeName);
        for (View view : actual) {
            Object actualValue = ViewAttributes.callGetterNormalizingStrings(view, getterMethodName);
            assertEquals(
                    String.format("Expected attribute '%s' of '%s' to be <%s> but was <%s>",
                            attributeName, view, expectedValue, actualValue),
                    expectedValue, actualValue);
        }
        return this;
    }

    /**
     * Asserts that the views in the selection have an attribute with the given
     * expected values.
     * @param attributeName name of the attribute to check (e.g., {@code "text"}. The
     *     implementation will call a getter on each view based on this attribute name
     *     (e.g., {@code getText()}.
     * @param expectedValues the expected values for the attribute. There should be
     *     one value for each view in the selection in the expected order of the views.
     * @return self for chaining
     * @throws AttributeAccessException if one of the views in the selection doesn't
     *     have a getter for the given attribute
     */
    public ViewSelectionAssert hasAttributesEqualTo(String attributeName, Object... expectedValues) {
        String getterMethodName = ViewAttributes.getGetterMethodName(attributeName);
        List<Object> attributeValues = new ArrayList<Object>();
        for (View matched : actual) {
            attributeValues.add(
                    ViewAttributes.callGetterNormalizingStrings(matched, getterMethodName));
        }
        assertObjectsEqual(expectedValues, attributeValues);
        return this;
    }

    private static void assertObjectsEqual(Object[] expectedObjects, List<Object> actualObjects) {
        assertEquals(
                String.format("Expected %s view(s) to match attributes but actual number was %s",
                        expectedObjects.length, actualObjects.size()),
                expectedObjects.length, actualObjects.size());
        for (int i = 0; i < expectedObjects.length; i++) {
            // TODO better custom message
            assertEquals(
                    String.format("Expected attribute <%s> at position %s but was <%s>",
                            expectedObjects[i], i, actualObjects.get(i)),
                    expectedObjects[i], actualObjects.get(i));
        }
    }

    public ViewSelectionAssert hasTag(Object tag) {
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasTag(tag);
        }
        return this;
    }
}
