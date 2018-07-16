package com.example.bean;

import org.springframework.stereotype.Component;

@Component
public class Station {
	
	
	private String stationId;
	private String name;
	private boolean hdEnabled;
	private String callSign;
	
	public Station()
	{
		
	}
	
	
	public Station(String stationId, String name, boolean hdEnabled, String callSign) {
		super();
		this.stationId = stationId;
		this.name = name;
		this.hdEnabled = hdEnabled;
		this.callSign = callSign;
	}
	
	public String getStationId() {
		return stationId;
	}
	public void setStationId(String stationId) {
		this.stationId = stationId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isHdEnabled() {
		return hdEnabled;
	}
	public void setHdEnabled(boolean hdEnabled) {
		this.hdEnabled = hdEnabled;
	}
	public String getCallSign() {
		return callSign;
	}
	public void setCallSign(String callSign) {
		this.callSign = callSign;
	}

	@Override
	public String toString() {
		return "Station [stationId=" + stationId + ", name=" + name + ", hdEnabled=" + hdEnabled + ", callSign="
				+ callSign + "]";
	}
	
}
