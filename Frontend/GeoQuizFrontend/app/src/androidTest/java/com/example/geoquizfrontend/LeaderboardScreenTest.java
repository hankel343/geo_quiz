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
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class LeaderboardScreenTest {

    @Before
    public void setup() {
        ActivityScenario.launch(LeaderboardScreen.class);
    }

    @Test
    public void testLeaderboardScreenLaunchesSuccessfully() {
        onView(withId(R.id.score1)).check(matches(isDisplayed()));
    }

    @Test
    public void testButtonClick() {
        onView(withId(R.id.Updatebtn)).perform(click());
        onView(withId(R.id.Updatebtn)).check(matches(withText("Update Leaderboard")));
    }
}

