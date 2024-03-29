import java.util.Random;

public class Routine {
	static Dinosaur tri = new Dinosaur(0, 50, 50, "Triceratops");
	static int food = 3;
	static int gold = 0;
	static int key = 0;
	static int age = 0;
	static double time = 6.00;
	boolean life = true;
	static int rand2;			// 0, 1 
	static int rand3; 			// 0, 1, 2
	static int rand4; 			// 0, 1, 2, 3
	static String textLine;
	static String hungerText;
	
	public static void feedDino() {
		if (food >= 1) {
			time += 1.00;
			food --;
			tri.happy += 2;
			tri.hunger -= 5;
			checkHunger();
			textLine = "You fed " + tri.name + 
					". He liked it!";
		}
		else {
			textLine = "" + tri.name + " has no food! Go find more!";
		}	
		
		if (time >= 22) {
			sleep();
		}
	}
	
	public static void explore() {
		Random r = new Random();
		rand3 = r.nextInt(3);
		rand4 = r.nextInt(4);
		if (tri.happy >= 80) {
			// from 0 to 3, if rand4 == 1, 2 or 3
			if (rand4 >= 1) {
				textLine = "He looks pretty confident..." +
				"\nSuccess! He found a lot of food!";
				food += 3;
				if (rand4 == 3) {
					textLine = tri.name + " also found a key!";
					key++;
				}
			}
			else {
			
			}
			textLine = "Not much food was found.";
			food += 1;
		}
		else if (tri.happy >= 30 && tri.happy < 80) {
			// from 0 to 2, if rand3 equals 1 or 2
			if (rand3 >= 1) {
				textLine = "Looking... looking... Alright! He found some food!";
				food += 1;
				if (rand4 == 3) {
					textLine = tri.name + " also found a key!";
					key++;
				}
			}
			else {
				textLine = "He looked all over, but no food was found...";
			}

			}
			tri.hunger += 5;
			time += 5.00;
			checkHunger();
			if (time >= 22) {
				sleep();
			}
			
	}
	
	public static void play() {
		Random r = new Random();
		rand2 = r.nextInt(2);
		rand3 = r.nextInt(3);
		rand4 = r.nextInt(4);
		if (rand3 == 0) {
			textLine = tri.name + " wants to play fetch!";
		}

		else if (rand3 == 1) {
			textLine = tri.name + " wants to race!";
		}

		else {
			textLine = tri.name + " wants to dig!";
			if (key >= 1) {
				textLine = tri.name + " found a treasure chest! Do you want to open it?";
			}
			else {
				textLine = tri.name + " found a treasure chest! But you don't have a key!!";
			}
		}
		time += 2;
		tri.hunger += 5;
		tri.happy += 5;
		checkHunger();
		if (time >= 22) {
			sleep();
		}
	}
	
	public static void checkHunger() {
		if (tri.hunger >= 90) {
			hungerText = "Starving";
		}
		else if (tri.hunger >= 60) {
			hungerText = "Very Hungry";
		}
		else if (tri.hunger >= 40) {
			hungerText = "Hungry";
		}
		else {
			hungerText = "Not hungry";
		}
	}
	
	// sleep is triggered if time reaches or passes 22.00
	public static void sleep() {
		textLine = tri.name + " is exhausted. He fell asleep.";
		tri.happy = (int) (tri.happy + (30 - time));
		time = 6.00;
		age++;
		tri.hunger += 5;
	}
	
	public Routine() {

	}
}
