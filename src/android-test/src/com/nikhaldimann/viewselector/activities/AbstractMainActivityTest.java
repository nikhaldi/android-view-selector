package com.nikhaldimann.viewselector.activities;

import static com.nikhaldimann.viewselector.ViewSelectorAssertions.assertThatSelection;
import android.app.Activity;
import android.content.Intent;
import android.test.ActivityUnitTestCase;

public abstract class AbstractMainActivityTest<A extends Activity> extends ActivityUnitTestCase<A> {

    private final Class<A> klass;
    protected A activity;

    public AbstractMainActivityTest(Class<A> klass) {
        super(klass);
        this.klass = klass;
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        startActivity(new Intent(getInstrumentation().getTargetContext(), klass),
                null, null);
        activity = getActivity();
    }

    public void testHelloWorld() {
        assertThatSelection("TextView#hello_world", activity).hasSize(1);
    }
}