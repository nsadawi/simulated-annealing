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


public class SimulatedAnnealing {
    
    public static void main(String[] args) {
        // Create and add our cities
        City city = new City("Paris",60, 200);
        TourManager.addCity(city);
        City city2 = new City("Lyon",180, 200);
        TourManager.addCity(city2);
        City city3 = new City("La Rochelle",80, 180);
        TourManager.addCity(city3);
        City city4 = new City("Bordeaux",140, 180);
        TourManager.addCity(city4);
        City city5 = new City("Lenz",20, 160);
        TourManager.addCity(city5);
        City city6 = new City("Nice",100, 160);
        TourManager.addCity(city6);
        City city7 = new City("Lille",200, 160);
        TourManager.addCity(city7);
        City city8 = new City("Rennes",140, 140);
        TourManager.addCity(city8);
        City city9 = new City("Brest",40, 120);
        TourManager.addCity(city9);
        City city10 = new City("Toulon",100, 120);
        TourManager.addCity(city10);        
        City city11 = new City("Nancy",180, 100);
        TourManager.addCity(city11);
        City city12 = new City("Calais",60, 80);
        TourManager.addCity(city12);
        
        //Set initial temp
        double temp = 100000;

        //Cooling rate
        double coolingRate = 0.003;

        //create random intial solution
        Tour currentSolution = new Tour();
        currentSolution.generateIndividual();
        
        System.out.println("Total distance of initial solution: " + currentSolution.getTotalDistance());
        System.out.println("Tour: " + currentSolution);

        // We would like to keep track if the best solution
        // Assume best solution is the current solution
        Tour best = new Tour(currentSolution.getTour());
        
        // Loop until system has cooled
        while (temp > 1) {
            // Create new neighbour tour
            Tour newSolution = new Tour(currentSolution.getTour());

            // Get random positions in the tour
            int tourPos1 = Utility.randomInt(0 , newSolution.tourSize());
            int tourPos2 = Utility.randomInt(0 , newSolution.tourSize());
            
            //to make sure that tourPos1 and tourPos2 are different
    		while(tourPos1 == tourPos2) {tourPos2 = Utility.randomInt(0 , newSolution.tourSize());}

            // Get the cities at selected positions in the tour
            City citySwap1 = newSolution.getCity(tourPos1);
            City citySwap2 = newSolution.getCity(tourPos2);

            // Swap them
            newSolution.setCity(tourPos2, citySwap1);
            newSolution.setCity(tourPos1, citySwap2);
            
            // Get energy of solutions
            int currentDistance   = currentSolution.getTotalDistance();
            int neighbourDistance = newSolution.getTotalDistance();

            // Decide if we should accept the neighbour
            double rand = Utility.randomDouble();
            if (Utility.acceptanceProbability(currentDistance, neighbourDistance, temp) > rand) {
                currentSolution = new Tour(newSolution.getTour());
            }

            // Keep track of the best solution found
            if (currentSolution.getTotalDistance() < best.getTotalDistance()) {
                best = new Tour(currentSolution.getTour());
            }
            
            // Cool system
            temp *= 1 - coolingRate;
        }

        System.out.println("Final solution distance: " + best.getTotalDistance());
        System.out.println("Tour: " + best);
    }
}
