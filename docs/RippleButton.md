#RippleButton Widget
====================

Inherits from [android.widget.Button](http://developer.android.com/reference/android/widget/Button.html) but allows you to customize the style easily in differents ways.

## Android Lollipop vs Android Jelly Bean

[![Lollipop](img/RippleButtonV21.gif)](demo)[![JellyBean](img/RippleButtonV16.gif)](demo)


##Usage

###Layout
| Attribute  | Type | Description |
| ------------- | ------------- | ------------- |
| app:buttonColor  | color  | The color of the button. |
| app:rippleColor  | color  | The color of the ripple effect in v21, in previous versions is the color of the button while pressed. |

###Style
| Attribute  | Type | Description |
| ------------- | ------------- | ------------- |
| android:colorButtonNormal  | color  |  Only in v21. The color of the button. |
| android:colorControlHighlight  | color  | Only in v21. The color of the ripple effect in v21 |
| colorButtonNormal  | color  |  Not in v21. The color of the RippleButton. |
| colorControlHighlight  | color  | Not in v21. The color of the ripple effect in RippleButton |

> **:paperclip:** In version 21 *android:colorButtonNormal* and *android:colorControlHighlight* also change the color of the android ImageButton.

###Java
| Method  | Description |
| ------------- | ------------- |
| setButtonColor(int color)  | The color of the button. |
| setRippleColor(int color)  | The color of the ripple effect in v21, in previous versions is the color of the button while pressed. |
| setColors(int buttonColor, int rippleColor)  | The color of the button and the ripple effect in v21, in previous versions is the color of the button while pressed. |

##Examples
From java
```xml

	<!--xml-->
    <com.xgc1986.ripplebutton.widget.RippleButton
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/rippleButton"
        android:text="Click me!"/>
```

```java

	//java
	int buttonColor = 0xff33b5e5; //holo_blue_light
	int rippleColor = 0x80ffffff; //transparent white
	final RippleButton rb = (RippleButton)findViewById(R.id.rippleButton);
	rb.setColors(colors[1], colors[2]);
```

From xml
```xml

	<!--xml-->
    <com.xgc1986.ripplebutton.widget.RippleButton
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/rippleButton"
        android:text="Click me!"
        app:rippleColor="#ff33b5e5"
        app:buttonColor="#80ffffff"
        app:/>
```

Modifying the theme:

```xml

	<!-- drawable/style.xml -->
	<!--xml-->
    <style name="AppTheme" parent="android:Theme.Material">
    	<!-- This also affects to android.widget.Button -->
    	<item name="android:colorControlHighlight">#ff33b5e5</item>
        <item name="android:colorButtonNormal">#80ffffff</item>

        <!-- for Jellybean & Kitkat -->
        <!-- This not affect to android.widget.Button -->
        <item name="colorControlHighlight">#ff33b5e5</item>
        <item name="colorButtonNormal">#80ffffff</item>
    </style>
```

And modifying a style:

```xml

	<!-- drawable/style.xml -->
	<!--xml-->
    <style name="AppTheme.Widget.CustomButton" parent="android:Widget.Material.Button">
    	<!-- This also affects to android.widget.Button -->
    	<item name="android:colorControlHighlight">#ff33b5e5</item>
        <item name="android:colorButtonNormal">#80ffffff</item>

        <!-- for Jellybean & Kitkat -->
        <!-- This not affect to android.widget.Button -->
        <item name="colorControlHighlight">#ff33b5e5</item>
        <item name="colorButtonNormal">#80ffffff</item>
    </style>
```

```xml

	<!-- layout -->
	<!--xml-->
    <com.xgc1986.ripplebutton.widget.RippleButton
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/rippleButton"
        android:text="Click me!"
        android:theme="@style/AppTheme.Widget.CustomButton"/>
```


Next: [RippleImageButton Widget](RippleImageButton.md)<br>
Prev: [README](../README.md)
