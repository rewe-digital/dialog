package org.rewedigital.dialog.model.google

import org.junit.Assert.*
import org.junit.Test

class GooglePayloadTest {
    @Test
    fun `check implicit user id generation`() {
        val sut = GooglePayload()
        assertNull(sut.userStorage)
        assertNotNull(sut.userData.userId)
        assertNotNull(sut.userStorage)
    }

    @Test
    fun `check user id generation in output`() {
        val sut = GooglePayload()
        val userId = sut.userData.userId
        assertNotNull(userId)
        assertEquals("userId should not change",userId, sut.userData.userId)
        assertEquals("userStorage has unexpected content", """{"data":{"userId":"$userId"}}""", sut.userStorage)
    }

    @Test
    fun `check custom payload`() {
        val sut = GooglePayload()
        sut.userData["Hello"] = "World"
        assertEquals("userStorage has unexpected content", """{"data":{"Hello":"World"}}""", sut.userStorage)
    }

    @Test
    fun `check custom payload with old user id`() {
        val sut = GooglePayload(userStorage = """{"data":{"userId":"abcdef"}}""")
        sut.userData["Hello"] = "World"
        assertEquals("userStorage has unexpected content", """{"data":{"Hello":"World","userId":"abcdef"}}""", sut.userStorage)
    }

    @Test
    fun `check parsing of user id`() {
        val sut = GooglePayload(userStorage = """{"data":{"userId":"abcdef"}}""")
        assertEquals("unexpected user id", "abcdef", sut.userData.userId)
    }
}