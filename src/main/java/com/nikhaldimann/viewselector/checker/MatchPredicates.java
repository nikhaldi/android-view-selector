package com.nikhaldimann.viewselector.checker;

import android.view.View;

/**
 * A collection of predefined predicates.
 */
public class MatchPredicates {

    private MatchPredicates() { }

    /**
     * A predicate that's always false, matches no view.
     */
    public static final MatchPredicate ALWAYS_FALSE_PREDICATE = new MatchPredicate() {
        public boolean matches(View view) {
            return false;
        }
    };

    /**
     * A predicate that's always true, matches all views.
     */
    public static final MatchPredicate ALWAYS_TRUE_PREDICATE = new MatchPredicate() {
        public boolean matches(View view) {
            return true;
        }
    };

}
