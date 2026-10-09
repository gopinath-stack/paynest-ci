# paynest-api

Payments API for PayNest.

## Build

    mvn clean package

## Run

    java -jar target/paynest-api-1.0.0.jar

## Endpoints

- GET  /health
- GET  /api/payments
- POST /api/payments?customer=NAME&amount=NUMBER
