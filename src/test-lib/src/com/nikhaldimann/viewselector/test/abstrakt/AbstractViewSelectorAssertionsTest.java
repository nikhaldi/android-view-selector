package com.nikhaldimann.viewselector.test.abstrakt;

import static com.nikhaldimann.viewselector.ViewSelectorAssertions.assertThat;
import static com.nikhaldimann.viewselector.ViewSelectorAssertions.assertThatSelection;
import static com.nikhaldimann.viewselector.ViewSelectorAssertions.extractAttribute;
import static com.nikhaldimann.viewselector.ViewSelectorAssertions.selection;

import org.junit.Test;

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
        assertThat(selection("TextView", view))
            .hasSize(1)
            .startsWith(view)
            .endsWith(view);
    }

    @Test
    public void testFailingAssertThat() {
        try {
            assertThat(selection("TextView", viewFactory.createTextView())).isEmpty();
            failHard();
        } catch (AssertionError ex) {
            // expected
        }
    }

    @Test
    public void testAssertThatSelection() {
        assertThatSelection("TextView", viewFactory.createTextView()).hasSize(1);
    }

    @Test
    public void testFailingAssertThatSelection() {
        try {
            assertThatSelection("TextView", viewFactory.createTextView()).isEmpty();
            failHard();
        } catch (AssertionError ex) {
            // expected
        }
    }

    @Test
    public void testExtractAttribute() {
        TextView view = viewFactory.createTextView();
        view.setText("foo");
        assertThat(extractAttribute("text").from(selection("TextView", view)))
            .containsExactly("foo");
    }

}
