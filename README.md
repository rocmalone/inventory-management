# INVENTORY MANAGEMENT APPLICATION

This repo hosts an inventory management application created for a university Java class.

The application was built to customer specifications, using an Angular frontend and Java Spring backend. Data is stored in an H2 database in the user's home directory. The project was initialized using SpringBoot with a Maven build pipeline and Thymeleaf for templating.

The changelog below is kept for posterity.

## Part 3 Changelog

- #### src/main/java/resources/templates/mainscreen.html

  - Add stylesheet link to src/main/java/resources/static/css/demo.css (Line 14)
  - Change page title to `<title>Hugh's Travel Land</title>` (Line 15)
  - Wrap page content in ` <div class="contentContainer">` (Line 19 and 100)
  - Redesign website header (Lines 20 - 30)
    - Add header image (logo.png) (Line 21)
    - Update page heading to `<h1>Hugh's Travel Land</h1>` (Line 23)
    - Add heading subtitle (Line 24)
    - Add Home link (Line 28)
    - CSS to style these changes is in **src/main/java/resources/static/css/demo.css** (Lines 1 - 45)
  - Style contentContainer margins in **src/main/java/resources/static/css/demo.css** (Lines 47 - 51)

- #### src/main/resources/templates/InhousePartForm.html

  - Add bootstrap css stylesheet link (Lines 8 - 10)
  - Add stylesheet link (Line 11)
  - Add redesigned website header same as mainscreen.html with link to home (Lines 15 - 25)
  - Replace "Inhouse Part Detail" with "Inhoues Part Details" in page header (Line 27)
  - Add `<label>` for Name, Price, Inventory, Part ID (Lines 34, 39, 45, 51)

- #### src/main/resources/templates/OutsourcedPartForm.html

  - Add bootstrap css stylesheet link (Lines 8 - 10)
  - Add stylesheet link (Line 11)
  - Add redesigned website header same as mainscreen.html with link to home (Lines 15 - 25)
  - Replace "Detail" with "Details" in page header (Line 27)
  - Add `<label>` for Name, Price, Inventory, Company Name (Lines 35, 40, 46, 52)

- #### src/main/resources/templates/productForm.html

  - Add bootstrap css stylesheet link (Lines 8 - 10)
  - Add stylesheet link (Line 11)
  - Add redesigned website header same as mainscreen.html with link to home (Lines 17 - 27)
  - Replace "Detail" with "Details" in page header (Line 29)
  - Add `<label>` for Name, Price, and Inventory (Lines 35, 40, 45)

- #### src/main/java/com/example/demo/controllers/AboutScreenController.java

  - Add file
  - Specify AboutScreenController as @Controller (Line 6)
  - Map public String aboutScreen() to URL location /about (Line 8)
  - Send about.html when user visits /about and triggers aboutScreen() (Line 10)

- #### src/main/resources/templates/about.html

  - Add file
  - Add title, stylesheet links, and website header same as mainscreen.html in Part C
  - Add navigation to main screen in website header nav link (Line 21)
  - Add navigation to About screen to header (Line 22)

- #### src/main/resources/templates/mainscreen.html
  - Add navigation to About screen (Line 29)
- #### src/main/resources/templates/InhousePartForm.html
  - Add navigation to About screen (Line 24)
- #### src/main/resources/templates/OutsourcedPartForm.html
  - Add navigation to About screen (Line 24)
- #### src/main/resources/templates/productForm.html
  - Add navigation to About screen (Line 26)

#### src/main/java/com/example/demo/bootstrap/BootStrapData.java

- Check if part and product lists are empty (Line 43)
- Create Sample Part 1 (Line 46)
  - Set properties of Sample Part 1 (Lines 47 - 50)
  - Save Sample Part 1 into part repository (Line 51)
- Create and save Sample Part 2 (Lines 53 - 58)
- Create and save Sample Part 3 (Lines 60 - 65)
- Create and save Sample Part 4 (Lines 67 - 72)
- Create and save Sample Part 5 (Lines 74 - 79)
- Create and save Sample Product 1 to product repository (Lines 82-83)
- Create and save Sample Product 2 to product repository (Lines 85-86)
- Create and save Sample Product 3 to product repository (Lines 88-89)
- Create and save Sample Product 4 to product repository (Lines 91-92)
- Create and save Sample Product 5 to product repository (Lines 94-95)

#### src/main/resources/templates/mainscreen.html

- Add Buy Now button with mapping to URL /buyproduct?productID= (Line 96)

#### src/main/resources/templates/confirmationbuyproduct.html

- Created file with text to inform user their product purchase has succeeded

#### src/main/resources/templates/errorbuyproduct.html

- Created file with text to inform user their product purchase has failed

#### src/main/java/com/example/demo/controllers/AddProductController.java

- Map url "/buyproduct" to buyProduct method (Line 172)
- Create buyProduct method with URL param productID (Line 173)
- Get product and if it exists with inventory > 0 decrement its inventory (Lines 174 - 184)
  - If decrement works, send the user to the confirmationbuyproduct.html page (Line 183)
- If the product cannot be found or has no inventory send the user to the errorbuyproduct.html page (Line 190)

#### src/main/java/com/example/demo/domain/Part.java

- Store min/max inventory in minInv and maxInv (Lines 31 - 35)
- Add minInv and maxInv to constructors (Lines 45 - 60)
- Add getter/setter methods for minInv and maxInv (Lines 120 - 133)
- Add method isInvValid() to return true if current inventory is between minInv and maxInv (Lines 135 - 140)

#### src/main/java/com/example/demo/bootstrap/BootStrapData.java

- Use setMinInv() and setMaxInv() to specify min/max inv in part creation of sample data (Lines 46 - 89)

#### src/main/resources/templates/InhousePartForm.html

- Create text input and form error displays for minInv and maxInv (Lines 50 - 60)

#### src/main/java/com/example/demo/controllers/AddInhousePartController.java

- Validate that inventory of new part is between the specified minInv and maxInv and prevent creation and send error message if it is not (Lines 45 - 49)

#### src/main/resources/templates/OutsourcedPartForm.html

- Create text input and form error displays for minInv and maxInv (Lines 51 - 61)

#### src/main/resources/application.properties

- Rename persistent storage file by changing `spring.datasource.url=jdbc:h2:file:~/spring-boot-h2-db102
` to `spring.datasource.url=jdbc:h2:file:~/spring-boot-h2-db102-renamed` (Line 6)

#### src/main/java/com/example/demo/controllers/AddOutsourcedPartController.java

- Validate that inventory of new part is between the specified minInv and maxInv and prevent creation and send error message if it is not (Lines 44 - 48)

#### src/main/java/com/example/demo/controllers/AddOutsourcedPartController.java

- Add error message for inventory > max inventory (Lines 46 - 50)
- Add error message for inventory < min inventory (Lines 51 - 55)

#### src/main/java/com/example/demo/controllers/AddInhousePartController.java

- Add error message for inventory > max inventory (Lines 47 - 51)
- Add error message for inventory < min inventory (Lines 52 - 56)
- #### src/main/java/com/example/demo/validators/EnufPartsValidator.java

  - Add check for part inventory < part min inventory in isValid() function (Line 37)
    - If inv < minInv then return false (not valid)

- #### src/test/java/com/example/demo/domain/PartTest.java

  - Add unit test for maxInv (Lines 160 - 167)
  - Add unit test for minInv (Lines 169 - 176)

- #### src/main/java/com/example/demo/validators/DeletePartValidator.java
  - Delete file due to no usages
