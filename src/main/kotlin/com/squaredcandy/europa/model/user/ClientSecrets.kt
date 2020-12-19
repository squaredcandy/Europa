package com.squaredcandy.europa.model.user

import java.time.OffsetDateTime

class ClientSecrets(
    val authToken: String,
    val refreshToken: String,
    val authTokenExpiry: OffsetDateTime,
)