package com.nikhaldimann.viewselector.test.abstrakt.attributes;

import org.junit.Test;

import android.text.InputType;
import android.widget.TextView;

import com.nikhaldimann.viewselector.attributes.AttributeAccessException;
import com.nikhaldimann.viewselector.attributes.ViewAttributes;
import com.nikhaldimann.viewselector.test.util.ViewSelectorAndroidTestCase;

public abstract class AbstractViewAttributesTest extends ViewSelectorAndroidTestCase {

    @Test
    public void testGetGetterMethodName() {
        assertEquals("getText", ViewAttributes.getGetterMethodName("text"));
        assertEquals("getText", ViewAttributes.getGetterMethodName("Text"));
        assertEquals("getFooText", ViewAttributes.getGetterMethodName("fooText"));
    }

    @Test
    public void testGetGetterMethodNameBooleanAttribute() {
        assertEquals("isFoo", ViewAttributes.getGetterMethodName("isFoo"));
        assertEquals("getIs", ViewAttributes.getGetterMethodName("is"));
        assertEquals("getIsland", ViewAttributes.getGetterMethodName("island"));
    }

    @Test
    public void testCallGetter() {
        TextView view = viewFactory.createTextView();
        view.setText("foo");
        view.setInputType(InputType.TYPE_CLASS_TEXT);
        assertEquals("foo", ViewAttributes.callGetter(view, "getText").toString());
        assertEquals(null, ViewAttributes.callGetter(view, "getTag"));
        assertEquals(InputType.TYPE_CLASS_TEXT, ViewAttributes.callGetter(view, "getInputType"));
        // TODO need to figure out how to deal with base class methods in Robolectric
    }

    @Test
    public void testCallGetterNoSuchMethod() {
        try {
            ViewAttributes.callGetter(viewFactory.createTextView(), "getFoo");
            fail();
        } catch (AttributeAccessException ex) {
            // expected
        }
    }

}
