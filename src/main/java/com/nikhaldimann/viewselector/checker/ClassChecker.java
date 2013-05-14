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

    private final Selector selector;
    private final MatchPredicate matchPredicate;

    public ClassChecker(Selector selector, View root) {
        this.selector = selector;

        final String className = selector.getTagName();
        if (className.equals(Selector.UNIVERSAL_TAG)) {
            matchPredicate = MatchPredicates.ALWAYS_TRUE_PREDICATE;
        } else {
            matchPredicate = new MatchPredicate() {
                public boolean matches(View view) {
                    return className.equals(view.getClass().getSimpleName());
                }
            };
        }
    }

    public ViewSelection check(Set<View> views) {
        ViewSelection result = new ViewSelection();
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
