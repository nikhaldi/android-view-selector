package com.nikhaldimann.viewselector.android.attributes;

import android.widget.TextView;

import com.nikhaldimann.viewselector.android.testutil.AndroidTestViewFactory;
import com.nikhaldimann.viewselector.attributes.ViewAttributes;
import com.nikhaldimann.viewselector.test.abstrakt.attributes.AbstractViewAttributesTest;
import com.nikhaldimann.viewselector.test.util.ViewFactory;

public class ViewAttributesTest extends AbstractViewAttributesTest {

    protected ViewFactory createViewFactory() {
        return new AndroidTestViewFactory(getContext());
    }

    public void testCallGettersOnBaseClass() {
        TextView view = viewFactory.createTextView();
        view.setMinimumHeight(200);
        view.setPivotX(1.25f);
        assertEquals(200, ViewAttributes.callGetter(view, "getMinimumHeight"));
        assertEquals(1.25f, ViewAttributes.callGetter(view, "getPivotX"));
    }

}
