# WeatherWizard
Authors and Contributors: Sophie L., Linhao L., Harmanpreet S. and Ishayu S.

WeatherWizard aims to provide users with a friendly accessible application to access Weather around the World. It can be used to plan trips, figure out historical weather data for projects and more. Many users have to use several tabs to compare weather in different destinations and this application aims to help users plan travel. 

## Table of Contents
1. [Features of Software](#features-of-software)
2. [API](#api)
3. [Installation](#installation)
   - [Common Installation Issues](#common-installation-issues)
4. [Usage Guide](#usage-guide)
5. [License and Copyright Notice](#license-and-copyright-notice)
6. [Contributions](#contributions)
7. [Feedback](#feedback)
8. [Accessibility](#accessibility)
9. [Want to Know More?](#want-to-know-more)

## Features of Software.
As mentioned previously the broad overarching sense of purpose lays in the ease in checking weather. The Software provides general information about the weather, humidity, windspeed, Visibility and sky condition. Asides from that, the application has the following features. 
* Accessible Map: The Software uses the JXMAP library to display a map that shows the location of the city. 
* Unit Conversion: The Software supports both Metric and Imperial Unit Conversion.
* Weather Alerts: The Software displays Emergency Alerts regarding the weather including but not limited to Flooding, Tornado, Snow Storms and etc.
* Nearby Cities: The Software displays a list of cities close to the main destination. 
* Comparisons: The Software allows for users to select up to two cities at a time to compare weather.
* Search History: The Software allows for the User to view their Search History.

## API.
The OpenWeather 3.0 API is called by city name to recieve weather information regarding temperature, humidity, windspeed & etc. 
   https://openweathermap.org/api/one-call-3
   
The JXMAP library is used to produce a map in which the user can drag and drop pins on cities.
msteiger/jxmapviewer2: JXMapViewer2 

## Installation.
The steps for Installation are as follows. 
1. Download the Java Development Kit (JDK) 17+, Apache Maven 3.8+ and an IDE of your choice (the instructions use Intellij).
2. Clone the repository by Opening IntelliJ and selecting File, then  New,  then Project from Version Control. Choose Git and in this drop box paste the repository link (press the green code button on Github to copy the repository link). Choose a directory of your choice and click clone.
3. Configure the project by going to File > Project Structure > Project Settings > Project. Here you should see what SDKs are setup. If you do not see the SDKs mentioned in step one, add them.
4.  Go to https://openweathermap.org/api/one-call-3 and obtain your own API key and replace with the one provided. Make sure to wait at least 7 hours as the API key activates several hours after creation.

### Common Installation Issues
* "Maven dependencies not resolved"
  Go to the Maven Tool window and press Reload All Maven Project. 
*  "Java Version Mismatch"
  Go to File > Project Structure > Project and download Java 17. 
*  "The Map is not Visible"
  Ensure that JXMapViewer2 library is downloaded in the pom.xml file, if not add it.

## Usage Guide
To use the software, navigate to the MainApplication file in Intellij located under the App folder.  ( Src > Main > Java > App > MainApplication) and press the run file button. 

## License and Copyright notice.
This project is protected by Canadian copyright law. Under the Copyright Act (RSC 1985, c. C-42), the content of this repository, including but not limited to source code, documentation, and other original works, is automatically protected by copyright as soon as it is created and fixed in a tangible form. All rights to the work are reserved to the original author(s) unless explicitly stated otherwise.

## Contributions
Contributions to this code are welcomed. If you would like to contribute, please ensure that the original authors are properly credited, you are welcome to create a pull request, that will be reviewed by the authors of this work. 

To make a fork on Github, press the fork button located across from the Project Name.

<img width="1029" alt="image" src="https://github.com/user-attachments/assets/8fbb1531-0ba8-4f53-a524-2f6960f47031">


## Feedback
Any and all feedback on this project is much appreciated. To provide your feedback, please visit the following typeform.

[Feedback Form](https://3g4dr8ponwb.typeform.com/to/XWR9pbZm)

If an email is provided, our team will contact you within 24 hours.

## Accessibility
The project aims to be accessible to everyone as much as possible and thus has several features to ensure such. For more information, please check out our accessibility report by navigating to the accessibility-report.md file. 

## Want to know more?
If you would like to know more please check out our presentation.
[Link to the Presentation](https://docs.google.com/presentation/d/1IjYeUM8Xk1bz7U48yP0Gn7wzcsYZ_4zVC14HXEVRnKU/edit?usp=sharing)
