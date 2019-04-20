# offers


Assumptions:

- The consumer's request includes the product name and its price. 
- Each product has a separate name

## How to run: 

```sh 
$ mvn clean install
```

```sh
$ mvn spring-boot:run -Dspring.profiles.active=localhost
```


### From POSTMAN: 

   POST request to http://localhost:8080/
    Header:
     Key: Content-Type 
     Value: application/json
     
   Body: 

   ```json
{
	"product": "test",
	"currency": "eur"
}
   ```

![postman](./screenshot.png?raw=true "Postman")

##To do:
-[ ] Not null not working - validation of request/response + tests
