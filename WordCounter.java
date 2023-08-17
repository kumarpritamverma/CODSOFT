package Codsoft;


		import java.io.*;
		import java.util.Scanner;

		public class WordCounter {
		    public static void main(String[] args) {
		        Scanner scanner = new Scanner(System.in);
		        
		        System.out.println("Word Counting Application");
		        System.out.println("1. Enter text");
		        System.out.println("2. Read from file");
		        System.out.print("Enter your choice: ");
		        
		        int choice = scanner.nextInt();
		        scanner.nextLine(); // Consume newline
		        
		        String inputText = "";
		        
		        switch (choice) {
		            case 1:
		                System.out.print("Enter the text: ");
		                inputText = scanner.nextLine();
		                break;
		            case 2:
		                System.out.print("Enter the file path: ");
		                String filePath = scanner.nextLine();
		                inputText = readFile(filePath);
		                break;
		            default:
		                System.out.println("Invalid choice.");
		                return;
		        }
		        
		        int wordCount = countWords(inputText);
		        System.out.println("Total words: " + wordCount);
		    }
		    
		    public static String readFile(String filePath) {
		        StringBuilder content = new StringBuilder();
		        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
		            String line;
		            while ((line = reader.readLine()) != null) {
		                content.append(line).append("\n");
		            }
		        } catch (IOException e) {
		            System.out.println("Error reading file: " + e.getMessage());
		        }
		        return content.toString();
		    }
		    
		    public static int countWords(String input) {
		        String[] words = input.split("\\s+|\\p{Punct}+");
		        return words.length;
		    }
		

	

}
