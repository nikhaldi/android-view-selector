package com.nikhaldimann.viewselector.activities;

import static com.nikhaldimann.viewselector.ViewSelectorAssertions.assertThatSelection;
import android.app.Fragment;
import android.app.FragmentManager;

import com.nikhaldimann.viewselector.test.MainActivity;
import com.nikhaldimann.viewselector.test.SimpleFragment;

public class MainActivityTest extends AbstractMainActivityTest<MainActivity> {

    public MainActivityTest() {
        super(MainActivity.class);
    }

    /**
     * Adds the fragment to a the activity, thereby fully initializing its view.
     */
    private void startFragment(Fragment fragment) {
        FragmentManager manager = activity.getFragmentManager();
        manager.beginTransaction().add(fragment, null).commit();
        manager.executePendingTransactions();
    }

    public void testSimpleFragment() {
        SimpleFragment fragment = new SimpleFragment();
        startFragment(fragment);
        assertThatSelection("TextView#hello_world", fragment.getView()).hasSize(1);
    }

}
