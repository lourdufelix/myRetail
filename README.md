# myRetail
sample demo project

### Requirements
* Java 1.8
* mongodb
  - if you're using Mac, ```brew install mongodb``` should install the tool
  - if you run `mongod`, it starts the DB at port 27017
  - if you're trying to test this in a different machine/OS, try to follow internet to install the DB

### Critical end points
This is written with the assumption that the application is running on localhost
* http://localhost:8080/products/{id} => passing the ID in `GET` fetches the item details from local mongo db
* http://localhost:8080/products/{id} => passing the ID in `PUT` method with a body similar to previous `GET`(without product name) lets the user change the price.

### Sample product IDs
* 13860428, 15117729, 16483589, 16696652, 16752456, 15643793
* 13860428 => this is the only valid product available in external redsky system, as of now. 
