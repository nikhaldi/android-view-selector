package com.nikhaldimann.viewselector.robolectric.activities;

import static com.nikhaldimann.viewselector.ViewSelectorAssertions.assertThatSelection;

import org.junit.Before;
import org.junit.Test;

import android.app.Activity;

public abstract class AbstractMainActivityTest {

    private Activity activity;

    protected abstract Activity createActivity();

    @Before
    public void setUp() {
        activity = createActivity();
    }

    @Test
    public void helloWorld() {
        assertThatSelection("TextView#hello_world", activity).hasSize(1);
    }
}
