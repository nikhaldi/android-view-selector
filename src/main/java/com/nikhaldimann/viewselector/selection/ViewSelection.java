package com.nikhaldimann.viewselector.selection;

import java.util.LinkedHashSet;

import android.view.View;

/**
 * Collection representing a selection of views made via a selector. We're
 * making this its own type in order to be able to single it out in FEST-style
 * {@code assertThat()} calls.
 */
public class ViewSelection extends LinkedHashSet<View> {

}
