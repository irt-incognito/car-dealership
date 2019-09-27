#CarSearch
 CarSearch is a rest api that will search a local h2 database for the availability of a car.

##Requirements
    Java 11
    Maven 3.6.2
 
##Swagger Doc
http://localhost:8080/swagger-ui.html
  
##Database Console
    http://localhost:8080/h2-console/
    
    jdbc connection: jdbc:h2:mem:cardb
    user:admin 
    password:admin
    
##Starting service
```$xslt
    mvn spring-boot:run
```
    
###Test Data
Curl command to insert data.
```$xslt
curl -X POST "http://localhost:8080/car" -H  "accept: */*" -H  "Content-Type: application/json" -d "[\t{\t\"make\": \"Chevy\",\t\"year\": 2016,\t\"color\": \"Gray\",\t\"price\": 16106,\t\"hasSunroof\": false,\t\"isFourWheelDrive\": true,\t\"hasLowMiles\": true,\t\"hasPowerWindows\": false,\t\"hasNavigation\": true,\t\"hasHeatedSeats\": false\t},\t{\t\"make\": \"Toyota\",\t\"year\": 2012,\t\"color\": \"Silver\",\t\"price\": 18696,\t\"hasSunroof\": true,\t\"isFourWheelDrive\": true,\t\"hasLowMiles\": false,\t\"hasPowerWindows\": true,\t\"hasNavigation\": false,\t\"hasHeatedSeats\": true\t},\t{\t\"make\": \"Mercedes\",\t\"year\": 2016,\t\"color\": \"Black\",\t\"price\": 18390,\t\"hasSunroof\": true,\t\"isFourWheelDrive\": false,\t\"hasLowMiles\": false,\t\"hasPowerWindows\": true,\t\"hasNavigation\": true,\t\"hasHeatedSeats\": false\t},\t{\t\"make\": \"Toyota\",\t\"year\": 2015,\t\"color\": \"White\",\t\"price\": 15895,\t\"hasSunroof\": true,\t\"isFourWheelDrive\": false,\t\"hasLowMiles\": true,\t\"hasPowerWindows\": true,\t\"hasNavigation\": false,\t\"hasHeatedSeats\": true\t},\t{\t\"make\": \"Ford\",\t\"year\": 2014,\t\"color\": \"Gray\",\t\"price\": 19710,\t\"hasSunroof\": false,\t\"isFourWheelDrive\": true,\t\"hasLowMiles\": false,\t\"hasPowerWindows\": false,\t\"hasNavigation\": true,\t\"hasHeatedSeats\": true\t},\t{\t\"make\": \"Toyota\",\t\"year\": 2014,\t\"color\": \"Red\",\t\"price\": 19248,\t\"hasSunroof\": true,\t\"isFourWheelDrive\": false,\t\"hasLowMiles\": true,\t\"hasPowerWindows\": true,\t\"hasNavigation\": true,\t\"hasHeatedSeats\": true\t},\t{\t\"make\": \"Toyota\",\t\"year\": 2015,\t\"color\": \"Black\",\t\"price\": 13170,\t\"hasSunroof\": true,\t\"isFourWheelDrive\": false,\t\"hasLowMiles\": true,\t\"hasPowerWindows\": true,\t\"hasNavigation\": false,\t\"hasHeatedSeats\": false\t},\t{\t\"make\": \"Mercedes\",\t\"year\": 2013,\t\"color\": \"Gray\",\t\"price\": 15669,\t\"hasSunroof\": false,\t\"isFourWheelDrive\": false,\t\"hasLowMiles\": true,\t\"hasPowerWindows\": false,\t\"hasNavigation\": false,\t\"hasHeatedSeats\": false\t},\t{\t\"make\": \"Toyota\",\t\"year\": 2015,\t\"color\": \"White\",\t\"price\": 16629,\t\"hasSunroof\": false,\t\"isFourWheelDrive\": false,\t\"hasLowMiles\": true,\t\"hasPowerWindows\": false,\t\"hasNavigation\": false,\t\"hasHeatedSeats\": true\t}]"
```

```
[
	{
	"make": "Chevy",
	"year": 2016,
	"color": "Gray",
	"price": 16106,
	"hasSunroof": false,
	"isFourWheelDrive": true,
	"hasLowMiles": true,
	"hasPowerWindows": false,
	"hasNavigation": true,
	"hasHeatedSeats": false
	},
	{
	"make": "Toyota",
	"year": 2012,
	"color": "Silver",
	"price": 18696,
	"hasSunroof": true,
	"isFourWheelDrive": true,
	"hasLowMiles": false,
	"hasPowerWindows": true,
	"hasNavigation": false,
	"hasHeatedSeats": true
	},
	{
	"make": "Mercedes",
	"year": 2016,
	"color": "Black",
	"price": 18390,
	"hasSunroof": true,
	"isFourWheelDrive": false,
	"hasLowMiles": false,
	"hasPowerWindows": true,
	"hasNavigation": true,
	"hasHeatedSeats": false
	},
	{
	"make": "Toyota",
	"year": 2015,
	"color": "White",
	"price": 15895,
	"hasSunroof": true,
	"isFourWheelDrive": false,
	"hasLowMiles": true,
	"hasPowerWindows": true,
	"hasNavigation": false,
	"hasHeatedSeats": true
	},
	{
	"make": "Ford",
	"year": 2014,
	"color": "Gray",
	"price": 19710,
	"hasSunroof": false,
	"isFourWheelDrive": true,
	"hasLowMiles": false,
	"hasPowerWindows": false,
	"hasNavigation": true,
	"hasHeatedSeats": true
	},
	{
	"make": "Toyota",
	"year": 2014,
	"color": "Red",
	"price": 19248,
	"hasSunroof": true,
	"isFourWheelDrive": false,
	"hasLowMiles": true,
	"hasPowerWindows": true,
	"hasNavigation": true,
	"hasHeatedSeats": true
	},
	{
	"make": "Toyota",
	"year": 2015,
	"color": "Black",
	"price": 13170,
	"hasSunroof": true,
	"isFourWheelDrive": false,
	"hasLowMiles": true,
	"hasPowerWindows": true,
	"hasNavigation": false,
	"hasHeatedSeats": false
	},
	{
	"make": "Mercedes",
	"year": 2013,
	"color": "Gray",
	"price": 15669,
	"hasSunroof": false,
	"isFourWheelDrive": false,
	"hasLowMiles": true,
	"hasPowerWindows": false,
	"hasNavigation": false,
	"hasHeatedSeats": false
	},
	{
	"make": "Toyota",
	"year": 2015,
	"color": "White",
	"price": 16629,
	"hasSunroof": false,
	"isFourWheelDrive": false,
	"hasLowMiles": true,
	"hasPowerWindows": false,
	"hasNavigation": false,
	"hasHeatedSeats": true
	}
```
##Usage
Navigate to: 
```$xslt
http://localhost:8080/car?color=Black&hasHeatedSeats=false&hasLowMiles=true&hasNavigation=true&hasPowerWindows=true&hasSunRoof=true&isFourWheelDrive=true
```
