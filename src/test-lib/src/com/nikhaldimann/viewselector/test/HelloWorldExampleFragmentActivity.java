package com.nikhaldimann.viewselector.test;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * A simple activity to demonstrate basic ViewSelector testing of an activity,
 * subclassing {@code FragmentActivity} to verify compatibility with the support
 * libraries.
 */
public class HelloWorldExampleFragmentActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_world);
    }

}
