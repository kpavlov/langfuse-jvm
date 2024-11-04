package me.kpavlov.langfuse.spring

import org.springframework.util.SystemPropertyUtils
import org.springframework.web.reactive.function.client.WebClient


public open class LangfuseClient(
    private val secretKey: String = SystemPropertyUtils.resolvePlaceholders("\${LANGFUSE_SECRET_KEY}"),
    private val publicKey: String = SystemPropertyUtils.resolvePlaceholders("\${LANGFUSE_PUBLIC_KEY}"),
    val host: String = SystemPropertyUtils.resolvePlaceholders("\${LANGFUSE_HOST}"),
) {

    protected open fun prepareClient(webClientBuilder: WebClient.Builder) : WebClient {
        return webClientBuilder
            .defaultHeaders { headers -> headers.setBasicAuth(publicKey, secretKey) }
            .build()
    }

    public open fun projectsApi(webClientBuilder: WebClient.Builder = WebClient.builder()) : ProjectsApi {
        return ProjectsApi(prepareClient(webClientBuilder))
    }
}
