package com.nikhaldimann.viewselector.test.abstrakt.checker;

import org.junit.Test;

import se.fishtank.css.selectors.specifier.AttributeSpecifier;
import se.fishtank.css.selectors.specifier.AttributeSpecifier.Match;
import android.text.InputType;
import android.view.View;
import android.widget.TextView;

import com.nikhaldimann.viewselector.checker.AttributeSpecifierChecker;
import com.nikhaldimann.viewselector.selection.ViewSelection;
import com.nikhaldimann.viewselector.test.util.ViewSelectorAndroidTestCase;

public abstract class AbstractAttributeSpecifierCheckerTest extends ViewSelectorAndroidTestCase {

    private Iterable<View> checkExistence(String name, View view) {
        return check(new AttributeSpecifier(name), view);
    }

    private Iterable<View> check(String name, String value, Match match, View view) {
        return check(new AttributeSpecifier(name, value, match), view);
    }

    private Iterable<View> check(AttributeSpecifier specifier, View view) {
        AttributeSpecifierChecker checker = new AttributeSpecifierChecker(specifier, view);
        ViewSelection selection = new ViewSelection();
        selection.add(view);
        return checker.check(selection);
    }

    @Test
    public void testAttributeExistence() {
        TextView view = viewFactory.createTextView();
        assertContentsInOrder(checkExistence("tag", view));
        assertContentsInOrder(checkExistence("text", view), view);
        assertContentsInOrder(checkExistence("width", view), view);
        assertContentsInOrder(checkExistence("foo", view));
    }

    @Test
    public void testExactMatch() {
        TextView view = viewFactory.createTextView();
        view.setTag("foo");
        assertContentsInOrder(check("tag", "foo", Match.EXACT, view), view);
        assertContentsInOrder(check("tag", "bar", Match.EXACT, view));
        assertContentsInOrder(check("gobbledygook", "bar", Match.EXACT, view));
    }

    @Test
    public void testExactMatchWithNumbers() {
        TextView view = viewFactory.createTextView();
        view.setInputType(InputType.TYPE_CLASS_TEXT);
        assertContentsInOrder(
                check("inputType", String.valueOf(InputType.TYPE_CLASS_TEXT), Match.EXACT, view),
                view);
        assertContentsInOrder(check("inputType", "42", Match.EXACT, view));
        assertContentsInOrder(check("inputType", "foo", Match.EXACT, view));
    }

    @Test
    public void testExactMatchWithBooleans() {
        TextView view = viewFactory.createTextView();
        view.setVisibility(View.INVISIBLE);
        assertContentsInOrder(check("isShown", "false", Match.EXACT, view), view);
        assertContentsInOrder(check("isShown", "true", Match.EXACT, view));
        assertContentsInOrder(check("isShown", "foo", Match.EXACT, view));
    }

    @Test
    public void testContainsMatch() {
        TextView view = viewFactory.createTextView();
        view.setTag("foobar");
        assertContentsInOrder(check("tag", "f", Match.CONTAINS, view), view);
        assertContentsInOrder(check("tag", "oba", Match.CONTAINS, view), view);
        assertContentsInOrder(check("tag", "baar", Match.CONTAINS, view));
        assertContentsInOrder(check("isShown", "foo", Match.CONTAINS, view));
    }

    @Test
    public void testPrefixMatch() {
        TextView view = viewFactory.createTextView();
        view.setTag("foobar");
        assertContentsInOrder(check("tag", "f", Match.PREFIX, view), view);
        assertContentsInOrder(check("tag", "foob", Match.PREFIX, view), view);
        assertContentsInOrder(check("tag", "bar", Match.PREFIX, view));
        assertContentsInOrder(check("tag", "foe", Match.PREFIX, view));
        assertContentsInOrder(check("tag", "foobare", Match.PREFIX, view));
        assertContentsInOrder(check("isShown", "foo", Match.PREFIX, view));
    }

    @Test
    public void testSuffixMatch() {
        TextView view = viewFactory.createTextView();
        view.setTag("foobar");
        assertContentsInOrder(check("tag", "r", Match.SUFFIX, view), view);
        assertContentsInOrder(check("tag", "bar", Match.SUFFIX, view), view);
        assertContentsInOrder(check("tag", "a foobar", Match.SUFFIX, view));
        assertContentsInOrder(check("tag", "foo", Match.SUFFIX, view));
        assertContentsInOrder(check("isShown", "false", Match.SUFFIX, view));
    }

}
