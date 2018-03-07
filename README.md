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
* http://localhost:8080/products/{id} => passing the ID in `PUT` method with a body similar to previous `GET` lets the user update the details, such as product price, currency or name in local system.
* http://localhost:8080/products/store => accessing this `POST` method with json body as in method 1, either creates a new product locally or updates the details, if it is already present.
* http://localhost:8080/products/fulldetails/{id} => passing the product id in `GET` method, fetches the item details from external API and attaches the price details from local system and provides the details.

### Sample product IDs
* 15117729, 16483589, 16696652, 16752456, 15643793
