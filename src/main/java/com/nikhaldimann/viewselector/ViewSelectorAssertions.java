package com.nikhaldimann.viewselector;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import android.view.View;

public class ViewSelectorAssertions {

    private ViewSelectorAssertions() { }

    public static ViewSelectionAssert assertThat(ViewSelection actual) {
        return new ViewSelectionAssert(actual);
    }

    public static ViewSelectionAssert assertThatSelection(String selector, View view) {
        return assertThat(selection(selector, view));
    }

    public static ViewSelection selection(String selector, View view) {
        return ViewSelector.compile(selector).selectViews(view);
    }

    public static void assertViewExists(String selectorString, View view) {
        assertTrue(
                String.format("Expected at least one view to match '%s' but none found", selectorString),
                selection(selectorString, view).size() > 0);
    }

    public static void assertViewCount(String selectorString, View view, int expectedCount) {
        int matchedCount = selection(selectorString, view).size();
        assertEquals(
                String.format("Expected to find <%s> views matching '%s' but was <%s>",
                        expectedCount, selectorString, matchedCount),
                expectedCount, matchedCount);
    }

    public static void assertViewAttributesEqual(String selectorString, String attributeName,
            View view, Object... expectedAttributeValues) {
        String getterMethodName = "get" + attributeName.substring(0, 1).toUpperCase()
                + attributeName.substring(1);
        List<Object> attributeValues = new ArrayList<Object>();
        for (View matched : selection(selectorString, view)) {
            attributeValues.add(callGetterMethod(matched, getterMethodName));
        }
        assertObjectsEqual(expectedAttributeValues, attributeValues);
    }

    private static void assertObjectsEqual(Object[] expectedObjects, List<Object> actualObjects) {
        assertEquals(
                String.format("Expected %s attribute(s) but actual number of attributes was %s",
                        expectedObjects.length, actualObjects.size()),
                expectedObjects.length, actualObjects.size());
        for (int i = 0; i < expectedObjects.length; i++) {
            assertEquals(
                    String.format("Expected attribute <%s> at position %s but was <%s>",
                            expectedObjects[i], i, actualObjects.get(i)),
                    expectedObjects[i], actualObjects.get(i));
        }
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
