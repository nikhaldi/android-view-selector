package com.nikhaldimann.viewselector.activities;

import static com.nikhaldimann.viewselector.ViewSelectorAssertions.assertThatSelection;
import android.content.Intent;
import android.test.ActivityUnitTestCase;

import com.nikhaldimann.viewselector.test.HelloWorldExampleFragmentActivity;

/**
 * Example unit test for a simple activity. The layout of the activity has a single
 * TextView with id "hello_world" and text "Hello World".
 *
 * This is equivalent to {@link HelloWorldExampleActivityTest} but uses a
 * {@code FragmentActivity}.
 *
 * Keep this example self-contained so it can be referenced from documentation.
 */
public class HelloWorldExampleFragmentActivityTest extends ActivityUnitTestCase<HelloWorldExampleFragmentActivity> {

    public HelloWorldExampleFragmentActivityTest() {
        super(HelloWorldExampleFragmentActivity.class);
    }

    private HelloWorldExampleFragmentActivity activity;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        startActivity(new Intent(getInstrumentation().getTargetContext(),
                HelloWorldExampleFragmentActivity.class), null, null);
        activity = getActivity();
    }

    public void testHelloWorld() {
        assertThatSelection("TextView#hello_world", activity).hasSize(1);
    }

}