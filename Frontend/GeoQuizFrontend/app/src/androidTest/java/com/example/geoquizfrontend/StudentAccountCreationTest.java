package com.example.geoquizfrontend;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class StudentAccountCreationTest {

    @Before
    public void setup() {
        ActivityScenario.launch(StudentAccountCreation.class);
    }

    @Test
    public void testStudentAccountCreationLaunchesSuccessfully() {
        onView(withId(R.id.firstName_text)).check(matches(isDisplayed()));
        onView(withId(R.id.lastName_text)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextTextEmailAddress)).check(matches(isDisplayed()));
        onView(withId(R.id.Password_text)).check(matches(isDisplayed()));
        onView(withId(R.id.passwordConfirm_text)).check(matches(isDisplayed()));
        onView(withId(R.id.classCode_text)).check(matches(isDisplayed()));
        onView(withId(R.id.signup_btn)).check(matches(isDisplayed()));
    }

    @Test
    public void testSignUpButton() {
//        Intents.init();
        onView(withId(R.id.firstName_text)).perform(typeText("Test"));
        onView(withId(R.id.lastName_text)).perform(typeText("User"));
        onView(withId(R.id.editTextTextEmailAddress)).perform(typeText("test@user.com"));
        onView(withId(R.id.Password_text)).perform(typeText("password"));
        onView(withId(R.id.passwordConfirm_text)).perform(typeText("password"));
        onView(withId(R.id.classCode_text)).perform(typeText("123456"));
        onView(withId(R.id.signup_btn)).perform(click());
//        intended(hasComponent(StudentAccountHome.class.getName()));
//        Intents.release();
    }
}

