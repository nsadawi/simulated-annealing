/**
 * Using Simulated Annealing to attempt solving the Travelling 
 * Salesman Problem .. TSP
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it as you wish ONLY for legal and ethical purposes
 * 
 * Please watch my explanation:
 * https://www.youtube.com/watch?v=G90qXUDfUzE&list=PLea0WJq13cnCHBp2WW3jtNEEH2pPkwEKw
 * 
 * Code adapted from LeeJackobson's code:
 * http://www.theprojectspot.com/
 *
 * Copyright (C) 2015 
 * @author Dr Noureddin Sadawi 
 *  
 * I ask you only, as a professional courtesy, to cite my name, web page 
 * and my YouTube Channel!
 *  
 */  

/*
* City.java
* Models a city
*/

//package simulated.annealing;

public class City {
    private int x;
    private int y;
    private String cityName;            

    //Constructor
    //creates a city given its name and (x,y) location
	public City(String cityName, int x, int y){
    	this.cityName = cityName;
        this.x = x;
        this.y = y;
    }            
        
    /**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * @param cityName the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
}
