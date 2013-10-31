package com.nikhaldimann.viewselector.test.abstrakt;

import static com.nikhaldimann.viewselector.ViewSelectorAssertions.assertThatSelection;
import junit.framework.AssertionFailedError;

import org.junit.Test;

import android.widget.LinearLayout;
import android.widget.TextView;

import com.nikhaldimann.viewselector.attributes.AttributeAccessException;
import com.nikhaldimann.viewselector.test.util.ViewSelectorAndroidTestCase;

public abstract class AbstractViewSelectionAssertTest extends ViewSelectorAndroidTestCase {

    /**
     * Fails with a RuntimeException, so we can distinguish this from planned
     * assertion failures.
     */
    private void failHard() {
        throw new RuntimeException("Failed to cause an assertion failure");
    }

    @Test
    public void testAttribute() {
        TextView view = viewFactory.createTextView();
        view.setText("foo");
        view.setTag("bar");
        assertThatSelection("TextView", view).attribute("text").containsOnly("foo");
        assertThatSelection("TextView", view).attribute("tag").containsOnly("bar");
    }

    @Test
    public void testFailingAttributeOnEmptySelection() {
        try {
            assertThatSelection("ImageView", viewFactory.createTextView()).attribute("tag");
            failHard();
        } catch (AssertionError ex) {
            // expected
        }
    }

    @Test
    public void testHasAttributeEqualTo() {
        TextView view = viewFactory.createTextView();
        view.setText("foo");
        view.setTag("bar");
        assertThatSelection("TextView", view).hasAttributeEqualTo("text", "foo");
        assertThatSelection("TextView", view).hasAttributeEqualTo("tag", "bar");
    }

    @Test
    public void testFailingHasAttributeEqualTo() {
        try {
            assertThatSelection("TextView", viewFactory.createTextView())
                .hasAttributeEqualTo("text", "foo");
            failHard();
        } catch (AssertionFailedError ex) {
            // expected
        }
    }

    @Test
    public void testFailingHasAttributeEqualToOnEmptySelection() {
        TextView view = viewFactory.createTextView();
        view.setTag("foo");
        try {
            assertThatSelection("ImageView", view).hasAttributeEqualTo("tag", "foo");
            failHard();
        } catch (AssertionError ex) {
            // expected
        }
    }

    @Test
    public void testNonExistentHasAttributeEqualTo() {
        try {
            assertThatSelection("TextView", viewFactory.createTextView())
                .hasAttributeEqualTo("foo", "bar");
            failHard();
        } catch (AttributeAccessException ex) {
            // expected
        }
    }

    @Test
    public void testHasAttributesEqualTo() {
        TextView view = viewFactory.createTextView();
        view.setText("foo");
        TextView view2 = viewFactory.createTextView();
        view2.setText("bar");
        LinearLayout root = viewFactory.createLinearLayout();
        root.addView(view);
        root.addView(view2);
        assertThatSelection("TextView", root)
            .hasSize(2)
            .hasAttributesEqualTo("text", "foo", "bar");
    }

    @Test
    public void testFailingHasAttributesEqualTo() {
        TextView view = viewFactory.createTextView();
        view.setText("foo");
        TextView view2 = viewFactory.createTextView();
        view.setText("bar");
        LinearLayout root = viewFactory.createLinearLayout();
        root.addView(view);
        root.addView(view2);
        try {
            assertThatSelection("TextView", root).hasAttributesEqualTo("text", "foo", "baz");
            failHard();
        } catch (AssertionFailedError ex) {
            // expected
        }
    }

    @Test
    public void testHasTag() {
        TextView view = viewFactory.createTextView();
        view.setTag("foo");
        assertThatSelection("TextView", view).hasTag("foo");
    }

    @Test
    public void testHasTagFailureOnMismatch() {
        TextView view = viewFactory.createTextView();
        view.setTag("foo");
        try {
            assertThatSelection("TextView", view).hasTag("bar");
            failHard();
        } catch (AssertionError ex) {
            // expected
        }
    }

    @Test
    public void testHasTagFailureOnNoTag() {
        TextView view = viewFactory.createTextView();
        try {
            assertThatSelection("TextView", view).hasTag("bar");
            failHard();
        } catch (AssertionError ex) {
            // expected
        }
    }

    @Test
    public void testHasTagFailureOnEmptySelection() {
        TextView view = viewFactory.createTextView();
        try {
            assertThatSelection("ImageView", view).hasTag("bar");
            failHard();
        } catch (AssertionError ex) {
            // expected
        }
    }

    @Test
    public void testHasTagFailureOnPartialSelectionMatch() {
        TextView view = viewFactory.createTextView();
        view.setTag("foo");
        TextView view2 = viewFactory.createTextView();
        view.setTag("bar");
        LinearLayout root = viewFactory.createLinearLayout();
        root.addView(view);
        root.addView(view2);
        try {
            assertThatSelection("TextView", view).hasTag("foo");
            failHard();
        } catch (AssertionError ex) {
            // expected
        }
    }

}
