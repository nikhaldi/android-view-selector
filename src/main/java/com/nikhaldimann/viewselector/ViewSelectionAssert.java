package com.nikhaldimann.viewselector;

import org.fest.assertions.api.ListAssert;

import android.view.View;

public class ViewSelectionAssert extends ListAssert<View> {

    public ViewSelectionAssert(ViewSelection actual) {
        super(actual);
    }

}
