package no.westerdals.pg4600.autocompletelivedemo;

import android.support.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

public class CountrySelectionActivityTest {
    @Rule
    public ActivityTestRule<CountrySelectionActivity> activityRule = new ActivityTestRule<>(
            CountrySelectionActivity.class
    );

    private CountrySelectionActivity countrySelectionActivity;

    @Before
    public void startActivity() {
        this.countrySelectionActivity = activityRule.getActivity();
    }

    @Test
    public void countrySelectorIsDisplayed() {
        onView(withId(R.id.countryAutoCompleteTextView))
                .check(matches(isDisplayed()));
    }

    @Test
    public void countrySelectorAcceptsText() {
        // Just type text into the country selector.
        onView(
                withId(R.id.countryAutoCompleteTextView)
        ).perform(
                typeText("Norwa"),
                closeSoftKeyboard()
        );
    }

    @Test
    public void expectedCountriesAreDisplayed() {
        // Type something into the country selector.
        onView(
                withId(R.id.countryAutoCompleteTextView)
        ).perform(
                typeText("N"),
                closeSoftKeyboard()
        );

        // Load and verify that expected countries from the resource are indeed present.
        String[] countries = countrySelectionActivity.getResources().getStringArray(R.array.countries);

        for (final String country : countries) {
            if (country.startsWith("N")) {
                onView(withText(country))
                        .inRoot(withDecorView(
                                not(
                                        is(
                                                countrySelectionActivity.getWindow().getDecorView()
                                        )
                                )
                        ))
                        .check(matches(isDisplayed()));
            }
        }
    }
}
