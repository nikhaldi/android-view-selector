package com.nikhaldimann.viewselector;

import static com.nikhaldimann.viewselector.ViewSelectorAsserts.assertViewAttributesEqual;
import static com.nikhaldimann.viewselector.ViewSelectorAsserts.assertViewCount;
import static com.nikhaldimann.viewselector.ViewSelectorAsserts.assertViewExists;

import android.test.AndroidTestCase;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class ViewSelectorAssertsTest extends AndroidTestCase {

    /**
     * Fails with a RuntimeException, so we can distinguish this from planned
     * assertion failures.
     */
    private void failHard() {
        throw new RuntimeException("Failed to cause an assertion failure");
    }

    private FrameLayout wrapInRoot(View view) {
        FrameLayout root = new FrameLayout(getContext());
        root.addView(view);
        return root;
    }

    public void testAssertViewExistsWithSingleView() {
        TextView view = new TextView(getContext());
        assertViewExists("TextView", wrapInRoot(view));
    }

    public void testFailingAssertViewExistsWithSingleView() {
        try {
            assertViewExists("FooView", wrapInRoot(new TextView(getContext())));
            failHard();
        } catch (AssertionError ex) {
            // expected
        }
    }

    public void testAssertViewCountWithSingleView() {
        TextView view = new TextView(getContext());
        View root = wrapInRoot(view);
        assertViewCount("TextView", root, 1);
        assertViewCount("FooView", root, 0);
    }

    public void testFailingAssertViewCountWithSingleView() {
        try {
            assertViewCount("TextView", wrapInRoot(new TextView(getContext())),  0);
            failHard();
        } catch (AssertionError ex) {
            // expected
        }
    }

    public void testAssertViewAttributesEqualWithSingleView() {
        TextView view = new TextView(getContext());
        view.setText("foo");
        view.setTag("bar");
        View root = wrapInRoot(view);
        assertViewAttributesEqual("TextView", "text", root, "foo");
        assertViewAttributesEqual("TextView", "tag", root, "bar");
    }

    public void testFailingAssertViewAttributesEqualWithSingleView() {
        try {
            assertViewAttributesEqual("TextView", "text", wrapInRoot(new TextView(getContext())), "foo");
            failHard();
        } catch (AssertionError ex) {
            // expected
        }
    }
}
