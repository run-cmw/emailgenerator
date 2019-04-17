package edu.neu.css.cs5004;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;


/**
 * This class represents Read Template.
 */
public class ReadTemplate {

  protected StringBuilder templateToBeLoaded = new StringBuilder();

  /**
   * Constructor to create a Template Reader.
   *
   */
  public ReadTemplate() {

  }

  /**
   * Method to parse the template.
   * @param templateName given template name
   * @return a string representation of the template
   */
  public String parseTemplate(String templateName) {
    //System.out.println(System.getProperty("user.dir"));

    try (BufferedReader inputFile = new BufferedReader(
        new InputStreamReader(new FileInputStream(templateName), "UTF8"))) {

      String line;
      //templateToBeLoaded.setLength(0);

      while ((line = inputFile.readLine()) != null) {

        templateToBeLoaded.append(line).append("\r\n");
        // System.out.println("Read : " + line);
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
  /**
   * Indicates whether some other object is "equal to" this one.
   *
   * @param obj - the reference object with which to compare
   * @return {@code true} if this object is the same as the obj argument and {@code false} otherwise
   */

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof ReadTemplate)) {
      return false;
    }
    ReadTemplate that = (ReadTemplate) obj;
    return templateToBeLoaded.equals(that.templateToBeLoaded);
  }

  /**
   * Returns a hash code value for the object.
   *
   * @return hash code value for the object
   */
  @Override
  public int hashCode() {
    return Objects.hash(templateToBeLoaded);
  }


  /**
   * Returns a string representation of the object.
   * @return String representation of the object
   */
  @Override
  public String toString() {
    return "ReadTemplate{"
        + "templateToBeLoaded=" + templateToBeLoaded
        + '}';
  }
}





