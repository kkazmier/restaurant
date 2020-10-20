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
##### Ingredients
###### Get all exist ingredients
`GET /v1/ingredient/all`
###### Get all 'free' ingredients (not depend to dish)
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
##### Dishes
###### Get all dishes
`GET /v1/dish/all`
###### Request a single dish
`GET /v1/dish/get/{id}`
dish id required
###### Create dish
`POST /v1/dish/create`
dish body required
###### Add ingredient to dish
`POST /v1/dish/addIngredient/{id}`
dish id and ingredient body required
###### Add ingredient to dish
`PUT /v1/dish/addIngredient/{ingredientId}/toDish/{dishId}`
dish id and ingredient id required
###### Remove ingredient from dish
`PUT /v1/dish/addIngredient/removeIngredient/{ingredientId}/fromDish/{dishId}`
dish id and ingredient id required
###### Remove dish
`DELETE /v1/dish/delete/{id}`
dish id required
##### Orders
###### Get all orders
`GET /v1/tableOrder/all`
###### Get order
`GET /v1/tableOrder/get/{id}`
order id required
###### Get orders belongs to employee
`GET /v1/tableOrder/getAllByEmp/{id}`
employee id required
###### Get dishes belongs to order
`GET /v1/tableOrder/getDishes/{id}`
order id required
###### Create order
`POST /v1/tableOrder/create`
order body required
###### Update order
`POST /v1/tableOrder/update`
order body required
###### Add dish to order
`POST /v1/tableOrder/addDish/{id}`
order id and dish body required
###### Add dish to order
`POST /v1/tableOrder/addDish/{dishId}/toTableOrder/{orderId}`
order id and dish id required
###### Remove dish from order
`POST /v1/tableOrder/removeDish/{dishId}/fromTableOrder/{orderId}`
order id and dish id required
###### Change order status to close
`PUT /v1/tableOrder/close/{id}`
order id required
##### Employees
###### Get all employees
`GET /v1/employee/all`
###### Get employee
`GET /v1/employee/get/{id}`
employee id required
###### Get employee
`GET /v1/employee/getEmployeeByPIN/{pin}`
PIN required
###### Get PIN belong to employee
`GET /v1/employee/getPIN/{empId}`
employee id required
###### Create employee
`POST /v1/employee/create`
employee body required
###### Update employee
`PUT /v1/employee/update`
employee body required
###### Create order
`PUT /v1/employee/createTableOrder/{empId}`
employee id and order body required
###### Remove order from employee
`PUT /v1/employee/deleteTableOrder/{orderId}/fromEmployee/{empId}`
employee id and order id required
###### Set PIN
`PUT /v1/employee/setPIN/{pin}/employee/{empId}`
employee id and PIN value required
##### Reports
###### Get summary orders cost
`GET /v1/report/summaryOrdersCostFrom/{begin}/to/{end}`
begin and end date-time required
