package org.rewedigital.dialog.model.google


data class User(
    val idToken: String?,
    val profile: Profile?,
    val accessToken: String?,
    val permissions: List<Permissions>?,
    val locale: String?,
    val lastSeen: String?,
    override var userStorage: String?
) : UserStorageHolder {
    data class Profile(
        val displayName: String?,
        val givenName: String?,
        val familyName: String?
    )
}