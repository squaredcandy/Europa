package com.squaredcandy.europa.model.smartlight

import com.squaredcandy.europa.model.SmartDeviceSummary
import com.squaredcandy.europa.model.user.Group

data class SmartLightSummary(
    val mac_address: String,
    val ip_address: String,
    val name: String,
    val isOn: Boolean,
    val color: SmartLightCapability.SmartLightColor,
    val location: SmartLightCapability.SmartLightLocation,
    override val groupId: String = Group.PUBLIC_GROUP_ID,
) : SmartDeviceSummary(
    groupId = groupId
)