package com.nikhaldimann.viewselector.activities;

import static com.nikhaldimann.viewselector.ViewSelectorAssertions.assertThatSelection;

import android.content.Intent;
import android.test.ActivityUnitTestCase;

import com.nikhaldimann.viewselector.test.MainActivity;

public class MainActivityTest extends ActivityUnitTestCase<MainActivity> {

    private MainActivity activity;

    public MainActivityTest() {
        super(MainActivity.class);
    }

    protected void setUp() throws Exception {
        super.setUp();
        startActivity(new Intent(getInstrumentation().getTargetContext(), MainActivity.class),
                null, null);
        activity = getActivity();
    }

    public void testHelloWorld() {
        assertThatSelection("TextView#hello_world", activity).hasSize(1);
    }
}
