package com.nikhaldimann.viewselector;

import java.util.List;

import se.fishtank.css.selectors.Selector;
import se.fishtank.css.selectors.Specifier;
import se.fishtank.css.selectors.scanner.Scanner;
import se.fishtank.css.selectors.scanner.ScannerException;
import se.fishtank.css.selectors.specifier.AttributeSpecifier;
import android.view.View;

import com.nikhaldimann.viewselector.checker.AttributeSpecifierChecker;
import com.nikhaldimann.viewselector.checker.ClassChecker;
import com.nikhaldimann.viewselector.checker.ViewTraversalChecker;
import com.nikhaldimann.viewselector.selection.ViewSelection;

/**
 * Represents a selector that can be applied to a view.
 */
public class ViewSelector {

    private final List<List<Selector>> selectorGroups;

    public ViewSelector(List<List<Selector>> selectorGroups) {
        this.selectorGroups = selectorGroups;
    }

    /**
     * Applies this selector to the given view, selecting all descendants of the
     * view that match this selector.
     * @return the ordered set of views that matches this selector
     */
    public ViewSelection selectViews(View view) {
        ViewSelection result = new ViewSelection();
        for (List<Selector> selectorParts : selectorGroups) {
            result.addAll(selectViewsForGroup(selectorParts, view));
        }
        return result;
    }

    private ViewSelection selectViewsForGroup(List<Selector> selectorParts, View view) {
        ViewSelection result = new ViewSelection();
        result.add(view);
        for (Selector selector : selectorParts) {
            ViewTraversalChecker checker = new ClassChecker(selector, view);
            result = checker.check(result);
            if (result.isEmpty()) {
                return result;
            }

            if (selector.hasSpecifiers())  {
                for (Specifier specifier : selector.getSpecifiers()) {
                    switch (specifier.getType()) {
                        case ATTRIBUTE:
                            checker = new AttributeSpecifierChecker((AttributeSpecifier) specifier, view);
                            break;
                        default:
                            throw new UnsupportedOperationException();
                    }
                    result = checker.check(result);
                    if (result.isEmpty()) {
                        return result;
                    }
                }
            }
        }
        return result;
    }

    /**
     * @return a new ViewSelector from the given selector string
     * @throws InvalidSelectorException if the given selector string can't be parsed into
     *     a valid selector
     */
    public static ViewSelector compile(String selectorString) {
        List<List<Selector>> groups;
        try {
            Scanner scanner = new Scanner(selectorString);
            groups = scanner.scan();
        } catch (ScannerException ex) {
            throw new InvalidSelectorException("Invalid selector: " + selectorString, ex);
        }
        return new ViewSelector(groups);
    }
}
