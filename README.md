Android ViewSelector
====================

ViewSelector makes unit testing Android UIs easier with CSS-style selectors. It
can express complex assertions about the UI with little code and without manually
fussing around with views.

    // These traditional assertions ...
    ListView view = (ListView) activity.findViewById(R.id.groceries);
    assertEquals(2, view.getChildCount());
    assertEquals("milk", ((TextView) view.getChildAt(0)).getText());
    assertEquals("cereal", ((TextView) view.getChildAt(1)).getText());

    // ... can be expressed as:
    assertThat(selection("ListView#groceries TextView", activity))
        .attribute("text").containsExactly("milk", "cereal");

It's compatible with both Android tests and Robolectric (1.2 & 2.x) tests. It was inspired
by the very handy assert_select in Rails and Android's own
[UiSelector](http://developer.android.com/tools/help/uiautomator/UiSelector.html).

Currently under development.


## Installation

### Maven

Releases are available from
[Maven Central](http://search.maven.org/#search%7Cgav%7C1%7Cg%3A%22com.nikhaldimann%22%20AND%20a%3A%22android-view-selector%22).
Add this dependency to your pom.xml:

    <dependency>
      <groupId>com.nikhaldimann</groupId>
      <artifactId>android-view-selector</artifactId>
      <version>1.0-beta-1</version>
      <scope>test</scope>
    </dependency>

### JARs

If contrary to all that is good and reasonable you're not using Maven, you can download
the lastest JAR with dependencies (android-view-selector-RELEASE-jar-with-dependencies.jar)
from [Sonatype](https://oss.sonatype.org/index.html#nexus-search;quick~android-view-selector).


## API

### Examples

ViewSelector uses fluent assertions (based on [FEST](http://fest.easytesting.org/)
and [FEST Android](http://square.github.io/fest-android/)):

    import static com.nikhaldimann.viewselector.ViewSelectorAssertions.assertThat;
    import static com.nikhaldimann.viewselector.ViewSelectorAssertions.selection;
    ...

    // Assert that rootView has 5 descendant views that are TextViews
    assertThat(selection("TextView", activity)).hasSize(5);

    // Assert that there are 4 TextViews that are descendants of the view with id
    // "container" and all have a width of 100 pixels
    assertThat(selection("#container ImageView", activity))
        .hasSize(4)
        .hasAttributeEqualTo("width", 100);

    // Assert that the TextViews which are direct children of a LinearLayout with
    // id "groceries" have text "milk", "cereal" (in that order)
    assertThat(selection("LinearLayout#groceries > TextView", activity))
        .attribute("text").containsExactly("milk", "cereal");

The second argument to `selection()` can be an activity or any `View`.

If you're already statically importing a different FEST-style `assertThat` method, you can
statically import ViewSelector's `assertThatSelection` to avoid conflicts:

    import static com.nikhaldimann.viewselector.ViewSelectorAssertions.assertThatSelection;
    ...

    // Equivalent to the first assertion above
    assertThatSelection("TextView", activity).hasSize(5);

You may also consult these two full examples of tests using ViewSelector:

  * [HelloWorldExampleActivityTest](https://github.com/nikhaldi/android-view-selector/blob/master/src/android-test/src/com/nikhaldimann/viewselector/android/activities/HelloWorldExampleActivityTest.java):
    A very simple unit test based on `ActivityUnitTestCase`, demonstrating how to test
    fairly static UIs.
  * [ListViewExampleActivityTest](https://github.com/nikhaldi/android-view-selector/blob/master/src/android-test/src/com/nikhaldimann/viewselector/android/activities/ListViewExampleActivityTest.java):
    A functional test based on `ActivityInstrumentationTestCase2`, demonstrating how to
    test more dynamic UIs.


### Supported Selectors

Selector semantics mirror those of CSS very closely. These selectors are supported so far:

 Selector            | Example               | Selects ...
---------------------|-----------------------|--------------
 Universal           | `*`                   | ... all views
 View type           | `TextView`            | ... views of type `TextView`
 View id             | `#foo`                | ... views with id `foo`
 Descendants         | `GridLayout TextView` | ... `TextViews` that are descendants of a `GridLayout`
 Children            | `#foo > ImageView`    | ... `ImageViews` that are direct children of a view with id `foo`
 Union               | `TextView, ImageView` | ... views of type `TextView` or `ImageView`
 Attribute existence | `TextView[tag]`       | ... `TextViews` that have a tag attribute that isn't `null`
 Attribute equality  | `TextView[tag=foo]`   | ... `TextViews` that have a tag attribute value equal to the string `"foo"`
 Attribute contains  | `TextView[tag*=foo]`  | ... `TextViews` that have a tag attribute value containing the substring `"foo"`
 Attribute prefix    | `TextView[tag^=foo]`  | ... `TextViews` that have a tag attribute value starting with `"foo"`
 Attribute suffix    | `TextView[tag$=foo]`  | ... `TextViews` that have a tag attribute value ending with `"foo"`
 Adjacent sibling    | `TextView + ImageView`| ... `ImageViews` directly preceded by a `TextView`
 General sibling     | `TextView ~ ImageView`| ... `ImageViews` preceded by a `TextView`


### Notes on Attribute Matching

The attribute selectors are implemented by calling corresponding getters on the views.
For example, the selector `[tag]` calls `getTag()` on views to find out whether that
attribute exists. Naming conventions for boolean attributes are respected, e.g.,
the selector `[isShown]` will call `isShown()` (not `getIsShown()`) on views.

Selectors with attribute matching (e.g., `[tag=foo]`) support some primitive
value types other than strings in a natural way:

  * The values `true` and `false` when used with a boolean attribute will be
    interpreted as booleans rather than strings. Example: `[isShown=true]`
  * Integer values used with integer attributes will be interpreted as integers.
    However, due to limitations in the CSS parsing library used the numbers
    have to be enclosed in quotes. Example: `[minWidth='100']`

Note that attribute matching for some attributes might not behave as you expect if
you're using Robolectric because of the shadowing techniques it uses.


## License

Distributed under an [MIT license](https://github.com/nikhaldi/android-view-selector/blob/master/LICENSE.md).
