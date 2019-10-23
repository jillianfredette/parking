# parking
assignment 3  for Software Design

## Project Classes
This project has classes ParkingGroup, ParkingLot, Car, Ticket, Gate, EntranceGate, ExitGate
The EntranceGate and ExitGate classes are subclasses of Gate

### Parking Group
Tha ParkingGroup has members price, discount, and name.
The ParkingGroup handles pricing of the lots and inquiries into pricing.

### Parking Lot
The ParkingLot has members entrance and exit gates, capacity, occupancy, profit, and name
The ParkingLot handles the movement of cars in/out of the lot through its gates and inquiries into space availability and keeps track of profits and current occupancy

### Car
The Car has members license and ticket, the ticket is null is the car is not currently in a lot

### Ticket
The Ticket has members price, car, lot, and timestamp to keep track of its price, the car it belongs to, the lot it is in, and the timestamp of when the car entered the lot

### Gate
The Gate has members type (entrance or exit) and the lot it belongs to

### Entrance Gate
The Entrance Gate extends Gate and has methods to allow for a car to enter a lot if it is not at capacity

### Exit Gate
the Exit Gate extends Gate and has member functions to allow for a car to exit a lot

## Project Driver
The Driver program for this project reads input from a text file and controls the operations.
the program will output information about the parking groups, lots, and cars added.
It will then output information about the actions being performed.
The driver handles invalid input file formatting, the classes handle invalid actions (i.e. a car trying to enter a lot that is already full).

## Input File Format
The input file must have the following format:  

The first line must read "Parking Groups"  
The next lines represent the parking groups, the must have the name, followed by the price (in cents), followed by the discount (as a percent, from 0 to 100)

This is followed by a blank line and then a line that must read "Parking Lots"  
The next lines represent the parking lots, they must have a string for the name of the lot followed by the name of the group that lot belongs to, followed by the capacity of the lot 

This is followed by a blank line and then the line  
"Cars" 
The next lines each have one string representing each car (the string is its license plate)

This is followed by another blank like and then the line  
"Actions"
The next lines have the actions occurring. The four possible actions are 'Enter', 'Exit', 'Inquire Price', and 'Inquire Space'.  
For each action, the first string is the licence of the car performing the action, followed by either one more string for 'Enter' or 'Exit'
(the car class handles finding an available lot with the lowest price to enter, and handles exiting the lot the car is in), or three more 
strings that to either inquire about the price for a group or the space for a lot. This has the format of either 
'Inquire Price GroupName' or 'Inquire Space LotName', replacing the GroupName or LotName with the name of the group/lot that is being inquired about.


### Example Input File
Parking Groups
GroupA 500 0
GroupB 100 20

Parking Lots  
LotA GroupA 100
LotB GroupB 200

Cars  
Car1
Car2

Actions  
Car1 Inquire Price GroupA
Car1 Inquire Space LotB
Car1 Park
Car2 Park
Car2 Exit
Car1 Exit

//Here the are two parking groups, GroupA with a price of 500 cents and a discount of 0% and 
GroupB with a price of 100 cents and discount of 20%
//Next are the Parking Lots, LotA that belongs to GroupA and has a capacity of 100, and LotB that 
belongs to GroupB and has a capacity of 200
//Next are two cars, Car1 and Car2
//And finally the actions, in the first action Car1 inquires the price for GroupA, in the second 
actions Car 1 inquires the space available in LotB, and the rest of the actions are the cars parking and exiting the lots.

## Output
At any point if the input file is incorrectly formatted, the program will notify you and then end.  
The program will output information about each group created, each lot created, and each car created.    
After all groups, lots, and cars have been created, the program will output the actions occurring. 
If there is an issue with the input that does not have to do with formatting (i.e. a car tries to enter a gate when it is already in one, or
a car tries to exit a lot when it is not in one) then the issue will be output but 
the program will handle this issue and continue to run.  
Once the program reaches the end of the actions, it will output the total profit of each lot and then end.

## Sample Inputs
There are 5 sample inputs. Each one showcases different aspects of the program.

### Sample Input 1
This sample shows a program which doesn't encounter any issues (formatting or otherwise) when running. 
This sample showcases the programs ability to handle multiple cars, multiple lots, multiple groups, and cars 
entering and exiting one lot and then subsequently entering and exiting another 
with a new ticket.


### Sample Input 2
This sample shows the case where a car is attempting to enter a lot when there are not spaces 
available in any lot. In action 5 Car3 attempts to park, but since Car1 and Car2 are already parked
and there is only one spot in each lot, Car3 is unable to park.


### Sample Input 3
This sample shows the case where an illegal action occurs,
a car is attempting to enter a lot when it is already in another lot.
At action 5, Car1 is attempting to enter a lot when it is already in LotB, it is denied the ability to 
park in two lots at once. The program notifies via output that 
Car1 is already in a lot and can't enter another lot, and then continues to run.


### Sample Input 4
This sample shows the case where an illegal action occurs, in the 5th action, Car3 is attempting to exit 
even though it never parked and is not in a lot. The program notifies via output that Car3 can't exit a 
lot when it isn't in one and continues to run.


### Sample Input 5
This sample shows the case where the input file is not formatted correctly 
and causes the program to terminate. 
The issue lies in the fact that LotA is trying to be added to GroupC, but there is not GroupC.
The program notifies the user via output of the issue and then terminates.


## Compiling and Running the Program
This program is a maven project which creates a jar executable, to compile it in command line, first navigate to the project folder, then enter  

*mvn clean package*

Next, navigate into the newly created target folder

*cd target*

Next you will run the executable jar with the path and name of the input file as an input argument

*java -jar parking-0.0.1-SNAPSHOT.jar "...\sampleinput1.txt"*  

//Here, you need to replace *"...\sampleinput1.txt"* with the actual location of the input file