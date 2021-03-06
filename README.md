# NEWS-PORTAL API

## Author
* Brian Muthaka

### Description
This is an Organizational Rest API that queries and retrieves scoped news and information within an organization.

## Features
A user visiting the news portal Api site will be able to:

1. Add New Departments .
2. Add new User/s' .
3. Add news in a particular department .

## Prerequisites & Application Setup
- Use of version control. ie. Git
- Java SDK & Environment.
- Java IntelliJIDEA Community.
- Gradle.
- PostgreSQL

### Clone Repository

- Depending on your prefereable method of acquiring the Application to your local machine, you might as well try:
1. Forking the repository to your repositories.
2. Cloning the forked repository or cloning directly from my repository.
3. Finally run the project on your IntelliJIDEA `$ gradle build`, `$ gradle run` in your projects terminal.

## Expected Behaviour. (USERS' GUIDE)
### View Main Landing Page.
* Method: GET
* Route: /

{
    message: "Welcome to the main page of Organisation news api.."
}

- The returned Json is as seen above.

### View Departments
* Method: GET
* Route: `/department`

### View Departments by ID
* Method: GET
* Route: `/department/:id`

### Add Department
* Method: POST
* Route: `/department/new`

- Add a new department.

### View Users by ID
* Method: GET
* Route: `/users/:id`

### Add user
* Method: POST
* Route: `/users/new`

## Technologies Used
- Java
- Java Spark*
- PostgreSQL
- Postman

## Bugs
~ At the moment there are no known bugs, but that is as if you come across any bug or functionality that fails, please feel free to reach out.

## Contact Information
~ For any inquiries or future git collaborative projects, reach out to:

Email: <a href="mailto:muthakabrian@gmail.com>muthakabrian@gmail.com </a>

## LICENSE
Copyright 2020 Brian Muthaka

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
