# API back-votos

Projeto Spring que abre uma sessão de votação em uma pauta e contabilizar os votos e dar o resultado da votação na pauta.

## Requisitos

* JDK 8
* PostgreSQL 12

## Heroku

Link para testar a api
https://tr-back-votos.herokuapp.com/back-votos/swagger-ui.html

## Bibliotecas Utilizadas

* modelmapper
* flyway
* swagger2
* spring validation

## Integração com sistemas externos

Com o 4Devs para validar o cpf

## API

### Cadastra uma pauta

Request

`POST /back-votos/pautas`

    curl -i -H 'Accept: application/json' http://localhost:8090/back-votos/pautas
    

### Realiza um voto em uma pauta

Request

`POST /back-votos/votos`

    curl -i -H 'Accept: application/json' http://localhost:8090/back-votos/votos
    
### Contabilizar os votos e dar o resultado da votação na pauta.

Request

`GET /votos/resultado/pauta/{id}`

    curl -i -H 'Accept: application/json' back-votos/votos/resultado/pauta/{id}
