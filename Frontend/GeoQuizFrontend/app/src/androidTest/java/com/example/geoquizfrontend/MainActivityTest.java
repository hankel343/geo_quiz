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
public class MainActivityTest {

    @Before
    public void setup() {
        ActivityScenario.launch(MainActivity.class);
    }

    @Test
    public void testMainActivityLaunchesSuccessfully() {
        onView(withId(R.id.GuestB)).check(matches(isDisplayed()));
        onView(withId(R.id.LoginB)).check(matches(isDisplayed()));
        onView(withId(R.id.LeaderboardB)).check(matches(isDisplayed()));
    }

    @Test
    public void testGuestButton() {
//        Intents.init();
//        onView(withId(R.id.GuestB)).perform(click());
//        intended(hasComponent(GuestLoginActivity.class.getName()));
//        Intents.release();
    }

    @Test
    public void testLoginButton() {
//        Intents.init();
//        onView(withId(R.id.LoginB)).perform(click());
//        intended(hasComponent(LoginActivity.class.getName()));
//        Intents.release();
    }

    @Test
    public void testLeaderboardButton() {
//        Intents.init();
//        onView(withId(R.id.LeaderboardB)).perform(click());
//        intended(hasComponent(LeaderboardScreen.class.getName()));
//        Intents.release();
    }
}
