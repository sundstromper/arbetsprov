# Arbetsprov backend


Kör programmet
```shell script
./mvnw compile quarkus:dev
```

Rensa och bygg applikationen

```shell script
./mvnw clean package
```

Bygg en dockerimage

```shell script
docker build -f src/main/Docker/Dockerfile.jvm -t backend .
```

Starta dockerimagen

```shell script
docker run -i --rm -p 8080:8080 backend
```


Health check
```shell script
curl http://localhost:8080/q/health/live
```


open-api
```shell script
curl http://localhost:8080/q/openapi
```


# Arbetsprov gui

## Installera beroenden
```
npm install
```

### Startar en developmentserver
```
npm run serve
```

