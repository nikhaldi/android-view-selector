package com.nikhaldimann.viewselector;

import static com.nikhaldimann.viewselector.ViewSelectorAsserts.assertViewExists;
import static com.nikhaldimann.viewselector.ViewSelectorAsserts.assertViewCount;

import android.test.AndroidTestCase;
import android.widget.TextView;

public class ViewSelectorAssertsTest extends AndroidTestCase {

    public void testAssertViewExistsWithSingleView() {
        TextView view = new TextView(getContext());
        assertViewExists("TextView", view);
    }

    public void testFailingAssertViewExistsWithSingleView() {
        try {
            assertViewExists("FooView", new TextView(getContext()));
            fail();
        } catch (AssertionError ex) {
            // expected
        }
    }

    public void testAssertViewCountWithSingleView() {
        TextView view = new TextView(getContext());
        assertViewCount("TextView", view, 1);
        assertViewCount("FooView", view, 0);
    }

    public void testFailingAssertViewCountWithSingleView() {
        try {
            assertViewCount("TextView", new TextView(getContext()),  0);
            fail();
        } catch (AssertionError ex) {
            // expected
        }
    }
}
