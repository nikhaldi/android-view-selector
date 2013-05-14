package com.nikhaldimann.viewselector.test.abstrakt;

import org.junit.Test;

import android.text.InputType;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nikhaldimann.viewselector.InvalidSelectorException;
import com.nikhaldimann.viewselector.ViewSelector;
import com.nikhaldimann.viewselector.selection.ViewSelection;
import com.nikhaldimann.viewselector.test.R;
import com.nikhaldimann.viewselector.test.util.ViewSelectorAndroidTestCase;

public abstract class AbstractViewSelectorTest extends ViewSelectorAndroidTestCase {

    private ViewSelection selectViews(String selector, View view) {
        return ViewSelector.compile(selector).selectViews(view);
    }

    @Test
    public void testSelectViewsSimpleSingleView() {
        TextView view = viewFactory.createTextView();
        assertContentsInOrder(selectViews("EditView", view));
        assertContentsInOrder(selectViews("TextView", view), view);
        assertContentsInOrder(selectViews("", view));
        assertContentsInOrder(selectViews("  ", view));
    }

    @Test
    public void testCompileInvalidSelector() {
        try {
            ViewSelector.compile("> EditView");
            fail();
        } catch (InvalidSelectorException ex) {
            // expected
        }
    }

    @Test
    public void testSelectyById() {
        TextView view = viewFactory.createTextView();
        view.setId(R.id.hello_world);
        assertContentsInOrder(selectViews("#hello_world", view), view);
        assertContentsInOrder(selectViews("#foobar", view));
        assertContentsInOrder(selectViews("TextView#hello_world", view), view);
        assertContentsInOrder(selectViews("ImageView#hello_world", view));
        assertContentsInOrder(selectViews("TextView#foobar", view));
    }

    @Test
    public void testSelectViewsDescendants() {
        LinearLayout layout = viewFactory.createLinearLayout();
        TextView view = viewFactory.createTextView();
        TextView view2 = viewFactory.createTextView();
        layout.addView(view);
        layout.addView(view2);
        assertContentsInOrder(selectViews("*", layout), layout, view, view2);
        assertContentsInOrder(selectViews("* TextView", layout), view, view2);
        assertContentsInOrder(selectViews("* *", layout), layout, view, view2);
        assertContentsInOrder(selectViews("* * Foo", layout));
    }

    @Test
    public void testSelectViewsChildren() {
        LinearLayout layout = viewFactory.createLinearLayout();
        TextView view = viewFactory.createTextView();
        TextView view2 = viewFactory.createTextView();
        layout.addView(view);
        layout.addView(view2);
        assertContentsInOrder(selectViews("* > *", layout), view, view2);
        assertContentsInOrder(selectViews("* > TextView", layout), view, view2);
        assertContentsInOrder(selectViews("LinearLayout > TextView", layout), view, view2);
        assertContentsInOrder(selectViews("Foo > TextView", layout));
        assertContentsInOrder(selectViews("* > Foo", layout));
    }

    @Test
    public void testSelectViewsUnion() {
        LinearLayout layout = viewFactory.createLinearLayout();
        TextView view = viewFactory.createTextView();
        TextView view2 = viewFactory.createTextView();
        layout.addView(view);
        layout.addView(view2);
        assertContentsInOrder(selectViews("TextView,LinearLayout", layout), view, view2, layout);
        assertContentsInOrder(selectViews("TextView, Foo", layout), view, view2);
    }

    @Test
    public void testSelectyByAttributeExistence() {
        TextView view = viewFactory.createTextView();
        assertContentsInOrder(selectViews("[text]", view), view);
        assertContentsInOrder(selectViews("[tag]", view));
        assertContentsInOrder(selectViews("TextView[text]", view), view);
        assertContentsInOrder(selectViews("TextView[foo]", view));
    }

    @Test
    public void testSelectyByExactAttributeMatch() {
        TextView view = viewFactory.createTextView();
        view.setTag("foo");
        view.setText("bar");
        view.setInputType(InputType.TYPE_CLASS_PHONE);
        view.setVisibility(View.INVISIBLE);
        assertContentsInOrder(selectViews("[tag=foo]", view), view);
        assertContentsInOrder(selectViews("[tag=foo][text=bar]", view), view);
        assertContentsInOrder(selectViews("[tag=bar]", view));
        assertContentsInOrder(selectViews("[foo=bar]", view));
        assertContentsInOrder(selectViews(String.format("[inputType='%s']", InputType.TYPE_CLASS_PHONE), view), view);
        assertContentsInOrder(selectViews("[inputType='42']", view));
        assertContentsInOrder(selectViews("[isShown=false]", view), view);
        assertContentsInOrder(selectViews("[isShown=true]", view));
    }

}
