# Langfuse-JVM 🪢☕️

JVM clients for [Langfuse](https://api.reference.langfuse.com)

[![Kotlin CI with Maven](https://github.com/kpavlov/langfuse-jvm/actions/workflows/maven.yml/badge.svg?branch=main)](https://github.com/kpavlov/langfuse-jvm/actions/workflows/maven.yml)
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/b213cf0965cb47dba3bdd67e3b463e08)](https://app.codacy.com/gh/kpavlov/langfuse-jvm/dashboard?utm_source=gh&utm_medium=referral&utm_content=&utm_campaign=Badge_grade)
[![Codacy Coverage](https://app.codacy.com/project/badge/Coverage/b213cf0965cb47dba3bdd67e3b463e08)](https://app.codacy.com/gh/kpavlov/langfuse-jvm/dashboard?utm_source=gh&utm_medium=referral&utm_content=&utm_campaign=Badge_coverage)
[![Api Docs](https://img.shields.io/badge/api-docs-blue)](https://kpavlov.github.io/langfuse-jvm/api/)
[![ktlint](https://img.shields.io/badge/ktlint%20code--style-%E2%9D%A4-FF4081)](https://pinterest.github.io/ktlint/)

# Overview

Project provides various JVM clients for Langfuse

Clients are generated from Langfuse [OpenAPI specification](https://api.reference.langfuse.com).

- [Spring Client](https://kpavlov.github.io/langfuse-jvm/api/root/me.kpavlov.langfuse.spring/-langfuse-client/) built on top of [Webclient](https://docs.spring.io/spring-framework/reference/web/webflux-webclient.html).

## How to run

Create `.env` file in root directory and add your API keys:

```dotenv
LANGFUSE_SECRET_KEY="sk-lf-..."
LANGFUSE_PUBLIC_KEY="pk-lf-..."
LANGFUSE_HOST="https://cloud.langfuse.com" # 🇪🇺 EU region
# LANGFUSE_HOST="https://us.cloud.langfuse.com" # 🇺🇸 US region
```

Building project locally:

```shell
mvn clean verify
```

or

```shell
make build
```

