# LabRegistryService-API

API REST de gestión de laboratorios desarrollada con Spring Boot 3 (Java 21) y Oracle Database. Expone operaciones CRUD y búsquedas por nombre y especialidad, con documentación OpenAPI/Swagger.

## 🚀 Tecnologías

- Java 21, Spring Boot 3.5.7
- Spring Web, Spring Data JPA, Bean Validation
- Spring Security (config abierta para desarrollo)
- Oracle JDBC (Autonomous/Thin + Wallet)
- springdoc-openapi (Swagger UI)
- Docker (build y runtime)

## 📁 Estructura

- `controller/` Endpoints REST (`/api/laboratories`)
- `service/` Lógica de negocio
- `repository/` Acceso a datos (JPA)
- `model/` Entidades JPA (`Laboratory`)
- `security/` Configuración de seguridad (todo permitido en dev)

## 🔐 Seguridad

La configuración actual permite todas las solicitudes sin autenticación y habilita Swagger sin restricciones.

- Swagger UI: http://localhost:8083/swagger-ui/index.html
- OpenAPI JSON: http://localhost:8083/v3/api-docs

## 🔌 Endpoints principales

Base URL: `http://localhost:8083/api/laboratories`

- `POST /` — Crear laboratorio
- `GET /` — Listar todos
- `GET /{id}` — Obtener por ID
- `PUT /{id}` — Actualizar por ID
- `DELETE /{id}` — Eliminar por ID
- `GET /specialty/{specialty}` — Buscar por especialidad
- `GET /name/{name}` — Buscar por nombre (parcial, case-insensitive)

## 🏃 Ejecutar en desarrollo (Windows PowerShell)

- Ejecutar con Maven Wrapper:

```powershell
# Compilar y correr
./mvnw.cmd spring-boot:run

# Pruebas
./mvnw.cmd test
```

- Empaquetar JAR y ejecutar:

```powershell
./mvnw.cmd clean package -DskipTests
java -jar target/labregistryservice-api-0.0.1-SNAPSHOT.jar
```

## 🐳 Docker

```powershell
# Construir imagen
docker build -t labregistryservice-api:latest .

# Ejecutar (mapea el puerto 8083)
docker run --name labregistryservice-api -p 8083:8083 labregistryservice-api:latest
```


## ✅ Validaciones del modelo `Laboratory`

- `name`: único, mínimo 4 caracteres
- `address`: máximo 150, requerido
- `phone`: `+` opcional y 7–15 dígitos
- `email`: formato válido, 5–100 caracteres
- `website`: máximo 100 (opcional)
- `specialty`: 2–50 caracteres, requerido

## 🧪 Salud y logs

- Puerto: `8083`
- Logs: nivel DEBUG para Spring y Hibernate habilitados en `application.properties`

