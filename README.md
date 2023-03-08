# currency-conversion-service

### Please update below db config details to run service [application.properties]
  - spring.datasource.url=DB_URL_WITH_PORT_AND_DB_NAME [e.g. jdbc:mysql://DB_HOSTNAME:DB_PORT/DB_NAME]
  - spring.datasource.username=USERNAME
  - spring.datasource.password=PASSWORD

### To run the application
  - Clone the project from repository
  - Import project as existing maven project into your IDE & wait for IDE to install all maven dependencies
  - Make the DB config changes in application.properties file located under resources folder
  - Run CurrencyConversionServiceApplication.java as java application to start the application [Refer to steps for deployment of spring boot application on different servers: https://spring.io/blog/2014/03/07/deploying-spring-boot-applications]
  - 
### Open API - Swagger 
- Swagger Url=SERVICE_URL_WITH_PORT/swagger-ui/index.html [e.g. http://localhost:8080/swagger-ui/index.html]