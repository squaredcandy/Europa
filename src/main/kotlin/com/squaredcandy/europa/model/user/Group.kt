package com.squaredcandy.europa.model.user

// A group contains devices
// Users join groups to get access to devices
class Group(
    val groupId: String,
    val displayName: String,
    val groupOwnerId: String,
    val groupType: GroupType,
) {
    companion object {
        const val PUBLIC_GROUP_ID = "-1"
        val PUBLIC_GROUP = Group(
            groupId = PUBLIC_GROUP_ID,
            displayName = "Public Group",
            groupOwnerId = "-1",
            groupType = GroupType.Public,
        )
    }
}