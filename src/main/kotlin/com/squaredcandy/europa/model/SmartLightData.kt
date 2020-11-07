package com.squaredcandy.europa.model

import java.time.OffsetDateTime

data class SmartLightData(
    val timestamp: OffsetDateTime = OffsetDateTime.now(),
    val ipAddress: String?,
    val isOn: Boolean, // False if not connected
    val capabilities: List<SmartLightCapability>,
) {
    val isConnected: Boolean
        get() = ipAddress.isNullOrBlank()
}