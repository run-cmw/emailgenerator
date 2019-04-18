package edu.neu.css.cs5004;

/**
 * Interface representing Generate Mail.
 */
public interface IGenerateMail {

  /**
   * Method to generate mail.
   * @param templateName name of the template
   * @param fileName name of the file
   * @param mailType mailtype email/letter
   * @param outputDir output directory where the generated files will go
   */

  void generateMail(String templateName, String fileName, MailType mailType,
      String outputDir) throws Exception;


}
