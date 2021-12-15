# **Microservice-Tutoring-Service**

API REST en Spring del microservicio de tutorias.

## Como utilizar
"Los endpoints se pueden ver claramente con el **SWAGGER** en la direccion http://localhost:8080/swagger-ui.html#/"

La API se consume por varios EndPoints:

### Temas que se incluyen en la tutoria

**Modelo de tema**

```json
Tema{
id	integer($int32)
name	string
}
```

**Buscar tema**

POST: http://localhost:8080/tutoriaServicio/tema/busquedaNombre/{nombre}

```json
{
  "nombre": "string"
}
```

**Guardar tema**

POST: http://localhost:8080/tutoriaServicio/tema/save

```json
{
  "id": 0,
  "name": "string"
}
```

**Editar tema**

PUT: http://localhost:8080/tutoriaServicio/tema

```json
{
  "id": 0,
  "name": "string"
}

```

**Eliminar tema**

DELETE: http://localhost:8080/tutoriaServicio/tema/delete/{id}/{nombre}

```json
{
  "id": 0,
  "nombre": "string"
}

```
**Listar todos los temas**

GET: http://localhost:8080/tutoriaServicio/tema/list

No parameters

**Buscar tutoria por nombre**

GET: http://localhost:8080/tutoriaServicio/tutoria/busquedaNombre/{nombre}

```json
{
  "name": "string"
}

```

### Categoria que se incluyen en la tutoria

**Modelo de Categoria**

```json
Categoria{
  "id": 0,
  "name": "string"
}

```

**Guardar Categoria**

POST: http://localhost:8080/tutoriaServicio/categoria/save

```json
{
  "id": 0,
  "name": "string"
}

```

**Editar Categoria**

PUT: http://localhost:8080/tutoriaServicio/categoria

```json
{
  "id": 0,
  "name": "string"
}

```

**Eliminar Categoria**

DELETE: http://localhost:8080/tutoriaServicio/categoria/delete/{id}/{nombre}

```json
{
  "id": 0,
  "name": "string"
}
```

**Listar todos los Categoria**

GET: http://localhost:8080/tutoriaServicio/categoria/list

No parameters

**Buscar Categoria por nombre**

GET: http://localhost:8080/tutoriaServicio/categoria/busquedaNombre/{nombre}

```json
{
  "name": "string"
}
```

### Tutoria

**Modelo de Tutoria**

```json
Tutoria{
{
  "category": {
    "id": 0,
    "name": "string"
  },
  "dateEnd": "2021-12-12T06:38:37.929Z",
  "dateStrat": "2021-12-12T06:38:37.929Z",
  "description": "string",
  "id": 0,
  "reason": "string",
  "state": true,
  "userCreator": {
    "address": "string",
    "age": "string",
    "apiToken": "string",
    "code": 0,
    "email": "string",
    "lastName": "string",
    "name": "string",
    "phone": "string",
    "role": "string",
    "semester": "string",
    "studentEmail": "string",
    "universityCareer": "string"
  },
  "userTutor": {
    "address": "string",
    "age": "string",
    "apiToken": "string",
    "code": 0,
    "email": "string",
    "lastName": "string",
    "name": "string",
    "phone": "string",
    "role": "string",
    "semester": "string",
    "studentEmail": "string",
    "universityCareer": "string"
  }
}
}

```

**Guardar Tutoria**

POST: http://localhost:8080/tutoriaServicio/tutoria/save

Header
```header
    Authorization: "string"
```
```json
{
  "dateEnd": "2021-12-15T03:35:52.761Z",
  "dateStrat": "2021-12-15T03:35:52.761Z",
  "description": "string",
  "id": 0,
  "idcategory": 0,
  "lissubjets": [
    0
  ],
  "reason": "string",
  "state": true,
  "userCreator": 0,
  "userTutor": 0
}
```
**Inscribirse a Tutoria**

