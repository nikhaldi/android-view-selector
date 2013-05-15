package com.nikhaldimann.viewselector.robolectric.activities;

import org.junit.runner.RunWith;

import android.app.Activity;

import com.nikhaldimann.viewselector.robolectric.RobolectricTestHelloWorldFragmentActivity;
import com.xtremelabs.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class HelloWorldFragmentActivityTest extends AbstractMainActivityTest {

    protected Activity createActivity() {
        RobolectricTestHelloWorldFragmentActivity activity = new RobolectricTestHelloWorldFragmentActivity();
        activity.onCreate(null);
        return activity;
    }

}
