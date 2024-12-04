package me.kpavlov.lanfguse.spring

import kotlinx.coroutines.reactor.awaitSingle
import me.kpavlov.langfuse.spring.PromptsApi
import me.kpavlov.langfuse.spring.model.Prompt
import me.kpavlov.langfuse.spring.model.PromptMetaListResponse
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
): Prompt =
    this
        .promptsGet(promptName, version, label)
        .awaitSingle()
