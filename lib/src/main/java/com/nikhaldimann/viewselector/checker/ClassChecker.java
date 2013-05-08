package com.nikhaldimann.viewselector.checker;

import java.util.ArrayList;
import java.util.List;

import se.fishtank.css.selectors.Selector;
import android.view.View;
import android.view.ViewGroup;

/**
 * Checks views based on matching the tag from a selector to the class of
 * a view.
 */
public class ClassChecker implements ViewTraversalChecker {

    private final Selector selector;

    public ClassChecker(Selector selector) {
        this.selector = selector;
    }

    public List<View> check(List<View> views) {
        List<View> result = new ArrayList<View>();
        for (View view : views) {
            checkDescendants(view, result);
        }
        return result;
    }

    private void checkDescendants(View view, List<View> result) {
        // Note: Using recursion. We hope that real-world layouts don't get deep
        // enough that this causes a problem.
        String className = selector.getTagName();
        if (matchesClass(className, view)) {
            result.add(view);
        } else if (view instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) view;
            for (int i = 0; i < group.getChildCount(); i++) {
                View childView = group.getChildAt(i);
                checkDescendants(childView, result);
            }
        }
    }

    private boolean matchesClass(String className, View view) {
        return className.equals(Selector.UNIVERSAL_TAG)
                || className.equals(view.getClass().getSimpleName());
    }
}
