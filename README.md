# parking
assignment 3  for Software Design

## Project Classes
This project has classes ParkingLot, Car, Ticket, Gate, EntranceGate, ExitGate
The EntranceGate and ExitGate classes are subclasses of Gate

### Parking Lot
The ParkingLot has members gates, capacity, occupancy, price, profit, and name
The ParkingLot handles the movement of cars in/out of the lot through its gates and keeps track of profits and current occupancy

### Car
The Car has members license and ticket, the ticket is null is the car is not currently in a lot

### Ticket
The Ticket has members price, car, lot, and timestamp to keep track of its price, the car it belongs to, the lot it is in, and the timestamp of when the car entered the lot

### Gate
The Gate has members type, lot, and number to keep track of its type (entrance or exit), the lot it belongs to, and its number

### Entrance Gate
The Entrance Gate extends Gate and has methods to allow for a car to enter a lot if it is not at capacity

### Exit Gate
the Exit Gate extends Gate and has member functions to allow for a car to exit a lot

## Project Driver
The Driver program for this project reads input from a text file and controls the operations.
the program will output information about the lots, gates, and cars added.
It will then output information about the actions being performed.
The driver handles invalid input file formatting, the classes handle invalid actions (i.e. a car trying to enter a lot through an exit gate).

## Input File Format
The input file must have the following format:  

The first line must read "Parking Lots"  
The next lines represent the parking lots, they must have a string for the name of the lot followed by an integer for the capacity of the lot, followed by an integer for the price (in cents) or the lot, followed by and integer for the number of entrance gates, and finally an integer for the number of exit gates.  

This is followed by a blank line and then the line  
"Cars" 
The next lines each have one integer representing each car (the integer is its license plate)

This is followed by another blank like and then the line  
"Actions"
The next lines have the actions occurring. These follow the format of an integer which is the license plat of the car performing the action, 
followed by a string which reads either "Exit" or "Enter", corresponding to the action to be performed, 
followed by a string which corresponds to the name of the parking lot this action is being performed at, 
and finally another integer corresponding to the gate number this action is happening at. The gates are numbered
such that the entrance gates are 1-the number of entrance gates, and the exit gates are numbered starting from 
1+the number of entrance gates - the total number of gates, for example if we had 1 entrance and 2 exits they would be numbered
1, 2, 3, with 1 being the entrance and 2,3 being the exits.

### Example Input File
Parking Lots  
A 1 50 1 2  
B 100 10 2 2 

Cars  
12345  
67891 

Actions  
12345 Enter A 1  
12345 Exit A 2

//Here there is a lot A with 1 spot, 50 cents to park, 1 entrance gate, and 2 exit gates
 and a lot B with 100 spots, 10 cents to park, 2 entrance gates (gates 1 and 2), and 2 exit gates (gates 3 and 4)  
//There are 2 cars with licence plates 12345 and 67891  
//Car 12345 enters lot A through gate 1 and then exits lot A through gate 2

## Output
At any point if the input file is incorrectly formatted, the program will notify you and then end.  
The program will output information about each lot created, each gate created, and each car created.    
After all lots, gates, and cars have been created, the program will output the actions occurring. 
If there is an issue with the input that does not have to do with formatting (i.e. a car tries to enter a lot through 
an exit gate or a car tries to enter a lot that is full) then the issue will be output but 
the program will handle this issue and continue to run.  
Once the program reaches the end of the actions, it will output the total profit of each lot and then end.

## Sample Inputs
There are 5 sample inputs. Each one showcases different aspects of the program.

### Sample Input 1
This sample shows a program which doesn't encounter any issues when running. This sample 
showcases the programs ability to handle multiple cars, multiple lots, and cars 
entering and exiting one lot and then subsequently entering and exiting another 
with a new ticket.


### Sample Input 2
This sample shows the case where a car is attempting to enter through an exit gate. 
In the first action, car 1 is attempting to enter lot A through gate 2 (which is an exit gate). 
The program notifies you via output that the input is invalid and does not allow 
car 1 to enter lot A. The program then continues to run with car 1 entering lot 
A through gate 1 which is an entrance.


### Sample Input 3
This sample shows the case where a car is attempting to enter a lot that is already at max capacity. 
This occurs in the 2nd action when are 2 tries to enter lot A even though A only has a capacity 
of 1 and already has 1 car in it. The program does not allow car 2 to enter and notifies via 
output. Once car 1 leaves the lot, car 2 is then able to enter the lot.


### Sample Input 4
This sample shows the case where an illegal action occurs, in the 3rd action, car 1 is attempting to 
enter lot B even though it is already in lot A. The program notifies via output that 
car 1 is already in a lot and can't enter another lot, and then continues to run.


### Sample Input 5
This sample shows the case where the input file is not formatted correctly 
and causes the program to terminate. The issue lies in the fact that first car that is attempting to perform an action 
does not exist (there is no car with the licence number 3).


## Compiling and Running the Program
This program is a maven project which creates a jar executable, to compile it in command line, first navigate to the project folder, then enter  

*mvn clean package*

Next, navigate into the newly created target folder

*cd target*

Next you will run the executable jar with the path and name of the input file as an input argument

*java -jar parking-0.0.1-SNAPSHOT.jar "C:\...\sampleinput1.txt"*  

//Here, you need to replace *"C:\...\sampleinput1.txt"* with the actual location of the input file