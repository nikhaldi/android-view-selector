package com.nikhaldimann.viewselector.test.abstrakt;

import static com.nikhaldimann.viewselector.ViewSelectorAssertions.assertThatSelection;
import junit.framework.AssertionFailedError;

import org.junit.Test;

import android.view.View;
import android.widget.TextView;

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
    public void testHasAttributeEqualTo() {
        TextView view = viewFactory.createTextView();
        view.setText("foo");
        view.setTag("bar");
        View root = wrapInRoot(view);
        assertThatSelection("TextView", root).hasAttributeEqualTo("text", "foo");
        assertThatSelection("TextView", root).hasAttributeEqualTo("tag", "bar");
    }

    @Test
    public void testFailingHasAttributeEqualTo() {
        try {
            assertThatSelection("TextView", wrapInRoot(viewFactory.createTextView()))
                .hasAttributeEqualTo("text", "foo");
            failHard();
        } catch (AssertionFailedError ex) {
            // expected
        }
    }

    @Test
    public void testHasAttributesEqualTo() {
        TextView view = viewFactory.createTextView();
        view.setText("foo");
        TextView view2 = viewFactory.createTextView();
        view2.setText("bar");
        View root = wrapInRoot(view, view2);
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
        View root = wrapInRoot(view, view2);
        try {
            assertThatSelection("TextView", root).hasAttributesEqualTo("text", "foo", "baz");
            failHard();
        } catch (AssertionFailedError ex) {
            // expected
        }
    }

}
