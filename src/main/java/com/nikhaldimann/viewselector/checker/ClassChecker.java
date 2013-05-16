package com.nikhaldimann.viewselector.checker;

import java.util.Set;

import se.fishtank.css.selectors.Selector;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.nikhaldimann.viewselector.selection.ViewSelection;

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
                case ADJACENT_SIBLING:
                    checkSiblings(view, result, true);
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

    private void checkSiblings(View view, Set<View> result, boolean isAdjacent) {
        ViewParent parent = view.getParent();
        if (!(parent instanceof ViewGroup)) {
            return;
        }
        ViewGroup parentGroup = (ViewGroup) parent;

        int childPos = 0;
        while (parentGroup.getChildAt(childPos) != view) {
            childPos++;
        }

        if (isAdjacent && parentGroup.getChildCount() > childPos + 1) {
            View sibling = parentGroup.getChildAt(childPos + 1);
            if (matchesView(sibling)) {
                result.add(sibling);
            }
        } else {
            for (int i = childPos + 1; parentGroup.getChildCount() > i; i++) {
                View sibling = parentGroup.getChildAt(i);
                if (matchesView(sibling)) {
                    result.add(sibling);
                }
            }
        }
    }

    private boolean matchesView(View view) {
        return matchPredicate.matches(view);
    }
}
