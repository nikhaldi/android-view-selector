package com.nikhaldimann.viewselector.android.activities;

import static com.nikhaldimann.viewselector.ViewSelectorAssertions.assertThatSelection;
import android.content.Intent;
import android.test.ActivityUnitTestCase;

import com.nikhaldimann.viewselector.test.HelloWorldExampleFragmentActivity;

/**
 * Example unit test for a simple activity. The layout of the activity has a single
 * TextView with id "hello_world" and text "Hello world!".
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

    public void testHelloWorld() {
        activity = startActivity(new Intent(getInstrumentation().getTargetContext(),
                HelloWorldExampleFragmentActivity.class), null, null);

        assertThatSelection("TextView#hello_world", activity)
            .hasSize(1)
            .hasAttributeEqualTo("text", "Hello world!");
    }

}