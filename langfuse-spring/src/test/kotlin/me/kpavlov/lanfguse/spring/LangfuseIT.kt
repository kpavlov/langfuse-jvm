package me.kpavlov.lanfguse.spring

import assertk.assertThat
import assertk.assertions.isNotNull
import kotlinx.coroutines.test.runTest
import me.kpavlov.langfuse.spring.LangfuseClient
import org.junit.jupiter.api.Test
import kotlin.time.Duration.Companion.seconds
import kotlin.time.toJavaDuration

internal class LangfuseIT {

    @Test
    fun `Should call Langfuse`() = runTest {
        val projects = LangfuseClient().projectsApi()
            .projectsGet()
            .block(5.seconds.toJavaDuration())

        assertThat(projects).isNotNull()
    }
}
