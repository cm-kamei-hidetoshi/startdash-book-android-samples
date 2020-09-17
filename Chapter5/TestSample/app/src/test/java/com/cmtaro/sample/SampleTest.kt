package com.cmtaro.sample

import org.junit.*

class SampleTest {

    companion object {

        @BeforeClass
        @JvmStatic
        fun beforeClass() {
            println("BeforeClass")
        }

        @AfterClass
        @JvmStatic
        fun afterClass() {
            println("AfterClass")
        }
    }

    @Before
    fun setUp() {
        println("Before")
    }

    @After
    fun tearDown() {
        println("After")
    }

    @Test
    fun sampleTest1() {
        println("sampleTest1")
    }

    @Ignore("テストをスキップします")
    @Test
    fun sampleTest2() {
        println("sampleTest2")
    }

    @Test
    fun sampleTest3() {
        println("sampleTest3")
    }
}