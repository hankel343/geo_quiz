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
public class LoginActivityTest {

    @Before
    public void setup() {
        ActivityScenario.launch(LoginActivity.class);
    }

    @Test
    public void testLoginActivityLaunchesSuccessfully() {
        onView(withId(R.id.student_btn)).check(matches(isDisplayed()));
        onView(withId(R.id.professor_btn)).check(matches(isDisplayed()));
    }

    @Test
    public void testStudentLoginButton() {
//        Intents.init();
//        onView(withId(R.id.student_btn)).perform(click());
//        intended(hasComponent(StudentSignInActivity.class.getName()));
//        Intents.release();
    }

    @Test
    public void testProfessorLoginButton() {
//        Intents.init();
//        onView(withId(R.id.professor_btn)).perform(click());
//        intended(hasComponent(ProfessorSignInActivity.class.getName()));
//        Intents.release();
    }
}

