#!/usr/bin/env bash
set -euo pipefail

export ANDROID_HOME="${ANDROID_HOME:-/opt/android-sdk}"
export ANDROID_SDK_ROOT="$ANDROID_HOME"
mkdir -p "$ANDROID_HOME/cmdline-tools"
if [ ! -x "$ANDROID_HOME/cmdline-tools/latest/bin/sdkmanager" ]; then
  echo "A instalar Android SDK Command-line Tools..."
  curl -fL --retry 3 -o /tmp/commandlinetools.zip \
    https://dl.google.com/android/repository/commandlinetools-linux-11076708_latest.zip
  mkdir -p /tmp/vcc-android-tools
  unzip -q /tmp/commandlinetools.zip -d /tmp/vcc-android-tools
  mv /tmp/vcc-android-tools/cmdline-tools "$ANDROID_HOME/cmdline-tools/latest"
  rm -rf /tmp/vcc-android-tools /tmp/commandlinetools.zip
fi
yes | sdkmanager --licenses >/dev/null || true
sdkmanager --install "platform-tools" "platforms;android-35" "build-tools;35.0.0"
echo "Android SDK pronto em $ANDROID_HOME"
if [ -f ./gradlew ]; then
  chmod +x ./gradlew
  echo "Gradle wrapper detetado. Executa: ./gradlew assembleDebug"
else
  echo "Ainda não existe gradlew. O projeto Android será inicializado no work item VCC-001."
fi
