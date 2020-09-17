package com.cmtaro.sample

import android.Manifest
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.GrantPermissionRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @get:Rule
    val failedWatcher = FailedTestWatcher()

    @get:Rule
    val grantPermissionRule: GrantPermissionRule =
        GrantPermissionRule.grant(Manifest.permission.WRITE_EXTERNAL_STORAGE)

    @Test
    fun mainActivityTest() {

        // FirstFragment で表示される label が Hello Espresso! になっていること
        onView(ViewMatchers.withId(R.id.label))
            .check(ViewAssertions.matches(ViewMatchers.withText("Hello Espresso!")))

        // edit_text に Hello を入力してキーボードを閉じる
        onView(ViewMatchers.withId(R.id.edit_text))
            .perform(ViewActions.typeText("Hello"), ViewActions.closeSoftKeyboard())

        // button をクリックする (SecondFragment に遷移)
        onView(ViewMatchers.withId(R.id.button))
            .perform(ViewActions.click())

        // Hello の入力に対して、 Hello World で検証する（エラー）
        onView(ViewMatchers.withId(R.id.show_text))
            .check(ViewAssertions.matches(ViewMatchers.withText("Hello World")))

    }
}