package com.squaredcandy.europa.model.user

open class User(
    open val userId: String,
    open val displayName: String,
    open val email: String,

    open val clientSecrets: ClientSecrets,
    open val userGroups: List<Group> = listOf(),
) {
    override fun equals(other: Any?): Boolean {
        return if(other is User) equals(other) else false
    }

    private fun equals(other: User): Boolean {
        return this.userId == other.userId
    }

    override fun hashCode(): Int {
        var result = userId.hashCode()
        result = 31 * result + displayName.hashCode()
        result = 31 * result + email.hashCode()
        result = 31 * result + clientSecrets.hashCode()
        return result
    }
}