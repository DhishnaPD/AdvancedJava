package com.dhishna.mvoc;

public class Server implements Computer{
private String ram;
private String model;
private String hdd;
private String cpu;
private String ssd;
public double price;
@Override
public String getModel() {
// TODO Auto-generated method stub
return this.model;
}
@Override
public String getRam() {
// TODO Auto-generated method stub
return this.ram;
}
@Override
public String getHDD() {
// TODO Auto-generated method stub
return this.hdd;
}
@Override
public String getCPU() {// TODO Auto-generated method stub
	return this.cpu;
	}
	@Override
	public String getSSD() {
	// TODO Auto-generated method stub
	return this.ssd;
	}
	@Override
	public double getPrice() {
	// TODO Auto-generated method stub
	return this.price;
	}
	public Server(String ram, String model, String hdd, String cpu, String ssd, double price) {
	super();
	this.ram = ram;
	this.model = model;
	this.hdd = hdd;
	this.cpu = cpu;
	this.ssd = ssd;
	this.price = price;
	}
	}
