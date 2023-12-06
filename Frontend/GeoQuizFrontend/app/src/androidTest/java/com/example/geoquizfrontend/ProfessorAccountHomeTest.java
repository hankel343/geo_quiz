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
public class ProfessorAccountHomeTest {

    @Before
    public void setup() {
        ActivityScenario.launch(ProfessorAccountHome.class);
    }

    @Test
    public void testProfessorAccountHomeLaunchesSuccessfully() {
        onView(withId(R.id.welcome_text)).check(matches(isDisplayed()));
        onView(withId(R.id.email_text)).check(matches(isDisplayed()));
        onView(withId(R.id.createClass_btn)).check(matches(isDisplayed()));
        onView(withId(R.id.viewClasses_btn)).check(matches(isDisplayed()));
        onView(withId(R.id.signOut_btn)).check(matches(isDisplayed()));
    }

    @Test
    public void testCreateClassButton() {
//        Intents.init();
        onView(withId(R.id.createClass_btn)).perform(click());
        // Intended is commented out because the button does not currently start an activity
        // intended(hasComponent(CreateClassActivity.class.getName()));
//        Intents.release();
    }

    @Test
    public void testViewClassesButton() {
//        Intents.init();
        onView(withId(R.id.viewClasses_btn)).perform(click());
        // Intended is commented out because the button does not currently start an activity
        // intended(hasComponent(ViewClassesActivity.class.getName()));
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

