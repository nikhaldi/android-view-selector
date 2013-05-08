package com.nikhaldimann.viewselector;

import java.util.ArrayList;
import java.util.List;

import se.fishtank.css.selectors.Selector;
import se.fishtank.css.selectors.scanner.Scanner;
import se.fishtank.css.selectors.scanner.ScannerException;
import android.view.View;

public class ViewSelector {

    private final List<Selector> selectorParts;

    public ViewSelector(List<Selector> selectorParts) {
        this.selectorParts = selectorParts;
    }

    public List<Object> matchView(View view) {
        List<Object> result = new ArrayList<Object>();
        result.add(view);
        for (Selector selector : selectorParts) {
            result = checkClass(selector, result);
        }
        return result;
    }

    private List<Object> checkClass(Selector selector, List<Object> nodes) {
        List<Object> result = new ArrayList<Object>();
        String className = selector.getTagName();
        for (Object node : nodes) {
            if (node instanceof View) {
                if (matchesClassName(className, node)) {
                    result.add(node);
                }
            }
        }
        return result;
    }

    private boolean matchesClassName(String className, Object object) {
        String objectClass = object.getClass().getName();
        objectClass = objectClass.substring(objectClass.lastIndexOf('.') + 1);
        return className.equals(objectClass);
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
        System.out.println(groups);
        return new ViewSelector(groups.get(0));
    }
}
