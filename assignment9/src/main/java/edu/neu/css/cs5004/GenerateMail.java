package edu.neu.css.cs5004;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Objects;


public class GenerateMail {

  private final String MEMBER_INFO_FILE = "insurance_company_members_copy.csv";


  private List<String> headers;
  private List<List<String>> members;
  private ReadTemplate newReadTemplate = new ReadTemplate();
  private CSVProcessor newCSVProcessor = new CSVProcessor(MEMBER_INFO_FILE);
  private String newFileName;


  public GenerateMail() throws IOException {

  }


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

      //System.out.println( "printing member mail: ");
      //System.out.println(memberMail);

      Enum OutPutFileName = mailType;

      //System.out.println("OutputFile name is" + OutPutFileName);
      newFileName = OutPutFileName + "_"
          + member.get(0).replace("\"", "") + "_"
          + member.get(1).replace("\"", "") + ".txt";

      //System.out.println(newFileName);

      BufferedWriter outputFile = new BufferedWriter( new OutputStreamWriter(new FileOutputStream(outputDir + File.separator + newFileName)));
      outputFile.write(memberMail);
      outputFile.flush();
      outputFile.close();


    }



  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof GenerateMail)) {
      return false;
    }
    GenerateMail that = (GenerateMail) o;
    return MEMBER_INFO_FILE.equals(that.MEMBER_INFO_FILE) &&
        headers.equals(that.headers) &&
        members.equals(that.members) &&
        newReadTemplate.equals(that.newReadTemplate) &&
        newCSVProcessor.equals(that.newCSVProcessor) &&
        newFileName.equals(that.newFileName);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(MEMBER_INFO_FILE, headers, members, newReadTemplate, newCSVProcessor, newFileName);
  }


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




