This file contains the work that I have done..

1. Created spring boot application
2. Created entities with the help of chatgpt
3. Entity relationships are clear
4. Added h2 database
5. created schema using few properties
	spring.jpa.properties.jakarta.persistence.schema-generation.scripts.action=create
	spring.jpa.properties.jakarta.persistence.schema-generation.scripts.create-target=create.sql
	spring.jpa.properties.jakarta.persistence.schema-generation.scripts.create-source=metadata
6. Added flyway migration dependency
7. commented above properties and created migration file under db/migration folder. need to follow specific syntax. Use below property in application.properties file

	<Prefix><numberr>__<desc>.sql  for example **V1__init.sql**	
	spring.flyway.locations=classpath:db/migration
	
8. db scripts got executed successfully
9. added h2 database, and scripts got executed successfully, added below properties.

	spring.datasource.url=jdbc:h2:mem:test_db
	spring.datasource.username=sa
	spring.datasource.password=
	spring.datasource.driverClassName=org.h2.Driver
	
	spring.h2.console.enabled=true   #http://localhost:8080/h2-console/
10. Swagger api --opendocs api specification
	followed this tutorial : https://springdoc.org/v2/
	just added 2 dependencies and it worked, below are the dependencies
	
	<dependency>
	        <groupId>org.springframework.boot</groupId>
	        <artifactId>spring-boot-starter-validation</artifactId>
	    </dependency>
	    <dependency>
	        <groupId>org.springdoc</groupId>
	        <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
	        <version>2.0.2</version>
	    </dependency>
	    
	did a bit research, springfox not yet supported spring-boot version 3.0. so not used spring-fox

11. Added JPA Repositories
12. Created user controller and wrote Junit tests to test them