![NTNU logo](https://qore.no/res/ntnu-logo-100.png)

# Prosjekt - TDT4145, Gruppe 40
https://github.com/rosvik/ntnu-tdt4145-database-project

# Installation

### How to add test-data to database
1. Open MySQL Workbench
2. Find the file named "workoutdiary.sql" locally on your computer
3. Open the file in MySQL Workbench
4. Execute the file
5. Make sure that the workoutdiary database has appeared

### Update database credentials
1. Open the file named config.conf
2. Replace 'username' on line 1 and 'password' on line 2 with the credentials to your database
3. If your database's location isn't local, replace the url with an appropriate url

# Running

### MacOS:
1. Open Terminal.app
2. Navigate to the project folder
	```
	cd location/of/workoutdiary/project
	```
3. Run `./workout-diary [data]` where [data] is replaced by one of the examples below.
4. Run `./workout-diary help` to get a list of possible commands

### Windows
1. Open cmd.exe
2. Navigate to the project folder
	```
	cd location/of/workoutdiary/project
	```
3. Run `workout-diary.bat [data]` where [data] is replaced by one of the examples below.
4. Run `workout-diary.bat help` to get a list of possible commands

# Examples

### List
```
list workout 5
list exercise 2012-04-25 2018-04-27
list group "Bulking"
list equipment 2012-04-25 2018-04-27
```
### Add
```
add workout 2018-04-25 11:45:23 8 "Fin tur i skogen"
add exercise "Fjelltur" "Gå en tur i fjellet"
add equipment "Spaserstokk" "Stav som gir stabilitet"
add group "Rolig beilmuskulaturvedlikehold"
```

### Connect
```
connect exercise 3 1 23 9
connect equipment 1 1 50 10
connect group 2 3
```
