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
   * ArrayList of parsed header values in the CSV file.
   */
  protected static ArrayList<ArrayList<String>> headerArrayList;
  /**
   * ArrayList of unparsed header values in the CSV file.
   */
  private static ArrayList<String> headerString;
  /**
   * ArrayList of parsed member information in the CSV file.
   */
  protected static ArrayList<ArrayList<String>> memberInfoArrayList;
  /**
   * Arraylist of unparsed member information in the CSV file.
   */
  private static ArrayList<String> memberInfoString;

  /**
   * Create a CSVProcessor given
   * @param fileName Name of the file to be read and parsed.
   * @throws IOException if there is an input or output exception, such as file not found.
   */
  public CSVProcessor(String fileName) throws IOException {
    this.headerArrayList = new ArrayList<>();
    this.memberInfoArrayList = new ArrayList<>();
    this.readFile(fileName);
    this.parseHeader();
    this.parseMemberInfo();
  }

  /**
   * Read the given CSV file and split according to the delimiter. Then store the header and
   * member information in separate ArrayLists.
   *
   * @param fileName Name of the file to be read.
   * @throws IOException if there is an input or output exception, such as file not found.
   */
  private void readFile(String fileName) throws IOException {
    try (BufferedReader inputFile = new BufferedReader(new FileReader(fileName))) {
      String commaBetweenQuotes = "\",\""; // delimeter for file splitting is: ","
      String line;

      line = inputFile.readLine();
      line =  line.substring(1, line.length()-1); // remove the double quotes at the beginning and end of the string (since not removed with split)
      headerString = new ArrayList<>(Arrays.asList(line.trim().split(commaBetweenQuotes)));

      while ((line = inputFile.readLine()) != null) {
        line = line.substring(1, line.length()-1); // remove the double quotes at the beginning and end of the string (since not removed with split)
        memberInfoString = new ArrayList<>(Arrays.asList(line.trim().split(commaBetweenQuotes)));
      }

    } catch (FileNotFoundException fnfe) {
      System.out.println("Sorry, this file was not found: " +  fnfe.getMessage());
    } catch (IOException ioe) {
      System.out.println("Sorry, something went wrong: " + ioe.getMessage());
      ioe.printStackTrace();
    }
  }

  /**
   * Parse the given CSV file by converting the ArrayList of header values into an
   * ArrayLists of ArrayLists so that specific data pieces are easily accessible.
   *
   * @return the ArrayList of parsed header values
   */
  private ArrayList<ArrayList<String>> parseHeader() {
    addDataToArrayList(headerString, headerArrayList);
    return headerArrayList;
  }

  /**
   * Parse the given CSV file by converting the ArrayList member information
   * into ArrayLists of ArrayLists so that specific data pieces are easily accessible.
   *
   * @return the ArrayList of parsed member information
   */
  private ArrayList<ArrayList<String>> parseMemberInfo() {
    addDataToArrayList(memberInfoString, memberInfoArrayList);
    return memberInfoArrayList;
  }

  /**
   * Helper method to add ArrayList of Strings data to an ArrayList of Arraylist.
   *
   * @param stringList ArrayList of unparsed data
   * @param listList ArrayList for parsed data
   */
  private void addDataToArrayList(ArrayList<String> stringList, ArrayList<ArrayList<String>> listList) {
    for (int i = 0; i < stringList.size(); i++) {
      listList.add(new ArrayList<String>(stringList.subList(i,i+1)));
    }
  }
}
