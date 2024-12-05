package me.kpavlov.langfuse.spring.model

public fun ChatPrompt.toRedactedString(): String {
    val sb = StringBuilder()
    sb.append("class ChatPrompt {\n")
    sb.append("    name: ").append(toIndentedString(name)).append("\n")
    sb.append("    prompt: ").append("[REDACTED]").append("\n")
    sb.append("    version: ").append(toIndentedString(version)).append("\n")
    sb.append("    config: ").append(toIndentedString(config)).append("\n")
    sb.append("    labels: ").append(toIndentedString(labels)).append("\n")
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n")
    sb.append("}")
    return sb.toString()
}

public fun TextPrompt.toRedactedString(): String {
    val sb = java.lang.StringBuilder()
    sb.append("class TextPrompt {\n")
    sb.append("    name: ").append(toIndentedString(name)).append("\n")
    sb.append("    prompt: ").append("[REDACTED]").append("\n")
    sb.append("    version: ").append(toIndentedString(version)).append("\n")
    sb.append("    config: ").append(toIndentedString(config)).append("\n")
    sb.append("    labels: ").append(toIndentedString(labels)).append("\n")
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n")
    sb.append("}")
    return sb.toString()
}

/**
 * Convert the given object to string with each line indented by 4 spaces
 * (except the first line).
 */
private fun toIndentedString(o: Any?): String {
    if (o == null) {
        return "null"
    }
    return o.toString().replace("\n", "\n    ")
}
