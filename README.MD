# **Microservice-Tutoring-Service**

API REST en Spring del microservicio de tutorias.

## Como utilizar

La API tiene varios end points:

### Temas que se incluyen en la tutoria

Modelo de tema

```json
Tema{
id	integer($int32)
name	string
}
```

Guardar tema

POST: http://localhost:8080/temas/save

```json
{
  "id": 0,
  "name": "string"
}

```

Editar tema

PUT: http://localhost:8080/temas

```json
{
  "id": 0,
  "name": "string"
}

```

Eliminar tema

DELETE: http://localhost:8080/temas/tema/{id}/{nombre}

```json
{
  "id": 0,
  "name": "string"
}

```
Listar todos los temas

GET: http://localhost:8080/temas/listar

No parameters

Buscar tutoria por nombre

GET: http://localhost:8080/temas/busquedaNombre/{nombre}

```json
{
  "name": "string"
}

```

Para mayor información se puede observar la documentación con [swagger](https://swagger.io/) con (GET /swagger-ui.html).

Para el front, hay una implementación en el siguiente [link]().

## Demo

Actualmente la API se encuentra en una instancia de [EC2](https://aws.amazon.com/es/ec2/?ec2-whats-new.sort-by=item.additionalFields.postDateTime&ec2-whats-new.sort-order=desc), accediendo al [link de swagger]() se puede ver la documentación de la api.

## Contribuidores

- [@S8Vega](https://github.com/S8Vega)
- [@coltdeus](https://github.com/coltdeus)
- [@nicolaspa1](https://github.com/nicolaspa1)
- [@kevinjimenez0119](https://github.com/Kevinjimenez0119)

## **Licencia**

[MIT](https://choosealicense.com/licenses/mit/)