package com.nikhaldimann.viewselector.checker;

import java.util.List;

import android.view.View;

/**
 * Interface for checkers that traverse views trying to find views
 * that match some selector criterion.
 */
public interface ViewTraversalChecker {

    /**
     * Checks the given views for views that match some criterion.
     * @param views the views to check
     * @return the set of matched views
     */
    List<View> check(List<View> views);

}
