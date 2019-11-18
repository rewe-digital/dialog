package org.rewedigital.dialog.factories

import org.rewedigital.dialog.model.google.*


internal object SystemIntentFactory {

    fun buildSignInIntent(optContext: String? = null) =
        SystemIntent(
            intent = SystemIntents.SIGN_IN,
            data = Data(
                inputValueDataType = InputValueDataTypes.SIGN_IN,
                optContext = optContext
            )
        )

    fun buildPermissionIntent(optContext: String? = null, vararg permissions: Permissions) =
        SystemIntent(
            intent = SystemIntents.PERMISSION,
            data = Data(
                inputValueDataType = InputValueDataTypes.PERMISSION,
                permissions = mutableListOf(*permissions),
                optContext = optContext
            )
        )
}
