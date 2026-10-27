#!/bin/sh
# VCC Fala & Aprende: Gradle launcher for Codespaces.
# The standard Gradle wrapper JAR is generated using the installed Gradle distribution.
set -eu
ROOT="$(CDPATH= cd -- "$(dirname -- "$0")" && pwd)"
if [ -f "$ROOT/gradle/wrapper/gradle-wrapper.jar" ]; then
  exec java -classpath "$ROOT/gradle/wrapper/gradle-wrapper.jar" org.gradle.wrapper.GradleWrapperMain "$@"
fi
if command -v gradle >/dev/null 2>&1; then
  exec gradle "$@"
fi
echo "Gradle ainda não instalado. Executa: bash .devcontainer/install-gradle.sh" >&2
exit 1
