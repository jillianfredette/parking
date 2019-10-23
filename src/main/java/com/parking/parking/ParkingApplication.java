package com.parking.parking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

@SpringBootApplication
public class ParkingApplication {

	public static void main(String[] args) throws Exception{

		SpringApplication.run(ParkingApplication.class, args);

		//open up file, name passed as a command line arg
		File file = new File(args[0]);
		BufferedReader reader = new BufferedReader(new FileReader(file));

		HashMap<String, ParkingGroup> groups = new HashMap<String, ParkingGroup>();
		HashMap<String, ParkingLot> parkingLots = new HashMap<String, ParkingLot>();
		HashMap<String, Car> cars = new HashMap<String, Car>();

		//read in each line
		String curr;

		try {
			//get Parking Groups
			if ((curr = reader.readLine()).equals("Parking Groups")){
				while((curr = reader.readLine()).length() > 0){
					String[] group = curr.split(" ");
					if(group.length > 3) throw new Exception();

					//create parking group
					if(groups.containsKey(group[0])){
						System.out.println("Group "+group[0]+" already exists");
						throw new Exception();
					}
					String newgroup = group[0];
					int price = Integer.parseInt(group[1]);
					int discount = Integer.parseInt(group[2]);
					//check for correct input
					if(price < 0){
						System.out.println("Price cannot be negative");
						throw new Exception();
					}
					if(discount < 0){
						System.out.println("Discount cannot be negative");
						throw new Exception();
					}
					if(discount > 100){
						System.out.println("discount cannot be more than 100 percent");
						throw new Exception();
					}
					groups.put(newgroup, new ParkingGroup(newgroup, price, discount));
				}
				System.out.println("");
			}
			else throw new Exception();

			//get Parking Lots
			if ((curr = reader.readLine()).equals("Parking Lots")) {
				while((curr = reader.readLine()).length() > 0){
					String[] lot = curr.split(" ");
					if (lot.length > 3) throw new Exception();
					String newlot = lot[0];
					String group = lot[1];
					int capacity = Integer.parseInt(lot[2]);

					//create parking lot
					if(parkingLots.containsKey(lot[0])){
						System.out.println("Lot "+newlot+" already exists");
						throw new Exception();
					}
					if(!groups.containsKey(lot[1])){
						System.out.println("Group "+group+" does not exist");
						throw new Exception();
					}
					if(capacity < 0){
						System.out.println("Capacity of a lot cannot be negative");
						throw new Exception();
					}
					parkingLots.put(newlot, new ParkingLot(groups.get(group), newlot, capacity));
				}
				System.out.println("");
			}
			else throw new Exception();

			//get Cars
			if ((curr = reader.readLine()).equals("Cars")) {
				while((curr = reader.readLine()).length() > 0){
					//add car
					if(cars.containsKey(curr)){
						System.out.println("Car "+curr+" already exists");
						throw new Exception();
					}
					cars.put(curr, new Car(curr));
				}
				System.out.println("");
			}
			else throw new Exception();

			if ((curr = reader.readLine()).equals("Actions")) {
				while((curr = reader.readLine()) != null && curr.length() > 0){
					//process action
					String[] action = curr.split(" ");
					String car = action[0];
					String act = action[1];

					//if park or exit
					if(action.length == 2){
						if (act.equals("Park")) cars.get(car).park(parkingLots);
						else if(act.equals("Exit")) cars.get(car).exit();
						else throw new Exception();
					}
					//if inquire
					else if( action.length == 4){
						if(!act.equals("Inquire")) throw new Exception();
						String actTwo = action[2];
						//price or space inquiry
						if(actTwo.equals("Price")){
							String group = action[3];
							cars.get(car).inquirePrice(groups.get(group));
						}
						else if (actTwo.equals("Space")){
							String lot = action[3];
							cars.get(car).inquireSpace(parkingLots.get(lot));
						}
						else throw new Exception();

					}
					//else, error in input file
					else throw new Exception();
					System.out.println("");
				}
				System.out.println("");
			}
			else throw new Exception();

			for(HashMap.Entry<String, ParkingLot> entry : parkingLots.entrySet()){
				System.out.println("Parking Lot "+entry.getKey()+" has made a profit of "+entry.getValue().profit+" cents");
			}
		}
		catch (Exception e){
			System.out.println("\nInvalid Input File Format\nProgram Ended");
		}


	}

}
