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

    fun env(
        name: String,
        defaultValue: String? = null,
    ): String? =
        if (defaultValue != null) {
            dotenv.get(name, defaultValue)
        } else {
            dotenv[name]
        }
}
