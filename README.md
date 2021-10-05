# Test 2
## Explanation
User must login and attain "accessToken" before proceeding to CRUD api.
"accessToken" is required in the request header

### Useful curl
- Login
  ```
  curl --location --request POST 'http://localhost:8080/api/auth/login' \
  --header 'Content-Type: application/json' \
  --header 'Cookie: JSESSIONID=4CF4D4C25F7F367DAF874EAB1213C9E2' \
  --data-raw '{
  "userName": "myname2",
  "password": "password"
  }'
  ```
- Create
  ```
  curl --location --request POST 'http://localhost:8080/api/customer' \
  --header 'Content-Type: application/json' \
  --header 'Cookie: JSESSIONID=4CF4D4C25F7F367DAF874EAB1213C9E2' \
  --data-raw '{
  "id": 2,
  "name": "myname2",
  "phone": "0123456789"
  }'
  ```
- Retrieve
  ```
  curl --location --request GET 'http://localhost:8080/api/customer' \
  --header 'accessToken: a8a7f69a-cb47-4901-90e4-d4ff514162d4' \
  --header 'Content-Type: application/json' \
  --header 'Cookie: JSESSIONID=4CF4D4C25F7F367DAF874EAB1213C9E2' \
  --data-raw '{
  "name": "myname",
  "phone": "0132234"
  }'
  ```
- Update
  ```
  curl --location --request PUT 'http://localhost:8080/api/customer' \
  --header 'accessToken: a8a7f69a-cb47-4901-90e4-d4ff514162d4' \
  --header 'Content-Type: application/json' \
  --header 'Cookie: JSESSIONID=4CF4D4C25F7F367DAF874EAB1213C9E2' \
  --data-raw '{
  "name": "myname",
  "phone": "0132234536"
  }'
  ```
- Delete
  ```
  curl --location --request DELETE 'http://localhost:8080/api/customer' \
  --header 'accessToken: a8a7f69a-cb47-4901-90e4-d4ff514162d4' \
  --header 'Cookie: JSESSIONID=4CF4D4C25F7F367DAF874EAB1213C9E2'
  ```
  
****Note
mock user data for login is created in flyway V2.*