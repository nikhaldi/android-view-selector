package com.nikhaldimann.viewselector.checker;

import static android.test.MoreAsserts.assertContentsInOrder;

import java.util.Arrays;

import se.fishtank.css.selectors.Selector;
import se.fishtank.css.selectors.Selector.Combinator;
import android.test.AndroidTestCase;
import android.view.View;
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

}
