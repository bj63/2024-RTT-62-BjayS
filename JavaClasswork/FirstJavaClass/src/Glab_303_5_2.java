public class Glab_303_5_2 {
}
import random

def guess_number():
        # Generate a random number between 0 and 100
target_number = random.randint(0, 100)

    while True:
        # Ask the user to input a guess
guess = int(input("Guess the number between 0 and 100: "))

        # Check if the guess is correct
        if guess == target_number:
print("Congratulations! You guessed the correct number:", target_number)
            break
                    # Check if the guess is too low
elif guess < target_number:
print("Too low! Try again.")
        # Check if the guess is too high
        else:
print("Too high! Try again.")

    # Ask the user if they want to play again
        play_again = input("Do you want to play again? (yes/no): ").lower()
    if play_again == "yes":
guess_number()
    else:
print("Thanks for playing!")

# Start the game
guess_number()


import java.util.Scanner; public class GuesstheNumber {
    public static void main(String[] args) {
// Generate a random number to be guessed
        int number = (int) (Math.random() * 101);
        Scanner input = new Scanner(System.in); System.out.println("Guess a magic number between 0 and 100"); int guess = -1;
        while (guess != number) {
            // Prompt the user to guess the number
            System.out.print("\nEnter your guess: "); guess = input.nextInt();
            if (guess == number)
                System.out.println("Yes, the number is " + number); else if (guess > number)
                System.out.println("Your guess is too high"); else
                System.out.println("Your guess is too low"); } // End of loop
    } }

public class SubtractionQuizLoop
public static void main(String[] args) {
    final int NUMBER_OF_QUESTIONS = 5; // Number of questions int correctCount = 0; // Count the number of correct answers int count = 0; // Count the number of questions
    long startTime = System.currentTimeMillis();
    String output = ""; // output string is initially empty Scanner input = new Scanner(System.in);
    while (count < NUMBER_OF_QUESTIONS) {
// 1. Generate two random single-digit integers
        int number1 = (int) (Math.random() * 10);
        int number2 = (int) (Math.random() * 10);
// 2. If number1 < number2, swap number1 with number2 if (number1 < number2) {
        int temp = number1; number1 = number2; number2 = temp;
    }
// 3. Prompt the student to answer
    System.out.print(
            "What is " + number1 + " -
    int answer = input.nextInt();
// 4. Grade the answer and display if (number1 - number2 == answer) {
    "What is number1 - number2?"
    " + number2 + "? "); the result
    System.out.println("You are correct!");
    correctCount++;
}


// Create a Scanner
Scanner input = new Scanner(System.in);
// Read an initial data
System.out.print("Enter an int value (the program exits if the input is 0): "); int data = input.nextInt();
// Keep reading data until the input is 0
int sum = 0;
while (data != 0) {
sum += data;
// Read the next data
System.out.print( "Enter an int value (the program exits if the input is 0): ");
data = input.nextInt(); }
        System.out.println("The sum is " + sum); }