GET: http://localhost:8080/tutoriaServicio/tutoria/inscribirse/{id}/{idusuario}

id -> id de la tutoria,

idusuario -> id del usuario
 
Header
```header
    Authorization: "string"
```
```json

```


**Editar Tutoria**

PUT: http://localhost:8080/tutoriaServicio/tutoria

```json
{
  "category": {
    "id": 0,
    "name": "string"
  },
  "dateEnd": "2021-12-15T03:34:55.427Z",
  "dateStart": "2021-12-15T03:34:55.427Z",
  "description": "string",
  "id": 0,
  "reason": "string",
  "state": true,
  "subjectList": [
    {
      "id": 0,
      "name": "string"
    }
  ],
  "userCreator": {
    "address": "string",
    "age": "string",
    "apiToken": "string",
    "code": 0,
    "email": "string",
    "lastName": "string",
    "name": "string",
    "phone": "string",
    "role": "string",
    "semester": "string",
    "studentEmail": "string",
    "universityCareer": "string"
  },
  "userList": [
    {
      "address": "string",
      "age": "string",
      "apiToken": "string",
      "code": 0,
      "email": "string",
      "lastName": "string",
      "name": "string",
      "phone": "string",
      "role": "string",
      "semester": "string",
      "studentEmail": "string",
      "universityCareer": "string"
    }
  ],
  "userTutor": {
    "address": "string",
    "age": "string",
    "apiToken": "string",
    "code": 0,
    "email": "string",
    "lastName": "string",
    "name": "string",
    "phone": "string",
    "role": "string",
    "semester": "string",
    "studentEmail": "string",
    "universityCareer": "string"
  }
}
```

**Eliminar Tutoria**

DELETE: http://localhost:8080/tutoriaServicio/tutoria/delete/{id}/{nombre}

```json
Sin datos

```
**Listar todos los Tutoria**

GET: http://localhost:8080/tutoriaServicio/tutoria/list

No parameters

**Listar Tutorias false**

GET: /tutoriaServicio/tutoria/list/terminadas

No parameters

**Listar Tutorias true**

GET: http://localhost:8080/tutoriaServicio/tutoria/list/activas

No parameters

**Buscar Tutoria por nombre**

GET: http://localhost:8080/tutoriaServicio/tutoria/busquedaNombre/{nombre}

```json
{
  
}
```

**Terminar Tutoria**

GET: http://localhost:8080/tutoriaServicio/tutoria/delete/{id}/{nombre}

```json
{
  
}
```

### Rol

**Guardar Rol**

GET: http://localhost:8080/usuario/{id}/rol/{rol}

Header

    Authorization: "String"

```json
{
  
}
```

### Notificaciones

**Listar Notificaciones**

GET: http://localhost:8080/tutoriaServicio/tutoria/notificacionesall

Header

    Authorization: "String"

```json
{
  
}
```

**Listar Notificacion**

GET: http://localhost:8080/tutoriaServicio/tutoria/notificacion/{nombre}

Header

    Authorization: "String"

```json
{
  
}
```

Para mayor información se puede observar la documentación con [swagger](https://swagger.io/) con (GET /swagger-ui.html).

Para el front, hay una implementación en el siguiente [link]().

## Demo

Actualmente la API se encuentra en una instancia de [EC2](https://aws.amazon.com/es/ec2/?ec2-whats-new.sort-by=item.additionalFields.postDateTime&ec2-whats-new.sort-order=desc), accediendo al [link de swagger](http://34.199.225.252:8080/swagger-ui.html#/) se puede ver la documentación de la api.

## Contribuidores

- [@S8Vega](https://github.com/S8Vega)
- [@coltdeus](https://github.com/coltdeus)
- [@nicolaspa1](https://github.com/nicolaspa1)
- [@kevinjimenez0119](https://github.com/Kevinjimenez0119)

## **Licencia**

[MIT](https://choosealicense.com/licenses/mit/)