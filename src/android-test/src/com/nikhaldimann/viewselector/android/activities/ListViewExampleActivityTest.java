package com.nikhaldimann.viewselector.android.activities;

import static com.nikhaldimann.viewselector.ViewSelectorAssertions.assertThatSelection;
import android.test.ActivityInstrumentationTestCase2;

import com.nikhaldimann.viewselector.test.ListViewExampleActivity;

/**
 * Example unit test for an activity with a dynamic list view. TODO More explanation
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

//        activity.addGroceryItem("Milk");
//        activity.addGroceryItem("Cereal");
//
//        // Assert that the groceries ListView now has two items
//        assertThatSelection("#groceries *", activity)
//            .hasSize(2)
//            .hasAttributesEqualTo("text", "Milk", "Cereal");
    }

}
