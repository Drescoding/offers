# Offers


## Assumptions:
- If you want to manually cancel an offer, you want to delete it from the database.
- Simplificaton: I'm using a embedded database so the data is only kept when the application is running. For a production application, this will need to be changed.
- The merchand provides an expiry date. The date is entered in that format: dd/MM/yyyy

## To do/ If I had more time:
- [X] Not null not working - validation of request/response + tests
- [X] Add screenshots to README
- [X] Add the automatic expiration
- [X] Preload database with example products
- [X] Finish BDD + document it
- [ ] Change from date to # of days
- [ ] Edge cases
- [ ] Cancellation/Delete? Remove assumption there? 
- [ ] Delete by name rather than ID

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
     
  If you leave the ID black, it takes the next available number (autogenerated). If you use an existing ID, it'll update the record. 
  
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

### Retrieving the product by its ID: 

GET Request to http://localhost:8080/product/id

![postman](./show1Product.png?raw=true "Postman")

### Retrieving the product(s) by its name:

GET Request to http://localhost:8080/productByName/name

![postman](./screenshotProductName.png?raw=true "Postman")

### Show all products: 

GET Request to http://localhost:8080/products/

![postman](./showAllProducts.png?raw=true "Postman")

### Delete product: 

DELETE Request to http://localhost:8080/product/id

![postman](./screenshotDelete.png?raw=true "Postman")


### How to run the database: 
Open the H2 console by typing in http://localhost:8080/h2-console in the browser address bar.
Change the Database URL to jdbc:h2:mem:testdb in the login screen as this is the default URL configured by Spring Boot.

### Run tests
```jshelllanguage
mvn test
```
If you run the Cucumber separately, the application should be running locally. 
