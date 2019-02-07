package org.rewedigital.dialog.model.dialogflow

import org.rewedigital.dialog.model.google.GoogleBasicCard
import org.rewedigital.dialog.model.google.GoogleSimpleResponses

interface FulfillmentMessage {
    val platform: Platform?
}

data class TextFulfillmentMessage(
    override val platform: Platform? = null,
    val text: TextMessage
) : FulfillmentMessage

data class ImageFulfillmentMessage(
    override val platform: Platform? = null,
    val image: Image
) : FulfillmentMessage

data class QuickRepliesFulfillmentMessage(
    override val platform: Platform? = null,
    val quickReplies: QuickReplies
) : FulfillmentMessage

data class CardFulfillmentMessage(
    override val platform: Platform? = null,
    val card: Card
) : FulfillmentMessage

data class SimpleResponsesFulfillmentMessage(
    override val platform: Platform? = null,
    val simpleResponses: GoogleSimpleResponses
) : FulfillmentMessage

data class BasicCardFulfillmentMessage(
    override val platform: Platform? = null,
    val basicCard: GoogleBasicCard
) : FulfillmentMessage

data class SuggestionsFulfillmentMessage(
    override val platform: Platform? = null,
    val suggestions: Suggestions
) : FulfillmentMessage

data class LinkOutSuggestionFulfillmentMessage(
    override val platform: Platform? = null,
    val linkOutSuggestion: LinkOutSuggestion
) : FulfillmentMessage

data class ListSelectFulfillmentMessage(
    override val platform: Platform? = null,
    val listSelect: ListSelect
) : FulfillmentMessage

data class CarouselSelectFulfillmentMessage(
    override val platform: Platform? = null,
    val carouselSelect: CarouselSelect
) : FulfillmentMessage

data class Messages(
    override val platform: Platform? = null,
    val text: TextMessage? = null,
    val image: Image? = null,
    val quickReplies: QuickReplies? = null,
    val card: Card? = null,
    //Google Objects
    val simpleResponses: GoogleSimpleResponses? = null,
    val basicCard: GoogleBasicCard? = null,
    val suggestions: Suggestions? = null,
    val linkOutSuggestion: LinkOutSuggestion? = null,
    val listSelect: ListSelect? = null,
    val carouselSelect: CarouselSelect? = null
): FulfillmentMessage