package edu.neu.css.cs5004;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class represents a CSV processor that reads and parses CSV files.
 */
public class CSVProcessor {

  /**
   * CSV file to be processed (read and parsed).
   */
  protected static final String MEMBER_INFO_FILE = "insurance_company_members.csv";
  /**
   * ArrayList of header values in the CSV file.
   */
  protected static ArrayList<String> header;
  /**
   * ArrayList of member information in the CSV file.
   */
  protected static ArrayList<String> memberInfoArrayList;

  /**
   * Create a CSVProcessor given
   * @param fileName
   * @throws IOException
   */
  public CSVProcessor(String fileName) throws IOException {
   this.memberInfoArrayList = new ArrayList<>();
   this.readFile(fileName);
   this.parseFile(fileName);
  }

  private void readFile(String fileName) throws IOException {
    try (BufferedReader inputFile = new BufferedReader(new FileReader(fileName))) {
      String commaBetweenQuotes = "\",\""; // delimeter for file splitting is ","
      String line;

      line = inputFile.readLine();
      line =  line.substring(1, line.length()-1); // remove the double quotes at the beginning and end of the string (since not removed with split)
      header = new ArrayList<String>(Arrays.asList(line.trim().split(commaBetweenQuotes)));

      while ((line = inputFile.readLine()) != null) {
        line = line.substring(1, line.length()-1); // remove the double quotes at the beginning and end of the string (since not removed with split)
        memberInfoArrayList = new ArrayList<String>(Arrays.asList(line.trim().split(commaBetweenQuotes)));
      }

    } catch (FileNotFoundException fnfe) {
      System.out.println("Sorry, this file was not found: " +  fnfe.getMessage());
    } catch (IOException ioe) {
      System.out.println("Sorry, something went wrong: " + ioe.getMessage());
      ioe.printStackTrace();
    }
  }

  private ArrayList<String> parseFile(String fileName) {
    return null;
  }
}
