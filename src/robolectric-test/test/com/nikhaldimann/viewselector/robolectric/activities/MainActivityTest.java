package com.nikhaldimann.viewselector.robolectric.activities;

import static com.nikhaldimann.viewselector.ViewSelectorAssertions.assertThatSelection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.nikhaldimann.viewselector.robolectric.RobolectricTestMainActivity;
import com.xtremelabs.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {

    private RobolectricTestMainActivity activity;

    @Before
    public void setUp() {
        activity = new RobolectricTestMainActivity();
        activity.onCreate(null);
    }

    @Test
    public void helloWorld() {
        assertThatSelection("TextView#hello_world", activity).hasSize(1);
    }
}
