package me.kpavlov.lanfguse.spring

import assertk.assertThat
import assertk.assertions.isNotEmpty
import assertk.assertions.isNotNull
import kotlinx.coroutines.test.runTest
import me.kpavlov.langfuse.spring.LangfuseClient
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import kotlin.time.Duration.Companion.seconds

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class LangfuseIT {
    private lateinit var langfuseClient: LangfuseClient

    @BeforeAll
    fun beforeAll() {
        val secretKey = TestEnvironment.env("LANGFUSE_SECRET_KEY")!!
        val publicKey = TestEnvironment.env("LANGFUSE_PUBLIC_KEY")!!
        langfuseClient =
            LangfuseClient(
                secretKey = secretKey,
                publicKey = publicKey,
            )
    }

    @Test
    fun `Should call ProjectApi`() =
        runTest(timeout = 5.seconds) {
            val projects =
                langfuseClient
                    .projectsApi()
                    .projectsGet()
                    .block()

            assertThat(projects).isNotNull()
            projects?.let {
                assertThat(it.data).isNotEmpty()
                println("projects = ${it.data}")
            }
        }

    @Test
    @Disabled("fix handling empty responses")
    fun `Should call CommentsApi`() =
        runTest(timeout = 5.seconds) {
            val comments =
                langfuseClient
                    .commentsApi()
                    .commentsGetRequestConfig()

            assertThat(comments).isNotNull()
        }
}
