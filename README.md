# PlacingFoodOrderAPI
This is Java base, Spring Boot API.
Steps to run the application.
1. Clone/Download the project and import it to Eclipse.
2. From Project Explorer 
  2.1. Right click on project name -> Maven -> Update Project.. -> Check Offile && Force Update of Snapshots/Releases.
  2.2. Right click on project name then click on Show in local terminal.
  2.3. Run command "mvn install -U -e" to do maven package/install.
  2.4. Right click on project name -> Run As -> Spring Boot App.

3. To the the correct syntax for JSON input String,
   3.1 Once application will start running, Open postman and make a GET call with url "http://localhost:9090/orders" and remove the '[' & ']' square brackets from returned JSON String.
4. Now paste the exmaple JSON string under Body (type JSON) of Postman and make POST call to url "http://localhost:9090/getOrders" for getting desired output (Total cost for your order).








# Screenshot with running API
![image](https://user-images.githubusercontent.com/26317224/125168984-cc75a100-e1c5-11eb-81b1-5ae830d8a9be.png)
![image](https://user-images.githubusercontent.com/26317224/125168977-c8498380-e1c5-11eb-8c01-45ddcee26cce.png)
![image](https://user-images.githubusercontent.com/26317224/125168986-cc75a100-e1c5-11eb-814b-978fe2b88aa0.png)
