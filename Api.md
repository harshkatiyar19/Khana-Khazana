## Khana-Khazana REST API
Base URL: `/api`
Notes:
- Times use ISO-8601. For `LocalDateTime`: `YYYY-MM-DDThh:mm:ss`. For `LocalTime`: `hh:mm:ss`.
- Unless otherwise specified, responses return JSON representations of entities or lists.
- Error responses typically use HTTP 4xx/5xx with an error message body.
### Users
Base path: `/api/users`
1) Sign up new user
- Method: POST
- Path: `/api/users/v1/signup`
- Request body:
```json
{
  "name": "Aarav Sharma",
  "email": "aarav@example.com",
  "password": "P@ssw0rd!",
  "confirmPassword": "P@ssw0rd!",
  "phoneNumber": "+91-9876543210"
}
```
- Success response (201/200):
```json
{
  "userId": 10,
  "name": "Aarav Sharma",
  "email": "aarav@example.com",
  "phoneNumber": "+91-9876543210"
}
```
2) Sign in with phone
- Method: POST
- Path: `/api/users/v1/signin/phone-number`
- Request body:
```json
{
  "phone": "+91-9876543210",
  "password": "P@ssw0rd!"
}
```
- Success response (200):
```json
{
  "message": "Sign-in successful",
  "user": {
    "userId": 10,
    "name": "Aarav Sharma",
    "email": "aarav@example.com",
    "phoneNumber": "+91-9876543210"
  }
}
```
3) Sign in with email
- Method: POST
- Path: `/api/users/v1/signin/email`
- Request body:
```json
{
  "email": "aarav@example.com",
  "password": "P@ssw0rd!"
}
```
- Success response (200): same as phone sign-in.
4) Update user email
- Method: PATCH
- Path: `/api/users/v1/{id}/update/email`
- Path params: `id` (number)
- Request body:
```json
{
  "email": "new.email@example.com",
  "password": "currentPassword"
}
```
- Success response (200):
```json
{
  "message": "Email updated",
  "user": {
    "userId": 10,
    "name": "Aarav Sharma",
    "email": "new.email@example.com",
    "phoneNumber": "+91-9876543210"
  }
}
```
5) Update user phone
- Method: PATCH
- Path: `/api/users/v1/{id}/update/phone-number`
- Request body:
```json
{
  "phone": "+91-9999999999",
  "password": "currentPassword"
}
```
- Success response (200): similar to email update.
6) Delete user
- Method: DELETE
- Path: `/api/users/v1/{id}/delete`
- Query params: `password` (string)
- Success response (200):
```json
{ "message": "User deleted" }
```
### Restaurant
Base path: `/api/restaurant`
1) Create new restaurant
- Method: POST
- Path: `/api/restaurant/v1/new`
- Request body:
```json
{
  "name": "Spice Villa",
  "address": "123 Main Street, City",
  "cuisine": "Indian",
  "openTime": "10:00:00",
  "closeTime": "23:00:00"
}
```
- Success response (200):
```json
{
  "restId": 10,
  "name": "Spice Villa",
  "address": "123 Main Street, City",
  "cuisine": "Indian",
  "openTime": "10:00:00",
  "closeTime": "23:00:00",
  "numberOfTables": 0
}
```
2) Update restaurant address
- Method: PATCH
- Path: `/api/restaurant/v1/{id}/update/address`
- Query params: `newAddress` (string)
- Success response (200): updated restaurant JSON.
3) Update restaurant open time
- Method: PATCH
- Path: `/api/restaurant/v1/{id}/update/open-time`
- Query params: `newOpenTime` (LocalTime, e.g. `10:00:00`)
- Success response (200): updated restaurant JSON.
4) Update restaurant close time
- Method: PATCH
- Path: `/api/restaurant/v1/{id}/update/close-time`
- Query params: `newCloseTime` (LocalTime)
- Success response (200): updated restaurant JSON.
5) Update restaurant cuisine
- Method: PATCH
- Path: `/api/restaurant/v1/{id}/update/cuisine`
- Query params: `newCuisine` (string)
- Success response (200): updated restaurant JSON.
6) Delete restaurant
- Method: DELETE
- Path: `/api/restaurant/v1/{id}/delete`
- Success response (200):
```json
{ "message": "Restaurant deleted" }
```
7) List restaurants
- Method: GET
- Path: `/api/restaurant`
- Success response (200):
```json
[
  { "restId": 10, "name": "Spice Villa", "address": "...", "cuisine": "Indian", "openTime": "10:00:00", "closeTime": "23:00:00", "numberOfTables": 12 }
]
```
8) Get restaurant by id
- Method: GET
- Path: `/api/restaurant/v1/{id}`
- Success response (200): restaurant JSON.
9) Search restaurants by name
- Method: GET
- Path: `/api/restaurant/name`
- Query params: `name` (string)
- Success response (200): list of restaurants.
10) Search restaurants by cuisine
- Method: GET
- Path: `/api/restaurant/cuisine`
- Query params: `cuisine` (string)
- Success response (200): list of restaurants.
11) Search restaurants by opening time
- Method: GET
- Path: `/api/restaurant/open-time`
- Query params: `openTime` (LocalTime)
- Success response (200): list of restaurants.
12) Search restaurants by closing time
- Method: GET
- Path: `/api/restaurant/close-time`
- Query params: `closeTime` (LocalTime)
- Success response (200): list of restaurants.
13) Search restaurants by number of tables
- Method: GET
- Path: `/api/restaurant/no-of-tables`
- Query params: `numberOfTables` (integer)
- Success response (200): list of restaurants.
14) List all cuisines
- Method: GET
- Path: `/api/restaurant/v1/cuisines`
- Success response (200):
```json
[
  "Indian",
  "Italian",
  "Chinese"
]
```
15) Get opening timings
- Method: GET
- Path: `/api/restaurant/v1/open-time`
- Success response (200): implementation-defined (e.g., examples or range). Example:
```json
{ "examples": ["09:00:00", "10:00:00", "11:00:00"] }
```
16) Get closing timings
- Method: GET
- Path: `/api/restaurant/v1/close-time`
- Success response (200): implementation-defined. Example:
```json
{ "examples": ["21:00:00", "22:00:00", "23:00:00"] }
```
### Tables
Base path: `/api/tables`
1) Create new table for restaurant
- Method: POST
- Path: `/api/tables/v1/new/{rest_id}`
- Path params: `rest_id` (number)
- Query params: `seats` (integer)
- Success response (200):
```json
{
  "tableId": 10,
  "restaurant": { "restId": 10, "name": "Spice Villa" },
  "seats": 4
}
```
2) List tables for restaurant
- Method: GET
- Path: `/api/tables/v1/allTables/{rest_id}`
- Success response (200): list of tables for the restaurant.
3) Get table by id
- Method: GET
- Path: `/api/tables/v1/tables/{id}`
- Success response (200): table JSON.
4) List tables by seats
- Method: GET
- Path: `/api/tables/v1/allTablesBySeats`
- Note: Controller currently uses `@PathVariable Integer seats` without it appearing in the path. Intended usage likely as a query param. Recommended call:
- Query params: `seats` (integer)
- Success response (200): list of tables.
5) Delete table
- Method: DELETE
- Path: `/api/tables/v1/allTables/{tableId}`
- Success response (200):
```json
{ "message": "Table deleted" }
```
6) Update table seats
- Method: PATCH
- Path: `/api/tables/v1/{id}/update/no-of-seats`
- Query params: `newSeats` (integer)
- Success response (200): updated table JSON.
### Booking
Base path: `/api/booking`
1) Create new booking
- Method: POST
- Path: `/api/booking/v1/new`
- Request body:
```json
{
  "restId": 10,
  "userId": 15,
  "openTime": "2025-08-30T19:00:00",
  "closeTime": "2025-08-30T21:00:00",
  "status": "pending",
  "people": 4
}
```
- Success response (200):
```json
{
  "bookingId": 10,
  "restaurant": { "restId": 10, "name": "Spice Villa" },
  "user": { "userId": 15, "name": "Aarav Sharma" },
  "table": { "tableId": 22, "seats": 4 },
  "openTime": "2025-08-30T19:00:00",
  "closeTime": "2025-08-30T21:00:00",
  "status": "pending",
  "people": 4
}
```
2) List bookings for user
- Method: GET
- Path: `/api/booking/v1/user/{id}`
- Success response (200): list of bookings for the user.
3) List bookings for restaurant
- Method: GET
- Path: `/api/booking/v1/restaurant/{id}`
- Success response (200): list of bookings for the restaurant.
4) List bookings by open time (for a restaurant)
- Method: GET
- Path: `/api/booking/v1/restaurant/{id}/open-time/{openTime}`
- Path params: `openTime` (LocalDateTime)
- Success response (200): list of bookings.
5) List bookings by close time (for a restaurant)
- Method: GET
- Path: `/api/booking/v1/restaurant/{id}/close-time/{closeTime}`
- Path params: `closeTime` (LocalDateTime)
- Success response (200): list of bookings.
6) List bookings by status (for a restaurant)
- Method: GET
- Path: `/api/booking/v1/restaurant/{id}/{status}`
- Path params: `status` (enum: `pending`, `confirmed`, `cancelled`, etc.)
- Success response (200): list of bookings.
7) List bookings by number of people (for a restaurant)
- Method: GET
- Path: `/api/booking/v1/restaurant/{id}/{people}`
- Path params: `people` (integer)
- Success response (200): list of bookings.
8) Update booking open time
- Method: PATCH
- Path: `/api/booking/v1/{id}/update/open-time`
- Query params: `newOpenTime` (LocalTime)
- Success response (200): updated booking JSON.
9) Update booking close time
- Method: PATCH
- Path: `/api/booking/v1/{id}/update/close-time`
- Query params: `newCloseTime` (LocalTime)
- Success response (200): updated booking JSON.
10) Update booking status
- Method: PATCH
- Path: `/api/booking/v1/{id}/update/status`
- Query params: `newStatus` (enum)
- Success response (200): updated booking JSON.
11) Update booking people
- Method: PATCH
- Path: `/api/booking/v1/{id}/update/people`
- Query params: `newPeople` (integer)
- Success response (200): updated booking JSON.
### Error response examples
```json
{
  "error": "Validation failed",
  "details": ["email already exists"]
}
```
### OpenAPI/Swagger
This project includes OpenAPI annotations. If Swagger UI is enabled, you can access it at a path like `/swagger-ui.html` or `/swagger-ui/index.html` depending on configuration.