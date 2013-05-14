package com.nikhaldimann.viewselector.checker;

import android.view.View;

/**
 * A predicate that can match certain views.
 */
public interface MatchPredicate {

    /**
     * @return whether the given view matches this predicate
     */
    boolean matches(View view);
}