package com.github.craftscat.kemuri

import kotlin.reflect.KVisibility
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Test class for Kemuri.
 */
class KemuriTest {
    class DefaultVisibilityClass // It doesn't have any visibility modifier, so it's internal.
    public class PublicVisibilityClass
    private class PrivateVisibilityClass
    protected class ProtectedVisibilityClass
    internal class InternalVisibilityClass

    @Test
    fun defaultVisibilityTest() {
        val defaultVisibilityClass = DefaultVisibilityClass()
        assertEquals(KVisibility.INTERNAL, defaultVisibilityClass.javaClass.kotlin.visibility)
    }

    @Test
    fun publicVisibilityTest() {
        val publicVisibilityClass = PublicVisibilityClass()
        assertEquals(KVisibility.PUBLIC, publicVisibilityClass.javaClass.kotlin.visibility)
    }

    @Test
    fun privateVisibilityTest() {
        val privateVisibilityClass = PrivateVisibilityClass()
        assertEquals(KVisibility.PRIVATE, privateVisibilityClass.javaClass.kotlin.visibility)
    }

    @Test
    fun protectedVisibilityTest() {
        val protectedVisibilityClass = ProtectedVisibilityClass()
        assertEquals(KVisibility.PROTECTED, protectedVisibilityClass.javaClass.kotlin.visibility)
    }

    @Test
    fun internalVisibilityTest() {
        val internalVisibilityClass = InternalVisibilityClass()
        assertEquals(KVisibility.INTERNAL, internalVisibilityClass.javaClass.kotlin.visibility)
    }
}
