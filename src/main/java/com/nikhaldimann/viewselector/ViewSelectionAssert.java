package com.nikhaldimann.viewselector;

import org.fest.assertions.api.ANDROID;
import org.fest.assertions.api.AbstractIterableAssert;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.Animation;

import com.nikhaldimann.viewselector.attributes.AttributeAccessException;
import com.nikhaldimann.viewselector.attributes.ViewSelectionAttribute;
import com.nikhaldimann.viewselector.selection.ViewSelection;

/**
 * Custom assertions for {@link ViewSelection}s. Generally, use entry points in
 * {@link ViewSelectorAssertions} to get access to these.
 */
public class ViewSelectionAssert
        extends AbstractIterableAssert<ViewSelectionAssert, ViewSelection, View> {

    public ViewSelectionAssert(ViewSelection actual) {
        super(actual, ViewSelectionAssert.class);
    }

    /**
     * Creates an object for making assertions about an attribute set extracted from
     * each view in the selection. This always fails for an empty selection.
     * @param attributeName name of the attribute to check (e.g., {@code "text"}. The
     *     implementation will call a getter on each view based on this attribute name
     *     (e.g., {@code getText()}.
     * @return a new assert over a set of attributes
     */
    public ViewSelectionAttributeAssert attribute(String attributeName) {
        isNotEmpty();
        ViewSelectionAttribute attributeValues = new ViewSelectionAttribute(actual, attributeName);
        return new ViewSelectionAttributeAssert(attributeValues);
    }

    /**
     * Asserts that every view in the selection has an attribute with the given
     * expected value. This is just a convenience shortcut for
     * {@code attribute(attributeName).containsOnly(expectedValue)}.
     * @param attributeName name of the attribute to check (e.g., {@code "text"}. The
     *     implementation will call a getter on each view based on this attribute name
     *     (e.g., {@code getText()}.
     * @param expectedValue the expected value for the attribute
     * @return self for chaining
     * @throws AttributeAccessException if one of the views in the selection doesn't
     *     have a getter for the given attribute
     */
    public ViewSelectionAssert hasAttributeEqualTo(String attributeName, Object expectedValue) {
        attribute(attributeName).containsOnly(expectedValue);
        return this;
    }

    // The below methods are for mimicking the interface of
    // org.fest.assertions.api.android.view.AbstractViewAssert and just pass the assertion
    // on to the equivalent fest-android methods for every view in the selection.

    public ViewSelectionAssert hasAlpha(float value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasAlpha(value);
        }
        return this;
    }

    public ViewSelectionAssert hasAnimation(Animation value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasAnimation(value);
        }
        return this;
    }

    public ViewSelectionAssert hasBackground(Drawable value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasBackground(value);
        }
        return this;
    }

    public ViewSelectionAssert hasBaseline(int value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasBaseline(value);
        }
        return this;
    }

    public ViewSelectionAssert hasBottom(int value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasBottom(value);
        }
        return this;
    }

    public ViewSelectionAssert hasContentDescription(CharSequence value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasContentDescription(value);
        }
        return this;
    }

    public ViewSelectionAssert hasContentDescription(int value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasContentDescription(value);
        }
        return this;
    }

    public ViewSelectionAssert hasDrawingCacheBackgroundColor(int value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasDrawingCacheBackgroundColor(value);
        }
        return this;
    }

    public ViewSelectionAssert hasDrawingCacheQuality(int value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasDrawingCacheQuality(value);
        }
        return this;
    }

    public ViewSelectionAssert hasHeight(int value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasHeight(value);
        }
        return this;
    }

    public ViewSelectionAssert hasHorizontalFadingEdgeLength(int value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasHorizontalFadingEdgeLength(value);
        }
        return this;
    }

    public ViewSelectionAssert hasId(int value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasId(value);
        }
        return this;
    }

    public ViewSelectionAssert isKeepingScreenOn() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).isKeepingScreenOn();
        }
        return this;
    }

    public ViewSelectionAssert isNotKeepingScreenOn() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).isNotKeepingScreenOn();
        }
        return this;
    }

    public ViewSelectionAssert hasLayerType(int value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasLayerType(value);
        }
        return this;
    }

    public ViewSelectionAssert hasLeft(int value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasLeft(value);
        }
        return this;
    }

    public ViewSelectionAssert hasMeasuredHeight(int value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasMeasuredHeight(value);
        }
        return this;
    }

    public ViewSelectionAssert hasMeasuredHeightAndState(int value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasMeasuredHeightAndState(value);
        }
        return this;
    }

    public ViewSelectionAssert hasMeasuredState(int value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasMeasuredState(value);
        }
        return this;
    }

    public ViewSelectionAssert hasMeasuredWidth(int value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasMeasuredWidth(value);
        }
        return this;
    }

    public ViewSelectionAssert hasMeasuredWidthAndState(int value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasMeasuredWidthAndState(value);
        }
        return this;
    }

    public ViewSelectionAssert hasMinimumHeight(int value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasMinimumHeight(value);
        }
        return this;
    }

    public ViewSelectionAssert hasMinimumWidth(int value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasMinimumWidth(value);
        }
        return this;
    }

    public ViewSelectionAssert hasNextFocusDownId(int value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasNextFocusDownId(value);
        }
        return this;
    }

    public ViewSelectionAssert hasNextFocusForwardId(int value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasNextFocusForwardId(value);
        }
        return this;
    }

    public ViewSelectionAssert hasNextFocusLeftId(int value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasNextFocusLeftId(value);
        }
        return this;
    }

    public ViewSelectionAssert hasNextFocusRightId(int value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasNextFocusRightId(value);
        }
        return this;
    }

    public ViewSelectionAssert hasNextFocusUpId(int value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasNextFocusUpId(value);
        }
        return this;
    }

    public ViewSelectionAssert hasOverScrollMode(int value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasOverScrollMode(value);
        }
        return this;
    }

    public ViewSelectionAssert hasPaddingBottom(int value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasPaddingBottom(value);
        }
        return this;
    }

    public ViewSelectionAssert hasPaddingLeft(int value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasPaddingLeft(value);
        }
        return this;
    }

    public ViewSelectionAssert hasPaddingRight(int value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasPaddingRight(value);
        }
        return this;
    }

    public ViewSelectionAssert hasPaddingTop(int value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasPaddingTop(value);
        }
        return this;
    }

    public ViewSelectionAssert hasParent(ViewParent value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasParent(value);
        }
        return this;
    }

    public ViewSelectionAssert hasParentForAccessibility(ViewParent value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasParentForAccessibility(value);
        }
        return this;
    }

    public ViewSelectionAssert hasPivotX(float value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasPivotX(value);
        }
        return this;
    }

    public ViewSelectionAssert hasPivotY(float value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasPivotY(value);
        }
        return this;
    }

    public ViewSelectionAssert hasRight(int value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasRight(value);
        }
        return this;
    }

    public ViewSelectionAssert hasRootView(View value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasRootView(value);
        }
        return this;
    }

    public ViewSelectionAssert hasRotation(float value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasRotation(value);
        }
        return this;
    }

    public ViewSelectionAssert hasRotationX(float value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasRotationX(value);
        }
        return this;
    }

    public ViewSelectionAssert hasRotationY(float value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasRotationY(value);
        }
        return this;
    }

    public ViewSelectionAssert hasTag(Object tag) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasTag(tag);
        }
        return this;
    }
}
