# spring-rest-api
A Spring based RESTful API for an inventory web service.
This project is a RESTful API for a web service that allows for CRUD operations on an inventory system. 
The two entities are Category and Product with a one-to-many relationship.

The Spring web service is coded in Java.

The stack used is as follows:

H2 (Database) - Model
Thymeleaf / HTML - View
Spring Boot (Java) - Controller

H2 is the default, commonly used Spring Boot db solution. Thymeleaf is similarly a frequently utilized front-end for Spring Boot. 
React, Angular etc can also be used. 
Spring Boot itself is a Java based web framework.

The project runs on local host port 8080. Deployment to Heroku is possible.

Endpoints:

/category/listCategory

/category/addCategoryPage

/category/updateCategoryPage

/category/delete/{id}

/product/listProduct

/product/addProductPage

/product/updateProductPage

/product/delete/{id}
