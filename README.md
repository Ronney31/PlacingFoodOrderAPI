# PlacingFoodOrderAPI
This is Java based, Spring Boot API.
Steps to run the application.
1. Clone/Download the project and import it to Eclipse.
2. From Project Explorer 
    1. Right-click on project name -> Maven -> Update Project.. -> Check offline && Force Update of Snapshots/Releases.
    2. Right-click on project name then click on Show in a local terminal.
    3. Run command ```mvn install -U -e``` to do maven package/install.
    4. Right-click on project name -> Run As -> Spring Boot App.

3. To the correct syntax for JSON input String,
    1 Once the application will start running, Open postman and make a GET call with the URL "http://localhost:9090/orders" and remove the '[' & ']' square brackets from returned JSON String.
4. Now paste the example JSON string under Body (type JSON) of Postman and make a POST call to URL "http://localhost:9090/getOrders" for getting desired output (Total cost for your order).






# Screenshot with running API
![image](https://user-images.githubusercontent.com/26317224/125168984-cc75a100-e1c5-11eb-81b1-5ae830d8a9be.png)
![image](https://user-images.githubusercontent.com/26317224/125168977-c8498380-e1c5-11eb-8c01-45ddcee26cce.png)
![image](https://user-images.githubusercontent.com/26317224/125168986-cc75a100-e1c5-11eb-814b-978fe2b88aa0.png)
