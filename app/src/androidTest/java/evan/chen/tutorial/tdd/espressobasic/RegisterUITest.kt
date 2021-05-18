package evan.chen.tutorial.tdd.espressobasic

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.isDialog
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class RegisterUITest {

    @Rule
    @JvmField
    var activityActivityTestRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun rightPassword_should_startActivity() {

        //輸入正確的帳號
        onView(withId(R.id.loginId))
            .perform(typeText("a123456789"), closeSoftKeyboard())

        //輸入正確的密碼
        onView(withId(R.id.password))
            .perform(typeText("a111111111"), closeSoftKeyboard())

        //點選註冊按鈕
        onView(withId(R.id.send))
            .perform(click())

        //註冊成功，導至成功頁。
        onView(withText("註冊成功"))
            .check(matches(isDisplayed()))
    }

    @Test
    fun wrongPassword_should_alert() {

        //輸入正確的帳號
        onView(withId(R.id.loginId))
            .perform(typeText("a123456789"), closeSoftKeyboard())

        //輸入正確的密碼
        onView(withId(R.id.password))
            .perform(typeText("1234"), closeSoftKeyboard())

        //點選註冊按鈕
        onView(withId(R.id.send))
            .perform(click())

        //註冊失敗，Alert
        onView(withText("錯誤"))
            .inRoot(isDialog())
            .check(matches(isDisplayed()))

    }

}