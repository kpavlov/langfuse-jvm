package me.kpavlov.lanfguse.spring

import assertk.assertThat
import assertk.assertions.contains
import assertk.assertions.doesNotContain
import assertk.assertions.isNotEmpty
import assertk.assertions.isNotNull
import assertk.fail
import kotlinx.coroutines.test.runTest
import me.kpavlov.langfuse.spring.LangfuseClient
import me.kpavlov.langfuse.spring.awaitPromptGet
import me.kpavlov.langfuse.spring.awaitPromptsList
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
        val secretKey = TestEnvironment["LANGFUSE_SECRET_KEY"]
        val publicKey = TestEnvironment["LANGFUSE_PUBLIC_KEY"]
        if (secretKey == null || publicKey == null) {
            fail("LANGFUSE_SECRET_KEY and LANGFUSE_PUBLIC_KEY must be set")
        }
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
                    .projectsApi
                    .projectsGet()
                    .block()

            assertThat(projects).isNotNull()
            projects?.let {
                assertThat(it.data).isNotEmpty()
                println("projects = ${it.data}")
            }
        }

    @Test
    @Disabled("Not implemented yet")
    fun `Should call DatasetItemsApi`() =
        runTest(timeout = 5.seconds) {
            val datasetItems =
                langfuseClient
                    .datasetItemsApi
                    .datasetItemsList(TODO(), TODO(), TODO(), TODO(), TODO())
                    .block()

            assertThat(datasetItems).isNotNull()
            datasetItems?.let {
                assertThat(it.data).isNotNull()
                println("datasetItems = ${it.data}")
            }
        }

    @Test
    @Disabled("Not implemented yet")
    fun `Should call DatasetRunItemsApi`() =
        runTest(timeout = 5.seconds) {
            val datasetRunItems =
                langfuseClient
                    .datasetRunItemsApi
                    .datasetRunItemsCreate(TODO())
                    .block()

            assertThat(datasetRunItems).isNotNull()
        }

    @Test
    @Disabled("Not implemented yet")
    fun `Should call DatasetsApi`() =
        runTest(timeout = 5.seconds) {
            val datasets =
                langfuseClient
                    .datasetsApi
                    .datasetsList(TODO(), TODO())
                    .block()

            assertThat(datasets).isNotNull()
            datasets?.let {
                assertThat(it.data).isNotNull()
                println("datasets = ${it.data}")
            }
        }

    @Test
    fun `Should call HealthApi`() =
        runTest(timeout = 5.seconds) {
            val health =
                langfuseClient
                    .healthApi
                    .healthHealth()
                    .block()

            assertThat(health).isNotNull()
            health?.let {
                assertThat(it.status).isNotEmpty()
                println("health = ${it.status}")
            }
        }

    @Test
    @Disabled("Not implemented yet")
    fun `Should call IngestionApi`() =
        runTest(timeout = 5.seconds) {
            val ingestion =
                langfuseClient
                    .ingestionApi
                    .ingestionBatch(TODO())
                    .block()

            assertThat(ingestion).isNotNull()
            ingestion?.let {
                assertThat(it.successes).isNotEmpty()
                println("successes = ${it.successes}")
            }
        }

    @Test
    @Disabled("Not implemented yet")
    fun `Should call MetricsApi`() =
        runTest(timeout = 5.seconds) {
            val metrics =
                langfuseClient
                    .metricsApi
                    .metricsDaily(TODO(), TODO(), TODO(), TODO(), TODO(), TODO(), TODO())
                    .block()

            assertThat(metrics).isNotNull()
            metrics?.let {
                assertThat(it.data).isNotNull()
                println("metrics = ${it.data}")
            }
        }

    @Test
    @Disabled("Not implemented yet")
    fun `Should call ModelsApi`() =
        runTest(timeout = 5.seconds) {
            val models =
                langfuseClient
                    .modelsApi
                    .modelsList(TODO(), TODO())
                    .block()

            assertThat(models).isNotNull()
            models?.let {
                assertThat(it.data).isNotEmpty()
                println("models = ${it.data}")
            }
        }

    @Test
    @Disabled("Not implemented yet")
    fun `Should call ObservationsApi`() =
        runTest(timeout = 5.seconds) {
            val observations =
                langfuseClient
                    .observationsApi
                    .observationsGetMany(
                        TODO(),
                        TODO(),
                        TODO(),
                        TODO(),
                        TODO(),
                        TODO(),
                        TODO(),
                        TODO(),
                        TODO(),
                        TODO(),
                    ).block()

            assertThat(observations).isNotNull()
            observations?.let {
                assertThat(it.data).isNotNull()
                println("observations = ${it.data}")
            }
        }

    @Test
    fun `Should call PromptsApi`() =
        runTest(timeout = 1500.seconds) {
            val prompts =
                langfuseClient
                    .promptsApi
                    .awaitPromptsList()

            assertThat(prompts).isNotNull()
            prompts.let {
                assertThat(it.data, "data").isNotEmpty()
                println("prompts = ${it.data}")
            }

            val promptListItem = prompts.data[0]

            val prompt =
                langfuseClient.promptsApi.awaitPromptGet(
                    promptName = promptListItem.name,
                )
            assertThat(prompt).isNotNull()
            assertThat(prompt.toString()).doesNotContain("You are")
            assertThat(prompt.toString()).contains("[REDACTED]")
        }

    @Test
    @Disabled("Not implemented yet")
    fun `Should call ScoreApi`() =
        runTest(timeout = 5.seconds) {
            val score =
                langfuseClient
                    .scoreApi
                    .scoreGet(
                        TODO(),
                        TODO(),
                        TODO(),
                        TODO(),
                        TODO(),
                        TODO(),
                        TODO(),
                        TODO(),
                        TODO(),
                        TODO(),
                        TODO(),
                        TODO(),
                        TODO(),
                        TODO(),
                    ).block()

            assertThat(score).isNotNull()
            score?.let {
                assertThat(it.data).isNotNull()
                println("score = ${it.data}")
            }
        }

    @Test
    fun `Should call ScoreConfigsApi`() =
        runTest(timeout = 5.seconds) {
            val scoreConfigs =
                langfuseClient
                    .scoreConfigsApi
                    .scoreConfigsGet(1, 100)
                    .block()

            assertThat(scoreConfigs).isNotNull()
            scoreConfigs?.let {
                assertThat(it.data).isNotNull()
                println("scoreConfigs = ${it.data}")
            }
        }

    @Test
    @Disabled("Not implemented yet")
    fun `Should call SessionsApi`() =
        runTest(timeout = 5.seconds) {
            val sessions =
                langfuseClient
                    .sessionsApi
                    .sessionsList(TODO(), TODO(), TODO(), TODO())
                    .block()

            assertThat(sessions).isNotNull()
            sessions?.let {
                assertThat(it.data).isNotNull()
                println("sessions = ${it.data}")
            }
        }

    @Test
    @Disabled("Not implemented yet")
    fun `Should call TraceApi`() =
        runTest(timeout = 5.seconds) {
            val trace =
                langfuseClient
                    .traceApi
                    .traceList(
                        TODO(),
                        TODO(),
                        TODO(),
                        TODO(),
                        TODO(),
                        TODO(),
                        TODO(),
                        TODO(),
                        TODO(),
                        TODO(),
                        TODO(),
                    ).block()

            assertThat(trace).isNotNull()
            trace?.let {
                assertThat(it.data).isNotNull()
                println("trace = ${it.data}")
            }
        }

    @Test
    @Disabled("fix handling empty responses")
    fun `Should call CommentsApi`() =
        runTest(timeout = 5.seconds) {
            val comments =
                langfuseClient
                    .commentsApi
                    .commentsGet(TODO(), TODO(), TODO(), TODO(), TODO())

            assertThat(comments).isNotNull()
        }
}
