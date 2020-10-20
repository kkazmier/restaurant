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
