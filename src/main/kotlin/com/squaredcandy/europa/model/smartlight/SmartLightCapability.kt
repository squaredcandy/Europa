package com.squaredcandy.europa.model.smartlight

sealed class SmartLightCapability {
    sealed class SmartLightColor(open val brightness: Float) : SmartLightCapability() {
        data class SmartLightHSB(
                val hue: Float,
                val saturation: Float,
                override val brightness: Float,
        ) : SmartLightColor(brightness)
        data class SmartLightKelvin(
                val kelvin: Int,
                override val brightness: Float,
        ) : SmartLightColor(brightness)
    }
    data class SmartLightLocation(val location: String) : SmartLightCapability()
}