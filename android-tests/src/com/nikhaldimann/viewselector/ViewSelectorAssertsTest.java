package com.nikhaldimann.viewselector;

import android.test.AndroidTestCase;
import android.widget.TextView;

public class ViewSelectorAssertsTest extends AndroidTestCase {

    public void testAssertViewExistsWithSingleView() {
        TextView view = new TextView(getContext());
        ViewSelectorAsserts.assertViewExists("TextView", view);
    }

    public void testFailingAssertViewExistsWithSingleView() {
        TextView view = new TextView(getContext());
        try {
            ViewSelectorAsserts.assertViewExists("FooView", view);
            fail();
        } catch (AssertionError ex) {
            // expected
        }
    }
}
