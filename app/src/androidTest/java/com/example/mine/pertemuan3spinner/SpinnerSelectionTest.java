package com.example.mine.pertemuan3spinner;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class SpinnerSelectionTest {
    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void iterateSpinnerItems() {
        String[] myArray = mActivityRule.getActivity().getResources().getStringArray(R.array.labels_array);
        int size = myArray.length;
        for (int i = 0; i < size; i++) {
            //	Find the spinner and click on it.
            onView(withId(R.id.label_spinner)).perform(click());
            //	Find the spinner item and click on it.
            onData(is(myArray[i])).perform(click());
        }

    }

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.mine.pertemuan3spinner", appContext.getPackageName());
    }



}
