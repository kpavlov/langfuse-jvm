package me.kpavlov.langfuse.spring

import com.fasterxml.jackson.databind.node.TreeTraversingParser
import kotlinx.coroutines.reactor.awaitSingle
import me.kpavlov.langfuse.spring.model.ChatPrompt
import me.kpavlov.langfuse.spring.model.PromptMetaListResponse
import me.kpavlov.langfuse.spring.model.PromptResult
import me.kpavlov.langfuse.spring.model.TextPrompt
import java.time.OffsetDateTime

private const val DEFAULT_PAGE_SIZE = 100

@Suppress("LongParameterList")
@JvmOverloads
suspend fun PromptsApi.awaitPromptsList(
    name: String? = null,
    label: String? = null,
    tag: String? = null,
    page: Int? = 1,
    limit: Int? = DEFAULT_PAGE_SIZE,
    fromUpdatedAt: OffsetDateTime? = null,
    toUpdatedAt: OffsetDateTime? = null,
): PromptMetaListResponse =
    this
        .promptsList(name, label, tag, page, limit, fromUpdatedAt, toUpdatedAt)
        .awaitSingle()

@Suppress("LongParameterList")
@JvmOverloads
suspend fun PromptsApi.awaitPromptGet(
    promptName: String,
    label: String? = null,
    version: Int? = null,
): PromptResult {
    val objectMapper = this.apiClient.objectMapper
    return this
        .promptsGet(promptName, version, label)
        .map {
            val parser = TreeTraversingParser(it)
            val type: String = it?.get("type")?.asText() ?: "text"
            if (type == "chat") {
                val chatPrompt = objectMapper.readValue(parser, ChatPrompt::class.java)
                return@map PromptResult(type, chatPrompt, null)
            } else {
                val textPrompt = objectMapper.readValue(parser, TextPrompt::class.java)
                return@map PromptResult(type, null, textPrompt)
            }
        }.awaitSingle()
}
