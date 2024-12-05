package me.kpavlov.langfuse.spring

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import me.kpavlov.langfuse.ApiClient
import org.slf4j.LoggerFactory
import org.springframework.util.SystemPropertyUtils
import org.springframework.web.reactive.function.client.WebClient

private val appVersion: String =
    LangfuseClient::class.java.getPackage().implementationVersion ?: "development"

fun configureObjectMapper(mapper: ObjectMapper) {
    mapper
        .findAndRegisterModules()
        .enable(JsonParser.Feature.USE_FAST_DOUBLE_PARSER)
        .enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)
        .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
}

/**
 * LangfuseClient is a client library for interacting with the Langfuse API. It provides various APIs
 * for accessing and managing resources within the Langfuse platform.
 *
 * @constructor primary constructor, accepts secretKey, publicKey, and host with default values from system properties
 * @property secretKey the secret key used for authentication
 * @property publicKey the public key used for authentication
 * @property host the host URL of the Langfuse API
 */
@Suppress("RedundantVisibilityModifier", "TooManyFunctions")
public open class LangfuseClient(
    private val secretKey: String =
        SystemPropertyUtils.resolvePlaceholders(
            "\${LANGFUSE_SECRET_KEY}",
        ),
    private val publicKey: String =
        SystemPropertyUtils.resolvePlaceholders(
            "\${LANGFUSE_PUBLIC_KEY}",
        ),
    private val host: String =
        SystemPropertyUtils.resolvePlaceholders(
            "\${LANGFUSE_HOST}",
        ),
) {
    private val logger = LoggerFactory.getLogger(javaClass)

    constructor(secretKey: String, publicKey: String) : this(
        secretKey = secretKey,
        publicKey = publicKey,
        host = "https://cloud.langfuse.com",
    )

    private fun prepareClient(
        webClientBuilder: WebClient.Builder = WebClient.builder(),
    ): ApiClient {
        val apiClient =
            ApiClient(
                webClientBuilder
                    .defaultHeaders { headers ->
                        headers.setBasicAuth(publicKey, secretKey)
                        headers.set("User-Agent", "me.kpavlov.langfuse-jvm.spring/$appVersion")
                    }.build(),
            )
        apiClient.basePath = host
        configureObjectMapper(apiClient.objectMapper)

        logger.info("Initialized LangFuse client with host: {}", host)

        return apiClient
    }

    private val client: ApiClient = prepareClient()

    /**
     * Provides an instance of `ProjectsApi` for accessing project-related API operations.
     *
     * This property is lazily initialized using the `client` instance, enabling interaction with
     * project entities, such as retrieving or managing projects associated with the API key.
     *
     * The `ProjectsApi` is part of the Langfuse client infrastructure, which facilitates communication
     * with a specific set of services or endpoints related to project management.
     */
    public open val projectsApi: ProjectsApi by lazy {
        ProjectsApi(client)
    }

    /**
     * Provides access to the API methods related to comments.
     * Initialized lazily using the prepared [ApiClient] instance.
     */
    public open val commentsApi: CommentsApi by lazy {
        CommentsApi(client)
    }

    /**
     * Provides an instance of the `DatasetItemsApi` for interacting with dataset items within the Langfuse system.
     * Initialized lazily using an `ApiClient` to facilitate API operations related to dataset items.
     * Part of the `LangfuseClient` which serves as a comprehensive client for engaging with various Langfuse APIs.
     */
    public open val datasetItemsApi: DatasetItemsApi by lazy {
        DatasetItemsApi(client)
    }

    /**
     * Provides access to the DatasetRunItemsApi instance for managing dataset run items.
     * It is initialized lazily using the provided client, ensuring that the API client
     * is ready for interaction when needed.
     */
    public open val datasetRunItemsApi: DatasetRunItemsApi by lazy {
        DatasetRunItemsApi(client)
    }

    /**
     * Provides access to the Datasets API, enabling operations related to datasets.
     *
     * The `datasetsApi` is initialized lazily and utilizes an instance of `ApiClient`
     * for executing requests. This configuration ensures the API client is set up
     * with appropriate authentication and headers.
     *
     * Part of the `LangfuseClient` structure, it is responsible for managing dataset-related
     * functionalities such as creation, retrieval, updating, and deletion of datasets.
     */
    public open val datasetsApi: DatasetsApi by lazy {
        DatasetsApi(client)
    }

    /**
     * Provides an instance of the HealthApi interface for checking the health of the API and database.
     *
     * The HealthApi allows you to interact with health-check endpoints, ensuring that the API and
     * associated database are operational and responding as expected.
     *
     * This property is lazily instantiated using the ApiClient configured for the system, which
     * means it will be initialized once upon first access and reused thereafter.
     *
     * The health checks typically cover a variety of response status codes, indicating the state
     * of the API:
     * - 200: Successful response, API and database are up and running.
     * - 400, 401, 403, 404, 405, 503: Various error states indicating issues with API access,
     *   authorization, unavailability, or misconfiguration.
     *
     * Usage of this API generally involves calling its health-check methods to ensure system
     * robustness before performing more critical operations.
     */
    public open val healthApi: HealthApi by lazy {
        HealthApi(client)
    }

    /**
     * Provides access to the Ingestion API for handling data ingestions through the client.
     * This property is lazily initialized and uses the provided client instance from the enclosing
     * LangfuseClient class to create an IngestionApi object. It is intended to be used for
     * making calls to the underlying data ingestion functionalities offered by the API.
     */
    public open val ingestionApi: IngestionApi by lazy {
        IngestionApi(client)
    }

    /**
     * Provides access to the Metrics API through the `MetricsApi` class.
     * This property is lazily initialized using the client configured in the `LangfuseClient`.
     * It facilitates interactions with the metrics functionality of the API.
     */
    public open val metricsApi: MetricsApi by lazy {
        MetricsApi(client)
    }

    /**
     * Provides access to the Models API, which is responsible for managing operations
     * related to models within the LangfuseClient.
     * It is initialized lazily with an instance of `ModelsApi`, utilizing the client configured for API communication.
     */
    public open val modelsApi: ModelsApi by lazy {
        ModelsApi(client)
    }

    /**
     * Provides access to operations related to observations within the API.
     * This is lazily initialized and uses the provided [client] to perform its operations.
     * The [ObservationsApi] is responsible for handling all interactions related to observations.
     */
    public open val observationsApi: ObservationsApi by lazy {
        ObservationsApi(client)
    }

    /**
     * Provides access to the Prompts API for interacting with prompt-related operations.
     * Initialized lazily with an instance of `PromptsApi` using the configured `ApiClient`.
     * Used within the `LangfuseClient` for managing prompt data.
     */
    public open val promptsApi: PromptsApi by lazy {
        PromptsApi(client)
    }

    /**
     * Provides access to the `ScoreApi` for interacting with scoring-related operations.
     * The `scoreApi` is initialized lazily and is configured using the `ApiClient` instance.
     *
     * This property is part of the `LangfuseClient` class and interfaces with the scoring service.
     */
    public open val scoreApi: ScoreApi by lazy {
        ScoreApi(client)
    }

    /**
     * Provides access to score configuration-related operations through the ScoreConfigsApi.
     * This property is initialized lazily and utilizes the underlying HTTP client.
     * It's part of the LangfuseClient, which serves as a client interface to interact with various
     * APIs, including score configurations, within the application.
     */
    public open val scoreConfigsApi: ScoreConfigsApi by lazy {
        ScoreConfigsApi(client)
    }

    /**
     * Provides access to the Sessions API, enabling the management and retrieval of session-related data.
     * This property is initialized lazily upon first access using the provided ApiClient instance.
     */
    public open val sessionsApi: SessionsApi by lazy {
        SessionsApi(client)
    }

    /**
     * Provides access to the Trace API operations using the configured API client.
     *
     * This property is lazily initialized and uses the central API client for setting
     * up communication with the Trace API endpoints. Once accessed, it allows for
     * interacting with trace-related functionalities of the system.
     *
     * @property traceApi Lazy-initialized property that provides an instance of
     * TraceApi, responsible for handling trace operations via the configured client instance.
     */
    public open val traceApi: TraceApi by lazy {
        TraceApi(client)
    }
}
