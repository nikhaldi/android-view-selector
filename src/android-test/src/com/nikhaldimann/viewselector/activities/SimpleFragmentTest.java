package com.nikhaldimann.viewselector.activities;

import static com.nikhaldimann.viewselector.ViewSelectorAssertions.assertThatSelection;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.test.ActivityUnitTestCase;

import com.nikhaldimann.viewselector.test.HelloWorldExampleActivity;
import com.nikhaldimann.viewselector.test.SimpleFragment;

/**
 * Example unit test for a simple fragment. Though creating an activity to fully
 * start the fragment may not be necessary for most cases.
 *
 * Keep this example self-contained so it can be referenced from documentation.
 */
public class SimpleFragmentTest extends ActivityUnitTestCase<HelloWorldExampleActivity> {

    public SimpleFragmentTest() {
        super(HelloWorldExampleActivity.class);
    }

    private HelloWorldExampleActivity activity;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        startActivity(new Intent(getInstrumentation().getTargetContext(),
                HelloWorldExampleActivity.class), null, null);
        activity = getActivity();
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
