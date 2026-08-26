import java.io.*; 
import java.util.ArrayList;
 
public class GradeAnalyzer {

        static int invalidLines = 0;
 
    public static void main(String[] args) {
        // Step 1: read scores from file
        ArrayList<Integer> scores = readScores("scores.txt");

        // Step 2: calculate statistics
        double average = calculateAverage(scores);

        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;

        for (int score : scores) {
            if (score > highest) {
                highest = score;
            }
            if (score < lowest) {
                lowest = score;
            }
        }

        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;
        int countF = 0;

        for (int score : scores) {
            if (score >= 90) {
                countA++;
            } else if (score >= 80) {
                countB++;
            } else if (score >= 70) {
                countC++;
            } else if (score >= 60) {
                countD++;
            } else {
                countF++;
            }
        }                
        // Step 3: write and print report

        writeReport(
            scores,
            average,
            highest,
            lowest,
            countA,
            countB,
            countC,
            countD,
            countF,
            "report.txt"
        );
    } 
 
    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {     
        ArrayList<Integer> scores = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }
                try {
                    int score = Integer.parseInt(line);
                    scores.add(score);

                } catch (NumberFormatException e) {
                    System.out.println("Warning: invalid score skipped: " + line);
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return scores;
    }
 
    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        if (scores.isEmpty()) {
            return 0.0;
        }
        double total = 0.0;
        for (int score : scores) {
            total += score;
        }
        return total / scores.size();
    } 
 
    // Writes and prints the report
   public static void writeReport(
            ArrayList<Integer> scores,
            double avg,
            int high,
            int low,
            int countA,
            int countB,
            int countC,
            int countD,
            int countF,
            String outputFile) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            writer.write("=== Grade Analysis Report ===\n");
            writer.write(String.format("Total scores processed:  %d%n", scores.size()));
            writer.write(String.format("Invalid lines skipped:    %d%n", invalidLines));

            writer.write(String.format("%nAverage score:   %.2f%n", avg));
            writer.write(String.format("Highest score:   %d%n", high));
            writer.write(String.format("Lowest score:    %d%n", low));

            writer.write("\nGrade distribution:\n");
            writer.write(String.format("  A (90-100):    %d%n", countA));
            writer.write(String.format("  B (80-89):     %d%n", countB));
            writer.write(String.format("  C (70-79):     %d%n", countC));
            writer.write(String.format("  D (60-69):     %d%n", countD));
            writer.write(String.format("  F (below 60):  %d%n", countF));

            writer.close();

            System.out.println("=== Grade Analysis Report ===");
            System.out.println("Total scores processed:  " + scores.size());
            System.out.println("Invalid lines skipped:    " + invalidLines);

            System.out.println(String.format("\nAverage score:   %.2f", avg));
            System.out.println("Highest score:   " + high);
            System.out.println("Lowest score:    " + low);

            System.out.println("\nGrade distribution:");
            System.out.println("  A (90-100):    " + countA);
            System.out.println("  B (80-89):     " + countB);
            System.out.println("  C (70-79):     " + countC);
            System.out.println("  D (60-69):     " + countD);
            System.out.println("  F (below 60):  " + countF);

        } catch (IOException e) {
            System.out.println("Error writing report: " + e.getMessage());
        }
    }
} 
