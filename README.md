# springBootRESTMongo

DB Setup:
---------
1. Install MongoDB and create DB with name "restAPI".
2. Create collection with name "employee"
3. Inserte data in the format of : 
  {
    "empName": "Abhinav",
    "deptName": "DTH",
    "age": 25
  }
  
  How to execute:
  ---------------
  1. Start mongoDB : $ mongod
  2. Launch spring project : $ mvn spring-boot:run
  3. Open Postman and hit apis :  (a) GET - localhost:9091/employees
                                  (b) GET - localhost:9091/employees/Abhinav
                                  (c) UT - localhost:9091/employees/Abhinav
                                  (d) DELETE - localhost:9091/employees/Abhinav
                                  (e) POST - localhost:9091/employees

Swagger Docs:
-------------
When service get up open url : http://localhost:9091/swagger-ui.html

Etag Caching logic:
-------------------
1. In EmployeeManagmentAPI.java class added :
    import javax.servlet.Filter;
    @Bean
	  public Filter shallowEtagFilter() {
		  return new ShallowEtagHeaderFilter();
	  }
2. Reboot spring project
3. Open Postman and execute http://localhost:9091/employees/Abhinav GET api
4. Check header in responce : Etag value will shown
5. Go to Request header and add key : If-None-Match  and value as Etag value in ""
6. Re-execute same GET api, you get responce code "304 Not Modified"
