# Performance Testing

The current and chosen framework for doing performance testing on the permissions service is [gatling](https://gatling.io/).

## Running

### Locally

This will take the set URL in the [gatling.conf](src/gatling/resources/conf/gatling.conf)

`./gradlew gatlingRun`

### CLI

Passing in different URL

`./gradlew gatlingRun -Dgatling.test.baseUrl=www.myurl.com`

Passing in different simulation args

`./gradlew gatlingRun -Dusers=5 -Dramp=5`