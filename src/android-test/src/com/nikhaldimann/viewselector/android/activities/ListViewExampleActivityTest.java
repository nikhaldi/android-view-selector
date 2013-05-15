package com.nikhaldimann.viewselector.android.activities;

import static com.nikhaldimann.viewselector.ViewSelectorAssertions.assertThatSelection;

import android.test.ActivityInstrumentationTestCase2;

import com.nikhaldimann.viewselector.test.ListViewExampleActivity;

/**
 * Example unit test for an activity with a dynamic list view. The acticity has
 * a ListView with the id "groceries". We can add items to the list.
 *
 * Keep this example self-contained so it can be referenced from documentation.
 */
public class ListViewExampleActivityTest extends ActivityInstrumentationTestCase2<ListViewExampleActivity> {

    private ListViewExampleActivity activity;

    public ListViewExampleActivityTest() {
        super(ListViewExampleActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        activity = getActivity();
    }

    public void testListView() {
        // Assert that there is a ListView with id "groceries" in this activity
        assertThatSelection("ListView#groceries", activity).hasSize(1);
        // Assert that the groceries ListView currently has no items in it
        assertThatSelection("#groceries TextView", activity).isEmpty();

        // Add a couple of items to the list and wait for the UI to update itself
        activity.runOnUiThread(new Runnable() {
            public void run() {
                activity.addGroceryItem("Milk");
                activity.addGroceryItem("Cereal");
            }
        });
        getInstrumentation().waitForIdleSync();

        // Assert that the groceries ListView now has two items
        assertThatSelection("#groceries TextView", activity)
            .hasSize(2)
            .hasAttributesEqualTo("text", "Milk", "Cereal");
    }

}
