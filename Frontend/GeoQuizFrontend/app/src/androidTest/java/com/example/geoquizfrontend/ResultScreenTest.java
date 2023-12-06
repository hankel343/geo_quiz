package com.example.geoquizfrontend;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class ResultScreenTest {

    @Before
    public void setup() {
        ActivityScenario.launch(ResultScreen.class);
    }

    @Test
    public void testResultScreenLaunchesSuccessfully() {
        onView(withId(R.id.YourScore)).check(matches(isDisplayed()));
        onView(withId(R.id.playagain_btn)).check(matches(isDisplayed()));
    }

    @Test
    public void testPlayAgainButton() {
//        Intents.init();
//        onView(withId(R.id.playagain_btn)).perform(click());
//        intended(hasComponent(GamescreenActivity.class.getName()));
//        Intents.release();
    }
}
