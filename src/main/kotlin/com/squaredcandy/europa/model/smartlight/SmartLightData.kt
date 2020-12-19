package com.squaredcandy.europa.model.smartlight

import java.time.OffsetDateTime

data class SmartLightData(
    val timestamp: OffsetDateTime = OffsetDateTime.now(),
    val connected: Boolean,
    val isOn: Boolean, // False if not connected
    val capabilities: List<SmartLightCapability>,
)