package com.nikhaldimann.viewselector.test.abstrakt;

import static com.nikhaldimann.viewselector.ViewSelectorAssertions.assertViewAttributesEqual;
import static com.nikhaldimann.viewselector.ViewSelectorAssertions.assertViewCount;
import static com.nikhaldimann.viewselector.ViewSelectorAssertions.assertViewExists;
import static com.nikhaldimann.viewselector.ViewSelectorAssertions.assertThat;
import static com.nikhaldimann.viewselector.ViewSelectorAssertions.assertThatSelection;
import static com.nikhaldimann.viewselector.ViewSelectorAssertions.selection;
import junit.framework.AssertionFailedError;

import org.junit.Test;

import android.view.View;
import android.widget.TextView;

import com.nikhaldimann.viewselector.test.util.ViewSelectorAndroidTestCase;

public abstract class AbstractViewSelectorAssertionsTest extends ViewSelectorAndroidTestCase {

    /**
     * Fails with a RuntimeException, so we can distinguish this from planned
     * assertion failures.
     */
    private void failHard() {
        throw new RuntimeException("Failed to cause an assertion failure");
    }

    @Test
    public void testAssertThat() {
        TextView view = viewFactory.createTextView();
        assertThat(selection("TextView", wrapInRoot(view)))
            .hasSize(1)
            .startsWith(view)
            .endsWith(view);
    }

    @Test
    public void testFailingAssertThat() {
        try {
            assertThat(selection("TextView", wrapInRoot(viewFactory.createTextView()))).isEmpty();
            failHard();
        } catch (AssertionError ex) {
            // expected
        }
    }

    @Test
    public void testAssertThatSelection() {
        assertThatSelection("TextView", wrapInRoot(viewFactory.createTextView())).hasSize(1);
    }

    @Test
    public void testFailingAssertThatSelection() {
        try {
            assertThatSelection("TextView", wrapInRoot(viewFactory.createTextView())).isEmpty();
            failHard();
        } catch (AssertionError ex) {
            // expected
        }
    }

    @Test
    public void testAssertViewExistsWithSingleView() {
        TextView view = viewFactory.createTextView();
        assertViewExists("TextView", wrapInRoot(view));
    }

    @Test
    public void testFailingAssertViewExistsWithSingleView() {
        try {
            assertViewExists("FooView", wrapInRoot(viewFactory.createTextView()));
            failHard();
        } catch (AssertionError ex) {
            // expected
        }
    }

    @Test
    public void testAssertViewCountWithSingleView() {
        TextView view = viewFactory.createTextView();
        View root = wrapInRoot(view);
        assertViewCount("TextView", root, 1);
        assertViewCount("FooView", root, 0);
    }

    @Test
    public void testFailingAssertViewCountWithSingleView() {
        try {
            assertViewCount("TextView", wrapInRoot(viewFactory.createTextView()),  0);
            failHard();
        } catch (AssertionError ex) {
            // expected
        }
    }

    @Test
    public void testAssertViewAttributesEqualWithSingleView() {
        TextView view = viewFactory.createTextView();
        view.setText("foo");
        view.setTag("bar");
        View root = wrapInRoot(view);
        assertViewAttributesEqual("TextView", "text", root, "foo");
        assertViewAttributesEqual("TextView", "tag", root, "bar");
    }

    @Test
    public void testFailingAssertViewAttributesEqualWithSingleView() {
        try {
            assertViewAttributesEqual("TextView", "text",
                    wrapInRoot(viewFactory.createTextView()), "foo");
            failHard();
        } catch (AssertionFailedError ex) {
            // expected
        }
    }

}
