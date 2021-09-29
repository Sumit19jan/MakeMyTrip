package com.example.makemytrip.response;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ResponseDTO implements Serializable {

	@SerializedName("hotel")
	private List<HotelDTO> hotel;

	public void setHotel(List<HotelDTO> hotel){
		this.hotel = hotel;
	}

	public List<HotelDTO> getHotel(){
		return hotel;
	}

	@Override
 	public String toString(){
		return 
			"ResponseDTO{" + 
			"hotel = '" + hotel + '\'' + 
			"}";
		}
}