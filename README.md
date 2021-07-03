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