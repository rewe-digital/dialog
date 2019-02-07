package org.rewedigital.dialog.model.google


enum class SystemIntents(val intentName: String) {
    MAIN("actions.intent.MAIN"),
    TEXT("actions.intent.TEXT"),
    PERMISSION("actions.intent.PERMISSION"),
    OPTION("actions.intent.OPTION"),
    TRANSACTION_REQUIREMENTS_CHECK("actions.intent.TRANSACTION_REQUIREMENTS_CHECK"),
    DELIVERY_ADDRESS("actions.intent.DELIVERY_ADDRESS"),
    TRANSACTION_DECISION("actions.intent.TRANSACTION_DECISION"),
    CONFIRMATION("actions.intent.CONFIRMATION"),
    DATETIME("actions.intent.DATETIME"),
    SIGN_IN("actions.intent.SIGN_IN"),
    NO_INPUT("actions.intent.NO_INPUT"),
    CANCEL("actions.intent.CANCEL"),
    NEW_SURFACE("actions.intent.NEW_SURFACE"),
    REGISTER_UPDATE("actions.intent.REGISTER_UPDATE"),
    CONFIGURE_UPDATES("actions.intent.CONFIGURE_UPDATES"),
    ANDROID_LINK("actions.intent.LINK"),
    PLACE("actions.intent.PLACE")
}