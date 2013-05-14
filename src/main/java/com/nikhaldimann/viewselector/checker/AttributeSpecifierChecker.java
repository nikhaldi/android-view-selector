package com.nikhaldimann.viewselector.checker;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

import se.fishtank.css.selectors.specifier.AttributeSpecifier;
import android.view.View;

import com.nikhaldimann.viewselector.selection.ViewSelection;

public class AttributeSpecifierChecker implements ViewTraversalChecker {

    private final MatchPredicate matchPredicate;

    public AttributeSpecifierChecker(AttributeSpecifier specifier, View root) {
        final String methodName = getGetterMethodName(specifier.getName());

        if (specifier.getValue() == null) {
            matchPredicate = new MatchPredicate() {
                public boolean matches(View view) {
                    Object actualValue = callGetterMethod(view, methodName);
                    return actualValue != null;
                }
            };
        } else if ("id".equals(specifier.getName())) {
            // TODO This supports only user-defined ids, but not globally defined ids in android.
            // Can this be fixed?
            String id = specifier.getValue();
            final int numId = root.getResources().getIdentifier(
                    id, "id", root.getContext().getPackageName());
            if (numId == View.NO_ID) {
                matchPredicate = MatchPredicates.ALWAYS_FALSE_PREDICATE;
            } else {
                matchPredicate = new MatchPredicate() {
                    public boolean matches(View view) {
                        return numId == view.getId();
                    }
                };
            }
        } else {
            // TODO implement other attribute matching
            throw new UnsupportedOperationException();
        }
    }

    public ViewSelection check(Set<View> views) {
        ViewSelection result = new ViewSelection();

        if (matchPredicate == MatchPredicates.ALWAYS_FALSE_PREDICATE) {
            return result;
        }

        for (View view : views) {
            if (matchPredicate.matches(view)) {
                result.add(view);
            }
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
