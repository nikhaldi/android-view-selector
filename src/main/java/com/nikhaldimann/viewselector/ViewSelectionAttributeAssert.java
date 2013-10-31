package com.nikhaldimann.viewselector;

import org.fest.assertions.api.AbstractIterableAssert;

import com.nikhaldimann.viewselector.attributes.ViewSelectionAttribute;
import com.nikhaldimann.viewselector.selection.ViewSelection;

/**
 * Custom assertions for a set of attributes extracted from the elements in
 * a {@link ViewSelection}. Generally you'll want to get at this via
 * {@link ViewSelectorAssert.attribute(Object)}.
 */
public class ViewSelectionAttributeAssert
        extends AbstractIterableAssert<ViewSelectionAttributeAssert, ViewSelectionAttribute, Object>{

    public ViewSelectionAttributeAssert(ViewSelectionAttribute actual) {
        super(actual, ViewSelectionAttributeAssert.class);
    }

}
