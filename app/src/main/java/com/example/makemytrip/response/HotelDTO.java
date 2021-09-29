package com.example.makemytrip.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class HotelDTO implements Serializable {

	@SerializedName("id")
	private String id;

	@SerializedName("name")
	private String name;

	@SerializedName("price")
	private int price;

	@SerializedName("address")
	private String address;

	@SerializedName("storiesimage")
	private String storiesimage;

	@SerializedName("star")
	private int star;

	@SerializedName("name1")
	private String name1;

	@SerializedName("adventurousimage")
	private String adventurousimage;

	@SerializedName("adventurouplace")
	private String adventurouplace;

	@SerializedName("wanderlustimage")
	private String wanderlustimage;

	@SerializedName("wanderlustplace")
	private String wanderlustplace;

	@SerializedName("interestimage")
	private String interestimage;

	@SerializedName("interestplace")
	private String interestplace;

	@SerializedName("hiddengemvideo")
	private String hiddengemvideo;

	@SerializedName("hiddengemplace")
	private String hiddengemplace;

	@SerializedName("hotel_image_url")
	private String hotelImageUrl;

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setPrice(int price){
		this.price = price;
	}

	public int getPrice(){
		return price;
	}

	public void setAddress(String address){
		this.address = address;
	}

	public String getAddress(){
		return address;
	}

	public void setStoriesimage(String storiesimage){
		this.storiesimage = storiesimage;
	}

	public String getStoriesimage(){
		return storiesimage;
	}

	public void setStar(int star){
		this.star = star;
	}

	public int getStar(){
		return star;
	}

	public void setName1(String name1){
		this.name1 = name1;
	}

	public String getName1(){
		return name1;
	}

	public void setAdventurousimage(String adventurousimage){
		this.adventurousimage = adventurousimage;
	}

	public String getAdventurousimage(){
		return adventurousimage;
	}

	public void setAdventurouplace(String adventurouplace){
		this.adventurouplace = adventurouplace;
	}

	public String getAdventurouplace(){
		return adventurouplace;
	}

	public void setWanderlustimage(String wanderlustimage){
		this.wanderlustimage = wanderlustimage;
	}

	public String getWanderlustimage(){
		return wanderlustimage;
	}

	public void setWanderlustplace(String wanderlustplace){
		this.wanderlustplace = wanderlustplace;
	}

	public String getWanderlustplace(){
		return wanderlustplace;
	}

	public void setInterestimage(String interestimage){
		this.interestimage = interestimage;
	}

	public String getInterestimage(){
		return interestimage;
	}

	public void setInterestplace(String interestplace){
		this.interestplace = interestplace;
	}

	public String getInterestplace(){
		return interestplace;
	}

	public void setHiddengemvideo(String hiddengemvideo){
		this.hiddengemvideo = hiddengemvideo;
	}

	public String getHiddengemvideo(){
		return hiddengemvideo;
	}

	public void setHiddengemplace(String hiddengemplace){
		this.hiddengemplace = hiddengemplace;
	}

	public String getHiddengemplace(){
		return hiddengemplace;
	}

	public void setHotelImageUrl(String hotelImageUrl){
		this.hotelImageUrl = hotelImageUrl;
	}

	public String getHotelImageUrl(){
		return hotelImageUrl;
	}

	@Override
 	public String toString(){
		return 
			"HotelDTO{" + 
			"id = '" + id + '\'' + 
			",name = '" + name + '\'' + 
			",price = '" + price + '\'' + 
			",address = '" + address + '\'' + 
			",storiesimage = '" + storiesimage + '\'' + 
			",star = '" + star + '\'' + 
			",name1 = '" + name1 + '\'' + 
			",adventurousimage = '" + adventurousimage + '\'' + 
			",adventurouplace = '" + adventurouplace + '\'' + 
			",wanderlustimage = '" + wanderlustimage + '\'' + 
			",wanderlustplace = '" + wanderlustplace + '\'' + 
			",interestimage = '" + interestimage + '\'' + 
			",interestplace = '" + interestplace + '\'' + 
			",hiddengemvideo = '" + hiddengemvideo + '\'' + 
			",hiddengemplace = '" + hiddengemplace + '\'' + 
			",hotel_image_url = '" + hotelImageUrl + '\'' + 
			"}";
		}
}