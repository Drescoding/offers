# offers


Assumptions:
- If you want to manually cancel an offer, you want to delete it from the database.
- Simplificaton: I'm using a embedded database so the data is only kept when the application is running. For a production application, this will need to be changed.
- The date is entered in that format: dd/MM/yyyy


## How to run: 

```sh 
$ mvn clean install
```

```sh
$ mvn spring-boot:run -Dspring.profiles.active=localhost
```


### Add or update a product: 

From POSTMAN:
   POST request to http://localhost:8080/addProduct
    Header:
     Key: Content-Type 
     Value: application/json
     
   Body: 

   ```json
{
	"id": 1,
	"name": "dress",
	"currency": "EUR",
	"price": 20,
	"description": "Brand new red dress",
	"expiryDate": "11/20/2019",
	"valid": true
}
   ```



![postman](./screenshotAddModify.png?raw=true "Postman")

###Retrieving the product by its ID: 

GET Request to http://localhost:8080/product/id

![postman](./show1Product.png?raw=true "Postman")

###Retrieving the product(s) by its name:

GET Request to http://localhost:8080/productByName/name

![postman](./screenshotProductName.png?raw=true "Postman")

###Show all products: 

GET Request to http://localhost:8080/products/

![postman](./showAllProducts.png?raw=true "Postman")

###Delete product: 

DELETE Request to http://localhost:8080/product/id

![postman](./screenshotDelete.png?raw=true "Postman")



##To do:
-[ ] Not null not working - validation of request/response + tests
-[X] Add screenshots to README
-[ ] Add the automatic expiration/ Change from date to # of days
-[ ] Preload database with example products
-[ ] Edge cases
-[ ] Cancellation/Delete? Remove assumption there? 




Open the H2 console by typing in http://localhost:8080/h2-console in the browser address bar.
change the Database URL to jdbc:h2:mem:testdb in the login screen as this is the default URL configured by Spring Boot.

