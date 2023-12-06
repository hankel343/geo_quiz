package com.example.geoquizfrontend;



import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.core.content.MimeTypeFilter.matches;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
public class GuestLoginActivityTest {

    @Before
    public void setup() {
        ActivityScenario.launch(GuestLoginActivity.class);
    }

    @Test
    public void testGuestLoginActivityLaunchesSuccessfully() {
//        onView(withId(R.id.initials_text)).check(matches(isDisplayed()));
    }

    @Test
    public void testButtonClick() {
        onView(withId(R.id.go_btn)).perform(click());
//        onView(withId(R.id.go_btn)).check(matches(withText("Go")));
    }
}

