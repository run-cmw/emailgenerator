package edu.neu.css.cs5004;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class ReadTemplate {

  protected StringBuilder templateToBeLoaded = new StringBuilder();

  /**
   * Constructor to create a Template Reader
   *
   */
  public ReadTemplate() {

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

  @Override
  public int hashCode() {
    return Objects.hash(templateToBeLoaded);
  }

  @Override
  public String toString() {
    return "ReadTemplate{" +
        "templateToBeLoaded=" + templateToBeLoaded +
        '}';
  }
}





