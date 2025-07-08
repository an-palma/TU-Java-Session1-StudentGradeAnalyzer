package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class StudentGradeAnalyzer {
    static ArrayList<Integer> gradeCounter = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));
    static ArrayList<String> topStudents = new ArrayList<>();
    static int highestScore = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students:\n>> ");
        int numOfStudents = sc.nextInt();
        int totalScore = 0;

        for (int i = 0; i < numOfStudents; i++) {
            System.out.print("Enter name: ");
            String name = sc.next();
            System.out.printf("Enter score for %s: ", name);
            int score = sc.nextInt();
            totalScore += score;
            getTopScorer(score, name);
            String grade = getGrade(score);
            System.out.printf("%s got grade: %s.\n\n", name, grade);
        }

        sc.close();

        System.out.println("----- CLASS SUMMARY -----");
        int average = totalScore / numOfStudents;
        System.out.printf("Average Score: %d\n", average);
        System.out.printf("Grade Counts: A:%d, B:%d, C:%d, D:%d, F:%d\n", gradeCounter.get(0), gradeCounter.get(1), gradeCounter.get(2), gradeCounter.get(3), gradeCounter.get(4));
        System.out.println("Top Student(s): ");
        for (String topStudent : topStudents) {
            System.out.println("\t" + topStudent);
        }

    }
    
    private static String getGrade(int score) {
        return switch (score / 10) {
            case 10, 9 -> {
                incrementCounter(0);
                yield "A";
            }
            case 8 -> {
                incrementCounter(1);
                yield "B";
            }
            case 7 -> {
                incrementCounter(2);
                yield "C";
            }
            case 6 -> {
                incrementCounter(3);
                yield "D";
            }
            default -> {
                incrementCounter(4);
                yield "F";
            }
        };
    }

    private static void incrementCounter(int index) {
        int counter = gradeCounter.get(index);
        gradeCounter.set(index, ++counter);
    }

    private static void getTopScorer(int score, String name) {
        if (score >= highestScore) {
            highestScore = score;
            topStudents.add(name);
        }
    }
}