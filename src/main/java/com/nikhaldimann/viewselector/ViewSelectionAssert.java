package com.nikhaldimann.viewselector;

import static junit.framework.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.fest.assertions.api.ListAssert;

import android.view.View;

public class ViewSelectionAssert extends ListAssert<View> {

    public ViewSelectionAssert(ViewSelection actual) {
        super(actual);
    }

    public ViewSelectionAssert hasAttributeEqualTo(String attributeName, Object expectedValue) {
        String getterMethodName = "get" + attributeName.substring(0, 1).toUpperCase()
                + attributeName.substring(1);
        for (View view : actual) {
            Object actualValue = callGetterMethod(view, getterMethodName);
            assertEquals(
                    String.format("Expected attribute '%s' of '%s' to be <%s> but was <%s>",
                            attributeName, view, expectedValue, actualValue),
                    expectedValue, actualValue);
        }
        return this;
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
