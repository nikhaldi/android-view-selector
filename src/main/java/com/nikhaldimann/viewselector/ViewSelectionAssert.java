package com.nikhaldimann.viewselector;

import static junit.framework.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.fest.assertions.api.AbstractIterableAssert;

import android.view.View;

import com.nikhaldimann.viewselector.attributes.ViewAttributes;
import com.nikhaldimann.viewselector.selection.ViewSelection;

public class ViewSelectionAssert
        extends AbstractIterableAssert<ViewSelectionAssert, ViewSelection, View> {

    public ViewSelectionAssert(ViewSelection actual) {
        super(actual, ViewSelectionAssert.class);
    }

    public ViewSelectionAssert hasAttributeEqualTo(String attributeName, Object expectedValue) {
        String getterMethodName = ViewAttributes.getGetterMethodName(attributeName);
        for (View view : actual) {
            Object actualValue = ViewAttributes.callGetter(view, getterMethodName);
            assertEquals(
                    String.format("Expected attribute '%s' of '%s' to be <%s> but was <%s>",
                            attributeName, view, expectedValue, actualValue),
                    expectedValue, actualValue);
        }
        return this;
    }

    public ViewSelectionAssert hasAttributesEqualTo(String attributeName, Object... expectedValues) {
        String getterMethodName = ViewAttributes.getGetterMethodName(attributeName);
        List<Object> attributeValues = new ArrayList<Object>();
        for (View matched : actual) {
            attributeValues.add(ViewAttributes.callGetter(matched, getterMethodName));
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

}
