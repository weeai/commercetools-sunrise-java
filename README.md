Sunrise Java :sunrise:
==============

[![Build Status](https://travis-ci.org/commercetools/commercetools-sunrise-java.png?branch=master)](https://travis-ci.org/commercetools/commercetools-sunrise-java) [![Stories in Ready](https://badge.waffle.io/commercetools/commercetools-sunrise-java.png?label=ready&title=Ready)](https://waffle.io/commercetools/commercetools-sunrise-java)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.commercetools.sunrise/commercetools-sunrise_2.11/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.commercetools.sunrise/commercetools-sunrise_2.11)

The next generation shop template.

* Demo: https://sunrise.commercetools.com
* [Documentation](manual/)
* [Javadoc](https://commercetools.github.io/commercetools-sunrise-java/javadoc/index.html)

## Preconditions

* install [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* install [SBT](http://www.scala-sbt.org/release/docs/Setup.html), Mac/Linux users can use the SBT script in the base folder (use `./sbt` instead of `sbt` in commands)

## Run it locally

* on Linux/Mac: `./activator ~run` 
* on Windows: `activator ~run`

The output will be like

```
[info] play - Listening for HTTP on /0:0:0:0:0:0:0:0:9000
(Server started, use Ctrl+D to stop and go back to the console...)
```

* open <a href="http://localhost:9000">http://localhost:9000</a> in your browser and set the commercetools platform project credentials

## Integration tests against commercetools platform

* Setup your environment variables (use a test project), so you need not to put your shop credentials under version control:

```bash
export SUNRISE_IT_CTP_PROJECT_KEY="your-CTP-project-key"
export SUNRISE_IT_CTP_CLIENT_SECRET="your-CTP-client-secret"
export SUNRISE_IT_CTP_CLIENT_ID="your-CTP-client-id"
```
* `sbt it:test`

## Deployment

For an easy and fast deployment of your application we recommend [heroku](https://www.heroku.com):

<a href="https://heroku.com/deploy?template=https://github.com/commercetools/commercetools-sunrise-java/tree/v0.6.0"><img src="https://www.herokucdn.com/deploy/button.png" alt="Deploy"></a>

## Docker

[![Docker build](http://dockeri.co/image/sphereio/sunrise)](https://registry.hub.docker.com/u/sphereio/sunrise/)

You can also use a ready-to-run docker container.

```bash
$ docker run -it --rm -p 9000:9000 -e CTP_PROJECT_KEY=YOUR_PROJECT_KEY -e CTP_CLIENT_ID=YOUR_CLIENT_ID -e CTP_CLIENT_SECRET=YOUR_CLIENT_SECRET -e APPLICATION_SECRET=YOUR_PLAY_APPLICATION_SECRET sphereio/sunrise
```

## Related projects

* Theme (layout and design sources): https://github.com/commercetools/commercetools-sunrise-theme
* Data: https://github.com/commercetools/commercetools-sunrise-data
* commercetools JVM SDK: https://github.com/commercetools/commercetools-jvm-sdk
