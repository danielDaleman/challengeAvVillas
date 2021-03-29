# challengeAvVillas

[![CircleCI](https://circleci.com/gh/danielDaleman/challengeAvVillas.svg?style=svg&circle-token=2ed89382eeacbfba9bfa3d961b18d7682f0590d9)](https://circleci.com/gh/danielDaleman/challengeAvVillas)
======

Es un API RestFul el cual se encarga de:
1. Validar si dos palabras contienen la misma longitud y letras entre si.
2. Validar si dos frases entre si, tienen palabras que contengan las mismas letras(Igual al caso 1), valida cuantas y cuales.
3. Valida si tres frases entre si, tienen palabras que contengan las mismas letras(Igual al caso 1 y 2), valida cuantas y cuales. Además cuenta con la siguientes operaciones: Cargar frases, Consultar frases y Eliminar frases

### Tecnologías usadas
- Java 11
- Spring Boot
- Maven
- Heroku
- H2 DataBase
- Swagger
- Lombok
- Mockito
- CircleCI

## Instalación y ejecución
**Pre requisitos**:
- Contar con:
  - JDK 11.0
  - Maven 3.6.3
  - Git
  - SpringToolsSuit4

**Paso 0**

Abrir una terminal en el equipo

**Paso 1**

Clonar el repositorio
```
git clone https://github.com/danielDaleman/challengeAvVillas
```

**Paso 2**

Mantenerse en la consola dónde fue clonado el repositorio y ubicarse en la raiz del mismo.

**Paso 3**

Ejecutar el siguente comando para descargar las dependencias y ver que no exista ningun problema.
```
mvn clean install
```
**Paso4**

Para correr el aplicativo ejecute el siguente comando
```
java -jar target/challengeAvVillas-0.0.1-SNAPSHOT.jar
```
**Nota:** 
*Asegurese de contar con la versión java y maven correcta*

**Configurar proyecto en SpringToolsSuit4**

**Paso1**

Abrir Spring Tools Suit 4

**Paso2**

En la parte izquierda seleccione la opción "import projects"
![image](https://user-images.githubusercontent.com/32171194/112774332-fdf3a380-8ffe-11eb-976b-9e0ecb93e0bc.png)

**Paso3**

Filtrar por maven y seleccionar la opción "Existing Maven Projects"
![image](https://user-images.githubusercontent.com/32171194/112774377-1c599f00-8fff-11eb-83ba-9c5ead36ac34.png)

**Paso4**

Buscar proyecto dónde se haya clonado con anterioridad y seleccionar finish
![image](https://user-images.githubusercontent.com/32171194/112774434-457a2f80-8fff-11eb-8aed-b8ed8930d3c4.png)


**Paso5**

Espere que el proyecto cargue. Una vez cargado, sobre el proyecto raiz de click derecho -> run As -> Spring Boot App 
![image](https://user-images.githubusercontent.com/32171194/112774528-9ab64100-8fff-11eb-96c6-be2547fa87e5.png)

**Paso6**

El proyecto se ejecutara
![image](https://user-images.githubusercontent.com/32171194/112774599-d2bd8400-8fff-11eb-913f-7f74ce9009a3.png)

# Consumo de API

Existe una configuración en postman, el cual le permitira realizar el consumo más facil, en el siguiente archivo: [archivo](https://github.com/danielDaleman/challengeAvVillas/tree/master/src/main/resources/postman).

**Nota:** 
*El proyecto viene configurado con la url de heroku [https://challengeavvillas.herokuapp.com/](), si desea usar la versión local basta con cambiarla por [http://localhost:8081/]()*

## Servidor de despliegue

El proyecto cuenta con integración continua con CircleCI, por lo que el despliegue al servidor es automatico, una vez se suban cambios al repositorio y los test se ejecuten correctamente.

El proyecto se encuentra desplegado en HEROKU, el cual responde en [https://challengeavvillas.herokuapp.com/]().

## Documentación de Servicios:
**Nota:** 
*El proyecto cuenta con documentación de los servicios, generada por SWAGGER. Para más detalle consulte la siguente url [https://challengeavvillas.herokuapp.com/swagger-ui/index.html#/]()*

| Servicio | Tipo | Descripción |
|--|--|--|
| /validateWords | POST | Realiza la validación de las dos palabras (Nivel 1) |
| /validateSentences | POST | Compara dos frases y retorna true/false, según el caso y el contador de las repeticiones (Nivel 2) |
| /validateSentencesPersistent | POST | Cargar frase para evaluar (Nivel 3) |
| /validateSentencesPersistent/deleteAll | DELETE | Elimina todos los mensajes registrados en el sistema (Nivel 3)|
| /validateSentencesPersistent/findAll | GET | Consulta todos los mensajes registrados en el sistema (Nivel 3)|
| /validateSentencesPersistent/validate | GET | Calcula las coincidencias de las frases cargadas en BD (Nivel 3)|

**Nota:** 
*El aplicativo cuenta con una tabla MESSAGE para persistir la información en la base de datos H2*





