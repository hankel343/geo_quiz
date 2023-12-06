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
public class GamescreenActivityTest {

    @Before
    public void setup() {
        ActivityScenario.launch(GamescreenActivity.class);
    }

    @Test
    public void testGamescreenActivityLaunchesSuccessfully() {
        onView(withId(R.id.CapitalGameB)).check(matches(isDisplayed()));
    }

    @Test
    public void testButtonClick() {
        onView(withId(R.id.CapitalGameB)).perform(click());
        onView(withId(R.id.CapitalGameB)).check(matches(withText("Capital Game")));
    }
}

