package com.nikhaldimann.viewselector.test.abstrakt.checker;

import org.junit.Test;

import se.fishtank.css.selectors.Selector;
import se.fishtank.css.selectors.Selector.Combinator;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nikhaldimann.viewselector.checker.ClassChecker;
import com.nikhaldimann.viewselector.selection.ViewSelection;
import com.nikhaldimann.viewselector.test.util.ViewSelectorAndroidTestCase;

public abstract class AbstractClassCheckerTest extends ViewSelectorAndroidTestCase {

    private Iterable<View> check(String selectorTag, Combinator combinator, View view) {
        Selector selector = new Selector(selectorTag, combinator);
        ClassChecker checker = new ClassChecker(selector, view);
        ViewSelection selection = new ViewSelection();
        selection.add(view);
        return checker.check(selection);
    }

    @Test
    public void testSingleView() {
        TextView view = viewFactory.createTextView();
        assertContentsInOrder(check("FooView", Combinator.DESCENDANT, view));
        assertContentsInOrder(check("TextView", Combinator.DESCENDANT, view), view);
        assertContentsInOrder(check("*", Combinator.DESCENDANT, view), view);
    }

    @Test
    public void testViewGroupWithDescendants() {
        LinearLayout layout = viewFactory.createLinearLayout();
        TextView view1 = viewFactory.createTextView();
        TextView view2 = viewFactory.createTextView();
        layout.addView(view1);
        layout.addView(view2);
        FrameLayout layout2 = viewFactory.createFrameLayout();
        TextView view3 = viewFactory.createTextView();
        layout2.addView(view3);
        layout.addView(layout2);
        assertContentsInOrder(check("*", Combinator.DESCENDANT, layout), layout, view1, view2, layout2, view3);
        assertContentsInOrder(check("FooView", Combinator.DESCENDANT, layout));
        assertContentsInOrder(check("LinearLayout", Combinator.DESCENDANT, layout), layout);
        assertContentsInOrder(check("FrameLayout", Combinator.DESCENDANT, layout), layout2);
        assertContentsInOrder(check("TextView", Combinator.DESCENDANT, layout), view1, view2, view3);
    }

    @Test
    public void testViewGroupWithChildren() {
        LinearLayout layout = viewFactory.createLinearLayout();
        TextView view1 = viewFactory.createTextView();
        TextView view2 = viewFactory.createTextView();
        layout.addView(view1);
        layout.addView(view2);
        FrameLayout layout2 = viewFactory.createFrameLayout();
        TextView view3 = viewFactory.createTextView();
        layout2.addView(view3);
        layout.addView(layout2);
        assertContentsInOrder(check("FooView", Combinator.CHILD, layout));
        assertContentsInOrder(check("LinearLayout", Combinator.CHILD, layout));
        assertContentsInOrder(check("TextView", Combinator.CHILD, layout), view1, view2);
        assertContentsInOrder(check("FrameLayout", Combinator.CHILD, layout2));
    }

    @Test
    public void testAdjacentSiblings() {
        LinearLayout layout = viewFactory.createLinearLayout();
        TextView view1 = viewFactory.createTextView();
        TextView view2 = viewFactory.createTextView();
        TextView view3 = viewFactory.createTextView();
        layout.addView(view1);
        layout.addView(view2);
        layout.addView(view3);
        assertContentsInOrder(
                check("TextView", Combinator.ADJACENT_SIBLING, layout));
        assertContentsInOrder(
                check("TextView", Combinator.ADJACENT_SIBLING, view1), view2);
        assertContentsInOrder(
                check("TextView", Combinator.ADJACENT_SIBLING, view2), view3);
        assertContentsInOrder(
                check("TextView", Combinator.ADJACENT_SIBLING, view3));
    }

    @Test
    public void testGeneralSiblings() {
        LinearLayout layout = viewFactory.createLinearLayout();
        TextView view1 = viewFactory.createTextView();
        TextView view2 = viewFactory.createTextView();
        TextView view3 = viewFactory.createTextView();
        layout.addView(view1);
        layout.addView(view2);
        layout.addView(view3);
        assertContentsInOrder(
                check("TextView", Combinator.GENERAL_SIBLING, layout));
        assertContentsInOrder(
                check("TextView", Combinator.GENERAL_SIBLING, view1), view2, view3);
        assertContentsInOrder(
                check("TextView", Combinator.GENERAL_SIBLING, view2), view3);
        assertContentsInOrder(
                check("TextView", Combinator.GENERAL_SIBLING, view3));
    }

}
