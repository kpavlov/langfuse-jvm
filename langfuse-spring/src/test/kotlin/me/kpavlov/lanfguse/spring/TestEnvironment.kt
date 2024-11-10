package me.kpavlov.lanfguse.spring

import io.github.cdimascio.dotenv.dotenv
import java.nio.file.Paths

object TestEnvironment {
    private val dotenv =
        dotenv {
            this.ignoreIfMissing = true
            this.directory =
                Paths
                    .get("${System.getProperty("user.dir")}/..")
                    .normalize()
                    .toString()
            println("Loading .env file from $directory")
        }

    @Suppress("RedundantNullableReturnType")
    fun env(
        name: String,
        defaultValue: String? = null,
    ): String? {
        val systemEnv = System.getenv(name)
        if (systemEnv != null) {
            return systemEnv
        }
        return if (defaultValue != null) {
            dotenv.get(name, defaultValue)
        } else {
            dotenv[name]
        }
    }
}
