# spring-boot-training

### Create Department
**POST** localhost:8080/department/create/{departmentName}

**Example:** localhost:8080/department/create/finans

### Creating Personnel
**POST** localhost:8080/personnel/create/{personnelName}/{departmentId}

**Example:** localhost:8080/personnel/create/armagancaglar/1

### Get Single Department By Id
**GET** localhost:8080/department/get/{departmentId}

**Example:** localhost:8080/department/get/1

### Get Single Personnel By Id
**GET** localhost:8080/personnel/get/{personnelId}

**Example:** localhost:8080/personnel/get/1

### Get Department with Personnels
**GET** localhost:8080/department/get-all/{page}/{size}

**Example:** localhost:8080/department/get-all/1/5

