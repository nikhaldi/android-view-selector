package com.nikhaldimann.viewselector;

import com.nikhaldimann.viewselector.attributes.ViewSelectionAttribute;
import com.nikhaldimann.viewselector.selection.ViewSelection;

/**
 * An attribute extractor, generally used via calling
 * {@code ViewSelectorAssertions.extractAttribute(String)}.
 */
public class Attributes {

    private final String attributeName;

    public Attributes(String attributeName) {
        this.attributeName = attributeName;
    }

    /**
     * @param selection the selection to extract attributes from
     * @return extracted attributes ready to make assertions about
     */
    public ViewSelectionAttribute from(ViewSelection selection) {
        return new ViewSelectionAttribute(selection, attributeName);
    }

}
