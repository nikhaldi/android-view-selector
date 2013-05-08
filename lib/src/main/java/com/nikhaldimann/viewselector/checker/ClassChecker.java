package com.nikhaldimann.viewselector.checker;

import java.util.ArrayList;
import java.util.List;

import se.fishtank.css.selectors.Selector;
import android.view.View;

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
        String className = selector.getTagName();
        for (View view : views) {
            if (matchesClass(className, view)) {
                result.add(view);
            }
        }
        return result;
    }

    private boolean matchesClass(String className, View view) {
        return className.equals(view.getClass().getSimpleName());
    }
}
