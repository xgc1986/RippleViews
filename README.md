
# RippleButton 

RippleButton is for Android 15+

RippleButton allows you to easily change the color of the button and the ripple effect without the need of creating styles or themes for every color you need.

RippleButton inherits from Button, it not generates any extra layouts and you can manage RippleButton instance as if it was an android Button.t

## Installation

in your build.gradle file

    dependencies {
        // ...
        compile 'com.xgc1986.android:ripplebutton:0.1.2'
    }

## Usage

minSdkVersion 15 (The ripple effect only works on API >= 21)

[![Android Arsenal](http://i.giphy.com/AxVvk2yAIHdcnMXDLW.gif)](demo)


with xml:
```xml

	<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:paddingLeft="@dimen/activity_horizontal_margin"
        android:paddingRight="@dimen/activity_horizontal_margin"
        android:paddingTop="@dimen/activity_vertical_margin"
        android:paddingBottom="@dimen/activity_vertical_margin"
        tools:context=".MainActivity">

        <!-- Default -->
        <com.xgc1986.ripplebutton.widget.RippleButton
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:id="@+id/btn1"
            android:text="Default android button"/>

        <!-- Edited in layout -->
        <com.xgc1986.ripplebutton.widget.RippleButton
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:id="@+id/btn2"
            android:layout_below="@id/btn1"
            android:text="Android button modified in layout"
            android:textColor="@android:color/white"
            app:buttonColor="@android:color/black"
            app:rippleColor="@android:color/white"/>

        <!-- Edited programatically -->
        <com.xgc1986.ripplebutton.widget.RippleButton
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:id="@+id/btn3"
            android:layout_below="@id/btn2"
            android:text="Android button modified programatically"/>

        <!-- Toggle demo -->
        <com.xgc1986.ripplebutton.widget.RippleButton
            android:layout_width="150dp"
            android:layout_height="150dp"
            android:layout_marginTop="30dp"
            android:id="@+id/btn4"
            android:layout_centerHorizontal="true"
            android:layout_below="@id/btn3"
            android:text="This"/>
    </RelativeLayout>
```

with java:
```java

    private int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

	// Change color programatically
        RippleButton rb = (RippleButton)findViewById(R.id.btn3);
        rb.setColors(getResources().getColor(android.R.color.holo_red_light), getResources().getColor(android.R.color.holo_blue_light));

	// Toggle demo
	final int[] colors = {
                getResources().getColor(android.R.color.holo_blue_light),
                getResources().getColor(android.R.color.holo_red_light),
                getResources().getColor(android.R.color.holo_green_light)
        };
        final String[] texts = {"AWESOME", "THIS", "IS"};
        
        final RippleButton rb2 = (RippleButton)findViewById(R.id.btn4);
        rb2.setColors(colors[1], colors[2]);
        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = (i + 1) % 3;
                rb2.setColors(colors[(i + 1) % 3], colors[(i + 2) % 3]);
                rb2.setText(texts[i]);
            }
        });
    }
```

## Other works
<a href="https://github.com/xgc1986/ParallaxPagerTransformer" target="_blank">Parallax Pager Transformer</a>


