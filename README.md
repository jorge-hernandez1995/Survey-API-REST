# Survey API - RobinFood

API REST Desarrollada en SpringBoot para prueba técnica de RobinFood. Desarrollada por Jorge Luis Hernández Castaño

## Comenzando 🚀

A continuación se presentan las instrucciones para ejecutar el API:

Clona la aplicación con el siguiente enlace https://github.com/jorge-hernandez1995/Survey-API-REST.git

Mira *Source* para encontrar las fuentes asociadas al desarrollo.

### Pre-requisitos 📋

Estos son los componentes necesarios para la ejecución de la API:

*Java 8 
*MongoDB instalado


### Instalación 🔧

En la raíz del proyecto, donde se encuentra el POM, debes abrir una ventanda CMD y ejecutar el siguiente comando para descargar las dependencias necesarias:

- mvn clean install

A continuación, debes garantizar que tengas la base de datos MongoDB disponible para establecer conexiones en el puerto 27017 (Puerto por defecto).

Luego, debes iniciar la aplicación de Springboot desde el IDE de tu preferencia.

El contenedor de Spring estará ejecutando el API en localhost:8080

## Ejecutando las pruebas ⚙️

Para ejecutar pruebas sobre el API se debe usar cualquier programa para ejecución de peticiones (Postman, SoapUI, API Tester, etc.)

El API tiene implementado los siguientes servicios:

**1 - CREAR NUEVA ENCUESTA:**

Para crear una nueva encuesta debes consumir un servicio POST con el siguiente ENDPOINT y "Body" JSON:

ENDPOINT: 
http://localhost:8080/addSurvey

En el siguiente JSON Body, hay un formato de encuesta de 5 preguntas, en donde se puede cambiar el campo "question" por la pregunta que se le quiera formular al cliente y guardar en la BD:

JSON Body:

    {
    	"questions": [
    	{
    		"questionOptions": {
            
    			"question":"<<Digita aquí la pregunta 1>>",
    			"optionA": false,
            	"optionB": false,
            	"optionC": false,
            	"optionD": false
    		}
    		
    	},
    	{
    		"questionOptions": {
    			"question":"<<Digita aquí la pregunta 2>>",
    			"optionA": false,
            	"optionB": false,
            	"optionC": false,
            	"optionD": false
    		}
    		
    	},
    	{
    		"questionOptions": {
    			"question":"<<Digita aquí la pregunta 3>>",
    			"optionA": false,
            	"optionB": false,
            	"optionC": false,
            	"optionD": false
    		}
    	},
    	{
    		"questionOptions": {
    			"question":"<<Digita aquí la pregunta 4>>",
    			"optionA": false,
            	"optionB": false,
            	"optionC": false,
            	"optionD": false
    		}
    	},
    	{
    		"questionOptions": {
    			"question":"<<Digita aquí la pregunta 5>>",
    			"optionA": false,
            	"optionB": false,
            	"optionC": false,
            	"optionD": false
    		}
    	}	
    	]
    }

Si se quieren generar encuestas de menos o más preguntas, se pueden agregar o remover mas objetos de tipo "questionOptions".

Cada objeto de tipo "questionOptions" tiene opción múltiple en donde están definidos valores booleanos para guardar cada una de las respuestas.

Al ejecutar el anterior método POST, debe retornar el siguiete mensaje:

- "Survey saved successfully. Id Generated: 60b0f8635932407a4648eb45"

En el anterior caso de ejemplo, se generó el ID **60b0f8635932407a4648eb45** el cual es el identificador de la encuesta, que posteriormente se va a utilizar para filtrar la encuesta buscando por ID. 


**2 - LISTAR ENCUESTA POR ID**

Para encontrar una encuesta por un ID ya generado, se debe consumir un servicio GET con el siguiente ENDPOINT:

- http://localhost:8080/findSurvey/{id}

Siguiendo el ejemplo anterior, al consumir el servicio con el siguiente enlace: http://localhost:8080/findSurvey/60b0f8635932407a4648eb45 se obtiene como respuesta el siguiente JSON:

    {
        "userId": "60b0f8635932407a4648eb45",
        "questions": [
            {
                "questionOptions": {
                    "question": "<<Digita aquí la pregunta 1>>",
                    "optionA": false,
                    "optionB": false,
                    "optionC": false,
                    "optionD": false
                }
            },
            {
                "questionOptions": {
                    "question": "<<Digita aquí la pregunta 2>>",
                    "optionA": false,
                    "optionB": false,
                    "optionC": false,
                    "optionD": false
                }
            },
            {
                "questionOptions": {
                    "question": "<<Digita aquí la pregunta 3>>",
                    "optionA": false,
                    "optionB": false,
                    "optionC": false,
                    "optionD": false
                }
            },
            {
                "questionOptions": {
                    "question": "<<Digita aquí la pregunta 4>>",
                    "optionA": false,
                    "optionB": false,
                    "optionC": false,
                    "optionD": false
                }
            },
            {
                "questionOptions": {
                    "question": "<<Digita aquí la pregunta 5>>",
                    "optionA": false,
                    "optionB": false,
                    "optionC": false,
                    "optionD": false
                }
            }
        ]
    }

**3 - LISTAR TODAS LAS ENCUESTAS**

Para obtener todas las encuestas generadas, se debe consumir un servicio GET con el siguiente ENDPOINT:

- http://localhost:8080/findAllSurveys

**4 - EJECUCIÓN PRUEBAS UNITARIAS**

En la ruta del proyecto **src/test/java**, se econtrará en el paquete **com.robinfood.survey.api.controller** la clase *SurveyControllerTest* en la cual están los Test de cada uno de los métodos del controlador.

## Construido con 🛠️

* [SpringBoot](https://spring.io/projects/spring-boot) - Java Framework
* [Maven](https://maven.apache.org/) - Dependencias
* [MongoDB](https://www.mongodb.com/es) - Base de datos 

## Autores ✒️


* *Jorge Luis Hernández Castaño* - Desarrollo 

---
