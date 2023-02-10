## Import project
https://start.spring.io/

## Building the project
```
mvn clean install
mvn install dockerfile:build
```

### Run the application

```
docker-compose -f docker-compose-mongo.yml up -d
```


### Stop the application
```
docker-compose -f docker-compose-mongo.yml down -d
```

### Doctor Controller
GET:

```
curl --location --request GET 'localhost:8080/doctor/doctorAppointment?doctorName=Dr. Firke' \
--header 'Authorization: Basic ZG9jdG9yNDU2OnBhc3N3b3Jk'
```

### Patient Controller
GET:
```
curl --location --request GET 'localhost:8080/patient/patientappointment?patientName=Dr. Firke' \
--header 'Authorization: Basic cGF0aWVudDQ1NjpwYXNzd29yZA==' \
--header 'Cookie: JSESSIONID=22BA6D4BD021AE334673E17DAF523919'
```


### Prescription Controller
GET:
```
curl --location --request GET 'localhost:8080/prescription/viewprescription?patientName=Dr. Firke' \
--header 'Authorization: Basic cGF0aWVudDQ1NjpwYXNzd29yZA==' \
--header 'Cookie: JSESSIONID=22BA6D4BD021AE334673E17DAF523919'
```


### Dockerization
Creating Docker Image
```
mvn install dockerfile:build 
```

### List docker images
```
docker images 
```


### Running the Application with Docker Compose
```
Docker-compose up-d
Docker-compose down 
```