package com.nikhaldimann.viewselector.checker;

import static android.test.MoreAsserts.assertContentsInOrder;

import java.util.Arrays;

import se.fishtank.css.selectors.Selector;
import se.fishtank.css.selectors.Selector.Combinator;
import android.test.AndroidTestCase;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ClassCheckerTest extends AndroidTestCase {

    private Iterable<View> check(String selectorTag, Combinator combinator, View... views) {
        Selector selector = new Selector(selectorTag, combinator);
        ClassChecker checker = new ClassChecker(selector);
        return checker.check(Arrays.asList(views));
    }

    public void testSingleView() {
        TextView view = new TextView(getContext());
        assertContentsInOrder(check("FooView", Combinator.DESCENDANT, view));
        assertContentsInOrder(check("TextView", Combinator.DESCENDANT, view), view);
        assertContentsInOrder(check("*", Combinator.DESCENDANT, view), view);
    }

    public void testViewGroupWithDescendants() {
        LinearLayout layout = new LinearLayout(getContext());
        TextView view1 = new TextView(getContext());
        TextView view2 = new TextView(getContext());
        layout.addView(view1);
        layout.addView(view2);
        FrameLayout layout2 = new FrameLayout(getContext());
        TextView view3 = new TextView(getContext());
        layout2.addView(view3);
        layout.addView(layout2);
        assertContentsInOrder(check("FooView", Combinator.DESCENDANT, layout));
        assertContentsInOrder(check("LinearLayout", Combinator.DESCENDANT, layout), layout);
        assertContentsInOrder(check("FrameLayout", Combinator.DESCENDANT, layout), layout2);
        assertContentsInOrder(check("TextView", Combinator.DESCENDANT, layout), view1, view2, view3);
    }

}
