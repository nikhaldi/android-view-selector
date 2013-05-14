package com.nikhaldimann.viewselector.checker;

import java.util.Set;

import se.fishtank.css.selectors.Selector;
import android.view.View;
import android.view.ViewGroup;

import com.nikhaldimann.viewselector.ViewSelection;

/**
 * Checks views based on matching the tag from a selector to the class of
 * a view.
 */
public class ClassChecker implements ViewTraversalChecker {

    private static interface MatchPredicate {
        boolean matches(View view);
    }

    private static final MatchPredicate ALWAYS_FALSE_PREDICATE = new MatchPredicate() {
        public boolean matches(View view) {
            return false;
        }
    };

    private static final MatchPredicate ALWAYS_TRUE_PREDICATE = new MatchPredicate() {
        public boolean matches(View view) {
            return true;
        }
    };

    private final Selector selector;
    private final MatchPredicate matchPredicate;

    public ClassChecker(Selector selector, View root) {
        this.selector = selector;

        String tagName = selector.getTagName();
        final String className;
        String id;
        int idSeparatorIndex = tagName.indexOf('#');
        if (idSeparatorIndex == 0) {
            className = Selector.UNIVERSAL_TAG;
            id = tagName.substring(1);
        } else if (idSeparatorIndex > 0) {
            className = tagName.substring(0, idSeparatorIndex);
            id = tagName.substring(idSeparatorIndex + 1);
        } else {
            className = tagName;
            id = null;
        }

        if (className.equals(Selector.UNIVERSAL_TAG) && id == null) {
            matchPredicate = ALWAYS_TRUE_PREDICATE;
        } else if (id == null) {
            matchPredicate = new MatchPredicate() {
                public boolean matches(View view) {
                    return className.equals(view.getClass().getSimpleName());
                }
            };
        } else {
            // TODO This supports only user-defined ids, but not globally defined ids in android.
            // Can this be fixed?
            final int numId = root.getResources().getIdentifier(
                    id, "id", root.getContext().getPackageName());
            if (numId == View.NO_ID) {
                matchPredicate = ALWAYS_FALSE_PREDICATE;
            } else if (className.equals(Selector.UNIVERSAL_TAG)) {
                matchPredicate = new MatchPredicate() {
                    public boolean matches(View view) {
                        return numId == view.getId();
                    }
                };
            } else {
                matchPredicate = new MatchPredicate() {
                    public boolean matches(View view) {
                        return className.equals(view.getClass().getSimpleName())
                                && numId == view.getId();
                    }
                };
            }
        }
    }

    public ViewSelection check(Set<View> views) {
        ViewSelection result = new ViewSelection();

        if (matchPredicate == ALWAYS_FALSE_PREDICATE) {
            return result;
        }

        for (View view : views) {
            switch (selector.getCombinator()) {
                case DESCENDANT:
                    checkDescendantsRecursively(view, result);
                    break;
                case CHILD:
                    if (!(view instanceof ViewGroup)) {
                        continue;
                    }
                    checkChildren((ViewGroup) view, result);
                    break;
                default:
                    throw new UnsupportedOperationException(
                            "Unsupported combinator " + selector.getCombinator());
            }

        }
        return result;
    }

    private void checkDescendantsRecursively(View view, Set<View> result) {
        // Note: Using recursion. We hope that real-world layouts don't get deep
        // enough that this causes a problem.
        if (matchesView(view)) {
            result.add(view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) view;
            for (int i = 0; i < group.getChildCount(); i++) {
                View childView = group.getChildAt(i);
                checkDescendantsRecursively(childView, result);
            }
        }
    }

    private void checkChildren(ViewGroup group, Set<View> result) {
        for (int i = 0; i < group.getChildCount(); i++) {
            View childView = group.getChildAt(i);
            if (matchesView(childView)) {
                result.add(childView);
            }
        }
    }

    private boolean matchesView(View view) {
        return matchPredicate.matches(view);
    }
}
