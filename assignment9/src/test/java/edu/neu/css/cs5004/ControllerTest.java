package edu.neu.css.cs5004;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import org.junit.Before;
import org.junit.Test;

public class ControllerTest {
  private String feedback = "\n Usage: \n"
      + "  --email: "
      + "only generate email messages. \n"
      + "  --email-template <file>: "
      + "accept a filename that holds the email template. Required if --email is used.\n"
      + "\n  --letter: "
      + "only generate letters.\n"
      + "  --letter-template <file>: "
      + "accept a filename that holds the email template. Required if --letter is used.\n"
      + "\n  --output-dir <path>: "
      + "accept the name of a folder, all output is placed in this folder. \n"
      + "  --csv-file <path>: "
      + "accept the name of the csv file to process. \n"
      + "\n Examples:\n"
      + "  --email "
      + "--email-template email-template.txt --output-dir emails --csv-file customer.csv\n"
      + "  or \n"
      + "  --letter "
      + "--letter-template letter-template.txt --output-dir letters --csv-file customer.csv\n";
  private Controller controller;
  private java.io.ByteArrayOutputStream out;
  private String [] args;
  private String argument;
  private InputStream input;
  private String success;

  @Before
  public void setUp() throws Exception {
    controller = new Controller();
    out = new java.io.ByteArrayOutputStream();
    args = null;
    success = "Mail generation was successful!";
  }

  @Test
  public void correctGenerationEmail() throws Exception {
    argument =
        "--email --email-template custom-email-template.txt "
            + "--output-dir email --csv-file insurance_company_members.csv";
    input = new ByteArrayInputStream(argument.getBytes());
    System.setOut(new java.io.PrintStream(out));
    System.setIn(input);
    Controller.main(args);
    String [] output = out.toString().split("\n");
    int size = output.length - 1;

    // If generated correctly, should output "Mail generation was successful!\r"
    assertEquals(success, output[size]);
  }

  @Test
  public void correctGenerationLetter() throws Exception {
    argument =
        "--letter --letter-template custom-letter-template.txt "
            + "--output-dir letter --csv-file insurance_company_members.csv";
    input = new ByteArrayInputStream(argument.getBytes());
    System.setOut(new java.io.PrintStream(out));
    System.setIn(input);
    Controller.main(args);
    String [] output = out.toString().split("\n");
    int size = output.length - 1;

    // If generated correctly, should output "Mail generation was successful!\r"
    assertEquals(success, output[size]);
  }

  @Test
  public void givenEmailNoEmailTemplateError() throws Exception {
    // Error that occurs when --email is given but no --email-template given

    argument =
        "--email --letter-template email-template.txt --output-dir emails --csv-file customer.csv";
    input = new ByteArrayInputStream(argument.getBytes());
    System.setOut(new java.io.PrintStream(out));
    System.setIn(input);
    Controller.main(args);
    feedback = "Enter arguments to generate email or letter:\n"
        + "Error: --email provided but no --email-template was provided.\n"
        + feedback;
    assertEquals(feedback, out.toString());
  }

  @Test
  public void givenLetterNoLetterTemplateError() throws Exception {
    // Error that occurs when --letter is given but no --letter-template given

    argument =
        "--letter --email-template email-template.txt --output-dir emails --csv-file customer.csv";
    input = new ByteArrayInputStream(argument.getBytes());
    System.setOut(new java.io.PrintStream(out));
    System.setIn(input);
    Controller.main(args);
    feedback = "Enter arguments to generate email or letter:\n"
        + "Error: --letter provided but no --letter-template was provided.\n"
        + feedback;
    assertEquals(feedback, out.toString());
  }

  @Test
  public void invalidNumberOfInputs() throws Exception {
    // Error that occurs when number of arguments given doesn't equal 4

    argument =
        "--email --email-template email-template.txt --output-dir emails";
    input = new ByteArrayInputStream(argument.getBytes());
    System.setOut(new java.io.PrintStream(out));
    System.setIn(input);
    Controller.main(args);
    feedback = "Enter arguments to generate email or letter:\n"
        + "Error: Expected 4 arguments given 3 arguments."
        + feedback;
    assertEquals(feedback, out.toString());
  }

  @Test
  public void illegalInput() throws Exception {
    // Error that occurs when the arguments given doesn't equal one of the allowed
    // arguments.

    argument =
        "--incorrect --email-template email-template.txt --output-dir emails --csv-file customer.csv";
    input = new ByteArrayInputStream(argument.getBytes());
    System.setOut(new java.io.PrintStream(out));
    System.setIn(input);
    Controller.main(args);
    feedback = "Enter arguments to generate email or letter:\n"
        + "Error: --incorrect is not a legal input.\n"
        + feedback;
    assertEquals(feedback, out.toString());
  }

}