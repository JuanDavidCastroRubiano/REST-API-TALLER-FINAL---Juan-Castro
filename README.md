# REST-API-TALLER-FINAL---Juan-Castro

# ✈️ Aerolínea API - REST API con Spring Boot

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-green?style=for-the-badge&logo=springboot)
![Maven](https://img.shields.io/badge/Maven-Build-blue?style=for-the-badge&logo=apachemaven)
![REST API](https://img.shields.io/badge/API-REST-black?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Completed-success?style=for-the-badge)

---

# 📌 Descripción del Proyecto

**Aerolínea API** es una aplicación backend desarrollada con **Java y Spring Boot** que permite gestionar información relacionada con una aerolínea mediante una arquitectura RESTful.

El proyecto implementa operaciones CRUD para:

- ✈️ Vuelos
- 👤 Pasajeros
- 🎟️ Reservas

La aplicación sigue buenas prácticas de desarrollo backend utilizando una arquitectura organizada por capas (`Controller`, `Service`, `Repository`, `DTO` y `Model`), facilitando la escalabilidad, mantenibilidad y comprensión del código.

---

# 🚀 Características Principales

✅ Arquitectura RESTful  
✅ CRUD completo de entidades  
✅ Uso de DTOs para transferencia de datos  
✅ Separación de responsabilidades  
✅ Persistencia de datos con JPA/Hibernate  
✅ Arquitectura limpia y mantenible  
✅ Integración con Maven  
✅ Buenas prácticas en desarrollo backend  

---

# 🛠️ Tecnologías Utilizadas

| Tecnología | Descripción |
|---|---|
| Java 17 | Lenguaje principal |
| Spring Boot | Framework backend |
| Spring Web | Construcción de APIs REST |
| Spring Data JPA | Persistencia de datos |
| Maven | Gestión de dependencias |
| Hibernate | ORM |
| Postman | Pruebas de endpoints |
| Git & GitHub | Control de versiones |

---

# 📂 Estructura del Proyecto

```bash
AerolineaAPI
│
├── .mvn/
│
├── src/
│   └── main/
│       └── java/
│           └── com.aerolinea.aerolineaapi/
│
│               ├── controller/
│               │   ├── PasajeroController.java
│               │   ├── ReservaController.java
│               │   └── VueloController.java
│               │
│               ├── dto/
│               │   ├── ReservaRequestDTO.java
│               │   └── ReservaResponseDTO.java
│               │
│               ├── model/
│               │   ├── ClaseAsiento.java
│               │   ├── EstadoVuelo.java
│               │   ├── Pasajero.java
│               │   ├── Reserva.java
│               │   └── Vuelo.java
│               │
│               ├── repository/
│               │   ├── PasajeroRepository.java
│               │   ├── ReservaRepository.java
│               │   └── VueloRepository.java
│               │
│               ├── service/
│               │   ├── PasajeroService.java
│               │   ├── ReservaService.java
│               │   └── VueloService.java
│               │
│               └── AerolineaApiApplication.java
│
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

---

# ⚙️ Instalación y Configuración

## 1️⃣ Clonar el repositorio

```bash
git clone https://github.com/JuanDavidCastroRubiano/REST-API-TALLER-FINAL---Juan-Castro.git
```

---

## 2️⃣ Acceder al proyecto

```bash
cd REST-API-TALLER-FINAL---Juan-Castro
```

---

## 3️⃣ Ejecutar la aplicación

### Windows

```bash
mvnw.cmd spring-boot:run
```

### Linux / Mac

```bash
./mvnw spring-boot:run
```

---

# 🌐 Acceso Local

Una vez ejecutada la aplicación:

```bash
http://localhost:8080
```

---

# 📡 Endpoints Principales

## ✈️ Vuelos

| Método | Endpoint | Descripción |
|---|---|---|
| GET | `/vuelos` | Obtener todos los vuelos |
| GET | `/vuelos/{id}` | Obtener vuelo por ID |
| POST | `/vuelos` | Crear vuelo |
| PUT | `/vuelos/{id}` | Actualizar vuelo |
| DELETE | `/vuelos/{id}` | Eliminar vuelo |

---

## 👤 Pasajeros

| Método | Endpoint | Descripción |
|---|---|---|
| GET | `/pasajeros` | Obtener pasajeros |
| GET | `/pasajeros/{id}` | Obtener pasajero por ID |
| POST | `/pasajeros` | Crear pasajero |
| PUT | `/pasajeros/{id}` | Actualizar pasajero |
| DELETE | `/pasajeros/{id}` | Eliminar pasajero |

---

## 🎟️ Reservas

| Método | Endpoint | Descripción |
|---|---|---|
| GET | `/reservas` | Obtener reservas |
| GET | `/reservas/{id}` | Obtener reserva por ID |
| POST | `/reservas` | Crear reserva |
| PUT | `/reservas/{id}` | Actualizar reserva |
| DELETE | `/reservas/{id}` | Eliminar reserva |

---

# 🧪 Ejemplo de Petición JSON

## Crear un vuelo

### POST `/vuelos`

```json
{
  "origen": "Bogotá",
  "destino": "Medellín",
  "fechaSalida": "2026-05-30",
  "estado": "PROGRAMADO"
}
```

---

# 📌 Arquitectura Implementada

El proyecto utiliza una arquitectura por capas:

| Capa | Responsabilidad |
|---|---|
| Controller | Manejo de peticiones HTTP |
| Service | Lógica de negocio |
| Repository | Acceso a datos |
| DTO | Transferencia segura de datos |
| Model | Entidades del sistema |

---

# 🧠 Buenas Prácticas Aplicadas

✔️ Arquitectura limpia  
✔️ Principio de responsabilidad única  
✔️ Separación de capas  
✔️ Uso de DTOs  
✔️ Nombres descriptivos  
✔️ Código modular  
✔️ API RESTful  
✔️ Estructura escalable  
✔️ Uso de Maven Wrapper  
✔️ Control de versiones con Git  

---

# 🧪 Herramientas de Prueba

Puedes probar los endpoints usando:

- Postman
- Insomnia
- Thunder Client

Ejemplo:

```http
GET http://localhost:8080/vuelos
```

---

# 📚 Conceptos Aplicados

- Desarrollo Backend
- Java Orientado a Objetos
- APIs REST
- Spring Framework
- CRUD
- Persistencia de Datos
- DTO Pattern
- Arquitectura por capas
- HTTP Methods
- JPA & Hibernate

---

# 👨‍💻 Autor

## Juan David Castro Rubiano

Desarrollador backend enfocado en tecnologías Java y Spring Boot.

### 🔗 Enlaces

- GitHub:  
  https://github.com/JuanDavidCastroRubiano

- Repositorio del proyecto:  
  https://github.com/JuanDavidCastroRubiano/REST-API-TALLER-FINAL---Juan-Castro

---

# ⭐ Estado del Proyecto

✅ Proyecto finalizado  
✅ Funcional  
✅ Estructura profesional  
✅ Buenas prácticas implementadas  

---

# 📄 Licencia

Este proyecto fue desarrollado con fines académicos y educativos.
