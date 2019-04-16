package edu.neu.css.cs5004;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Objects;

/**
 * This class represents Generating a mail functionality
 */

public class GenerateMail {

  private final String MEMBER_INFO_FILE = "insurance_company_members_copy.csv";

  /**
   * List of headers
   */
  private List<String> headers;
  /**
   * List of List containing string of members
   */
  private List<List<String>> members;
  /**
   * Create a new object of Readtemplate
   */
  private ReadTemplate newReadTemplate = new ReadTemplate();

  /**
   * Create a new object of CSVProcsessor
   */
  private CSVProcessor newCSVProcessor = new CSVProcessor(MEMBER_INFO_FILE);

  /**
   * newFileName as a String
   */
  private String newFileName;

  /**
   * Constructor to GenerateMail
   * @throws IOException Exception thrown
   */
  public GenerateMail() throws IOException {

  }

  /**
   * Method to generate Mail
   * @param templateName templateName
   * @param fileName fileName
   * @param mailType mailType
   * @param outputDir outputDir
   * @throws Exception
   */
  public void generateMail(String templateName, String fileName, MailType mailType, String outputDir) throws Exception{

    headers = newCSVProcessor.getHeaderArrayList();

    members = newCSVProcessor.getMemberInfoArrayList();

    String template = newReadTemplate.parseTemplate(templateName);

    for (List<String> member : members) {

      String memberMail = template;
      for (int i = 0; i < headers.size(); i++) {
        String currentHeader = headers.get(i);
        String memberProperty = member.get(i);
        String stringToReplace = "\\[\\[" + currentHeader + "\\]\\]";
        memberMail = memberMail.replaceAll(stringToReplace, memberProperty);

      }

      Enum OutPutFileName = mailType;

      //System.out.println("OutputFile name is" + OutPutFileName);
      newFileName = OutPutFileName + "_"
          + member.get(0).replace("\"", "") + "_"
          + member.get(1).replace("\"", "") + ".txt";

      BufferedWriter outputFile = new BufferedWriter( new OutputStreamWriter(new FileOutputStream(outputDir + File.separator + newFileName)));
      outputFile.write(memberMail);
      outputFile.flush();
      outputFile.close();


    }

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
    if (!(obj instanceof GenerateMail)) {
      return false;
    }
    GenerateMail that = (GenerateMail) obj;
    return MEMBER_INFO_FILE.equals(that.MEMBER_INFO_FILE) &&
        headers.equals(that.headers) &&
        members.equals(that.members) &&
        newReadTemplate.equals(that.newReadTemplate) &&
        newCSVProcessor.equals(that.newCSVProcessor) &&
        newFileName.equals(that.newFileName);
  }

  /**
   * Returns a hash code value for the object.
   *
   * @return hash code value for the object
   */
  @Override
  public int hashCode() {
    return Objects
        .hash(MEMBER_INFO_FILE, headers, members, newReadTemplate, newCSVProcessor, newFileName);
  }

  /**
   * Returns a string representation of the object
   * @return String representation of the object
   */

  @Override
  public String toString() {
    return "GenerateMail{" +
        "MEMBER_INFO_FILE='" + MEMBER_INFO_FILE + '\'' +
        ", headers=" + headers +
        ", members=" + members +
        ", newReadTemplate=" + newReadTemplate +
        ", newCSVProcessor=" + newCSVProcessor +
        ", newFileName='" + newFileName + '\'' +
        '}';
  }
}




