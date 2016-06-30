package com.elyeproj.kotlinespressomock

import android.support.test.InstrumentationRegistry
import android.support.test.rule.ActivityTestRule

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain
import org.junit.rules.TestRule

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import org.mockito.Mockito.`when`

class MainActivityTest {

    val component = TestComponentRule(InstrumentationRegistry.getTargetContext())
    val main = ActivityTestRule(MainActivity::class.java, false, false)
    // TestComponentRule needs to go first so we make sure the ApplicationTestComponent is set
    // in the Application before any Activity is launched.
    @JvmField @Rule
    var chain: TestRule = RuleChain.outerRule(component).around(main)

    @Before
    fun setUp() {
    }

    @Test
    fun simpleTrueTest() {
        `when`(component.mockInjectedData.status).thenReturn(true)
        main.launchActivity(null)

        onView(withId(R.id.txt_myview)).check(matches(withText("True")))
    }

    @Test
    fun simpleFalseTest() {
        `when`(component.mockInjectedData.status).thenReturn(false)
        main.launchActivity(null)

        onView(withId(R.id.txt_myview)).check(matches(withText("False")))
    }

}