RAFAEL TORREGROSA DÍAZ

CLUB
Create
POST -> http://localhost:8081/club

RUNNER
Create (Una vez creado el club se le asocia)
POST -> http://localhost:8081/runner/{IdClub}

Read
GET -> http://localhost:8081/runner
GET -> http://localhost:8081/runner/{IdRunner}

Update
PUT -> http://localhost:8081/runner/{IdRunner}

Delete
DELETE -> http://localhost:8081/runner/{IdRunner}

RACING
Create
POST -> http://localhost:8081/racing
NOTA: A la hora de crear JSON, la fecha tiene este formato: "yyyy/mm/dd"

RESULT
Create (Una vez creado 'runner', que se pasa en el body y 'racing' que se para como parametro en la URL)
POST -> http://localhost:8081/result/{IdRacing}

Read
GET -> http://localhost:8081/result
GET -> http://localhost:8081/result/{IdResult}

Clasificación de una prueba por categorías (Escribe en el directorio raiz un fichero con la clasificación)
Para Master 20: En el parametro de year: 20.
Para Master 30: En el parametro de year: 30.
Para Master 40: En el parametro de year: 40.
GET -> http://localhost:8081/racing/runner/{IdRacing}?year=20

Clasificación de una prueba por Equipos asignandole puntos(Escribe en el directorio raiz un fichero con la clasificación)
NOTA: La ejecución de dicho algoritmo no es la esperada. No he conseguido agrupar los equipos por puntos.
En su lugar, he hecho una clasificación de la prueba por equipos sin llegar a sumar dichos puntos.

GET -> http://localhost:8081/racing?IdRacing=8
