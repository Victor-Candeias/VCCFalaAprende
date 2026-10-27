#!/usr/bin/env bash
set -euo pipefail
VERSION="8.10.2"
DIR="/opt/gradle"
mkdir -p "$DIR"
if [ ! -x "$DIR/gradle-$VERSION/bin/gradle" ]; then
  curl -fL --retry 3 "https://services.gradle.org/distributions/gradle-$VERSION-bin.zip" -o /tmp/gradle.zip
  unzip -q /tmp/gradle.zip -d "$DIR"
  rm -f /tmp/gradle.zip
fi
export PATH="$DIR/gradle-$VERSION/bin:$PATH"
gradle wrapper --gradle-version "$VERSION" --distribution-type bin
chmod +x gradlew
echo "Gradle Wrapper gerado."
