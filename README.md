# appstore
Applications store demo
To correct run this application you need:
*Java 8
*free port 8090
*MySQL 8.0 or higher
Spring Boot 2.5.5

Appstore has the following endpoinds:

- Save application:
To save application you need to send POST request with JSON message: 
  name (String, must be in the range 4 to 128), 
  version (String)
  content rate (int, must be one of the following : 3, 7, 12, 16, 18)
Example:
{
    "name" : "testApp",
    "version" : "1.0",
    "contentRate" : "3"
}
In response, save method will send a JSON message with saved object and it's id:
{
    "id": 7,
    "name": "testApp",
    "version": "1.0",
    "contentRate": 3
}

- Get application by id:
To get application by id you need to send GET method with id (int parameter) by the next link:
http://localhost:8090/api/applications/{id}
In response will you get a JSON message with object or with notFound message.

- Delete application by id:
To delete application by id you need to send DELETE method with id (int parameter) by the next link:
http://localhost:8090/api/applications/{id}
In response will you get a JSON message with deleted object id.

- Get all application:
To all applications you need to send GET method by the next link:
http://localhost:8090/api/applications/
In response will you get a JSON array message with all the objects in the database

- Compare application by vesion (e.g. 2.2.0 is greater than 1.6.8):
To compare applications by vesrion you need to send GET method with id through whom (1,4,5) by the next link:
http://localhost:8090/api/appCompare/{applicationsIds}
In response will you get a JSON message with the object that have greater version.
Example: 
http://localhost:8090/api/appCompare/1,2
{
    "id": 2,
    "name": "TestApp2",
    "version": "2.5.9",
    "contentRate": 16
}

- Get count of application by content rate:
To all applications you need to send GET method with content rate by the next link:
http://localhost:8090/api/countByContentRate/{contentRate}
In response will you get a JSON message with count of objects with this content rate.
Example:
http://localhost:8090/api/applications/countByContentRate/16
7

