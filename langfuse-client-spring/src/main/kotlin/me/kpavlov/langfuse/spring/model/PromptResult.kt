@file:JvmName("PromptResult")

package me.kpavlov.langfuse.spring.model

public data class PromptResult(
    val type: String,
    val chatPrompt: ChatPrompt?,
    val textPrompt: TextPrompt?,
) {
    override fun toString(): String =
        if (type == "chat") {
            "PromptResult(type='$type', chatPrompt=${chatPrompt?.toRedactedString()})"
        } else {
            "PromptResult(type='$type', textPrompt=${textPrompt?.toRedactedString()})"
        }
}
