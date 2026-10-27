FROM mcr.microsoft.com/devcontainers/base:debian-12

ARG DEBIAN_FRONTEND=noninteractive
RUN apt-get update && apt-get install -y --no-install-recommends \
    openjdk-17-jdk-headless curl wget unzip zip git ca-certificates \
    libstdc++6 libgcc-s1 libz1 libncurses6 && \
    rm -rf /var/lib/apt/lists/*

ENV JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
ENV ANDROID_HOME=/opt/android-sdk
ENV ANDROID_SDK_ROOT=/opt/android-sdk
ENV PATH="/opt/android-sdk/cmdline-tools/latest/bin:/opt/android-sdk/platform-tools:${PATH}"
RUN mkdir -p /opt/android-sdk && chown -R vscode:vscode /opt/android-sdk
