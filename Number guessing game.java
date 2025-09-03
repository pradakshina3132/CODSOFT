
import java.util.Random;
import java.util.Scanner;

public class NumberGame {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
Random rand = new Random();
int score = 0;
boolean playAgain = true;

System.out.println("🎮 Welcome to the Number Guessing Game!");

while (playAgain) {
int number = rand.nextInt(100) + 1; // Random number 1-100
int attempts = 7;
boolean guessed = false;

System.out.println("\nI'm thinking of a number between 1 and 100.");
System.out.println("You have " + attempts + " attempts to guess it!");

while (attempts > 0) {
System.out.print("Enter your guess: ");

int guess;
try {
guess = sc.nextInt();
} catch (Exception e) {
System.out.println("⚠️ Please enter a valid number!");
sc.next(); // clear invalid input
continue;
}

if (guess == number) {
System.out.println("🎉 Correct! You guessed the number!");
score++;
guessed = true;
break;
} else if (guess < number) {
System.out.println("Too low 📉");
} else {
System.out.println("Too high 📈");
}

attempts--;
System.out.println("Attempts left: " + attempts);
}

if (!guessed) {
System.out.println("😢 Out of attempts! The number was " + number);
}

System.out.println("Your current score: " + score);

System.out.print("Do you want to play again? (yes/no): ");
String choice = sc.next().toLowerCase();
if (!choice.equals("yes")) {
playAgain = false;
System.out.println("🏆 Final Score: " + score);
System.out.println("Thanks for playing! 👋");
}
}

sc.close();
}
}


