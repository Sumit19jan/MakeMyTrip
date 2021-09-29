package com.example.makemytrip.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class FlightResponseDTO implements Serializable {

	@SerializedName("price")
	private int price;

	@SerializedName("destination")
	private String destination;

	@SerializedName("name")
	private String name;

	@SerializedName("endtime")
	private String endtime;

	@SerializedName("source")
	private String source;

	@SerializedName("id")
	private int id;

	@SerializedName("starttime")
	private String starttime;

	@SerializedName("body")
	private String body;

	@SerializedName("email")
	private String email;

	public void setPrice(int price){
		this.price = price;
	}

	public int getPrice(){
		return price;
	}

	public void setDestination(String destination){
		this.destination = destination;
	}

	public String getDestination(){
		return destination;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setEndtime(String endtime){
		this.endtime = endtime;
	}

	public String getEndtime(){
		return endtime;
	}

	public void setSource(String source){
		this.source = source;
	}

	public String getSource(){
		return source;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setStarttime(String starttime){
		this.starttime = starttime;
	}

	public String getStarttime(){
		return starttime;
	}

	public void setBody(String body){
		this.body = body;
	}

	public String getBody(){
		return body;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	@Override
 	public String toString(){
		return 
			"FlightResponseDTO{" + 
			"price = '" + price + '\'' + 
			",destination = '" + destination + '\'' + 
			",name = '" + name + '\'' + 
			",endtime = '" + endtime + '\'' + 
			",source = '" + source + '\'' + 
			",id = '" + id + '\'' + 
			",starttime = '" + starttime + '\'' + 
			",body = '" + body + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}
}