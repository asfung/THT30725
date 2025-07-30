# THT30725

### System Info
- Fedora Linux 42 (Workstation Edition)
- GraalVM 17 Community Edition
- Maven 3.9.9
- MySQL 0.4.32-MariaDB

## Quick Start

```bash
$ git clone https://github.com/asfung/THT30725.git
$ cd THT30725
$ cp .env.example .env
```

### Edit .env

```
DATABASE_NAME=NAME
DATABASE_PORT=3306 # mysql port
DATABASE_USERNAME=USERNAME
DATABASE_PASSWORD=PASSWORD
```

### Run Spring Boot Project
```bash
$ mvn spring-boot:run
# or 
$ ./mvnw spring-boot:run
```

### Open Browser
```
http://localhost:8080/swagger-ui/index.html
```

