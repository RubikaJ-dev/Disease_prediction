package org.disease;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalScore = 0;

        System.out.println("SARC-F Questionnaire: Answer with 0 (No Difficulty), 1 (Some Difficulty), or 2 (Severe Difficulty)");

        // Strength (S)
        totalScore += getScore(scanner, "1. Difficulty in lifting 5 kg (e.g., grocery bag)?");

        // Assistance in Walking (A)
        totalScore += getScore(scanner, "2. Difficulty in walking across a room without assistance?");

        // Rising from a Chair (R)
        totalScore += getScore(scanner, "3. Difficulty rising from a chair without using arms?");

        // Climbing Stairs (C)
        totalScore += getScore(scanner, "4. Difficulty climbing a flight of 10 stairs?");

        // Falls (F)
        totalScore += getScore(scanner, "5. Have you fallen 4 or more times in the past year?");

        // Display Result
        System.out.println("\nTotal SARC-F Score: " + totalScore);
        if (totalScore >= 4) {
            System.out.println("High risk of sarcopenia. Please consult a doctor.");
        } else {
            System.out.println("Low risk of sarcopenia.");
        }

        scanner.close();
    }
    private static int getScore(Scanner scanner, String question) {
        int score;
        while (true) {
            System.out.print(question + " (0/1/2): ");
            try {
                score = Integer.parseInt(scanner.nextLine().trim());
                if (score == 0 || score == 1 || score == 2) {
                    return score;
                } else {
                    System.out.println("Invalid input. Please enter 0, 1, or 2.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number (0, 1, or 2).");
            }
        }
    }
}

