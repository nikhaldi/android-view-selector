package com.nikhaldimann.viewselector.attributes;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import android.view.View;

/**
 * Utils for accessing view attributes using reflection.
 */
public class ViewAttributes {

    private ViewAttributes() { }

    public static String getGetterMethodName(String attributeName) {
        return "get" + attributeName.substring(0, 1).toUpperCase() + attributeName.substring(1);
    }

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
