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
public class StudentSignInActivityTest {

    @Before
    public void setup() {
        ActivityScenario.launch(StudentSignInActivity.class);
    }

    @Test
    public void testStudentSignInActivityLaunchesSuccessfully() {
        onView(withId(R.id.sign_in_btn)).check(matches(isDisplayed()));
        onView(withId(R.id.new_user_btn)).check(matches(isDisplayed()));
        onView(withId(R.id.email_input)).check(matches(isDisplayed()));
        onView(withId(R.id.password_input)).check(matches(isDisplayed()));
    }

    @Test
    public void testSignInButton() {
//        Intents.init();
//        onView(withId(R.id.email_input)).perform(typeText("test@user.com"));
//        onView(withId(R.id.password_input)).perform(typeText("password"));
//        onView(withId(R.id.sign_in_btn)).perform(click());
//        intended(hasComponent(StudentAccountHome.class.getName()));
//        Intents.release();
    }

    @Test
    public void testNewUserButton() {
//        Intents.init();
//        onView(withId(R.id.new_user_btn)).perform(click());
//        intended(hasComponent(StudentAccountCreation.class.getName()));
//        Intents.release();
    }
}

