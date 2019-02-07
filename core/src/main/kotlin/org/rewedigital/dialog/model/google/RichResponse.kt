package org.rewedigital.dialog.model.google

import org.rewedigital.dialog.model.dialogflow.Button
import org.rewedigital.dialog.model.dialogflow.Image
import org.rewedigital.dialog.model.dialogflow.LinkOutSuggestion
import org.rewedigital.dialog.model.dialogflow.Suggestion
import org.rewedigital.dialog.model.google.table.ColumnProperties
import org.rewedigital.dialog.model.google.table.Row
import org.rewedigital.dialog.model.google.table.TableCard

data class RichResponse(
    val items: MutableList<ResponseHolder> = mutableListOf(),
    val suggestions: MutableList<Suggestion> = mutableListOf(),
    val linkOutSuggestion: MutableList<LinkOutSuggestion> = mutableListOf()
) {
    fun withSimpleResponse(
        textToSpeech: String? = null,
        ssml: String? = null,
        displayText: String? = null
    ) = apply {
        if (items.count { it is SimpleResponseHolder } > 2) throw RuntimeException("Too many simple responses")
        items += SimpleResponseHolder(
            GoogleSimpleResponse(
                textToSpeech,
                ssml,
                displayText
            )
        )
    }

    fun withCarousel(
        items: MutableList<GoogleCarouselItem> = mutableListOf(),
        imageDisplayOptions: ImageDisplayOptions = ImageDisplayOptions.CROPPED
    ) = apply {
        this.items += CarouselBrowseHolder(CarouselBrowse(items, imageDisplayOptions))
    }

    fun withBasicCard(
        title: String? = null,
        subtitle: String? = null,
        formattedText: String? = null,
        image: GoogleImage? = null,
        buttons: MutableList<GoogleButton> = mutableListOf(),
        imageDisplayOptions: ImageDisplayOptions? = ImageDisplayOptions.CROPPED
    ) = apply {
        items += BasicCardHolder(
            GoogleBasicCard(
                title,
                subtitle,
                formattedText,
                image,
                buttons,
                imageDisplayOptions
            )
        )
    }

    //fun withStructuredResponse() = apply {
    //    items += StructuredResponseHolder(StructuredResponse())
    //}

    fun withMediaResponse(
        mediaType: MediaType = MediaType.MEDIA_TYPE_UNSPECIFIED,
        mediaObjects: MutableList<MediaObject> = mutableListOf()
    ) = apply {
        items += MediaResponseHolder(MediaResponse(mediaType, mediaObjects))
    }

    fun withTableCard(
        title: String? = null,
        subtitle: String? = null,
        image: Image? = null,
        columnProperties: MutableList<ColumnProperties> = mutableListOf(),
        rows: MutableList<Row> = mutableListOf(),
        buttons: MutableList<Button> = mutableListOf()
    ) = apply {
        items += TableCardHolder(TableCard(title, subtitle, image, columnProperties, rows, buttons))
    }

    fun withSuggestions(vararg suggestions: String) = apply {
        this.suggestions += suggestions.map(::Suggestion)
    }

    fun withLinkOutSuggestions(suggestions: Map<String, String>) = apply {
        linkOutSuggestion += suggestions.entries.map { LinkOutSuggestion(it.key, it.value) }
    }

    fun withLinkOutSuggestions(vararg suggestions: LinkOutSuggestion) = apply {
        linkOutSuggestion += suggestions
    }

    fun withLinkOutSuggestion(destinationName: String, uri: String) = apply {
        linkOutSuggestion += LinkOutSuggestion(destinationName, uri)
    }
}