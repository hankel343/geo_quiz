package com.example.geoquizfrontend;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class FlagGameTest {

    @Before
    public void setup() {
        ActivityScenario.launch(FlagGame.class);
    }

    @Test
    public void testFlagGameActivityLaunchesSuccessfully() {
        onView(withId(R.id.FlagQuestion)).check(matches(isDisplayed()));
    }

    @Test
    public void testButtonClick() {
        onView(withId(R.id.opt0_btn)).perform(click());
        onView(withId(R.id.FlagQuestion)).check(matches(withText("What country has the following flag?")));
    }
}

