package com.nikhaldimann.viewselector.robolectric.activities;

import org.junit.runner.RunWith;

import android.app.Activity;

import com.nikhaldimann.viewselector.robolectric.RobolectricTestMainFragmentActivity;
import com.xtremelabs.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class MainFragmentActivityTest extends AbstractMainActivityTest {

    protected Activity createActivity() {
        RobolectricTestMainFragmentActivity activity = new RobolectricTestMainFragmentActivity();
        activity.onCreate(null);
        return activity;
    }

}
