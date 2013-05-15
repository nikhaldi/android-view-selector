package com.nikhaldimann.viewselector.robolectric.activities;

import org.junit.runner.RunWith;

import android.app.Activity;

import com.nikhaldimann.viewselector.robolectric.RobolectricTestHelloWorldActivity;
import com.xtremelabs.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class HelloWorldActivityTest extends AbstractMainActivityTest {

    protected Activity createActivity() {
        RobolectricTestHelloWorldActivity activity = new RobolectricTestHelloWorldActivity();
        activity.onCreate(null);
        return activity;
    }

}
