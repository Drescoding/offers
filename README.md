# offers


Assumptions:


## How to run: 

```sh 
$ mvn clean install
```

```sh
$ mvn spring-boot:run -Dspring.profiles.active=localhost
```


### From POSTMAN: 

Add or update a product:
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



![postman](./screenshot1.png?raw=true "Postman")

Retrieving the new product: 

GET Request to http://localhost:8080/product/1

##To do:
-[ ] Not null not working - validation of request/response + tests
-[ ] Add screenshots to README


Open the H2 console by typing in http://localhost:8080/h2-console in the browser address bar.
change the Database URL to jdbc:h2:mem:testdb in the login screen as this is the default URL configured by Spring Boot.

