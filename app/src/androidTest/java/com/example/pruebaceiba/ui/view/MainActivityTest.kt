package com.example.pruebaceiba.ui.view

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.pruebaceiba.R
import com.example.pruebaceiba.ui.adapter.UserViewHolder
import org.hamcrest.CoreMatchers
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
@LargeTest
class MainActivityTest{
    val LIST_ITEM_IN_TEST = 4


   @get:Rule
   val activityRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun type_word_in_edittext(){
       onView(withId(R.id.edtSearch)).perform(typeText("prueba"), closeSoftKeyboard())
        onView(withId(R.id.edtSearch)).check(matches(withText("prueba")))
    }

    @Test
    fun load_progres(){
        onView(withId(R.id.rcyList)).check(matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.loading)).check(matches(CoreMatchers.not(ViewMatchers.isDisplayed())))
    }

    @Test
    fun test_selectListItem_recycler() {
        onView(withId(R.id.rcyList))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<UserViewHolder>(
                    LIST_ITEM_IN_TEST,
                    ViewActions.click()
                )
            )

        onView(withId(R.id.textName)).check(matches(withText(LIST_ITEM_IN_TEST)))
    }





}

