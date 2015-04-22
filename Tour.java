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
* Class Tour.java 
* This class represents a tour (a candidate solution) through all cities
*/

package simulated.annealing;

import java.util.ArrayList;
import java.util.Collections;

/*
* Tour.java
* Models a traveling salesman tour
* Stores a candidate tour through all cities
*/

public class Tour{

    //to hold a tour of cities
    private ArrayList<City> tour = new ArrayList<City>();
    
    //we assume initial value of distance is 0 
    private int distance = 0;
    
    //Constructor
    //starts an empty tour
    public Tour(){
        for (int i = 0; i < TourManager.numberOfCities(); i++) {
            tour.add(null);
        }
    }
    
    //another Constructor
    //starts a tour from another tour
    @SuppressWarnings("unchecked")
	public Tour(ArrayList<City> tour){
        this.tour = (ArrayList<City>) tour.clone();
    }
    
    /**
      Returns tour information
      @return currenttour
     */
    public ArrayList<City> getTour(){
        return tour;
    }
     
    /**
     * Creates a random tour (i.e. individual or candidate solution)
     */
    public void generateIndividual() {
        // Loop through all our destination cities and add them to our tour
        for (int cityIndex = 0; cityIndex < TourManager.numberOfCities(); cityIndex++) {
          setCity(cityIndex, TourManager.getCity(cityIndex));
        }
        // Randomly reorder the tour
        Collections.shuffle(tour);
    }

    /**
     * Returns a city from the tour given the city's index
     * @param index
     * @return City at that index
     */
    public City getCity(int index) {
        return tour.get(index);
    }

    /**
     * Sets a city in a certain position within a tour
     * @param index
     * @param city
     */
    public void setCity(int index, City city) {
        tour.set(index, city);
        // If the tour has been altered we need to reset the fitness and distance
        distance = 0;
    }
    
    /**
     * Computes and returns the total distance of the tour
     * @return distance total distance of the tour
     */
    public int getTotalDistance(){
    	if (distance == 0) {
            int tourDistance = 0;
            // Loop through our tour's cities
            for (int cityIndex=0; cityIndex < tourSize(); cityIndex++) {
                // Get city we're traveling from
                City fromCity = getCity(cityIndex);
                // City we're traveling to
                City destinationCity;
                // Check we're not on our tour's last city, if we are set our
                // tour's final destination city to our starting city
                if(cityIndex+1 < tourSize()){
                    destinationCity = getCity(cityIndex+1);
                }
                else{
                    destinationCity = getCity(0);
                }                
                // Get the distance between the two cities
                tourDistance += Utility.distance(fromCity, destinationCity); 
            }
            distance = tourDistance;
        }
        return distance;
    }

    /**
     * Get number of cities on our tour
     * @return number how many cities there are in the tour!
     */
    public int tourSize() {
        return tour.size();
    }
    
    @Override
    /**
     * To print out a list of all the cities in the tour
     */
    public String toString() {
        String s = getCity(0).getCityName();
        for (int i = 1; i < tourSize(); i++) {
            s += " -> " + getCity(i).getCityName();
        }
        return s;
    }
}
    
