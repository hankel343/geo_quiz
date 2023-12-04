package com.example.geoquizfrontend;

import static androidx.core.content.MimeTypeFilter.matches;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class ContinentsQuizTest {

    @Before
    public void setup() {
        ActivityScenario.launch(ContinentsQuiz.class);
    }

    @Test
    public void testContinentsQuizActivityLaunchesSuccessfully() {
    }

    @Test
    public void testButtonClick() {
        onView(withId(R.id.opt0_btn)).perform(click());
    }
}

