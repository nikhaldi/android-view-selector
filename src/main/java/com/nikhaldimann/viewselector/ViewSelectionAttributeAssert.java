package com.nikhaldimann.viewselector;

import java.util.List;

import org.fest.assertions.api.AbstractIterableAssert;

import com.nikhaldimann.viewselector.selection.ViewSelection;

/**
 * Custom assertions for a set of attributes extracted from the elements in
 * a {@link ViewSelection}. Generally you'll want to get at this via
 * {@link ViewSelectorAssert.attribute(Object)}.
 */
public class ViewSelectionAttributeAssert
        extends AbstractIterableAssert<ViewSelectionAttributeAssert, List<Object>, Object>{

    public ViewSelectionAttributeAssert(List<Object> actual) {
        super(actual, ViewSelectionAttributeAssert.class);
    }

}
