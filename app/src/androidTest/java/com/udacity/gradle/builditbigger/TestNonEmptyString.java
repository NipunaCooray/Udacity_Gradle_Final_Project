package com.udacity.gradle.builditbigger;


import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.AndroidTestCase;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.assertion.ViewAssertions.matches;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

@RunWith(AndroidJUnit4.class)
public class TestNonEmptyString extends AndroidTestCase {

    String TAG = EndpointsAsyncTask.class.getSimpleName();
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule(MainActivity.class);



    @Test
    public void testJokeIsNotEmpty() throws Exception {

        TestEndPointAsyncTask aTest =  new TestEndPointAsyncTask();
        aTest.execute(InstrumentationRegistry.getContext());
        String joke = aTest.get(5, TimeUnit.SECONDS);
        Assert.assertTrue(!joke.equals(""));
    }

    @Test
    public void testVerifyResponse() {


        onView(withId(R.id.btn_tellJoke)).perform(click());
        onView(withId(R.id.tv_jokeText)).check(matches(isDisplayed()));
    }

}
