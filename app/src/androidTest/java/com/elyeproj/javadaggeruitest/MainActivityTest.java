package com.elyeproj.javadaggeruitest;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.mockito.Mockito.when;

public class MainActivityTest {

    public final TestComponentRule component =
            new TestComponentRule(InstrumentationRegistry.getTargetContext());
    public final ActivityTestRule<MainActivity> main =
            new ActivityTestRule<>(MainActivity.class, false, false);
    // TestComponentRule needs to go first so we make sure the ApplicationTestComponent is set
    // in the Application before any Activity is launched.
    @Rule
    public TestRule chain = RuleChain.outerRule(component).around(main);

    @Before
    public void setUp() {
    }

    @Test
    public void simpleTrueTest() {
        when(component.getMockInjectedData().getStatus()).thenReturn(true);
        main.launchActivity(null);

        onView(withId(R.id.txt_myview))
                .check(matches(withText("True")));
    }

    @Test
    public void simpleFalseTest() {
        when(component.getMockInjectedData().getStatus()).thenReturn(false);
        main.launchActivity(null);

        onView(withId(R.id.txt_myview))
                .check(matches(withText("False")));
    }


}