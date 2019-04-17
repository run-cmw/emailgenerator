package edu.neu.css.cs5004;

import java.util.HashMap;

/**
 * Controller class that takes in user actions and responds (modifies data or UI).
 */
public class Controller {
  /**
   * Constant that represents the command line argument --email.
   */
  private static final String EMAIL_KEY = "email ";
  /**
   * Constant that represents the command line argument --email-template.
   */
  private static final String EMAIL_TEMPLATE_KEY = "email-template";
  /**
   * Constant that represents the command line argument --letter.
   */
  private static final String LETTER_KEY = "letter ";
  /**
   * Constant that represents the command line argument --letter-template.
   */
  private static final String LETTER_TEMPLATE_KEY = "letter-template";
  /**
   * Constant that represents the command line argument --csv-file.
   */
  private static final String FILE_KEY = "csv-file";
  /**
   * Constant that represents the command line argument --output-dir.
   */
  private static final String OUTPUT_KEY = "output-dir";
  /**
   * The number of expected inputs in the command line when running this class.
   */
  private static final int EXPECTED_ARGUMENT_NUMBER = 4;
  /**
   * The type of the request - either generate email or letter files.
   */
  private static String type = "";

  /**
   * Function that creates a hash map with the command line arguments that must be included.
   * @return hash map with the command line arguments that must be included when calling the
   *     mail generator.
   */
  private static HashMap<String, String> createDictionary() {
    HashMap<String, String> dictionaryArguments = new HashMap<>();
    dictionaryArguments.put(EMAIL_KEY, null);
    dictionaryArguments.put(EMAIL_TEMPLATE_KEY, null);
    dictionaryArguments.put(LETTER_KEY, null);
    dictionaryArguments.put(LETTER_TEMPLATE_KEY, null);
    dictionaryArguments.put(FILE_KEY, null);
    dictionaryArguments.put(OUTPUT_KEY, null);
    return dictionaryArguments;
  }

  /**
   * Validates the command line inputs/arguments passed in by the user and either throws an
   * IllegalArgumentException or returns a hash map with the the command line arguments
   * parsed as a value.
   *
   * <p>Example</p>:
   * Command line input:
   * --email --letter-template email-template.txt --output-dir emails --csv-file customer.csv
   *
   * <p>Hash map contents</p>:
   * email: email
   * email-template: email-template.txt
   * output-dir: emails
   * csv-file: customer.csv
   *
   * @param userInput - Command line inputs provided by the user.
   * @param dictionary - Hash map (dictionary) that will store the user inputs.
   * @return - Hash map with user inputs.
   * @throws IllegalArgumentException - Thrown if the number of arguments given is not four,
   *     if the --email argument is included but --email-template is not included,
   *     if the --letter argument is included but --letter-template is not included, or
   *     if any arguments besides --csv-file, --output-dir, or the arguments above are given.
   */
  private static HashMap<String, String> validInputs(String userInput,
      HashMap<String, String> dictionary) throws IllegalArgumentException {
    // Splitting the user input by the flag '--'
    String[] arrayInput = userInput.split("--");

    int size = arrayInput.length;
    int argumentNumber = size - 1;

    // If number of inputs given is not four, error message returned.
    if (argumentNumber != EXPECTED_ARGUMENT_NUMBER) {
      String feedback = "Error: Expected " + EXPECTED_ARGUMENT_NUMBER + " arguments "
          + "given " + argumentNumber + " arguments.";
      throw new IllegalArgumentException(feedback);
    }

    // Iterating through inputs and determining if email or letter
    // template should be created.
    for (int i = 1; i < size; i++) {
      if (arrayInput[i].equals(EMAIL_KEY)) {
        // If EMAIL_KEY (--email) is included, removing LETTER_KEY and LETTER_TEMPLATE_KEY
        // from dictionary.
        dictionary.remove(LETTER_KEY);
        dictionary.remove(LETTER_TEMPLATE_KEY);
        type = EMAIL_KEY;
        break;
      } else if (arrayInput[i].equals(LETTER_KEY)) {
        // If LETTER_KEY (--letter) is included, removing EMAIL_KEY and EMAIL_TEMPLATE_KEY
        // from dictionary.
        dictionary.remove(EMAIL_KEY);
        dictionary.remove(EMAIL_TEMPLATE_KEY);
        type = LETTER_KEY;
        size -= 1;
        break;
      } else {
        continue;
      }
    }

    // Iterating through inputs and populating the dictionary.
    for (int i = 1; i < size; i++) {
      if (arrayInput[i].equals(type)) {
        // If current argument is "--email" or "--letter", placing it into dictionary
        // with key: value pair, "--email": "--email" or "--letter": "--letter".
        dictionary.put(type, type);
        continue;
      }

      String [] input = arrayInput[i].split(" ");
      // If dictionary inputs contains a wrong key, print out an error message.
      if (!dictionary.containsKey(input[0])) {
        String feedback;
        if (type.equals(EMAIL_KEY) && input[0].equals(LETTER_TEMPLATE_KEY)) {
          // If --email was provided but no --email-template
          feedback = "Error: --"
              + type
              + "provided but no --"
              + EMAIL_TEMPLATE_KEY
              + " was provided.\n";
        } else if (type.equals(LETTER_KEY) && input[0].equals(EMAIL_TEMPLATE_KEY)) {
          // If --letter was provided but no --letter-template
          feedback = "Error: --"
              + type
              + "provided but no --"
              + LETTER_TEMPLATE_KEY
              + " was provided.\n";
        } else {
          // If given argument is not one of the legal arguments.
          feedback = "Error: --"
              + input[0]
              + " is not a legal input.\n";
        }
        throw new IllegalArgumentException(feedback);
      } else {
        // If not "--email" or "--letter", placing argument into dictionary with
        // key: value pair of flag: path. Example: --email-template: "emails"
        input[1] = input[1].replaceAll("\\s","");
        dictionary.put(input[0], input[1]);
      }
    }
    return dictionary;
  }

  /**
   * Main function that initiates the UI (calls the View class) to get user input and responds, as
   * necessary, based on user actions.
   * @param arguments - Arguments given by the user.
   * @throws Exception - Thrown any I/O exceptions occur.
   */
  public static void main(String[] arguments) throws Exception {

    HashMap<String, String> dictionaryArguments = createDictionary();

    String userInput;

    // Ask for user input via the View
    userInput = View.getInput("Enter arguments to generate email or letter:\n");

    try {
      dictionaryArguments = validInputs(userInput, dictionaryArguments);
    } catch (IllegalArgumentException exception) {
      // If the user provided improper inputs, provide user feedback.
      View.giveFeedback(exception.getMessage());
      View.provideExample();
      return;
    }

    // If there are no errors with inputs, proceed.
    GenerateMail model = new GenerateMail();
    MailType mailType;
    if (type == EMAIL_KEY) {
      mailType =  MailType.EMAIL;
      model.generateMail(dictionaryArguments.get(EMAIL_TEMPLATE_KEY),
          dictionaryArguments.get(FILE_KEY), mailType, dictionaryArguments.get(OUTPUT_KEY));
    } else {
      mailType =  MailType.LETTER;
      model.generateMail(dictionaryArguments.get(LETTER_TEMPLATE_KEY),
          dictionaryArguments.get(FILE_KEY), mailType, dictionaryArguments.get(OUTPUT_KEY));
    }

    // If everything is successful, provide user message indicating success.
    View.provideSuccessMessage();
  }

}
