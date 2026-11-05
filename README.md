# sample-sb-2-7-with-oauth-sso

Shows the logged-in user's name.

## Stack

- Spring Boot 2.7.18
- Java 17
- Gradle 8.4

## Build

```
./gradlew build
```

## Run

```
./gradlew bootRun
```

Create a GitHub OAuth app with the callback URL `http://localhost:8080/login/oauth2/code/github`, then set `OAUTH_CLIENT_ID` and `OAUTH_CLIENT_SECRET`.

Open http://localhost:8080/user and sign in.
