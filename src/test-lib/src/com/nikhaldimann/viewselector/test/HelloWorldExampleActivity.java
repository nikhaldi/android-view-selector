package com.nikhaldimann.viewselector.test;

import android.app.Activity;
import android.os.Bundle;

/**
 * A simple activity to demonstrate basic ViewSelector testing of an activity.
 */
public class HelloWorldExampleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_world);
    }

}
