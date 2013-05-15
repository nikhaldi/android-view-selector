package com.nikhaldimann.viewselector.test;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Simple activity with a dynamic list view to demonstrate how testing
 * list views gets easy with ViewSelector.
 */
public class ListViewExampleActivity extends Activity {

    private ArrayAdapter<String> listAdapter;
    private List<String> groceries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        ListView list = (ListView) this.findViewById(R.id.groceries);
        groceries = new ArrayList<String>();
        listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, groceries);
        list.setAdapter(listAdapter);

        addGroceryItem("Milk");
        addGroceryItem("Cereal");

        listAdapter.notifyDataSetChanged();
    }

    /**
     * Adds an item to the grocery list.
     */
    public void addGroceryItem(String item) {
        groceries.add(item);
        listAdapter.notifyDataSetChanged();
    }

}
