package com.nikhaldimann.viewselector.robolectric;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * Robolectric 1.2 can't see resources from an Android library, so we
 * need to create a separate activity here with a layout defined in
 * this project rather than the shared test library.
 */
public class RobolectricTestHelloWorldFragmentActivity extends FragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_world);
    }

}
