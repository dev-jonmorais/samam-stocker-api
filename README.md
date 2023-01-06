
# SAM STOCKER API

Sam Stocker API é uma simples api baseada no projeto samam-stocker (sisteminha para gerenciar estoques).

## Get All Customers

### Request

`GET /customers/`

curl -i -H 'Accept: application/json' http://localhost:8080/customers/

## Get One Customer

### Request

`GET /customers/{id}`

curl -i -H 'Accept: application/json' http://localhost:8080/customers/{id}/
