Why is limited to API +16?
==========================

Long time ago everybody used android 2.2 and 2.3.x, but apple decided to create Ice Cream Sandwich and after that when I have to develop for this new awesome version, I feel like developing JavaScript and making backwards compatibility to Internet Explorer 8.

Since then for every app I had to create I had to create two apps, because the backwards compatibility, and then I started to use libraries that allows to save time avoiding this android mess. But of course all this libraries didn't behave exactly as how android showed in its presentation, and also, why all the tools that Android showed to us? Because we couldn't use them until android 5.0 was released. 4 years to be able to use all the new old features from Ice Cream.

But what happens with the all new Material design, it's the fucking same, I have to use libraries to allow old version to have this ripple effect, but all the libraries have two problems, one is not the same ripple effect from lollipop, second, they consumes more performance than the lollipop ones. And why didn't google create some stupid and easy backwards compatibility, if I want to create a button, I have to create the button for android Gingerbread, another exactly button for ICS, JB and KK, and a third button for Lollipop. Then I'm not stupid I will create one that works on gingerbread and finish. But then you lose oll the cool features from 4.0 and 5.0.

Also, to make more annoying to develop, Android have new methods for drawables like setTint, but of course before use it I have to put an 'if' to check if the android version is correct, if you don't put that, the app will break. It would be much betters that if I call this method on a previous android version, then it didn’t do nothing or an equivalent thing for this version.

And that's the reason, I hate Gingerbread because it's an old version, with ICS the same, I want to use all de android features when I want, not 5 years later, most of the developers still use ActionBarActivity instead of Activity because they have two develop for old versions. Also every time I put setBackgroundDrawable because of ICS. And this has to finish.

You are free to modify my code to put minSDK to 9 if you want, they won't break, but also they won't do anything.

I like Android, but I think the SDK can be done much better.
