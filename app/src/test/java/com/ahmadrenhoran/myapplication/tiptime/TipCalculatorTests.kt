package com.ahmadrenhoran.myapplication.tiptime

import com.ahmadrenhoran.myapplication.unit2.calculateTip
import org.junit.Assert.assertEquals
import org.junit.Test
import java.text.NumberFormat

class TipCalculatorTests {

    @Test
    fun calculate_20_percent_tip_no_roundup() {
        val amount = 10.00
        val tipPercent = 20.00
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        val actualTip = calculateTip(amount = amount, tipPercent = tipPercent, false)
        assertEquals(expectedTip, actualTip)
    }

    @Test
    fun calculate_20_percent_tip_roundup() {
        val amount = 21.00
        val tipPercent = 12.00
        val expectedTip = NumberFormat.getCurrencyInstance().format(3)
        val actualTip = calculateTip(amount = amount, tipPercent = tipPercent, true)
        assertEquals(expectedTip, actualTip)
    }
}