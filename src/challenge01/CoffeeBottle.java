package challenge01;

import java.util.Scanner;

public class CoffeeBottle 
{
	//Declaring & Initializing variables
	public static int coffeeBottle = 0
			          ,noOfExchange = 0
					  ,totalCoffeeBottle =0;
	public static Scanner myObj;
	
	//Main method
	public static void main(String[] args) 
	{	
		//Calling the methods which are defined in the same class itself
		getDetails();
		calculateCoffeeBottles();
	}
	
	
	//Method to get details from User like coffeeBottle and noOfExchange
	public static void getDetails() 
	{
		try
		{
		    //Getting initial Cold Coffee Bottles count from User
			myObj = new Scanner(System.in);	
			System.out.println("\nEnter initial Cold Coffee Bottles bought:");
			coffeeBottle = myObj.nextInt();
			
			//Getting initial Number of exchange from User
			System.out.println("Enter Number of exchange:");
			noOfExchange = myObj.nextInt();
			myObj.close();
		}
		catch (Exception e)
		{
			System.err.println("Wrong input!!! Please use Numbers only and try again.");
			getDetails();
		}		
	}
	
	//Method to calculate and display the Total received filled Cold Coffee
	public static void calculateCoffeeBottles() 
	{
		totalCoffeeBottle = coffeeBottle;
		//Check for user inputs to avoid infinite loop and negative numbers 
		if(!(coffeeBottle<0 || noOfExchange==1 || noOfExchange<0))
		{
			while(coffeeBottle>0)
			{
				coffeeBottle = coffeeBottle/noOfExchange;
				totalCoffeeBottle += coffeeBottle;
				if(coffeeBottle%noOfExchange!=0)
					coffeeBottle +=	coffeeBottle%noOfExchange;
			}
			//Print the total filled Cold Coffee Bottles
			System.out.println("\nThe total filled Cold Coffee Bottles received are: "+totalCoffeeBottle);
		}
		
		else 
			//Error message
			System.err.println("Wrong input!!! \n Please enter a possitive number for Coffee Bottle."
					+ "\n Please enter a possitive number for Number of exchange except 1.\n");
	}
}
