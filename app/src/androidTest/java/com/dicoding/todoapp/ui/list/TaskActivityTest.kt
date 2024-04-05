package com.dicoding.todoapp.ui.list

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.dicoding.todoapp.ui.add.AddTaskActivity
import com.dicoding.todoapp.R
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

//TODO 16 : Write UI test to validate when user tap Add Task (+), the AddTaskActivity displayed
@RunWith(AndroidJUnit4ClassRunner::class)
class TaskActivityTest {
    @Before
    fun setup() {
        ActivityScenario.launch(TaskActivity::class.java)
    }

    @Test
    fun tapAddTask() {
        Intents.init()
        onView(withId(R.id.fab)).perform(click())
        Intents.intended(hasComponent(AddTaskActivity::class.java.name))
        Intents.release()
    }
}