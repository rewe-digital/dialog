package org.rewedigital.dialog.model.google

import java.util.*

interface UserStorageHolder {
    var userStorage: String?
}

val UserStorageHolder.userData: DataStorage
get() = DataStorage(this)

class DataStorage(private val userData : UserStorageHolder) : LinkedHashMap<String, String>() {
    init {
        val data = userData.userStorage
        data?.let {
            val dataPos = data.indexOf("data")
            val firstBracket = data.indexOf("{")
            val secondBracket = data.indexOf("{", 1)
            val seemsValid =
                firstBracket == 0 && dataPos > firstBracket && secondBracket > dataPos && data.endsWith("}}")
            if (seemsValid) {
                // remove known pre- and suffix
                data.substring(secondBracket + 1, data.length - 2)
                    .split(',')
                    .forEach { keyValuePair ->
                        val (key, value) = keyValuePair.split(":")
                        put(key.stripQuotesAndSlashes(), value.stripQuotesAndSlashes())
                    }
            }
        }
    }

    private fun String.stripQuotesAndSlashes(): String {
        return trim().trim('"').replace("\\\\", "\\")
    }

    override fun clear() {
        super.clear()
        userData.userStorage = asJson()
    }

    override fun putAll(from: Map<out String, String>) {
        super.putAll(from)
        userData.userStorage = asJson()
    }

    override fun put(key: String, value: String) =
        super.put(key, value).also {
            userData.userStorage = asJson()
        }

    override fun remove(key: String) =
        super.remove(key).also {
            userData.userStorage = asJson()
        }

    override fun remove(key: String, value: String)=
        super.remove(key, value).also {
            userData.userStorage = asJson()
    }

    val userId: String
        get() = getOrPut("userId") { UUID.randomUUID().toString() }

    private fun asJson(): String? =
        if (entries.size > 0)
            entries
                .sortedBy { it.key } // order by key to make the output more deterministic
                .joinToString(separator = ",", prefix = """{"data":{""", postfix = "}}") {
                    fun String.mask() = replace("\"", "\\\"").replace("\\", "\\\\")
                    """"${it.key.mask()}":"${it.value.mask()}""""
                }
        else null
}