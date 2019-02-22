# Dialog [![Build Status][travis-image]][travis-url] [![Download at Bintray][bintray-image]][bintray-url] [![License: MIT][mit-image]][mit-url] [![Stars][star-img]][star-url]

Dialog is a Dialogflow v2 API implementation written in Kotlin. With some great optional extensions you can use to
write your own voice application fast.

## Top features

- Dialogflow V2 API reference implementation written in Kotlin
- Intercepter API for adding e.g. tracking
- Spring reference implementation
- SSML builder for creating rich responses
- Plugin for Konversation to distinct the dialogs from code

### Dialogflow API v2 Usage

A response with a simple response and a basic card would look like this:

    return handler.responseBuilder
        .expectUserResponse(true)
        .withGoogleSimpleResponse(speech)
        .withGoogleBasicCard(
            title = "CardTitle",
            subtitle = "CardSubTitle",
            formattedText = "CardFormattedText",
            buttons = mutableListOf(
                GoogleButton(
                    title = "ButtonText",
                    openUrlAction = OpenUrlAction(url = "https://rewe-digital.com/")
                )
            )
        )
        .withGoogleSimpleResponse(question)
        .withGoogleSuggestions(*suggestions.orEmpty())

<sup>Example taken from [UiElementsIntentHandler](spring-sample/src/main/kotlin/org/rewedigital/dialog/springsample/intenthandler/UiElementsIntentHandler.kt#L40-L55)</sub>

Here is a list of some selected methods you can use to create the response of your voice application:
- [`askGoogleForCoarseLocation(...)`](docs/core/org.rewedigital.dialog.handler/-dialogflow-response-builder/ask-google-for-coarse-location.md)
- [`askGoogleForLocation(...)`](docs/core/org.rewedigital.dialog.handler/-dialogflow-response-builder/ask-google-for-location.md)
- [`askGoogleForPreciseLocation(...)`](docs/core/org.rewedigital.dialog.handler/-dialogflow-response-builder/ask-google-for-precise-location.md)
- [`askGoogleForSignIn(...)`](docs/core/org.rewedigital.dialog.handler/-dialogflow-response-builder/ask-google-for-sign-in.md)
- [`expectUserResponse(...)`](docs/core/org.rewedigital.dialog.handler/-dialogflow-response-builder/expect-user-response.md)
- [`withCard(...)`](docs/core/org.rewedigital.dialog.handler/-dialogflow-response-builder/with-card.md)
- [`withGoogleBasicCard(...)`](docs/core/org.rewedigital.dialog.handler/-dialogflow-response-builder/with-google-basic-card.md)
- [`withGoogleCarouselSelect(...)`](docs/core/org.rewedigital.dialog.handler/-dialogflow-response-builder/with-google-carousel-select.md)
- [`withGoogleLinkOutSuggestion(...)`](docs/core/org.rewedigital.dialog.handler/-dialogflow-response-builder/with-google-link-out-suggestion.md)
- [`withGoogleListSelect(...)`](docs/core/org.rewedigital.dialog.handler/-dialogflow-response-builder/with-google-list-select.md)
- [`withGoogleReprompts(...)`](docs/core/org.rewedigital.dialog.handler/-dialogflow-response-builder/with-google-reprompts.md)
- [`withGoogleSimpleResponse(...)`](docs/core/org.rewedigital.dialog.handler/-dialogflow-response-builder/with-google-simple-response.md)
- [`withGoogleSimpleResponses(...)`](docs/core/org.rewedigital.dialog.handler/-dialogflow-response-builder/with-google-simple-responses.md)
- [`withGoogleSuggestions(...)`](docs/core/org.rewedigital.dialog.handler/-dialogflow-response-builder/with-google-suggestions.md)
- [`withImage(...)`](docs/core/org.rewedigital.dialog.handler/-dialogflow-response-builder/with-image.md)
- [`withQuickReplies(...)`](docs/core/org.rewedigital.dialog.handler/-dialogflow-response-builder/with-quick-replies.md)
- [`withText(...)`](docs/core/org.rewedigital.dialog.handler/-dialogflow-response-builder/with-text.md)

## Dialog Intro

You can use the core library for you own implementation, where you can choose your own application server or your own
server less hosting. In the end you need to setup your rest endpoints yourself and manage the conversion of the POKOs
(plain old Kotlin objects).

When you have your request converted to [WebhookRequest] Dialog can handle the request by using the [RequestResolver].
The constructor expects 4 arguments: `intentHandlers`, `requestInterceptors`, `responseInterceptors` and
`fallbackAction`. The first three options are lists each of them are explained in more details in the following sections.

### Handling intents

The [DialogflowIntentHandler] is the core where you handle the intents. Each handler can choose independent if it feels
responsible for the intent. This is very helpful if you have some intents which depends on the current context.

[RequestResolver] will call the function [`canHandleDialogflowIntent(...)`][intent-methods]. When your intent feels
responsible return `true` then the [`handleDialogflowIntent(...)`][intent-methods] will be called. Please note that
you define the order of the calls with the order of of the `RequestResolver`'s `intentHandlers`. First come first serve,
you should avoid that multiple handlers return `true` of the same intent, based your the list implementation the result
could be random.

As said above the [RequestResolver] will call the [`handleDialogflowIntent(...)`][intent-methods] method if you return
`true` in the [`canHandleDialogflowIntent`][intent-methods] method. The logic for handling the Intent goes here. To
create a response use [`input.responseBuilder`][ResponseBuilder].

### Interceptors

You can use the [RequestInterceptor] for tracking. In `onDialogflowRequest()` will get the input where you can grep the
data you need for analytics.

### FallbackAction

This is a special [DialogflowIntentHandler] which will be invoked when no intent handler will feel responsible for your
request. Please note that the result of the `canHandle` method will be ignored for the fallback usage.

### Example

    class WelcomeIntentHandler : DialogflowIntentHandler {
    
        override fun canHandleDialogflowIntent(handler: DialogflowHandler): Boolean {
            return handler.action?.equals("input.welcome") ?: false
        }
    
        override fun handleDialogflowIntent(handler: DialogflowHandler): DialogflowResponseBuilder {
            return handler.responseBuilder.withText("Welcome to Dialog!")
        }
    }


## Using Dialog with Spring

We have a special plugin for Spring which should make it very easy to implement your own webservice with it. You can use
the spring-sample project as template for your own project. When you use our plugin you should annotate each intent with
`@IntentHandler` to make that intent handler to a component which provides you all the advantages of dependency
injection. The best it that we use it also for discovering your intent handler automatically. For the fallback intent
you should use the annotation `@FallbackIntentHandler`, if it is missing you service won't start up.

## License

The MIT license (MIT)

Copyright (c) 2018 REWE Digital GmbH

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit
persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

[travis-image]: https://travis-ci.com/rewe-digital-incubator/dialog.svg?branch=master
[travis-url]: https://travis-ci.com/rewe-digital-incubator/dialog
[bintray-image]: https://api.bintray.com/packages/rewe-digital/dialog/core/images/download.svg
[bintray-url]: https://bintray.com/rewe-digital/dialog/core/_latestVersion
[mit-image]: https://img.shields.io/badge/License-MIT-yellow.svg
[mit-url]: https://opensource.org/licenses/MIT
[star-img]: https://img.shields.io/github/stars/rewe-digital-incubator/dialog.svg?style=social&label=Star&maxAge=3600
[star-url]: https://github.com/rewe-digital-incubator/dialog/stargazers
[WebhookRequest]: core/src/main/kotlin/org/rewedigital/dialog/model/dialogflow/WebhookRequest.kt
[RequestResolver]: docs/core/org.rewedigital.dialog.resolver/-request-resolver/index.md
[DialogflowIntentHandler]: docs/core/org.rewedigital.dialog.handler/-dialogflow-intent-handler/index.md
[intent-methods]: docs/core/org.rewedigital.dialog.handler/-dialogflow-intent-handler/index.md#Functions
[ResponseBuilder]: docs/core/org.rewedigital.dialog.handler/-dialogflow-response-builder/index.md
[RequestInterceptor]: docs/core/org.rewedigital.dialog.interceptors/-request-interceptor/index.md
