package com.nikhaldimann.viewselector;

import static com.nikhaldimann.viewselector.ViewSelectorAsserts.assertViewAttributesEqual;
import static com.nikhaldimann.viewselector.ViewSelectorAsserts.assertViewCount;
import static com.nikhaldimann.viewselector.ViewSelectorAsserts.assertViewExists;

import android.test.AndroidTestCase;
import android.widget.TextView;

public class ViewSelectorAssertsTest extends AndroidTestCase {

    /**
     * Fails with a RuntimeException, so we can distinguish this from planned
     * assertion failures.
     */
    private void failHard() {
        throw new RuntimeException("Failed to cause an assertion failure");
    }

    public void testAssertViewExistsWithSingleView() {
        TextView view = new TextView(getContext());
        assertViewExists("TextView", view);
    }

    public void testFailingAssertViewExistsWithSingleView() {
        try {
            assertViewExists("FooView", new TextView(getContext()));
            failHard();
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
            failHard();
        } catch (AssertionError ex) {
            // expected
        }
    }

    public void testAssertViewAttributesEqualWithSingleView() {
        TextView view = new TextView(getContext());
        view.setText("foo");
        view.setTag("bar");
        assertViewAttributesEqual("TextView", "text", view, "foo");
        assertViewAttributesEqual("TextView", "tag", view, "bar");
    }

    public void testFailingAssertViewAttributesEqualWithSingleView() {
        try {
            assertViewAttributesEqual("TextView", "text", new TextView(getContext()), "foo");
            failHard();
        } catch (AssertionError ex) {
            // expected
        }
    }
}
