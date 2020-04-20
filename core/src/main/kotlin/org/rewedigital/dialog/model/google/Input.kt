package org.rewedigital.dialog.model.google


data class Input(
    val rawInputs: List<RawInput>? = null,
    val intent: String? = null,
    val arguments: List<Argument>? = null
) {

    data class RawInput(
        val inputType: InputType? = null,
        val query: String? = null
    ) {
        enum class InputType {
            UNSPECIFIED_INPUT_TYPE,
            TOUCH,
            VOICE,
            KEYBOARD,
            URL
        }
    }

    data class Argument(
        val name: String? = null,
        val rawText: String? = null,
        val textValue: String? = null,
        val intValue: String? = null,
        val floatValue: Double? = null,
        val boolValue: Boolean? = null,
        val extension: Extension? = null
    ) {
        data class Extension(
            val `@type`: String? = null,
            val status: String? = null
        )

        enum class ArgumentNames {
            PERMISSION,
            OPTION,
            TRANSACTION_REQ_CHECK_RESULT,
            DELIVERY_ADDRESS_VALUE,
            TRANSACTION_DECISION_VALUE,
            CONFIRMATION,
            DATETIME,
            SIGN_IN,
            REPROMPT_COUNT,
            IS_FINAL_REPROMPT,
            NEW_SURFACE,
            REGISTER_UPDATE,
            TEXT
        }
    }
}