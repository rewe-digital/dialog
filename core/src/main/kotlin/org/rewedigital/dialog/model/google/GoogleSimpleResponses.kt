package org.rewedigital.dialog.model.google

data class GoogleSimpleResponses(val simpleResponses: MutableList<GoogleSimpleResponse> = mutableListOf()) {
    constructor(simpleResponses: GoogleSimpleResponse) : this(mutableListOf(simpleResponses))
    constructor(simpleResponses1: GoogleSimpleResponse, simpleResponses2: GoogleSimpleResponse) : this(
        mutableListOf(
            simpleResponses1,
            simpleResponses2
        )
    )

    constructor(simpleResponses: String) : this(
        mutableListOf(
            GoogleSimpleResponse(
                simpleResponses
            )
        )
    )

    constructor(simpleResponses1: String, simpleResponses2: String) : this(
        mutableListOf(
            GoogleSimpleResponse(simpleResponses1),
            GoogleSimpleResponse(simpleResponses2)
        )
    )
}