package com.nikhaldimann.viewselector.attributes;

import java.util.ArrayList;

import android.view.View;

import com.nikhaldimann.viewselector.selection.ViewSelection;

/**
 * Collection representing an attribute of a selection of views made. We're
 * making this its own type in order to be able to single it out in FEST-style
 * {@code assertThat()} calls.
 */
public class ViewSelectionAttribute extends ArrayList<Object> {

    public ViewSelectionAttribute() {
        super();
    }

    public ViewSelectionAttribute(ViewSelection selection, String attributeName) {
        super();
        String getterMethodName = ViewAttributes.getGetterMethodName(attributeName);
        for (View matched : selection) {
            add(ViewAttributes.callGetterNormalizingStrings(matched, getterMethodName));
        }
    }

}
