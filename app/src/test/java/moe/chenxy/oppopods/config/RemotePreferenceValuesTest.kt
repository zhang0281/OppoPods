package moe.chenxy.oppopods.config

import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class RemotePreferenceValuesTest {
    @Test
    fun `empty remote string sets use a framework-loadable Java collection`() {
        val encoded = ConfigManager.remoteStringSet(emptySet())

        assertEquals(java.util.HashSet::class.java, encoded.javaClass)
        val output = ByteArrayOutputStream()
        ObjectOutputStream(output).use { it.writeObject(encoded) }
        val decoded = ObjectInputStream(ByteArrayInputStream(output.toByteArray())).use {
            @Suppress("UNCHECKED_CAST")
            it.readObject() as Set<String>
        }
        assertTrue(decoded.isEmpty())
    }
}
