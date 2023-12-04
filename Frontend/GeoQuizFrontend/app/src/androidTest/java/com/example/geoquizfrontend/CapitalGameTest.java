package com.example.geoquizfrontend;

import static androidx.core.content.MimeTypeFilter.matches;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.CoreMatchers.containsString;

import androidx.test.filters.LargeTest;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4ClassRunner.class)
@LargeTest
public class CapitalGameTest {

    @Test
    public void testCountryButtonClick() {
        onView(withId(R.id.opt0_btn)).perform(click());
    }

    @Test
    public void testScoreUpdate() {
        onView(withId(R.id.opt0_btn)).perform(click());
    }

    @Test
    public void testGameOver() {
        onView(withId(R.id.opt0_btn)).perform(click());
        onView(withId(R.id.opt1_btn)).perform(click());
        onView(withId(R.id.opt2_btn)).perform(click());
        onView(withId(R.id.opt3_btn)).perform(click());
    }
}

