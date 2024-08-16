## Project Overview

This repository contains a collection of automated test scripts developed during an automation course I participated in, held by Azimut. The scripts are primarily written in Java, utilizing Selenium for browser automation, and follow a structured testing methodology aimed at validating the functionality of various features in a web application.

### Project Structure

- **Test Cases:** Located in the `test/java/Test` directory, these files contain the test cases that simulate different user interactions with the application. Each test is focused on a specific feature or functionality, such as searching for products, managing shopping lists, or user authentication.

- **Base Setup:** The `BaseTest.java` file under `test/java/Base` serves as the foundation for all test cases, handling the setup and teardown processes, such as opening and closing the browser.

- **Helper Methods:** The `HelpMethod.java` file in the `test/java/Help` directory includes utility functions that are commonly used across different test cases, like scrolling, handling pop-ups, and performing assertions.

- **Main Application Code:** There is a simple Java application located in the `main/java/com/example/java` directory, which serves as a basic demonstration of running code in IntelliJ IDEA. It's not directly related to the test cases but provides a foundation for practicing Java programming.

### Key Test Scenarios

- **Shopping List Management:** Tests like `ShoppingList_AddProduct.java` and `ShoppingList_DeleteProduct.java` simulate adding and removing products from a shopping list, ensuring that the feature behaves correctly under different conditions.

- **Search Functionality:** The `SearchBar.java` and `Searchbar_WrongProduct.java` tests focus on the application's search capabilities, validating that users can find the right products or handle cases where no results are found.

- **User Authentication:** Tests such as `Login.java`, `Register.java`, and `Register_ContExistent.java` cover the login and registration processes, including edge cases like attempting to register with an existing account or logging in with incorrect credentials.

### Purpose

These automated tests are designed to ensure that key functionalities of the web application are working as intended. By automating these checks, I aim to catch potential issues early in the development process, contributing to a more stable and reliable product.

This project showcases the skills and knowledge acquired during the Azimut automation course, focusing on writing clean, maintainable test scripts and improving the quality of software through effective test automation.

### Technologies Used

- **Java**: The primary programming language used for writing the test scripts.
- **Selenium**: A tool for automating web browsers, used for simulating user interactions in the test cases.
- **TestNG**: A testing framework that allows me to structure and run the test cases efficiently.

### Future Improvements

I plan to continue enhancing these tests by:
- Expanding the test coverage to include more scenarios.
- Refactoring the code to improve maintainability.
