package com.ahmadrenhoran.myapplication.tiptime

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.ahmadrenhoran.myapplication.unit2.TipCalculatorView
import com.ahmadrenhoran.myapplication.unit2.ui.theme.ComposePracticeTheme
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat

class TipCalculatorUITest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calculate_20_percent_tip() {
        composeTestRule.setContent {
            ComposePracticeTheme {
                TipCalculatorView()
            }
        }
        composeTestRule.onNodeWithText("Bill Amount").performTextInput("10")
        composeTestRule.onNodeWithText("Tip (%)").performTextInput("20")
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        composeTestRule.onNodeWithText("Tip amount: $expectedTip").assertExists(
            "No node with this text was found."
        )
    }
}