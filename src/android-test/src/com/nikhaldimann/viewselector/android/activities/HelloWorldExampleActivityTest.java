package com.nikhaldimann.viewselector.android.activities;

import static com.nikhaldimann.viewselector.ViewSelectorAssertions.assertThatSelection;
import android.content.Intent;
import android.test.ActivityUnitTestCase;

import com.nikhaldimann.viewselector.test.HelloWorldExampleActivity;

/**
 * Example unit test for a simple activity. The layout of the activity has a single
 * TextView with id "hello_world" and text "Hello world!".
 *
 * Keep this example self-contained so it can be referenced from documentation.
 */
public class HelloWorldExampleActivityTest extends ActivityUnitTestCase<HelloWorldExampleActivity> {

    public HelloWorldExampleActivityTest() {
        super(HelloWorldExampleActivity.class);
    }

    private HelloWorldExampleActivity activity;

    public void testHelloWorld() {
        activity = startActivity(new Intent(getInstrumentation().getTargetContext(),
                HelloWorldExampleActivity.class), null, null);

        assertThatSelection("TextView#hello_world", activity)
            .hasSize(1)
            .hasAttributeEqualTo("text", "Hello world!");
    }

}
