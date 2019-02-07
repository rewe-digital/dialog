package org.rewedigital.dialog.model.google


data class Device(val location: Location?) {
    data class Location(
        val coordinates: Coordinates?,
        val formattedAddress: String?,
        val zipCode: String?,
        val city: String?,
        val postalAddress: Any?,
        val name: String?,
        val phoneNumber: String?,
        val notes: String?,
        val placeId: String?
    ) {
        data class Coordinates(
            val latitude: Double?,
            val longitude: Double?
        )
    }
}