package me.kpavlov.langfuse.client.native

private val env = System.getenv()

/**
 * LangfuseClient is a client library for interacting with the Langfuse API. It provides various APIs
 * for accessing and managing resources within the Langfuse platform.
 *
 * @constructor primary constructor, accepts secretKey, publicKey, and host with default values from system properties
 * @property secretKey the secret key used for authentication
 * @property publicKey the public key used for authentication
 * @property host the host URL of the Langfuse API
 */
@Suppress(
    "RedundantVisibilityModifier",
    "TooManyFunctions",
    "UnusedPrivateProperty",
)
public open class LangfuseClient(
    private val secretKey: String = env["LANGFUSE_SECRET_KEY"] ?: TODO(),
    private val publicKey: String? = env["LANGFUSE_PUBLIC_KEY"] ?: TODO(),
    val host: String = env["LANGFUSE_HOST"] ?: "https://cloud.langfuse.com",
) {
//    constructor(secretKey: String, publicKey: String) : this(
//        secretKey = secretKey,
//        publicKey = publicKey,
//        host = "https://cloud.langfuse.com",
//    )
//
//    protected open fun prepareClient(
//        webClientBuilder: WebClient.Builder = WebClient.builder(),
//    ): WebClient =
//        webClientBuilder
//            .baseUrl(host)
//            .defaultHeaders { headers ->
//                headers.setBasicAuth(publicKey, secretKey)
//                headers.set("User-Agent", "me.kpavlov.langfuse-jvm.spring/$VERSION")
//            }.build()

//    /**
//     * Provides a client for accessing project-related endpoints.
//     *
//     * @return an instance of ProjectsApi configured with the client's WebClient
//     */
//    public open fun projectsApi(): ProjectsApi = ProjectsApi(prepareClient())
//
//    /**
//     * Provides a client for accessing comment-related endpoints.
//     *
//     * @return an instance of CommentsApi configured with the client's WebClient.
//     */
//    public open fun commentsApi(): CommentsApi = CommentsApi(prepareClient())
//
//    /**
//     * Provides a client for accessing dataset items-related endpoints.
//     *
//     * @return an instance of DatasetItemsApi configured with the client's WebClient.
//     */
//    public open fun datasetItemsApi(): DatasetItemsApi = DatasetItemsApi(prepareClient())
//
//    /**
//     * Provides a client for accessing dataset run items-related endpoints.
//     *
//     * @return an instance of DatasetRunItemsApi configured with the client's WebClient.
//     */
//    public open fun datasetRunItemsApi(): DatasetRunItemsApi = DatasetRunItemsApi(prepareClient())
//
//    /**
//     * Provides a client for accessing dataset-related endpoints.
//     *
//     * @return an instance of DatasetsApi configured with the client's WebClient.
//     */
//    public open fun datasetsApi(): DatasetsApi = DatasetsApi(prepareClient())
//
//    /**
//     * Provides a client for accessing health-related endpoints.
//     *
//     * @return an instance of HealthApi configured with the client's WebClient.
//     */
//    public open fun healthApi(): HealthApi = HealthApi(prepareClient())
//
//    /**
//     * Provides a client for accessing ingestion-related endpoints.
//     *
//     * @return an instance of IngestionApi configured with the client's WebClient.
//     */
//    public open fun ingestionApi(): IngestionApi = IngestionApi(prepareClient())
//
//    /**
//     * Provides a client for accessing metrics-related endpoints.
//     *
//     * @return an instance of MetricsApi configured with the client's WebClient.
//     */
//    public open fun metricsApi(): MetricsApi = MetricsApi(prepareClient())
//
//    /**
//     * Provides a client for accessing model-related endpoints.
//     *
//     * @return an instance of ModelsApi configured with the client's WebClient.
//     */
//    public open fun modelsApi(): ModelsApi = ModelsApi(prepareClient())
//
//    /**
//     * Provides a client for accessing observation-related endpoints.
//     *
//     * @return an instance of ObservationsApi configured with the client's WebClient.
//     */
//    public open fun observationsApi(): ObservationsApi = ObservationsApi(prepareClient())
//
//    /**
//     * Provides a client for accessing prompt-related endpoints.
//     *
//     * @return an instance of PromptsApi configured with the client's WebClient.
//     */
//    public open fun promptsApi(): PromptsApi = PromptsApi(prepareClient())
//
//    /**
//     * Provides a client for accessing score-related endpoints.
//     *
//     * @return an instance of ScoreApi configured with the client's WebClient
//     */
//    public open fun scoreApi(): ScoreApi = ScoreApi(prepareClient())
//
//    /**
//     * Provides a client for accessing score configuration-related endpoints.
//     *
//     * @return an instance of ScoreConfigsApi configured with the client's WebClient.
//     */
//    public open fun scoreConfigsApi(): ScoreConfigsApi = ScoreConfigsApi(prepareClient())
//
//    /**
//     * Provides a client for accessing session-related endpoints.
//     *
//     * @return an instance of SessionsApi configured with the client's WebClient.
//     */
//    public open fun sessionsApi(): SessionsApi = SessionsApi(prepareClient())
//
//    /**
//     * Provides a client for accessing trace-related endpoints.
//     *
//     * @return an instance of TraceApi configured with the client's WebClient
//     */
//    public open fun traceApi(): TraceApi = TraceApi(prepareClient())
}
