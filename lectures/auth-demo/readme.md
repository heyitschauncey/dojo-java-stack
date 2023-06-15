# Auth Notes
## Project setup
- pom.xml : add jasper, jstl, bcrypt, validation
- application.properties: add WEB-INF config, connect to database, enable hidden methods for Put&Delete
- create all subpackages : models, controllers, services, respositories

# Full Spring notes (After logreg is done)
## Project Setup
#### Models: 
- Create the one-to-many relationship between User & Donation (Check platform / [1:n readme](/Java4MVC#2-models) / Dojos & Ninjas assignment)

## Create 
- As the donor is the logged in user, NO DROPDOWN MENU and hence.. no userList.
- Make sure you attach the userId from session to create the 1:n in Donation (can be done in form:hidden for the hidden input OR in controller)
```html
    <form:hidden name="donor" value="${userId}">
```

## Dashboard 
- The dashboard will look like fruity loops 
- Donor is a User object. To display the userName, need to get it from the donor object
- Refer to [one-to-many readme](/Java4MVC#5-controllers--views)

## FindOne 
- get id from path variables
- get the donation and put it in model to display in jsp

## Edit 
- Create is similar to Edit, with a few things to note (1. form action with the id 2. make it a "put" route 3. 1:n reference)
- Make sure you attached donor in the form
- If you want the donor will be changed to the logged in user, what should you do?
- If you want the donor to stay the same, what should you do?


## Delete
- Controller method: @DeleteMapping
- In order to direct to Delete Route, it has to be a form with hidden input for the method. 

