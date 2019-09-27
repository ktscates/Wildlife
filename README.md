# Wildlife - Tracker
#### This application allows Rangers to track wildlife sightings in the area, 27th September 2019
#### By **Cates NSENGIYUMVA**
## Description
 This application allows Rangers to track wildlife sightings in the area. It collect data from rangers about specific animal, the name of animals, its health condition, its location, its estimated age and if it is endangered or not.
## Setup/Installation Requirements
* Go to GitHub account => www.github.com/ktscates
* Go to my repositories
* Select Wildlife.
* Click on the green button labeled: clone or download. you can clone or download it directly into your computer.
* Unzip the folder.
* You should have all the project files.
## BDD
#### In PSQL:
* CREATE DATABASE wildlife;
* CREATE TABLE animals (id serial PRIMARY KEY, name varchar, endangered varchar, health varchar, age varchar);
* CREATE TABLE sightings (id serial, ranger varchar, location varchar, animal_id int, date date);
## Known Bugs
There no bugs in the application.
## Technologies Used
* Java.
* Spark Java.
## Support and contact details
If you run into errors, please feel free to contact me on github.
### License
Copyright (c) 2019 **Cates NSENGIYUMVA**