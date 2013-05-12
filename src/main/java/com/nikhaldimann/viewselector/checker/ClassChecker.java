package com.nikhaldimann.viewselector.checker;

import java.util.List;

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

        final String tagName = selector.getTagName();
        if (tagName.equals(Selector.UNIVERSAL_TAG)) {
            matchPredicate = ALWAYS_TRUE_PREDICATE;
        } else if (tagName.charAt(0) == '#') {
            // TODO This supports only user-defined ids, but not globally defined ids in android.
            // Can this be fixed?
            String id = tagName.substring(1);
            final int numId = root.getResources().getIdentifier(
                    id, "id", root.getContext().getPackageName());
            if (numId == View.NO_ID) {
                matchPredicate = ALWAYS_FALSE_PREDICATE;
            } else {
                matchPredicate = new MatchPredicate() {
                    public boolean matches(View view) {
                        return numId == view.getId();
                    }
                };
            }
        } else {
            matchPredicate = new MatchPredicate() {
                public boolean matches(View view) {
                    return tagName.equals(view.getClass().getSimpleName());
                }
            };
        }
    }

    public ViewSelection check(List<View> views) {
        ViewSelection result = new ViewSelection();

        if (matchPredicate == ALWAYS_FALSE_PREDICATE) {
            return result;
        }

        for (View view : views) {
            if (!(view instanceof ViewGroup)) {
                continue;
            }
            ViewGroup group = (ViewGroup) view;
            switch (selector.getCombinator()) {
                case DESCENDANT:
                    checkDescendantsRecursively(group, result, group);
                    break;
                case CHILD:
                    checkChildren(group, result);
                    break;
                default:
                    throw new UnsupportedOperationException(
                            "Unsupported combinator " + selector.getCombinator());
            }

        }
        return result;
    }

    private void checkDescendantsRecursively(View view, List<View> result, View root) {
        // Note: Using recursion. We hope that real-world layouts don't get deep
        // enough that this causes a problem.
        if (view != root && matchesView(view)) {
            result.add(view);
        } else if (view instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) view;
            for (int i = 0; i < group.getChildCount(); i++) {
                View childView = group.getChildAt(i);
                checkDescendantsRecursively(childView, result, root);
            }
        }
    }

    private void checkChildren(ViewGroup group, List<View> result) {
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
