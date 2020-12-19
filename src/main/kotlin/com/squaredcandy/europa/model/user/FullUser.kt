package com.squaredcandy.europa.model.user

open class FullUser(
    override val userId: String,
    override val displayName: String,
    override val email: String,

    override val clientSecrets: ClientSecrets,
    override val userGroups: List<Group> = listOf(),
    val userAccountType: AccountType = AccountType.Normal,
): User(
    userId, displayName, email, clientSecrets, userGroups,
)