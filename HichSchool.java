import java.io.*;
import java.util.*;

public class HighSchool 
{

	public static void main(String[] args) 
	{
		
		// System objects
		Scanner in = new Scanner(System.in);
		Random rand = new Random();
		
		// Game variables
		String[] enemies = { "Bully", "Teacher", "Tank", "XGirlfriend" };
		int maxEnemyHealth = 75;
		int enemyAttackDamage = 25;
		
		//Player variables
		int health = 100;
		int attackDamage = 50;
		int numHealthPotions = 3;
		int healthPotionHealAmount = 30;
		int healthPotionDropChance = 50; // Percentage
		
		boolean running = true;
		
		System.out.println("\nWelcome to HighSchoolUndead!");
		
		GAME:
		while(running)
		{
			System.out.println("--------------------------------------------------------");
			
			int enemyHealth = rand.nextInt(maxEnemyHealth);
			String enemy = enemies[rand.nextInt(enemies.length)];
			System.out.println("\t# " + enemy + " appeared! #\n");
			
			while(enemyHealth > 0)	
			{
				System.out.println("\tYour HP: " + health);
				System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
				System.out.println("\n\tWhat would you like to do?");
				System.out.println("\t1. Attack");
				System.out.println("\t2. Drink health potion");
				System.out.println("\t3. Run!");
				
				String input = in.nextLine();
				if(input.equals("1"))
				{
					int damageDealt = rand.nextInt(attackDamage);
					int damageTaken = rand.nextInt(enemyAttackDamage);
					
					enemyHealth -= damageDealt;
					health -= damageTaken;
					
					System.out.println("\t> You strike the " + enemy + " for " + damageDealt + " damage.");
					System.out.println("\t> You recieve " + damageTaken + " in retaliation!");
					
					if(health < 1)
					{
						System.out.println("\t> You have taken too much damage, you are too weak to go on!");
						break;
					}
					
				}
				else if(input.equals("2"))
				{
					if(numHealthPotions > 0)
					{
						health += healthPotionHealAmount;
						numHealthPotions--;
						System.out.println("\t> You drink a health potion, healing yourself for " + healthPotionHealAmount + "."
											+ "\n\t> You now have " + health + " HP."
											+ "\n\t> You have " + numHealthPotions + " health potions left.\n");
					}
					else
					{
						System.out.println("\t> You have no health potions left! Defeat enemies for a chance to obtain one!");
					}
				}
				else if(input.equals("3"))
				{
					System.out.println("\tYou run away from the " + enemy + "!");
					continue GAME;
				}
				else{
					System.out.println("\tInvalid Command!");
				}
			}
			
			if(health < 1)
			{
				System.out.println("You limp to the nurse's room, weak from battle.");
				break;
			}
			
			System.out.println("--------------------------------------------------------");
			System.out.println(" # " + enemy + " was defeated! # ");
			System.out.println(" # You have " + health + " HP left. #");
			if(rand.nextInt(100) < healthPotionDropChance)
			{
				numHealthPotions++;
				System.out.println(" # " + enemy + " dropped a health potion! # ");
				System.out.println(" # You now have " + numHealthPotions + " health potion(s). # ");
			}
			System.out.println("--------------------------------------------------------");
			System.out.println("What would you like to do now?");
			System.out.println("1. Continue fighting");
			System.out.println("2. Exit Atlanta High School");
			
			String input = in.nextLine();
			
			while(!input.equals("1") && !input.equals("2"))
			{
				System.out.println("Invalid Command!");
				input = in.nextLine();
			}
			
			if(input.equals("1"))
			{
				System.out.println("You continue on your brawl!");
			}
			else if(input.equals("2"))
			{
				System.out.println("You exit the school, successful from your adventures!");
				break;
			}
		}
		
		System.out.println("#######################");
		System.out.println("# THANKS FOR PLAYING! #");
		System.out.println("#######################");
		
	}

}
