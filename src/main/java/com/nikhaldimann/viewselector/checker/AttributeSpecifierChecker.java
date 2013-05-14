package com.nikhaldimann.viewselector.checker;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

import se.fishtank.css.selectors.specifier.AttributeSpecifier;
import android.view.View;

import com.nikhaldimann.viewselector.ViewSelection;

public class AttributeSpecifierChecker implements ViewTraversalChecker {

    private final AttributeSpecifier specifier;

    public AttributeSpecifierChecker(AttributeSpecifier specifier) {
        this.specifier = specifier;
    }

    public ViewSelection check(Set<View> views) {
        ViewSelection result = new ViewSelection();
        for (View view : views) {
            String methodName = getGetterMethodName(specifier.getName());
            Object actualValue = callGetterMethod(view, methodName);

            // TODO refactor to use MatchPredicates
            if (specifier.getValue() == null) {
                if (actualValue != null) {
                    result.add(view);
                }
                continue;
            }

            if ("id".equals(specifier.getName())) {
                // TODO will need to make id a special case
            }

            // TODO more matches
        }
        return result;
    }

    // TODO extract to reuse in ViewSelectionAssert
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
