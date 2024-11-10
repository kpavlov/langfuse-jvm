package me.kpavlov.lanfguse.client.native

import assertk.fail
import me.kpavlov.langfuse.client.native.LangfuseClient
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

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
/*
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
    fun `Should call DatasetItemsApi`() =
        runTest(timeout = 5.seconds) {
            val datasetItems =
                langfuseClient
                    .datasetItemsApi()
                    .datasetItemsList()
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
                    .datasetRunItemsApi()
                    .datasetRunItemsCreate(TODO())
                    .block()

            assertThat(datasetRunItems).isNotNull()
        }

    @Test
    fun `Should call DatasetsApi`() =
        runTest(timeout = 5.seconds) {
            val datasets =
                langfuseClient
                    .datasetsApi()
                    .datasetsList()
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
                    .healthApi()
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
                    .ingestionApi()
                    .ingestionBatch(TODO())
                    .block()

            assertThat(ingestion).isNotNull()
            ingestion?.let {
                assertThat(it.successes).isNotEmpty()
                println("successes = ${it.successes}")
            }
        }

    @Test
    fun `Should call MetricsApi`() =
        runTest(timeout = 5.seconds) {
            val metrics =
                langfuseClient
                    .metricsApi()
                    .metricsDaily()
                    .block()

            assertThat(metrics).isNotNull()
            metrics?.let {
                assertThat(it.data).isNotNull()
                println("metrics = ${it.data}")
            }
        }

    @Test
    fun `Should call ModelsApi`() =
        runTest(timeout = 5.seconds) {
            val models =
                langfuseClient
                    .modelsApi()
                    .modelsList()
                    .block()

            assertThat(models).isNotNull()
            models?.let {
                assertThat(it.data).isNotEmpty()
                println("models = ${it.data}")
            }
        }

    @Test
    fun `Should call ObservationsApi`() =
        runTest(timeout = 5.seconds) {
            val observations =
                langfuseClient
                    .observationsApi()
                    .observationsGetMany()
                    .block()

            assertThat(observations).isNotNull()
            observations?.let {
                assertThat(it.data).isNotNull()
                println("observations = ${it.data}")
            }
        }

    @Test
    fun `Should call PromptsApi`() =
        runTest(timeout = 5.seconds) {
            val prompts =
                langfuseClient
                    .promptsApi()
                    .promptsList()
                    .block()

            assertThat(prompts).isNotNull()
            prompts?.let {
                assertThat(it.data).isNotNull()
                println("prompts = ${it.data}")
            }
        }

    @Test
    fun `Should call ScoreApi`() =
        runTest(timeout = 5.seconds) {
            val score =
                langfuseClient
                    .scoreApi()
                    .scoreGet()
                    .block()

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
                    .scoreConfigsApi()
                    .scoreConfigsGet()
                    .block()

            assertThat(scoreConfigs).isNotNull()
            scoreConfigs?.let {
                assertThat(it.data).isNotNull()
                println("scoreConfigs = ${it.data}")
            }
        }

    @Test
    fun `Should call SessionsApi`() =
        runTest(timeout = 5.seconds) {
            val sessions =
                langfuseClient
                    .sessionsApi()
                    .sessionsList()
                    .block()

            assertThat(sessions).isNotNull()
            sessions?.let {
                assertThat(it.data).isNotNull()
                println("sessions = ${it.data}")
            }
        }

    @Test
    fun `Should call TraceApi`() =
        runTest(timeout = 5.seconds) {
            val trace =
                langfuseClient
                    .traceApi()
                    .traceList()
                    .block()

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
                    .commentsApi()
                    .commentsGetRequestConfig()

            assertThat(comments).isNotNull()
        }
 */
}
