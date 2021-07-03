# eSamudaay Task API Server

API server as defined in the task [here](https://docs.google.com/document/d/1_SYROYkW_WxN1kb4ClnrpsKTHa7RzkKkGV0-J5_5gEs/edit)<br>

## Prerequisites 
The following tools are required to build and run this project<br>
1.  Java8/11
2.  Maven
3. Docker
4. Docker-compose 

## Overview  

The API specification is defined as per Open-API spec in the file **api-spec.yml**<br>
Read more on Open-API [here](https://swagger.io/specification/)

Use **build.sh** to build and run the project

To bootstrap, Run: `./builder.sh -p -r`<br>
The API server will be avaiable at localhost:8090 (it has a nice swagger UI)


## Examples 

1.Example of a valid request <br>
   ```curl -X POST "http://localhost:8090/v1/orders/values" -H  "accept: application/json" -H  "Content-Type: application/json" -d "{  \"order_items\": [    {      \"name\": \"bread\",      \"quantity\": 2,      \"price\": 1    },    {      \"name\": \"butter\",      \"quantity\": 1,      \"price\": 5900    }  ],  \"distance\": 1200,  \"offer\": {    \"offer_type\": \"FLAT\",    \"offer_val\": 1000  }}" ```

2. Example of an unprocessable request i.e. discount offer value > total with discount<br>
``` curl -X POST "http://localhost:8090/v1/orders/values" -H  "accept: application/json" -H  "Content-Type: application/json" -d "{  \"order_items\": [    {      \"name\": \"bread\",      \"quantity\": 2,      \"price\": 1    },    {      \"name\": \"butter\",      \"quantity\": 1,      \"price\": 5900    }  ],  \"distance\": 1200,  \"offer\": {    \"offer_type\": \"FLAT\",    \"offer_val\": 10000000  }}" ```

3. Example of a bad request<br>
   ``` curl -X POST "http://localhost:8090/v1/orders/values" -H  "accept: application/json" -H  "Content-Type: application/json" -d "{  \"distance\": 0,  \"offer\": {    \"offer_type\": \"FLAT\",    \"offer_val\": 0  },  \"order_items\": [    {      \"name\": \"string\",      \"price\": 0,      \"quantity\": 0    }  ]}" ```



## "Technical" details

1. The endpoint chosen is orders/values. This is because the API is not "orders" per say, but would be part of /orders APIs.
2. The method is POST. The reason being, it has a request body and request body for GET has no semantic meaning. Read more about it [here](https://stackoverflow.com/questions/978061/http-get-with-request-body)
3. In Request Body. The minium and max values are
   1. name: 1-30 letter
   2. quantity: 1 to 10
   3. price: 1 to 1000000
   4. For over_val in FLAT offer, minimum value can be 1
   5. Distance can be between 0 to 500000


4. The Slabs are configurable through *src/main/resources/application.yml* file.<br>
     Slab config used is:
      
~~~
slab-config:
  slabs:
    - lower: 0 # lower limit in KM (inclusive)
      upper: 10 # upper limit in KM (exclusive)
      fee: 50 # fee in INR
    - lower: 10
      upper: 20
      fee: 100
    - lower: 20
      upper: 50
      fee: 500
    - lower: 50 # last slab should not have upper field
      fee: 1000
~~~
      
5. If the discount value comes more than the total value with discount, error code 422 (Unprocessable Enitity) is thrown.