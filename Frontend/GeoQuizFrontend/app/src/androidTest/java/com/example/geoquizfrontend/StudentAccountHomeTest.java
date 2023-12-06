package com.example.geoquizfrontend;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class StudentAccountHomeTest {

    @Before
    public void setup() {
        ActivityScenario.launch(StudentAccountHome.class);
    }

    @Test
    public void testStudentAccountHomeLaunchesSuccessfully() {
        onView(withId(R.id.welcome_text)).check(matches(isDisplayed()));
        onView(withId(R.id.email_text)).check(matches(isDisplayed()));
        onView(withId(R.id.playQuizzes_btn)).check(matches(isDisplayed()));
        onView(withId(R.id.pastScores_btn)).check(matches(isDisplayed()));
        onView(withId(R.id.signOut_btn)).check(matches(isDisplayed()));
    }

    @Test
    public void testPlayQuizButton() {
//        Intents.init();
//        onView(withId(R.id.playQuizzes_btn)).perform(click());
//        intended(hasComponent(GamescreenActivity.class.getName()));
//        Intents.release();
    }

    @Test
    public void testPastScoresButton() {
//        Intents.init();
//        onView(withId(R.id.pastScores_btn)).perform(click());
//        intended(hasComponent(StudentPastScores.class.getName()));
//        Intents.release();
    }

    @Test
    public void testSignOutButton() {
//        Intents.init();
//        onView(withId(R.id.signOut_btn)).perform(click());
//        intended(hasComponent(MainActivity.class.getName()));
//        Intents.release();
    }
}

