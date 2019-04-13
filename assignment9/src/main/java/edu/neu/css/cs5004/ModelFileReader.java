package edu.neu.css.cs5004;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ModelFileReader {
  private static final String MEMBER_INFO_FILE = "insurance_company_members.csv";
  protected ArrayList<String> header;
  protected ArrayList<String> memberInfoArrayList;

  public ModelFileReader() throws IOException {
   this.memberInfoArrayList = new ArrayList<String>();
   this.readFile(MEMBER_INFO_FILE);
//   this.parseFile(MEMBER_INFO_FILE);
  }

  private void readFile(String fileName) throws IOException {
    try (BufferedReader inputFile = new BufferedReader(new FileReader(fileName))) {
      String doubleQuote = "\"";
      String line;

      line = inputFile.readLine();
      line =  line.substring(1, line.length()-4); // remove the additional commas and white spaces standard in split CSV files
      header = new ArrayList<String>(Arrays.asList(line.trim().split(doubleQuote)));

      while ((line = inputFile.readLine()) != null) {
        line = line.substring(1, line.length()-4); // remove the additional commas and white spaces standard in split CSV files
        memberInfoArrayList = new ArrayList<String>(Arrays.asList(line.trim().split(doubleQuote)));
      }

    } catch (FileNotFoundException fnfe) {
      System.out.println("Sorry, this file was not found: " +  fnfe.getMessage());
    } catch (IOException ioe) {
      System.out.println("Sorry, something went wrong: " + ioe.getMessage());
      ioe.printStackTrace();
    }
  }

//  private void parseFile(String fileName) {
//
//  }
}
