package com.marktracker;

public class StudentMarkTracker {
    private static final int MIN_MARK = 1;
    private static final int MAX_MARK = 10;

    private static final int[][] STUDENT_MARKS = {
            {9, 10, 8, 9, 10, 9, 4, 2, 2, -2},
            {7, 8, 6, 7, 8, 3, 10, 10},
            {5, 6, 4, 5, 6, 10, 10},
            {}
    };
    private static final String STUDENT_LABEL = "Student";

    public static void main(String[] args) {

        for (int i = 0; i < STUDENT_MARKS.length; i++) {
            int[] marks = STUDENT_MARKS[i];

            String studentName = STUDENT_LABEL + " " + (i + 1);

            if (marks.length == 0) {
                System.out.println(studentName + " has no marks, skipped.");
            } else if (!areMarksValid(marks)) {
                System.out.println(studentName + " has an invalid mark, skipped.");
            } else {
                double average = calculateAverage(marks);
                System.out.println(studentName + ": average " + average + " - " + classifyAverage(average));
            }
        }

    }

    private static boolean isValidMark(int mark) {
        return mark >= MIN_MARK && mark <= MAX_MARK;
    }

    private static boolean areMarksValid(int[] marks) {
        for (int mark : marks) {
            if (!isValidMark(mark)) {
                return false;
            }
        }
        return true;
    }

    private static double calculateAverage(int[] marks) {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        double average = (double) total / marks.length;
        return Math.round(average * 100) / 100.0;
    }

    private static String classifyAverage(double average) {
        int roundedAverage = (int) Math.round(average);

        switch (roundedAverage) {
            case 10 -> {
                return "A - Pass";
            }
            case 9 -> {
                return "B - Pass";
            }
            case 8 -> {
                return "C - Pass";
            }
            case 7 -> {
                return "D - Pass";
            }
            case 5, 6 -> {
                return "E - Pass";
            }
            default -> {
                return "F - Fail";
            }
        }
    }
}
