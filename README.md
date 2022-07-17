# Dice_Tech_Project

For better understanding please follow below steps to check the API's working

--Run the application from main class which is ------->Dice_TechApplication<--------(class name)

----For Token-----
1)goto POSTMAN----use below  Authentication URL

====Authentication URL - localhost:9090/authenticate
---put this username & password in body-----
{
    "userName":"dice",
    "password":"pass"
}

Output - e.g.eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJkaWNlIiwiZXhwIjoxNjU4MDgxNjcyLCJpYXQiOjE2NTgwODEzNzJ9.c0lhM4aitZBVBeAKqQfhja7TfbPhxhD74mQMWxz8TKM---(token)



=====API URL's======
Get method URL - localhost:9090/api/getAllEmployees
----in Headers----
Key - Authorization
Value - Bearer ######Token

Get method by empId URL - localhost:9090/api/getAllEmployees/1001
----in Headers----
Key - Authorization
Value - Bearer ######Token

----OR---
Authorzation Type - Bearer Token in dropdown 



Post method URL - localhost:9090/api/createEmployees
----in Headers----
Key - Authorization
Value - Bearer ######Token

----OR---
Authorzation Type - Bearer Token in dropdown 



Put method URL - localhost:9090/api/getAllEmployees/10
----in Headers----
Key - Authorization
Value - Bearer ######Token

----OR---
Authorzation Type - Bearer Token in dropdown 




Delete method URL - localhost:9090/api/getAllEmployees/1006
----in Headers----
Key - Authorization
Value - Bearer ######Token

----OR---
Authorzation Type - Bearer Token in dropdown 
