package com.nikhaldimann.viewselector.test.abstrakt;

import static com.nikhaldimann.viewselector.ViewSelectorAsserts.assertViewAttributesEqual;
import static com.nikhaldimann.viewselector.ViewSelectorAsserts.assertViewCount;
import static com.nikhaldimann.viewselector.ViewSelectorAsserts.assertViewExists;
import junit.framework.AssertionFailedError;

import org.junit.Test;

import android.view.View;
import android.widget.TextView;

import com.nikhaldimann.viewselector.test.util.ViewSelectorAndroidTestCase;

public abstract class AbstractViewSelectorAssertsTest extends ViewSelectorAndroidTestCase {

    /**
     * Fails with a RuntimeException, so we can distinguish this from planned
     * assertion failures.
     */
    private void failHard() {
        throw new RuntimeException("Failed to cause an assertion failure");
    }

    @Test
    public void testAssertViewExistsWithSingleView() {
        TextView view = new TextView(getContext());
        assertViewExists("TextView", wrapInRoot(view));
    }

    @Test
    public void testFailingAssertViewExistsWithSingleView() {
        try {
            assertViewExists("FooView", wrapInRoot(new TextView(getContext())));
            failHard();
        } catch (AssertionFailedError ex) {
            // expected
        }
    }

    @Test
    public void testAssertViewCountWithSingleView() {
        TextView view = new TextView(getContext());
        View root = wrapInRoot(view);
        assertViewCount("TextView", root, 1);
        assertViewCount("FooView", root, 0);
    }

    @Test
    public void testFailingAssertViewCountWithSingleView() {
        try {
            assertViewCount("TextView", wrapInRoot(new TextView(getContext())),  0);
            failHard();
        } catch (AssertionFailedError ex) {
            // expected
        }
    }

    @Test
    public void testAssertViewAttributesEqualWithSingleView() {
        TextView view = new TextView(getContext());
        view.setText("foo");
        view.setTag("bar");
        View root = wrapInRoot(view);
        assertViewAttributesEqual("TextView", "text", root, "foo");
        assertViewAttributesEqual("TextView", "tag", root, "bar");
    }

    @Test
    public void testFailingAssertViewAttributesEqualWithSingleView() {
        try {
            assertViewAttributesEqual("TextView", "text", wrapInRoot(new TextView(getContext())), "foo");
            failHard();
        } catch (AssertionFailedError ex) {
            // expected
        }
    }

}
