package model

import java.time.OffsetDateTime

data class SmartLight(
    val name: String,
    val macAddress: String,
    val created: OffsetDateTime = OffsetDateTime.now(),
    val lastUpdated: OffsetDateTime = OffsetDateTime.now(),
    val smartLightData: List<SmartLightData>,
)