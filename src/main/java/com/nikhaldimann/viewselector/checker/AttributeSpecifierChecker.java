package com.nikhaldimann.viewselector.checker;

import java.util.Set;

import se.fishtank.css.selectors.specifier.AttributeSpecifier;
import android.view.View;

import com.nikhaldimann.viewselector.attributes.AttributeAccessException;
import com.nikhaldimann.viewselector.attributes.ViewAttributes;
import com.nikhaldimann.viewselector.selection.ViewSelection;

public class AttributeSpecifierChecker implements ViewTraversalChecker {

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
            final String value = specifier.getValue();
            switch (specifier.getMatch()) {
                case EXACT:
                    // TODO support numbers and booleans
                    matchPredicate = new MatchPredicate() {
                        public boolean matches(View view) {
                            try {
                                return value.equals(ViewAttributes.callGetter(view, methodName));
                            } catch (AttributeAccessException ex) {
                                return false;
                            }
                        }
                    };
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
