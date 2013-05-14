package com.nikhaldimann.viewselector.attributes;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import android.view.View;

/**
 * Utils for accessing view attributes using reflection.
 */
public class ViewAttributes {

    private ViewAttributes() { }

    /**
     * @return the full getter method name for a plain attribute, following conventions
     *     used in the Android code.. Prepends "get" to the attribute name and formats
     *     it in camel-case. Recognizes boolean attributes of the format isFoo and returns
     *     them unchanged.
     */
    public static String getGetterMethodName(String attributeName) {
        if (isBooleanAttribute(attributeName)) {
            return attributeName;
        }
        return "get" + attributeName.substring(0, 1).toUpperCase() + attributeName.substring(1);
    }

    private static boolean isBooleanAttribute(String attributeName) {
        return attributeName.startsWith("is")
                && attributeName.length() > 2
                && Character.isUpperCase(attributeName.charAt(2));
    }

    /**
     * Calls the given method by name on the given view, assuming that it's a getter,
     * i.e., it doesn't have arguments.
     * @return the result of the method call
     * @throws AttributeAccessException when the method doesn't exist or can't be
     *     called for various reasons
     */
    public static Object callGetter(View view, String methodName) {
        try {
            Method method = view.getClass().getMethod(methodName);
            return method.invoke(view);
        } catch (SecurityException ex) {
            throw new AttributeAccessException(ex);
        } catch (NoSuchMethodException ex) {
            throw new AttributeAccessException("No such attribute", ex);
        } catch (IllegalAccessException ex) {
            throw new AttributeAccessException(ex);
        } catch (InvocationTargetException ex) {
            throw new AttributeAccessException(ex);
        }
    }

}
