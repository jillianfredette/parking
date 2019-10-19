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

		HashMap<String, ParkingLot> parkingLots = new HashMap<String, ParkingLot>();
		HashMap<Integer, Car> cars = new HashMap<Integer, Car>();

		//read in each line
		String curr;

		try {
			//get Parking Lots
			if ((curr = reader.readLine()).equals("Parking Lots")) {
				while((curr = reader.readLine()).length() > 0){
					String[] lot = curr.split(" ");

					//create parking lot
					parkingLots.put(lot[0], new ParkingLot(lot[0], Integer.parseInt(lot[1]), Integer.parseInt(lot[2])));

					//add entrance gates
					for(int i = 1; i <= Integer.parseInt(lot[3]); i++){
						parkingLots.get(lot[0]).addEntrance(i);
					}

					//add exit gates
					for(int i = 1; i <= Integer.parseInt(lot[4]); i++){
						parkingLots.get(lot[0]).addExit(i+Integer.parseInt(lot[3]));
					}
					System.out.println("");
				}
				System.out.println("");
			}
			else throw new Exception();

			//get Cars
			if ((curr = reader.readLine()).equals("Cars")) {
				while((curr = reader.readLine()).length() > 0){
					//add car
					cars.put(Integer.parseInt(curr), new Car(Integer.parseInt(curr)));
				}
				System.out.println("\n");
			}
			else throw new Exception();

			//process Actions
			if ((curr = reader.readLine()).equals("Actions")) {
				while((curr = reader.readLine()) != null && curr.length() > 0){
					//process action
					String[] action = curr.split(" ");
					int car = Integer.parseInt(action[0]);
					String act = action[1];
					String lot = action[2];
					int gate = Integer.parseInt(action[3]);
					if(act.equals("Enter")){
						if(!parkingLots.get(lot).Enter(cars.get(car), gate)){
							System.out.println("Car "+ car+" is unable to enter Lot "+lot+" throw gate "+gate);
						}
					}
					else if(act.equals("Exit")){
						if(!parkingLots.get(lot).Exit(cars.get(car), gate)){
							System.out.println("Car "+ car+" is unable to exit Lot "+lot+" throw gate "+gate);
						}
					}
					else throw new Exception();
				}
				System.out.println("\n");
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
