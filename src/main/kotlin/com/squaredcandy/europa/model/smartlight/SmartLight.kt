package com.squaredcandy.europa.model.smartlight

import com.squaredcandy.europa.model.SmartDevice
import com.squaredcandy.europa.model.user.Group
import java.time.OffsetDateTime

data class SmartLight(
    val name: String,
    val macAddress: String,
    // Last available IP Address
    val ipAddress: String,
    val created: OffsetDateTime = OffsetDateTime.now(),
    val lastUpdated: OffsetDateTime = OffsetDateTime.now(),
    val smartLightData: List<SmartLightData>,
    override val groupId: String = Group.PUBLIC_GROUP_ID,
) : SmartDevice(groupId = groupId)