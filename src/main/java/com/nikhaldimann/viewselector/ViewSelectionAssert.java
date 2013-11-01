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

    public ViewSelectionAssert hasScaleX(float value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasScaleX(value);
        }
        return this;
    }

    public ViewSelectionAssert hasScaleY(float value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasScaleY(value);
        }
        return this;
    }

    public ViewSelectionAssert hasScrollBarDefaultDelayBeforeFade(int value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasScrollBarDefaultDelayBeforeFade(value);
        }
        return this;
    }

    public ViewSelectionAssert hasScrollBarFadeDuration(int value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasScrollBarFadeDuration(value);
        }
        return this;
    }

    public ViewSelectionAssert hasScrollBarSize(int value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasScrollBarSize(value);
        }
        return this;
    }

    public ViewSelectionAssert hasScrollBarStyle(int value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasScrollBarStyle(value);
        }
        return this;
    }

    public ViewSelectionAssert hasScrollX(int value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasScrollX(value);
        }
        return this;
    }

    public ViewSelectionAssert hasScrollY(int value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasScrollY(value);
        }
        return this;
    }

    public ViewSelectionAssert hasSolidColor(int value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasSolidColor(value);
        }
        return this;
    }

    public ViewSelectionAssert hasSystemUiVisibility(int value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasSystemUiVisibility(value);
        }
        return this;
    }

    public ViewSelectionAssert hasTag(int key, Object tag) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasTag(key, tag);
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

    public ViewSelectionAssert hasTop(int value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasTop(value);
        }
        return this;
    }

    public ViewSelectionAssert hasTranslationX(float value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasTranslationX(value);
        }
        return this;
    }

    public ViewSelectionAssert hasTranslationY(float value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasTranslationY(value);
        }
        return this;
    }

    public ViewSelectionAssert hasVerticalFadingEdgeLength(int value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasVerticalFadingEdgeLength(value);
        }
        return this;
    }

    public ViewSelectionAssert hasVerticalScrollbarPosition(int value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasVerticalScrollbarPosition(value);
        }
        return this;
    }

    public ViewSelectionAssert hasVerticalScrollbarWidth(int value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasVerticalScrollbarWidth(value);
        }
        return this;
    }

    public ViewSelectionAssert hasVisibility(int value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasVisibility(value);
        }
        return this;
    }

    public ViewSelectionAssert isVisible() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).isVisible();
        }
        return this;
    }

    public ViewSelectionAssert isNotVisible() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).isNotVisible();
        }
        return this;
    }

    public ViewSelectionAssert isInvisible() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).isInvisible();
        }
        return this;
    }

    public ViewSelectionAssert isNotInvisible() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).isNotInvisible();
        }
        return this;
    }

    public ViewSelectionAssert isGone() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).isGone();
        }
        return this;
    }

    public ViewSelectionAssert isNotGone() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).isNotGone();
        }
        return this;
    }

    public ViewSelectionAssert hasWidth(int value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasWidth(value);
        }
        return this;
    }

    public ViewSelectionAssert hasWindowVisibility(int value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasWindowVisibility(value);
        }
        return this;
    }

    public ViewSelectionAssert hasX(float value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasX(value);
        }
        return this;
    }

    public ViewSelectionAssert hasY(float value) {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasY(value);
        }
        return this;
    }

    public ViewSelectionAssert hasFocus() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasFocus();
        }
        return this;
    }

    public ViewSelectionAssert hasNoFocus() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasNoFocus();
        }
        return this;
    }

    public ViewSelectionAssert hasFocusable() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasFocusable();
        }
        return this;
    }

    public ViewSelectionAssert isInFocusedWindow() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).isInFocusedWindow();
        }
        return this;
    }

    public ViewSelectionAssert isNotInFocusedWindow() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).isNotInFocusedWindow();
        }
        return this;
    }

    public ViewSelectionAssert isActivated() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).isActivated();
        }
        return this;
    }

    public ViewSelectionAssert isNotActivated() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).isNotActivated();
        }
        return this;
    }

    public ViewSelectionAssert isClickable() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).isClickable();
        }
        return this;
    }

    public ViewSelectionAssert isNotClickable() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).isNotClickable();
        }
        return this;
    }

    public ViewSelectionAssert isDirty() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).isDirty();
        }
        return this;
    }

    public ViewSelectionAssert isNotDirty() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).isNotDirty();
        }
        return this;
    }

    public ViewSelectionAssert isUsingDrawingCache() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).isUsingDrawingCache();
        }
        return this;
    }

    public ViewSelectionAssert isNotUsingDrawingCache() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).isNotUsingDrawingCache();
        }
        return this;
    }

    public ViewSelectionAssert isDuplicatingParentState() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).isDuplicatingParentState();
        }
        return this;
    }

    public ViewSelectionAssert isNotDuplicatingParentState() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).isNotDuplicatingParentState();
        }
        return this;
    }

    public ViewSelectionAssert isEnabled() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).isEnabled();
        }
        return this;
    }

    public ViewSelectionAssert isDisabled() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).isDisabled();
        }
        return this;
    }

    public ViewSelectionAssert isFocusable() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).isFocusable();
        }
        return this;
    }

    public ViewSelectionAssert isNotFocusable() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).isNotFocusable();
        }
        return this;
    }

    public ViewSelectionAssert isFocusableInTouchMode() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).isFocusableInTouchMode();
        }
        return this;
    }

    public ViewSelectionAssert isNotFocusableInTouchMode() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).isNotFocusableInTouchMode();
        }
        return this;
    }

    public ViewSelectionAssert isFocused() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).isFocused();
        }
        return this;
    }

    public ViewSelectionAssert isNotFocused() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).isNotFocused();
        }
        return this;
    }

    public ViewSelectionAssert hasHapticFeedbackEnabled() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasHapticFeedbackEnabled();
        }
        return this;
    }

    public ViewSelectionAssert hasHapticFeedbackDisabled() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasHapticFeedbackDisabled();
        }
        return this;
    }

    public ViewSelectionAssert isHardwareAccelerated() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).isHardwareAccelerated();
        }
        return this;
    }

    public ViewSelectionAssert isNotHardwareAccelerated() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).isNotHardwareAccelerated();
        }
        return this;
    }

    public ViewSelectionAssert hasHorizontalFadingEdgesEnabled() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasHorizontalFadingEdgesEnabled();
        }
        return this;
    }

    public ViewSelectionAssert hasHorizontalFadingEdgesDisabled() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasHorizontalFadingEdgesDisabled();
        }
        return this;
    }

    public ViewSelectionAssert hasHorizontalScrollbarEnabled() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasHorizontalScrollbarEnabled();
        }
        return this;
    }

    public ViewSelectionAssert hasHorizontalScrollbarDisabled() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasHorizontalScrollbarDisabled();
        }
        return this;
    }

    public ViewSelectionAssert isHovered() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).isHovered();
        }
        return this;
    }

    public ViewSelectionAssert isNotHovered() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).isNotHovered();
        }
        return this;
    }

    public ViewSelectionAssert isInEditMode() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).isInEditMode();
        }
        return this;
    }

    public ViewSelectionAssert isNotInEditMode() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).isNotInEditMode();
        }
        return this;
    }

    public ViewSelectionAssert isInTouchMode() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).isInTouchMode();
        }
        return this;
    }

    public ViewSelectionAssert isNotInTouchMode() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).isNotInTouchMode();
        }
        return this;
    }

    public ViewSelectionAssert hasLayoutRequested() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasLayoutRequested();
        }
        return this;
    }

    public ViewSelectionAssert hasNoLayoutRequested() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasNoLayoutRequested();
        }
        return this;
    }

    public ViewSelectionAssert isLongClickable() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).isLongClickable();
        }
        return this;
    }

    public ViewSelectionAssert isNotLongClickable() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).isNotLongClickable();
        }
        return this;
    }

    public ViewSelectionAssert isOpaque() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).isOpaque();
        }
        return this;
    }

    public ViewSelectionAssert isNotOpaque() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).isNotOpaque();
        }
        return this;
    }

    public ViewSelectionAssert isPressed() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).isPressed();
        }
        return this;
    }

    public ViewSelectionAssert isNotPressed() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).isNotPressed();
        }
        return this;
    }

    public ViewSelectionAssert hasSaveEnabled() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasSaveEnabled();
        }
        return this;
    }

    public ViewSelectionAssert hasSaveDisabled() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasSaveDisabled();
        }
        return this;
    }

    public ViewSelectionAssert hasSaveFromParentEnabled() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasSaveFromParentEnabled();
        }
        return this;
    }

    public ViewSelectionAssert hasSaveFromParentDisabled() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasSaveFromParentDisabled();
        }
        return this;
    }

    public ViewSelectionAssert isScrollContainer() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).isScrollContainer();
        }
        return this;
    }

    public ViewSelectionAssert isNotScrollContainer() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).isNotScrollContainer();
        }
        return this;
    }

    public ViewSelectionAssert hasScrollbarFadingEnabled() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasScrollbarFadingEnabled();
        }
        return this;
    }

    public ViewSelectionAssert hasScrollbarFadingDisabled() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasScrollbarFadingDisabled();
        }
        return this;
    }

    public ViewSelectionAssert isSelected() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).isSelected();
        }
        return this;
    }

    public ViewSelectionAssert isNotSelected() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).isNotSelected();
        }
        return this;
    }

    public ViewSelectionAssert isShown() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).isShown();
        }
        return this;
    }

    public ViewSelectionAssert isNotShown() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).isNotShown();
        }
        return this;
    }

    public ViewSelectionAssert hasSoundEffectsEnabled() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasSoundEffectsEnabled();
        }
        return this;
    }

    public ViewSelectionAssert hasSoundEffectsDisabled() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasSoundEffectsDisabled();
        }
        return this;
    }

    public ViewSelectionAssert hasVerticalFadingEdgeEnabled() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasVerticalFadingEdgeEnabled();
        }
        return this;
    }

    public ViewSelectionAssert hasVerticalFadingEdgeDisabled() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasVerticalFadingEdgeDisabled();
        }
        return this;
    }

    public ViewSelectionAssert hasVerticalScrollBarEnabled() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasVerticalScrollBarEnabled();
        }
        return this;
    }

    public ViewSelectionAssert hasVerticalScrollBarDisabled() {
        isNotEmpty();
        for (View matched : actual) {
            ANDROID.assertThat(matched).hasVerticalScrollBarDisabled();
        }
        return this;
    }

}
