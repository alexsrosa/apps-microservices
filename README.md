# apps-microservices


## Docker Compose

Para efetuar o build das aplicações, conforme detalhe incluído no dockerfile, criando novas imagens:

```
docker-compose build 
```

Rodar o conjunto de aplicações:

-d = Detached mode: Run containers in the background

```
docker-compose -d up
```

Baixar todas as aplicações:
```
docker-compose down
```

## Access link to consul
http://localhost:8500

## More information about API Rest
http://localhost:9090/api/cadastro-service/swagger-ui.html