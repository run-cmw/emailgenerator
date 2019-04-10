package edu.neu.css.cs5004;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadTemplate {

//create a String Builder object
  protected StringBuilder templateToBeLoaded;

  /**
   * Constructor to create a Template Reader
   * @param templateToBeLoaded to be read
   */
  public ReadTemplate(StringBuilder templateToBeLoaded) {
    this.templateToBeLoaded = templateToBeLoaded;
  }

  /**
   * Method to parse the template
   * @param templateName given
   * @return a string representation of the template
   */
  public String parseTemplate(String templateName) {
    System.out.println(System.getProperty("user.dir"));

    try (BufferedReader inputFile = new BufferedReader(
        new InputStreamReader(new FileInputStream(templateName)))) {

      String line;
      templateToBeLoaded.setLength(0);

      while ((line = inputFile.readLine()) != null) {
        if ("".equals(line)) {
          break;
        }

        templateToBeLoaded.append(line).append("\r\n");

      }

    } catch (FileNotFoundException fnfe) {
      System.out.println("*** OOPS! A file was not found : " + fnfe.getMessage());
      fnfe.printStackTrace();
    } catch (IOException ioe) {
      System.out.println("Something went wrong! : " + ioe.getMessage());
      ioe.printStackTrace();
    }


    return templateToBeLoaded.toString();
  }

}





