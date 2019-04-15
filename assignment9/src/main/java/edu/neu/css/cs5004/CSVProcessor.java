package edu.neu.css.cs5004;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * This class represents a CSV processor that reads and parses CSV files.
 * It implements ICSVProcessor.
 */
public class CSVProcessor implements ICSVProcessor {
  /**
   * ArrayList of parsed header values in the CSV file. In headerArrayList, each header value
   * is its own ArrayList.
   */
  private List<String> headerArrayList;

  /**
   * ArrayList of parsed member information in the CSV file. In memberInfoArrayList, each member
   * (with corresponding member info) is an ArrayList.
   */
  private List<List<String>> memberInfoArrayList;
  /**
   * ArrayList of unparsed member information in the CSV file. It is one Arraylist with all member
   * data in String form.
   */
  private List<String> memberInfoString;

  /**
   * Create a CSVProcessor given a CSV file name.
   *
   * @param fileName Name of the file to be read and parsed
   * @throws IOException if there is an input or output exception, such as file not found
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
   * @param fileName Name of the file to be read
   * @throws IOException if there is an input or output exception, such as file not found
   */
  private void readFile(String fileName) throws IOException {
    try (BufferedReader inputFile = new BufferedReader(new FileReader(fileName))) {
      String commaBetweenQuotes = "\",\""; // delimiter for file splitting is: ","
      String line;

      line = inputFile.readLine();
      line =  line.substring(1, line.length()-1); // remove the double quotes at the beginning and end of the string (since not removed with split)
      headerArrayList = new ArrayList<>(Arrays.asList(line.trim().split(commaBetweenQuotes)));

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
   * member information into ArrayLists of ArrayLists so that specific data pieces are easily
   * accessible.
   *
   * @return the ArrayList of parsed member information
   */
  private List<List<String>> parseMemberInfo() {
    // iterate through ArrayList of member info represented as Strings
    // add the number of elements in the parsed header to int i b/c that will loop to next member
    for (int i = 0; i < memberInfoString.size(); i = i + headerArrayList.size()) {
      memberInfoArrayList.add(memberInfoString.subList(i, headerArrayList.size())); // end each sublist at the end of the current member
    }

    return memberInfoArrayList;
  }

  /**
   * Return ArrayList of header titles.
   *
   * @return ArrayList of header titles
   */
  public List<String> getHeaderArrayList() {
    return headerArrayList;
  }

  /**
   * Return ArrayList of ArrayLists of member information.
   *
   * @return ArrayList of ArrayLists of member information
   */
  public List<List<String>> getMemberInfoArrayList() {
    return memberInfoArrayList;
  }

  /**
   * Indicates whether some other object is "equal to" this one.
   *
   * @param obj - the reference object with which to compare
   * @return {@code true} if this object is the same as the obj argument and {@code false} otherwise
   */
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof CSVProcessor)) {
      return false;
    }
    CSVProcessor other = (CSVProcessor) obj;
    return this.getHeaderArrayList().equals(other.getHeaderArrayList())
        && this.getMemberInfoArrayList().equals(other.getMemberInfoArrayList());
  }

  /**
   * Returns a hash code value for the object.
   *
   * @return hash code value for the object
   */
  public int hashCode() {
    return Objects.hash(headerArrayList, memberInfoArrayList, memberInfoString);
  }

  /**
   * Returns a string representation of the object.
   * Format -
   * "Header titles: [header_title, header_title, header_title,...]
   *  Member data: [[member1_info, member1_info, member1_info],
   *               [member2_info, member1_info, member1_info], ...]"
   *
   * @return string representation of the object
   */
  public String toString() {
    return "Header titles: " +
        headerArrayList.toString() + "\n" +
        "Member data: " +
        memberInfoArrayList.toString();
  }

  //  !!!!! main method not permanent - only for testing merge from scratch file !!!!!
  public static void main(String[] args) throws IOException {
    final String MEMBER_INFO_FILE = "insurance_company_members.csv";
    CSVProcessor processor = new CSVProcessor(MEMBER_INFO_FILE);
    System.out.println("Header list: " + processor.headerArrayList);
    System.out.println("Member string: " + processor.memberInfoString);
    System.out.println("Member list: " + processor.memberInfoArrayList);

    System.out.println("Sixth header title: " + processor.headerArrayList.get(5));
    System.out.println("First member:" + processor.memberInfoArrayList.get(0));
    System.out.println("First member's company: " + processor.memberInfoArrayList.get(0).get(2));
    System.out.println("First member's website: " + processor.memberInfoArrayList.get(0).get(processor.headerArrayList.size()-1));
    System.out.println("Sixth member: " + processor.memberInfoArrayList.get(5));
    System.out.println("Header size: " + processor.getHeaderArrayList().size());
  }
}
