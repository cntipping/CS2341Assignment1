import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LogProcessor {
    public static void main(String[] args) throws IOException {
        // Create a queue to store all log entries from file
        Queue<String> logQueue = new LinkedList<>();

        // Create stack to store error log entries ONLY
        Stack<String> errorStack = new Stack<>();

        // Initialize variables for log count
        int infoCount = 0, warningCount = 0, errorCount = 0, memoryCount = 0;

        // Create an ArrayList to store last 100 error logs
        ArrayList<String> last100 = new ArrayList<>();

        // Open and read in csv file
        // Use BufferedReader -> better for larger files
        BufferedReader reader = new BufferedReader(new FileReader("log-data.csv"));
        // Create variable to hold lines
        String line;

        // Read in each line
        while ((line = reader.readLine()) != null) {
            logQueue.offer(line); // enqueues each line
        }

        // close reader
        reader.close();

        // process each log then dequeue
        while(!logQueue.isEmpty()) {
            String log = logQueue.poll(); // dequeue funct

            // sort depending on log entry type
            if(log.contains("INFO")){
                infoCount++;
            }
            else if(log.contains("WARNING")){
                warningCount++;
                if(log.contains("Memory")) {
                    memoryCount++;
                }
            }
            else if(log.contains("ERROR")){
                errorCount++;
                errorStack.push(log);

                // final 100 error counts
                if(last100.size() < 100){
                    last100.add(log);
                }
            }
        }

        //Print out error counts
        System.out.println("Info: " + infoCount + " " + warningCount + " " + errorCount + " " + memoryCount);
        for (String error : last100) {
            // Print last 100 errors line by line
            System.out.println(error);
        }

    }
}
