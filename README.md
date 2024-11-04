# Langfuse-JVM 🪢☕️
JVM clients for [Langfuse](https://api.reference.langfuse.com)

[![Kotlin CI with Maven](https://github.com/kpavlov/langfuse-jvm/actions/workflows/maven.yml/badge.svg?branch=main)](https://github.com/kpavlov/langfuse-jvm/actions/workflows/maven.yml)
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/4da0f1abf0fd49038bb29676b6d38579)](https://app.codacy.com/gh/kpavlov/langfuse-jvm/dashboard?utm_source=gh&utm_medium=referral&utm_content=&utm_campaign=Badge_grade)
[![Codacy Coverage](https://app.codacy.com/project/badge/Coverage/4da0f1abf0fd49038bb29676b6d38579)](https://app.codacy.com/gh/kpavlov/langfuse-jvm/dashboard?utm_source=gh&utm_medium=referral&utm_content=&utm_campaign=Badge_coverage)

# Overview

Project provides various JVM clients for Langfuse

- Clients are generated from Langfuse [OpenAPI specification](https://api.reference.langfuse.com).

## How to run

Create `.env` file in root directory and add your API keys:

```dotenv
OPENAI_API_KEY=sk-xxxxx
```

Building project locally:
```shell
mvn clean verify
```
or
```shell
make build
```

