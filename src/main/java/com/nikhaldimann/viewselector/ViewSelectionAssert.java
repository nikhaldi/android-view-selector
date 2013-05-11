package com.nikhaldimann.viewselector;

import static junit.framework.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.fest.assertions.api.AbstractIterableAssert;

import android.view.View;

public class ViewSelectionAssert
        extends AbstractIterableAssert<ViewSelectionAssert, ViewSelection, View> {

    public ViewSelectionAssert(ViewSelection actual) {
        super(actual, ViewSelectionAssert.class);
    }

    public ViewSelectionAssert hasAttributeEqualTo(String attributeName, Object expectedValue) {
        String getterMethodName = getGetterMethodName(attributeName);
        for (View view : actual) {
            Object actualValue = callGetterMethod(view, getterMethodName);
            assertEquals(
                    String.format("Expected attribute '%s' of '%s' to be <%s> but was <%s>",
                            attributeName, view, expectedValue, actualValue),
                    expectedValue, actualValue);
        }
        return this;
    }

    public ViewSelectionAssert hasAttributesEqualTo(String attributeName, Object... expectedValues) {
        String getterMethodName = getGetterMethodName(attributeName);
        List<Object> attributeValues = new ArrayList<Object>();
        for (View matched : actual) {
            attributeValues.add(callGetterMethod(matched, getterMethodName));
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

    private static String getGetterMethodName(String attributeName) {
        return "get" + attributeName.substring(0, 1).toUpperCase() + attributeName.substring(1);
    }

    private static Object callGetterMethod(Object object, String methodName) {
        try {
            Method method = object.getClass().getMethod(methodName);
            return method.invoke(object);
            // TODO more explicit exception messages
        } catch (SecurityException ex) {
            throw new RuntimeException(ex);
        } catch (NoSuchMethodException ex) {
            throw new RuntimeException(ex);
        } catch (IllegalArgumentException ex) {
            throw new RuntimeException(ex);
        } catch (IllegalAccessException ex) {
            throw new RuntimeException(ex);
        } catch (InvocationTargetException ex) {
            throw new RuntimeException(ex);
        }
    }

}
