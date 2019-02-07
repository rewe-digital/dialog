[core](../../index.md) / [org.rewedigital.dialog.handler](../index.md) / [DialogflowResponseBuilder](index.md) / [askGoogleForLocation](./ask-google-for-location.md)

# askGoogleForLocation

`fun askGoogleForLocation(reason: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`DialogflowResponseBuilder`](index.md)

Helper function to ask the user for [Permissions.DEVICE_COARSE_LOCATION](../../org.rewedigital.dialog.model.google/-permissions/-d-e-v-i-c-e_-c-o-a-r-s-e_-l-o-c-a-t-i-o-n.md) and
[Permissions.DEVICE_PRECISE_LOCATION](../../org.rewedigital.dialog.model.google/-permissions/-d-e-v-i-c-e_-p-r-e-c-i-s-e_-l-o-c-a-t-i-o-n.md) permission.
[DialogflowHandler.permissionGranted](../-dialogflow-handler/permission-granted.md) will return true if the permission was granted.

