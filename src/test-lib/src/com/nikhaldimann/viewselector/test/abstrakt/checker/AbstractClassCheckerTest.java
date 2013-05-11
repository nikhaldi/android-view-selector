package com.nikhaldimann.viewselector.test.abstrakt.checker;

import java.util.Arrays;

import org.junit.Test;

import se.fishtank.css.selectors.Selector;
import se.fishtank.css.selectors.Selector.Combinator;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nikhaldimann.viewselector.checker.ClassChecker;
import com.nikhaldimann.viewselector.test.util.ViewSelectorAndroidTestCase;

public abstract class AbstractClassCheckerTest extends ViewSelectorAndroidTestCase {

    private Iterable<View> check(String selectorTag, Combinator combinator, View... views) {
        Selector selector = new Selector(selectorTag, combinator);
        ClassChecker checker = new ClassChecker(selector);
        return checker.check(Arrays.asList(views));
    }

    @Test
    public void testSingleView() {
        TextView view = viewFactory.createTextView();
        View root = wrapInRoot(view);
        assertContentsInOrder(check("FooView", Combinator.DESCENDANT, root));
        assertContentsInOrder(check("TextView", Combinator.DESCENDANT, root), view);
        assertContentsInOrder(check("*", Combinator.DESCENDANT, root), view);
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
        View root = wrapInRoot(layout);
        assertContentsInOrder(check("FooView", Combinator.DESCENDANT, root));
        assertContentsInOrder(check("LinearLayout", Combinator.DESCENDANT, root), layout);
        assertContentsInOrder(check("FrameLayout", Combinator.DESCENDANT, root), layout2);
        assertContentsInOrder(check("TextView", Combinator.DESCENDANT, root), view1, view2, view3);
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

}
