package edu.neu.css.cs5004;

import java.util.Scanner;

public class View {

  public static String getInput(String prompt) {
    Scanner scan = new Scanner(System.in);
    System.out.println(prompt);
    return scan.nextLine();
  }

  public static void giveFeedback(String feedback) {
    System.out.println(feedback);
  }

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
        + "--csv-file customer.csv";
    System.out.println(feedback);
  }
}
