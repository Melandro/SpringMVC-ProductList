# Spring MVC - Product List Demo Application

This demo is intented to show the backend and frontend implementation for a simple product requirement. 
From the home page, the user is ale to see a list of product, create a new one, edit or delete a selected product.
This demo also allow a user to search a product by price higher than a value.

- Rest Controller

The @RestController annotation is used to define RESTful web services. 
It serves JSON, XML, and custom response.

- Request Mapping

The @RequestMapping annotation is used to define the Request URI to access
the REST Endpoints. We can define Request method to consume and produce 
objects. The default request method is GET.

- Request Body

The @RequestBody annotation is used to define the request body content type.
 
- Path Variable

The @PathVariable annotation is used to define a custom or dynamic request 
URI.


# GET API
The default HTTP request method is GET. This method does not require any 
Request Body. You can send request parameters and path variables to define
the custom or dynamic URL.

# POST API
The HTTP POST request is used to create a resource. This method contains the 
Request Body.

# PUT API
The HTTP PUT request is used to update the existing resource. This method 
contains a Request Body. We can send request parameters and path variables 
to define the custom or dynamic URL.

## 
This is a Maven project and therefore in order to package the library 
you will need to run the command: 

- `mvn clean package`

This command will create an executable JAR file, which can be used later 
to run the application. 
You can run this demo application by executing the following command:

- `mvn spring-boot:run`

Which will deploy the application in Maven's internal Server Application; then
you can use an external applicaion like Postman to make API's calls.
