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
 
//package simulated.annealing;

import java.util.ArrayList;

/*
* TourManager.java
* Holds and keeps track of the cities of a tour
*/


public class TourManager {

    // Holds our cities
    private static ArrayList<City> destinationCities = new ArrayList<City>();

    /**
	 * Adds a destination city
	 * @param city
	 */
	public static void addCity(City city) {
		destinationCities.add(city);
	}

	/**
	 * returns a city given its index
	 * @param index
	 * @return city the city at index 
	 */
	public static City getCity(int index){
		return (City)destinationCities.get(index);
	}

	/**
	 * Returns the number of destination cities 
	 * @return size the number of destination cities
	 */
	public static int numberOfCities(){
		return destinationCities.size();
	}
    
}
