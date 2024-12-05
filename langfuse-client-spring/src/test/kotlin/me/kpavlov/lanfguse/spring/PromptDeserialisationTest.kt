package me.kpavlov.lanfguse.spring

import assertk.assertThat
import assertk.assertions.hasSize
import assertk.assertions.isNotNull
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import me.kpavlov.langfuse.spring.configureObjectMapper
import me.kpavlov.langfuse.spring.model.ChatPrompt
import org.junit.jupiter.api.Test

class PromptDeserialisationTest {
    @Test
    fun `Should parse ChatPrompt`() {
        val payload =
            """
            {
              "id": "cm4ac73bm00j613yia6rjbgxm",
              "createdAt": "2024-12-04T20:24:48.802Z",
              "updatedAt": "2024-12-04T20:24:58.144Z",
              "projectId": "cm33i24uk002qw3c2s1iq3nen",
              "createdBy": "cm33i1hd5002gw4c9czfqwoxm",
              "prompt": [
                {
                  "role": "system",
                  "content": "You are helpful advisor for 6 years old kids"
                },
                {
                  "role": "user",
                  "content": "Answer to {{message}}"
                }
              ],
              "name": "first_chat_prompt",
              "version": 1,
              "type": "chat",
              "isActive": null,
              "config": {},
              "tags": [],
              "labels": [
                "latest",
                "production"
              ]
            }
            """.trimIndent()

        val localVarReturnType = object : TypeReference<ChatPrompt>() {}

        val objectMapper = ObjectMapper()

        configureObjectMapper(objectMapper)

        val result = objectMapper.readValue(payload, localVarReturnType)

        assertThat(result).isNotNull()
        assertThat(result.prompt).hasSize(2)
        assertThat(result.labels).hasSize(2)
    }
}
