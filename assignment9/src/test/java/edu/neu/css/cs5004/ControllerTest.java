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
      + "--letter-template letter-template.txt --output-dir letters --csv-file customer.csv\r\n";
  @Before
  public void setUp() throws Exception {

  }


  @Test
  public void testMain() {
    Controller controller = new Controller();
    java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
    String[] args = null;
    String argument =
        "--email --letter-template email-template.txt --output-dr emails --csv-file customer.csv";
    InputStream input = new ByteArrayInputStream(argument.getBytes());
    System.setOut(new java.io.PrintStream(out));
    System.setIn(input);
    Controller.main(args);
    feedback = "Enter arguments to generate email or letter:\r\n"
        + "Error : --email provided but no --email-template was provided.\r\n"
        + feedback;
    assertEquals(feedback, out.toString());

  }


}