package com.nikhaldimann.viewselector.checker;

import java.util.Set;

import se.fishtank.css.selectors.specifier.AttributeSpecifier;
import android.view.View;

import com.nikhaldimann.viewselector.attributes.AttributeAccessException;
import com.nikhaldimann.viewselector.attributes.ViewAttributes;
import com.nikhaldimann.viewselector.selection.ViewSelection;

/**
 * Checks views based on a selectors attribute specifier, handling all the
 * attribute selection. Note that selection by id via a hash (e.g.,
 * {@code TextView#foo}) is also translated to an attribute specifier.
 */
public class AttributeSpecifierChecker implements ViewTraversalChecker {

    private static class ExactMatchPredicate implements MatchPredicate {

        private final String methodName;
        private final String value;

        public ExactMatchPredicate(String methodName, String value) {
            this.methodName = methodName;
            this.value = value;
        }

        public boolean matches(View view) {
            Object actualValue;
            try {
                actualValue = ViewAttributes.callGetter(view, methodName);
            } catch (AttributeAccessException ex) {
                return false;
            }
            Object convertedValue = value;
            if (actualValue instanceof CharSequence) {
                // Android is using some CharSequence representations internally that
                // don't compare well with strings (in particularly as returned from
                // TextView.getText()), so we convert to a strong explicitly.
                actualValue = actualValue.toString();
            } else if (actualValue instanceof Integer) {
                try {
                    convertedValue = Integer.parseInt(value);
                } catch (NumberFormatException ex) {
                    // Do nothing
                }
            } else if (actualValue instanceof Long) {
                try {
                    convertedValue = Long.parseLong(value);
                } catch (NumberFormatException ex) {
                    // Do nothing
                }
            } else if (actualValue instanceof Boolean) {
                if ("true".equals(value)) {
                    convertedValue = true;
                } else if ("false".equals(value)) {
                    convertedValue = false;
                }
            }
            return convertedValue.equals(actualValue);
        }
    }

    private final MatchPredicate matchPredicate;

    public AttributeSpecifierChecker(AttributeSpecifier specifier, View root) {
        final String methodName = ViewAttributes.getGetterMethodName(specifier.getName());

        if (specifier.getValue() == null) {
            matchPredicate = new MatchPredicate() {
                public boolean matches(View view) {
                    try {
                        return ViewAttributes.callGetter(view, methodName) != null;
                    } catch (AttributeAccessException ex) {
                        return false;
                    }
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
            switch (specifier.getMatch()) {
                case EXACT:
                    matchPredicate = new ExactMatchPredicate(methodName, specifier.getValue());
                    break;
                default:
                    // TODO implement other attribute matching
                    throw new UnsupportedOperationException();
            }
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

}
