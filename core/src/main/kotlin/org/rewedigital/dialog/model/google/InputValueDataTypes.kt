package org.rewedigital.dialog.model.google


enum class InputValueDataTypes(val type: String) {
    PERMISSION("type.googleapis.com/google.actions.v2.PermissionValueSpec"),
    OPTION("type.googleapis.com/google.actions.v2.OptionValueSpec"),
    TRANSACTION_REQ_CHECK("type.googleapis.com/google.actions.v2.TransactionRequirementsCheckSpec"),
    DELIVERY_ADDRESS("type.googleapis.com/google.actions.v2.DeliveryAddressValueSpec"),
    TRANSACTION_DECISION("type.googleapis.com/google.actions.v2.TransactionDecisionValueSpec"),
    CONFIRMATION("type.googleapis.com/google.actions.v2.ConfirmationValueSpec"),
    DATETIME("type.googleapis.com/google.actions.v2.DateTimeValueSpec"),
    SIGN_IN("type.googleapis.com/google.actions.v2.SignInValueSpec"),
    NEW_SURFACE("type.googleapis.com/google.actions.v2.NewSurfaceValueSpec"),
    REGISTER_UPDATE("type.googleapis.com/google.actions.v2.RegisterUpdateValueSpec"),
    ANDROID_LINK("type.googleapis.com/google.actions.v2.LinkValueSpec"),
    PLACE("type.googleapis.com/google.actions.v2.PlaceValueSpec")
}