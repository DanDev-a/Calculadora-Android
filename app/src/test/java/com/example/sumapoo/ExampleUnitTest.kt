package com.example.sumapoo

import com.example.sumapoo.data.Calculadora
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val cal = Calculadora()
        assertEquals("4", cal.suma("3.a","0.995"))
    }
}