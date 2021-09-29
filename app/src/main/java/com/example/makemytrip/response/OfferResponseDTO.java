package com.example.makemytrip.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class OfferResponseDTO implements Serializable {

	@SerializedName("trainimageurl")
	private String trainimageurl;

	@SerializedName("cabs")
	private String cabs;

	@SerializedName("flightimageurl")
	private String flightimageurl;

	@SerializedName("villaimageurl")
	private String villaimageurl;

	@SerializedName("tranding")
	private String tranding;

	@SerializedName("id")
	private int id;

	public void setTrainimageurl(String trainimageurl){
		this.trainimageurl = trainimageurl;
	}

	public String getTrainimageurl(){
		return trainimageurl;
	}

	public void setCabs(String cabs){
		this.cabs = cabs;
	}

	public String getCabs(){
		return cabs;
	}

	public void setFlightimageurl(String flightimageurl){
		this.flightimageurl = flightimageurl;
	}

	public String getFlightimageurl(){
		return flightimageurl;
	}

	public void setVillaimageurl(String villaimageurl){
		this.villaimageurl = villaimageurl;
	}

	public String getVillaimageurl(){
		return villaimageurl;
	}

	public void setTranding(String tranding){
		this.tranding = tranding;
	}

	public String getTranding(){
		return tranding;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"OfferResponseDTO{" + 
			"trainimageurl = '" + trainimageurl + '\'' + 
			",cabs = '" + cabs + '\'' + 
			",flightimageurl = '" + flightimageurl + '\'' + 
			",villaimageurl = '" + villaimageurl + '\'' + 
			",tranding = '" + tranding + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}