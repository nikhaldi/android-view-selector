package com.nikhaldimann.viewselector.attributes;

import android.widget.TextView;

import com.nikhaldimann.viewselector.test.abstrakt.attributes.AbstractViewAttributesTest;
import com.nikhaldimann.viewselector.test.util.ViewFactory;
import com.nikhaldimann.viewselector.testutil.AndroidTestViewFactory;

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
