# Cloud Usage Calculator

## Description
This application calculates the total usage time of cloud customers based on event data.

## Prerequisites
- Docker
- Docker Compose
- Maven

## Project Structure
- `src/main/java/de.hhn.labapp.ln1`: Java source code
- `Dockerfile`: Docker image for the application
- `docker-compose.yml`: Docker Compose configuration
- `pom.xml`: Maven project file

## Execution
1. Clone the repository:
   ```bash
   git clone https://github.com/vohangnguyen/labapp-repo.git

## Example POST Request
curl -X POST http://localhost:8080/v1/dataset \
-H "Content-Type: application/json" \
-d '[
{
"customerId": "342a55a3-b138-4665-8351-111b28833d34",
"workloadId": "53ddf5cf-7a12-4b7f-8751-48757774c0c5",
"timestamp": 1699872883000,
"eventType": "start"
},
{
"customerId": "342a55a3-b138-4665-8351-111b28833d34",
"workloadId": "53ddf5cf-7a12-4b7f-8751-48757774c0c5",
"timestamp": 1700401984000,
"eventType": "stop"
}
]'
