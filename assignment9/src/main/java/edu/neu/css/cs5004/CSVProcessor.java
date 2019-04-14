package edu.neu.css.cs5004;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class represents a CSV processor that reads and parses CSV files.
 */
public class CSVProcessor {
  /**
   * ArrayList of parsed header values in the CSV file. In headerArrayList, each header value
   * is its own ArrayList.
   */
  protected List<List<String>> headerArrayList;
  /**
   * ArrayList of unparsed header values in the CSV file. It is one ArrayList with header values
   * in String form.
   */
  private List<String> headerString;
  /**
   * ArrayList of parsed member information in the CSV file. In memberInfoArrayList, each member
   * (with corresponding member info) is an ArrayList.
   */
  protected List<List<String>> memberInfoArrayList;
  /**
   * ArrayList of unparsed member information in the CSV file. It is one Arraylist with all member
   * data in String form.
   */
  private List<String> memberInfoString;

  /**
   * Create a CSVProcessor given a CSV file name.
   *
   * @param fileName Name of the file to be read and parsed.
   * @throws IOException if there is an input or output exception, such as file not found.
   */
  public CSVProcessor(String fileName) throws IOException {
    this.headerArrayList = new ArrayList<>();
    this.memberInfoArrayList = new ArrayList<>();
    this.readFile(fileName);
  }

  /**
   * Read the given CSV file and split according to the delimiter. Then store the header and
   * member information in separate ArrayLists.
   *
   * @param fileName Name of the file to be read.
   * @throws IOException if there is an input or output exception, such as file not found.
   */
  protected void readFile(String fileName) throws IOException {
    try (BufferedReader inputFile = new BufferedReader(new FileReader(fileName))) {
      String commaBetweenQuotes = "\",\""; // delimiter for file splitting is: ","
      String line;

      line = inputFile.readLine();
      line =  line.substring(1, line.length()-1); // remove the double quotes at the beginning and end of the string (since not removed with split)
      headerString = new ArrayList<>(Arrays.asList(line.trim().split(commaBetweenQuotes)));
      parseHeader();

      while ((line = inputFile.readLine()) != null) {
        line = line.substring(1, line.length()-1); // remove the double quotes at the beginning and end of the string (since not removed with split)
        memberInfoString = new ArrayList<>(Arrays.asList(line.trim().split(commaBetweenQuotes)));
        parseMemberInfo();
      }
    } catch (FileNotFoundException fnfe) {
      System.out.println("Sorry, this file was not found: " +  fnfe.getMessage());
    } catch (IOException ioe) {
      System.out.println("Sorry, something went wrong: " + ioe.getMessage());
      ioe.printStackTrace();
    }
  }

  /**
   * Helper method to parse the given CSV file by converting the ArrayList of Strings containing
   * header values into an ArrayList of ArrayLists so that specific data pieces are easily
   * accessible.
   *
   * @return the ArrayList of parsed header values
   */
  protected List<List<String>> parseHeader() {
    // iterate through ArrayList of header titles represented as Strings
    for (int i = 0; i < headerString.size(); i++) {
      headerArrayList.add(new ArrayList<>(headerString.subList(i,i+1)));
    }

    return headerArrayList;
  }

  /**
   * Helper method to parse the given CSV file by converting the ArrayList of Strings containing
   * member information into ArrayLists of ArrayLists so that specific data pieces are easily
   * accessible.
   *
   * @return the ArrayList of parsed member information
   */
  protected List<List<String>> parseMemberInfo() {
    // iterate through ArrayList of member info represented as Strings
    // add the number of elements in the parsed header to int i b/c that will loop to next member
    for (int i = 0; i < memberInfoString.size(); i = i + headerArrayList.size()) {
      memberInfoArrayList.add(memberInfoString.subList(i, headerArrayList.size())); // end each sublist at the end of the current member
    }

    return memberInfoArrayList;
  }

  //  !!!!! main method not permanent - only for testing merge from scratch file !!!!!
  public static void main(String[] args) throws IOException {
    final String MEMBER_INFO_FILE = "insurance_company_members.csv";
    CSVProcessor processor = new CSVProcessor(MEMBER_INFO_FILE);
    System.out.println("Header string: " + processor.headerString);
    System.out.println("Header list: " + processor.headerArrayList);
    System.out.println("Member string: " + processor.memberInfoString);
    System.out.println("Member list: " + processor.memberInfoArrayList);

    System.out.println("Sixth header title: " + processor.headerArrayList.get(5));
    System.out.println("First member:" + processor.memberInfoArrayList.get(0));
    System.out.println("First member's company: " + processor.memberInfoArrayList.get(0).get(2));
    System.out.println("First member's website: " + processor.memberInfoArrayList.get(0).get(processor.headerArrayList.size()-1));
    System.out.println("Sixth member: " + processor.memberInfoArrayList.get(5));
  }
}
