package edu.neu.css.cs5004;

import java.util.HashMap;

public class Controller {
  private static final String emailKey = "email ";
  private static final String emailTemplateKey = "email-template";
  private static final String letterKey = "letter ";
  private static final String letterTemplateKey = "letter-template";
  private static final String fileKey = "csv-file";
  private static final String outputKey = "output-dir";
  private static final int expectedArgumentNumber = 4;

  public static HashMap<String, String> createDictionary() {
    HashMap<String, String> dictionaryArguments = new HashMap<>();
    dictionaryArguments.put(emailKey, null);
    dictionaryArguments.put(emailTemplateKey, null);
    dictionaryArguments.put(letterKey, null);
    dictionaryArguments.put(letterTemplateKey, null);
    dictionaryArguments.put(fileKey, null);
    dictionaryArguments.put(outputKey, null);
    return dictionaryArguments;
  }

  public static HashMap<String, String> validInputs(String userInput,
      HashMap<String, String> dictionary) throws IllegalArgumentException {
    String[] arrayInput = userInput.split("--");

    String type = "";

    int size = arrayInput.length;

    // If number of inputs given is not four, error message returned.
    if (size - 1 != expectedArgumentNumber) {
      String feedback = "Expected " + expectedArgumentNumber + " arguments "
          + "given " + size + " arguments.";
      throw new IllegalArgumentException(feedback);
    }

    // Iterating through inputs and determining if email or letter
    // template should be created.
    for (int i = 1; i < size; i++) {
      if (arrayInput[i].equals(emailKey)) {
        // If emailKey (--email) is included, removing letterKey and letterTemplateKey
        // from dictionary.
        dictionary.remove(letterKey);
        dictionary.remove(letterTemplateKey);
        type = emailKey;
        break;
      } else if (arrayInput[i].equals(letterKey)) {
        // If letterKey (--letter) is included, removing emailKey and emailTemplateKey
        // from dictionary.
        dictionary.remove(emailKey);
        dictionary.remove(emailTemplateKey);
        type = letterKey;
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
        if (type.equals(emailKey) && input[0].equals(letterTemplateKey)) {
          // If --email was provided but no --email-template
          feedback = "Error : --" + type + "provided but no --" + emailTemplateKey +
              " was provided.";
        } else if (type.equals(letterKey) && input[0].equals(emailTemplateKey)) {
          // If --letter was provided but no --letter-template
          feedback = "Error: --" + type + "provided but no --" + letterTemplateKey +
              " was provided.";
        } else {
          // If given argument is not one of the legal arguments.
          feedback = "Error: " + input[0] + " is not a legal input.";
        }
        throw new IllegalArgumentException(feedback);
      } else {
          // If not "--email" or "--letter", placing argument into dictionary with
          // key: value pair of flag: path. Example: --email-template: "emails"
          input[1].replaceAll("\\s","");
          dictionary.put(input[0], input[1]);
      }
    }
    return dictionary;
  }
  public static void main(String[] args) {
    // Model model = new Model();
    HashMap<String, String> dictionaryArguments = createDictionary();

    String userInput;

    // Ask for user input via the View
    userInput = View.getInput("Enter arguments to generate email or letter:");

    try {
      dictionaryArguments = validInputs(userInput, dictionaryArguments);
    } catch (IllegalArgumentException exception) {
      View.giveFeedback(exception.getMessage());
      View.provideExample();
    }
  }


}
