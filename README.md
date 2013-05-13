ViewSelector
===========

ViewSelector is an experiment in using CSS-style selectors for unit testing particularly
complex and dynamic Android UIs. It's compatible with both Android test projects and
Robolectric. It was inspired by the very handy assert_select in Rails.

Currently under heavy development. Alpha releases are available from
[Maven Central](http://search.maven.org/#search%7Cgav%7C1%7Cg%3A%22com.nikhaldimann%22%20AND%20a%3A%22android-view-selector%22).


## API

It's recommended to use fluent assertions (based on [FEST](http://fest.easytesting.org/)):

    import static com.nikhaldimann.viewselector.ViewSelectorAssertions.assertThat;
    import static com.nikhaldimann.viewselector.ViewSelectorAssertions.selection;
    ...

    // Assert that rootView has 5 descendant views that are TextViews
    assertThat(selection("TextView", rootView)).hasSize(5);

    // Assert that there are 4 TextViews that are descendants of the view with id
    // "container" and all have a width of 100 pixels
    assertThat(selection("#container ImageView", rootView))
        .hasSize(4)
        .hasAttributeEqualTo("width", 100);

    // Assert that the TextViews which are direct children of a LinearLayout with
    // id "groceries" have text "milk", "cereal" (in that order)
    assertThat(selection("LinearLayout#groceries > TextView", rootView))
        .hasAttributesEqualTo("text", "milk", "cereal");

If you're already statically importing a different FEST-style `assertThat` method, you can
statically import ViewSelector's `assertThatSelection` to avoid conflicts:

    import static com.nikhaldimann.viewselector.ViewSelectorAssertions.assertThatSelection;
    ...

    // Equivalent to the first assertion above
    assertThatSelection("TextView", rootView).hasSize(5);


## License

Distributed under an [MIT license](https://github.com/nikhaldi/android-view-selector/blob/master/LICENSE.md).
