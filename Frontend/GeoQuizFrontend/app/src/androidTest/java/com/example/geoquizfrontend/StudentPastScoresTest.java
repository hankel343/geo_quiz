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
public class StudentPastScoresTest {

    @Before
    public void setup() {
        ActivityScenario.launch(StudentPastScores.class);
    }

    @Test
    public void testStudentPastScoresLaunchesSuccessfully() {
        onView(withId(R.id.scoreTable)).check(matches(isDisplayed()));
    }
}

