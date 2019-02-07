package org.rewedigital.dialog.model.google

import org.rewedigital.dialog.model.google.table.TableCard

interface ResponseHolder

data class SimpleResponseHolder(val simpleResponse: GoogleSimpleResponse) : ResponseHolder
data class BasicCardHolder(val basicCard: GoogleBasicCard) : ResponseHolder
data class StructuredResponseHolder(val structuredResponse: StructuredResponse) : ResponseHolder
data class MediaResponseHolder(val mediaResponse: MediaResponse) : ResponseHolder
data class CarouselBrowseHolder(val carouselBrowse: CarouselBrowse) : ResponseHolder
data class TableCardHolder(val tableCard: TableCard) : ResponseHolder