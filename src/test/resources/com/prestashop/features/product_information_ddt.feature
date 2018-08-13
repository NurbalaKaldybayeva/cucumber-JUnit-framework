Feature: Verify product information 
#Scenario: Verify item name 
#  When the user selects "Printed Summer Dress" 
#  Then product page title should contain "Printed Summer Dress" 
#  And product name should be "Printed Summer Dress" 


 
 
 Scenario Outline: Verify item name
  Given the user is on the home page
 When the user selects "<product>"
# Then product page title should contain <product>
 Then product name should be "<product>"
 And the price should be "<price>"
 And correct default count should be 1
 Examples:
 |product              | price|
 |Printed Summer Dress |28.98 |
 |Printed Dress        |26.00 |
 |Printed Chiffon Dress|16.40 |
 
 
  Scenario Outline: Verify usernames   
#  outline expects of Example table
  Given the user is on the login page
  When I login using username "<username>" and password "<password>"
  Then users full name "<firstname>" "<lastname>" should be displayed
  Examples:
 |firstname|lastname |username          |password|
 |John     |Smith    |nitoyey@dumoac.net|password|
 |Geraldine |Whitehead  |lectus@sociisnatoquepenatibus.org |password|
 |Inigo     |Montoya  |vel.quam@Donec.org                |password|
 |Elija     |Baker    |mollis.nec@quama.org              |password|
 |Hakeem    |Wagner   |gravida.molestie@sagittissemper.ca|password|
 |Gareth    |Ruiz     |at.risus.Nunc@tempor.ca           |password|
 |Bryar     |Gilbert  |at@tempusscelerisque.co.uk        |password|
 |Charity   |Deleon   |tincidunt.tempus@egestas.com      |password|
 |Cullen    |Stafford |Proin.nisl@acarcuNunc.net         |password|
 |Hadassah  |Fuentes  |et@ipsumprimisin.net              |password|
 |Sydney    |Vazquez  |tincidunt.nunc.ac@atiaculis.edu   |password|
 |Martena   |Murray   |Donec.fringilla@mauris.org        |password|
 |Quynn     |Rocha    |lorem@enimCurabiturmassa.net      |password|
 