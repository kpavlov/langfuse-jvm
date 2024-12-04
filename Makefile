build:
	  mvn clean verify site

apidocs:
	  mvn  mvn clean compile site && \
  	mkdir -p target/docs && \
  	cp -R target/dokka target/docs/api

lint:prepare
	  ktlint '!**/target/**' && \
    mvn spotless:check

# https://docs.openrewrite.org/recipes/maven/bestpractices
format:prepare
	  ktlint --format '!**/target/**' && \
  	mvn spotless:apply && \
	  mvn -U org.openrewrite.maven:rewrite-maven-plugin:run \
				-Drewrite.activeRecipes=org.openrewrite.maven.BestPractices \
				-Drewrite.exportDatatables=true

prepare:
	  brew install ktlint --quiet

all: format lint build
