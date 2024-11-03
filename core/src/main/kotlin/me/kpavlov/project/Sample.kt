package me.kpavlov.project

import kotlinx.coroutines.coroutineScope

class Sample {
    /**
     * Returns a greeting message.
     *
     * @return A string containing the greeting message "Hi".
     */
    fun sayHi(): String = "Hi"

    /**
     * Asynchronously obtains a response from the provided supplier function.
     *
     * @param supplier A lambda function that supplies a string.
     * @return The string response provided by the supplier.
     */
    suspend fun getResponseAsync(supplier: () -> String): String =
        coroutineScope { supplier.invoke() }
}
