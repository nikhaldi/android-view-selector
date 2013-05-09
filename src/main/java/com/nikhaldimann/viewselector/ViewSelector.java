package com.nikhaldimann.viewselector;

import java.util.ArrayList;
import java.util.List;

import se.fishtank.css.selectors.Selector;
import se.fishtank.css.selectors.scanner.Scanner;
import se.fishtank.css.selectors.scanner.ScannerException;
import android.view.View;

import com.nikhaldimann.viewselector.checker.ClassChecker;

public class ViewSelector {

    private final List<Selector> selectorParts;

    public ViewSelector(List<Selector> selectorParts) {
        this.selectorParts = selectorParts;
    }

    public List<View> matchView(View view) {
        List<View> result = new ArrayList<View>();
        result.add(view);
        for (Selector selector : selectorParts) {
            ClassChecker checker = new ClassChecker(selector);
            result = checker.check(result);
        }
        return result;
    }

    public static ViewSelector compile(String selectorString) {
        List<List<Selector>> groups;
        try {
            Scanner scanner = new Scanner(selectorString);
            groups = scanner.scan();
        } catch (ScannerException ex) {
            // TODO deal with failure more explicitly
            throw new RuntimeException(ex);
        }
        if (groups.size() != 1) {
            // TODO more explicit failure
            throw new RuntimeException("no single selector");
        }
        return new ViewSelector(groups.get(0));
    }
}
