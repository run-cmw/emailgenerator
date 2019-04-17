package edu.neu.css.cs5004;

import java.util.Scanner;

/**
 * View class that creates the user interface.
 */
public class View {

  /**
   * Takes in and returns user input.
   * @param prompt - A string that informs the user what to input.
   * @return - returns the user input.
   */
  public static String getInput(String prompt) {
    Scanner scan = new Scanner(System.in, "UTF-8");
    System.out.print(prompt);
    return scan.nextLine();
  }

  /**
   * Takes in a feedback string and shows this feedback to the user.
   * @param feedback - A string with feedback (error message).
   */
  public static void giveFeedback(String feedback) {
    System.out.print(feedback);
  }

  /**
   * Provides an example of proper user inputs to the user when the user provides incorrect inputs.
   */
  public static void provideExample() {
    String feedback = "\n Usage: \n"
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
        + "  --email --email-template email-template.txt --output-dir emails "
        + "--csv-file customer.csv\n"
        + "  or \n"
        + "  --letter --letter-template letter-template.txt --output-dir letters "
        + "--csv-file customer.csv\n";
    System.out.print(feedback);
  }

  /**
   * Provides a success message if the mails were generated successfully.
   */
  public static void provideSuccessMessage() {
    System.out.print("Mail generation was successful!\n");
  }
}
