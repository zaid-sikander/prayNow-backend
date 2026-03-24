# PrayNow Backend

Spring Boot REST API for serving masjid iqama times.

## Tech Stack
- Java 21
- Spring Boot 3.5
- MongoDB Atlas
- JWT Authentication
- Swagger UI

## API Documentation
Live Swagger UI: `https://praynow-backend-production.up.railway.app/swagger-ui.html`

## Endpoints

| Method | Endpoint | Auth | Description |
|--------|----------|------|-------------|
| POST | `/auth/login` | No | Get JWT token |
| GET | `/api/masjids` | No | Get all masjid schedules |
| GET | `/api/masjids/{masjidId}` | No | Get all schedules for a masjid |
| GET | `/api/masjids/{masjidId}/{year}/{month}` | No | Get schedule for a specific month |
| POST | `/api/masjids` | JWT | Add a masjid schedule |

## Local Setup

### Prerequisites
- Java 21
- Maven
- MongoDB (local)

### Running Locally
1. Create `src/main/resources/application-local.properties`:
```
spring.data.mongodb.uri=mongodb://localhost:27017/praynow
app.token.secret=your-secret-key
app.token.expiration=86400000
app.auth.username=your-username
app.auth.password=your-password
```

2. Run:
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=local
```

3. Visit `http://localhost:8080/swagger-ui.html`

## Deployment
Deployed on Railway with MongoDB Atlas. Environment variables are set in the Railway dashboard.
