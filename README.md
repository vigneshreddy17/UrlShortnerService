# URL Shortener Service

The URL Shortener Service is a simple application that allows users to shorten long URLs into shorter, more manageable links.

## Features
-> Shorten long URLs into tiny URLs.
-> Customizable expiration date for generated URLs.
-> Simple and intuitive REST API for integration.

## Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

## Prerequisites
Java Development Kit (JDK) installed on your machine
Apache Maven for building the project
Git for cloning the repository

## Installation
Clone the repository:
git clone https://github.com/vigneshreddy17/UrlShortnerService.git

## Navigate to the project directory:
cd UrlShortnerService

### Build the project using Maven:
mvn clean install

### Run the application:
java -jar target/UrlShortnerService.jar

### Usage
To use the URL Shortener Service, you can call the generate endpoint using the Postman to send a POST request with the long URL in the request body. The service will respond with a shortened URL.

### Example:

Request:
{
  "url": "https://www.google.com"
}

Response:
{
				"tinyUrl": "360efda7",
        "creationDate": "2024-02-20T12:45:47.063382",
        "expirationDate": "2024-02-20T12:55:47.063382"
}

## Continuous Integration
Continuous integration is set up using GitHub Actions. Whenever a new pull request is opened, the CI workflow will be triggered to run tests and ensure code quality before merging.

## Docker
Created a docker image for the service and published the image onto docker hub https://hub.docker.com/repository/docker/vigneshreddy17/url-shortner-service/general

## Contributing
Contributions are welcome! Please feel free to open a pull request or submit an issue if you encounter any problems or have suggestions for improvements.

## License
This project is licensed under the MIT License - see the LICENSE file for details.
