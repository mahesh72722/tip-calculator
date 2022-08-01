package com.example.tipcalculator

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import  androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.CoreMatchers.containsString
import java.util.regex.Pattern.matches


@RunWith(AndroidJUnit4::class)
class TipCalculatorInstrumentedTest {

    @get:Rule()
    val activity = ActivityScenarioRule(MainActivity::class.java)

    // Espresso is a library that comes ready to use with an Android project
    @Test
    fun calculate_20_percent_tip() {
      onView(withId(R.id.etCostOfService)).perform(typeText("50.00"))
        onView(withId(R.id.btnCalculate)).perform(click())
        onView(withId(R.id.txtTipAmount)).check(matches(withText(containsString("0.0"))))
    }

}