# Restaurant Application
Restaurant is a Spring Boot application that allows manage small gastronomic company. 
## Features
- Create, update and delete: 
  - ingredients
  - dishes
  - orders
  - employees
- Add/remove:
  - ingredients from dishes
  - dishes from orders
  - orders from employees
- Generate variety type of reports
- log into application throw PIN (unical for each employee)
### Endpoints
###### Get all exist ingredients
`GET /v1/ingredient/all`
##### Get all 'free' ingredients (not depend to dish)
`GET /v1/ingredient/notDependToDish`
###### Request a single ingredient
`GET /v1/ingredient/get/{id}`
ingredient id required
###### Create 'free' ingredient
`POST /v1/ingredient/create`
ingredient body required
###### Create ingredient depend to dish
`POST /v1/ingredient/create/{dish_id}`
ingredient body and dish id required
###### Update ingredient
`PUT /v1/ingredient/update`
ingredient body required
###### Remove ingredient
`DELETE /v1/ingredient/delete/{id}`
ingredient id required
###### Get all exist dishes
`GET /v1/dish/all`

