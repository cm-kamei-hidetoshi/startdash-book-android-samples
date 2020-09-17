package com.cmtaro.sample

import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test

class CalculatorTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun sum() {
        val calc = Calculator()

        // calc.sum(1,2) は 3 となることを確認する
        assertThat(calc.sum(1, 2)).isEqualTo(3)

    }

    @Test
    fun isEvenNumber() {
        val calc = Calculator()

        // 12 は偶数である
        assertThat(calc.isEvenNumber(12)).isTrue()
    }

    @Test
    fun message() {
        val calc = Calculator()

        assertThat(calc.message()).apply {
            isNotEmpty()
            startsWith("me")    // 先頭が me である
            contains("ssa")     // ssa が含まれる
            endsWith("ge")      // 末尾が ge である
        }
    }

}
