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

    private final Selector selector;

    public ClassChecker(Selector selector) {
        this.selector = selector;
    }

    public ViewSelection check(List<View> views) {
        ViewSelection result = new ViewSelection();
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
        if (view != root && matchesView(selector.getTagName(), view)) {
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
            if (matchesView(selector.getTagName(), childView)) {
                result.add(childView);
            }
        }
    }

    private boolean matchesView(String tagName, View view) {
        // TODO refactor this to do the distinction between the types of matches ahead of time
        if (tagName.charAt(0) == '#') {
            // TODO This supports only user-defined ids, but not globally defined ids in android.
            // Can this be fixed?
            String id = tagName.substring(1);
            int numId = view.getResources().getIdentifier(id, "id", view.getContext().getPackageName());
            return numId != View.NO_ID && numId == view.getId();
        }
        return tagName.equals(Selector.UNIVERSAL_TAG)
                || tagName.equals(view.getClass().getSimpleName());
    }
}
