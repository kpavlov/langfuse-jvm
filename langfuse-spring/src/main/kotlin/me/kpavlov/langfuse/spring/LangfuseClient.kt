package me.kpavlov.langfuse.spring

import org.springframework.util.SystemPropertyUtils
import org.springframework.web.reactive.function.client.WebClient

private const val VERSION = "0.1.0"

/**
 * The `LangfuseClient` class is responsible for instantiating Langfuse API client.
 * It configurest authentication and provides access to Langfuse project-related functionalities.
 *
 * @constructor The primary constructor allows for specifying custom `secretKey`, `publicKey`, and `host`.
 *              Alternatively, default values will be used if the constructor is not provided with any arguments.
 *
 * @property secretKey The secret key for authenticating requests. Defaults to the `LANGFUSE_SECRET_KEY`
 *                      system property placeholder.
 * @property publicKey The public key for authenticating requests. Defaults to the `LANGFUSE_PUBLIC_KEY`
 *                      system property placeholder.
 * @property host The host URL for the Langfuse API. Defaults to the `LANGFUSE_HOST` system property placeholder.
 */
public open class LangfuseClient(
    private val secretKey: String =
        SystemPropertyUtils.resolvePlaceholders(
            "\${LANGFUSE_SECRET_KEY}",
        ),
    private val publicKey: String =
        SystemPropertyUtils.resolvePlaceholders(
            "\${LANGFUSE_PUBLIC_KEY}",
        ),
    val host: String =
        SystemPropertyUtils.resolvePlaceholders(
            "\${LANGFUSE_HOST}",
        ),
) {
    constructor(secretKey: String, publicKey: String) : this(
        secretKey = secretKey,
        publicKey = publicKey,
        host = "https://cloud.langfuse.com",
    )

    protected open fun prepareClient(
        webClientBuilder: WebClient.Builder = WebClient.builder(),
    ): WebClient =
        webClientBuilder
            .baseUrl(host)
            .defaultHeaders { headers ->
                headers.setBasicAuth(publicKey, secretKey)
                headers.set("User-Agent", "me.kpavlov.langfuse-jvm.spring/$VERSION")
            }.build()

    public open fun projectsApi(): ProjectsApi = ProjectsApi(prepareClient())

    public open fun commentsApi(): CommentsApi = CommentsApi(prepareClient())

    public open fun datasetItemsApi(): DatasetItemsApi = DatasetItemsApi(prepareClient())

    public open fun datasetRunItemsApi(): DatasetRunItemsApi = DatasetRunItemsApi(prepareClient())

    public open fun datasetsApi(): DatasetsApi = DatasetsApi(prepareClient())

    public open fun healthApi(): HealthApi = HealthApi(prepareClient())

    public open fun ingestionApi(): IngestionApi = IngestionApi(prepareClient())

    public open fun metricsApi(): MetricsApi = MetricsApi(prepareClient())

    public open fun modelsApi(): ModelsApi = ModelsApi(prepareClient())

    public open fun observationsApi(): ObservationsApi = ObservationsApi(prepareClient())

    public open fun promptsApi(): PromptsApi = PromptsApi(prepareClient())

    public open fun scoreApi(): ScoreApi = ScoreApi(prepareClient())

    public open fun scoreConfigsApi(): ScoreConfigsApi = ScoreConfigsApi(prepareClient())

    public open fun sessionsApi(): SessionsApi = SessionsApi(prepareClient())

    public open fun traceApi(): TraceApi = TraceApi(prepareClient())
}
