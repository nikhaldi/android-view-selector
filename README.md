ViewSelector
===========

ViewSelector is an experiment in using CSS-style selectors for unit testing particularly
complex and dynamic Android UIs. It's compatible with both Android test projects and
Robolectric. It was inspired by very handy assert_select in Rails.

Currently under heavy development. Alpha releases are available from
[Maven Central](http://search.maven.org/#search%7Cgav%7C1%7Cg%3A%22com.nikhaldimann%22%20AND%20a%3A%22android-view-selector%22).


## API

It's recommended to use fluent assertions (based on [FEST](http://fest.easytesting.org/)):

    import static com.nikhaldimann.viewselector.ViewSelectorAssertions.assertThatSelection;
    ...

    // Assert that rootView has 5 descendant views that are TextViews
    assertThatSelection("TextView", rootView).hasSize(5);

    // Assert that there are 4 TextViews that are descendants of the view with id
    // "container" and all have a width of 100 pixels
    assertThatSelection("#container ImageView", rootView)
        .hasSize(4)
        .hasAttributeEqualTo("width", 100);

    // Assert that the TextViews which are direct children of a LinearLayout with
    // id "groceries" have text "milk", "cereal" (in that order)
    assertThatSelection("LinearLayout#groceries > TextView", rootView)
        .hasAttributesEqualTo("text", "milk", "cereal");


## License

Distributed under an [MIT license](https://github.com/nikhaldi/android-view-selector/blob/master/LICENSE.md).
