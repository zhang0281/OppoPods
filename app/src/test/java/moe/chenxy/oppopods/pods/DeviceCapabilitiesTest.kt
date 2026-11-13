package moe.chenxy.oppopods.pods

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Test

class DeviceCapabilitiesTest {
    @Test
    fun `missing Android context falls back to conservative capabilities`() {
        val capabilities = detectDeviceCapabilities(context = null, deviceName = "OPPO Enco X3")

        assertFalse(capabilities.adaptiveSupported)
        assertFalse(capabilities.spatialAudioSupported)
        assertFalse(capabilities.spatialSoundSwitchSupported)
        assertEquals(AncImplementation.STANDARD, capabilities.ancImplementation)
    }
}
