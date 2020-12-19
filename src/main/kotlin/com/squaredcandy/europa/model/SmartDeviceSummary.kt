package com.squaredcandy.europa.model

import com.squaredcandy.europa.model.user.Group

abstract class SmartDeviceSummary(
    open val groupId: String = Group.PUBLIC_GROUP_ID
)