# Gila
  *Cucumber 6 
  *Selenium 3.14
  *Java 11 
  *Maven 
  *Allure 
  *Junit4

Browser support:
  *Chrome (tested)
  *Firefox (untested)

In order to generate a report after execution, you need to have allure command line installed in the system where tests are being run from.
If you have npm installed already, you can do so by executing the following command:

    npm install -g allure-commandline --save-dev

Once test execution is complete, run the following command in order to generate the report:

      allure serve

Note: At this point, screenshots will be only taken in case of test execution failure.


