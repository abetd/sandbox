package com.example.core

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.assertEquals

class HelloWorldTest {

    @Test
    @DisplayName("サンプル")
    internal fun hello() {
        val actual = HelloWorld().message()
        assertEquals("Hello World.", actual)
    }
}
