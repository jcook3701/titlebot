# Base Image
FROM ubuntu:18.04

# Sets the sh defualt shell to bash
SHELL ["/bin/bash", "-c"]

# Create dir app
RUN mkdir /app

# Set the working directory to /app
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY . /app

# Update and Upgrade
RUN apt-get update && apt-get upgrade -y && apt-get install -y wget openjdk-11-jre
RUN apt-get install apt-transport-https curl gnupg -yqq

RUN echo "deb https://repo.scala-sbt.org/scalasbt/debian all main" | tee /etc/apt/sources.list.d/sbt.list && \
    echo "deb https://repo.scala-sbt.org/scalasbt/debian /" | tee /etc/apt/sources.list.d/sbt_old.list && \
    curl -sL "https://keyserver.ubuntu.com/pks/lookup?op=get&search=0x2EE0EA64E40A89B84B2DF73499E82A75642AC823" | gpg --no-default-keyring --keyring gnupg-ring:/etc/apt/trusted.gpg.d/scalasbt-release.gpg --import && \
    chmod 644 /etc/apt/trusted.gpg.d/scalasbt-release.gpg && \
    apt-get update && \
    apt-get install sbt -y


EXPOSE 9000

# Start command
# ENTRYPOINT ["bash"]
CMD sbt compile run
