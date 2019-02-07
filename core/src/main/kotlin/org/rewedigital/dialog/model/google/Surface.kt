package org.rewedigital.dialog.model.google


data class Surface(val capabilities: List<Capability>?) {

    data class Capability(val name: String?)
}