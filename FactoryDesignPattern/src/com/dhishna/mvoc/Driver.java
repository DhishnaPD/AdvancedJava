package com.dhishna.mvoc;

public class Driver {

	public static void getInfo(Computer computer) {
		System.out.println("===================================");
		System.out.println("Model : "+computer.getModel());
		System.out.println("CPU : "+computer.getCPU());
		System.out.println("RAM : "+computer.getRam());
		System.out.println("HDD : "+computer.getHDD());
		System.out.println("SSD : "+computer.getSSD());
		System.out.println("Price : Rs."+computer.getPrice());
		System.out.println("===================================");
		}
		public static void main(String[] args) {
		Computer computer1 = ComputerFactory.getComputer("pc", "HP Omen", "16GB DDR4","1TB @ 7200RPM", "512GB NvME","Intel core i7 13000K", 90000.00);
		Computer computer2 = ComputerFactory.getComputer("server", "HP Server 5400HS","512GB DDR4", "100TB @ 7200RPM", "10TB NvME","AMD Threadripper 3900X", 390000.00);
		getInfo(computer1);
		getInfo(computer2);
		}
		}


