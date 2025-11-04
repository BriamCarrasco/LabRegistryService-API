# LabRegistryService‑API

## 🎯 Descripción
Este proyecto es un microservicio desarrollado con **Spring Boot 3.4.4** y **Java 21**, orientado al registro y gestión de laboratorios o servicios veterinarios.  
Permite registrar servicios, generar facturas, consultar datos, validar información y realizar pagos. La persistencia actualmente puede estar en memoria, con posibilidad de integrarse a una base de datos real.

## 🧰 Tecnologías utilizadas
- Java 21  
- Spring Boot 3.4.4  
- Maven  
- Spring Web, Spring Data JPA  
- Oracle Driver (si aplica)  
- Lombok  
- Docker  
- Scripts SQL (`Create tables.sql`)  

## 📁 Estructura del proyecto
```
/
├─ .mvn/
├─ src/
│   ├─ main/
│   ├─ test/
│   └─ resources/
├─ Create tables.sql
├─ Dockerfile
├─ pom.xml
├─ mvnw, mvnw.cmd
└─ README.md
```

## 🚀 Ejecución del proyecto
1. Clonar el repositorio:
   ```bash
   git clone https://github.com/BriamCarrasco/LabRegistryService-API.git
   cd LabRegistryService-API
   ```
2. Compilar con Maven:
   ```bash
   ./mvnw clean install
   ```
3. Ejecutar la aplicación:
   ```bash
   ./mvnw spring-boot:run
   ```
4. (Opcional) Usar Docker:
   ```bash
   docker build -t lab-registry-service .
   docker run -p 8080:8080 lab-registry-service
   ```
5. Acceder al servicio en: `http://localhost:8080/api/v1/...`

## 🧩 Funcionalidades principales
- Registro de servicios o productos  
- Cálculo de costos y generación de facturas  
- Validación de datos  
- Consulta de facturas emitidas  
- Integración con pagos  
- Soporte para despliegue en Docker  

## ⚙️ Configuración
- Modifica `application.properties` o `application.yml` según tu entorno.  
- Si se usa una base de datos real, configura URL, usuario y contraseña.  
- El script `Create tables.sql` define la estructura inicial.

## 🧪 Pruebas
- Se recomienda usar **JUnit 5** y **Mockito** para pruebas unitarias.  
- Implementar pruebas de integración para los endpoints REST.  

## 🤝 Contribución
1. Haz *fork* del repositorio.  
2. Crea una rama (`feature/nueva-funcionalidad`).  
3. Realiza los cambios y abre un *Pull Request*.  

## 🪪 Licencia
Este proyecto está bajo la licencia **MIT**.

## 👤 Autor
**Briam Carrasco**  
📦 [Repositorio GitHub](https://github.com/BriamCarrasco/LabRegistryService-API)
