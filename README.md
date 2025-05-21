Banking Application using Microservices Architecture:
        This is a banking application that uses microservices architecture to manage financial transactions. 
        The application is written in Java and uses MySQL as the database.

Architecture:
        This application is built using a microservices architecture, which means that the application is composed of many small, 
        independently deployable services that work together to provide the full functionality of the application. 
        The microservices are:
        
            Account Management Service: manages user accounts.
              -	Add Money to account. (Before adding money to account must check if customer details passed in the request are valid or not)
              -	Withdraw money from account. (Before adding money to account must check if customer details passed in the request are valid or not)
              -	Get Account details. (Details include account details and related customer details).
              -	Delete Account.

            Customer Manage Service: manage customer details like: 
              -	Add customer
              -	Get all Customers
              -	Get single Customer Details
              -	Update Customer Details
              -	Delete Customer (Deleting customer should also delete the customer account from account management service)
              
           Api Gateway Bankin gSystem service
           Eureka server for service registration
           Config Server Banking System service


            Each microservice is responsible for a specific area of the application's functionality and communicates with other microservices using REST APIs.

Installation:
        To install and run this application, follow these steps:
            Install Java JDK on your system. This application requires at least Java 8 to run.
            Install MySQL database on your system.
            Download the source code from the repository and extract it to your desired location.
            Run the following command to start the MySQL server: mysql.server start
            Open a terminal or command prompt and navigate to the project directory.
            Compile and package each microservice by running the following commands for each service: cd [service_name] && ./mvnw clean package
            Start each microservice by running the following commands for each service: java -jar target/[service_name]-0.0.1-SNAPSHOT.jar

Usage:
        To use the application, users can perform the following actions:
            Create an account: Users can create an account by providing their personal information.
            Deposit: Users can add money to their account.
            Withdraw: Users can withdraw money from their account.
            
Technologies:
        This application is built using the following technologies:
            Java
            Spring Boot
            MySQL
            Netflix Eureka (for service discovery)
            RestTemplate (for communication between services)
            

Troubleshooting
        If you encounter any issues while running the application, try the following:
            Make sure you have Java 8 or later installed on your system.
            Make sure the MySQL server is running.
            Make sure all microservices are running by checking their logs.
            Check the application logs for error messages.
            If you are still having issues, please contact the developer for support.

Contribution Guidelines
        This application is open-source, and contributions are welcome. 
        If you would like to contribute, please follow these guidelines:
            Fork the repository and create a new branch for your changes.
            Make your changes and commit them to your branch.
            Submit a pull request with a clear description of your changes.

Contact Information
      If you have any questions or issues, please contact the developer at ummedsingh3062000@gmail.com.
