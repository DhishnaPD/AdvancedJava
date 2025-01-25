package com.dhishna.mvoc;

public class ComputerFactory {
	public static Computer getComputer(String type,String model, String ram, String hdd, String 
			ssd, String cpu, double price) {
			switch(type.toUpperCase()) {
			case "PC":
			return new PersonalComputer(ram, model, hdd, cpu, ssd, price);
			case "SERVER":
			return new Server(ram, model, hdd, cpu, ssd, price);
			default:
			System.out.println("Invalid type : "+type);
			}
			return null;
			}
}


