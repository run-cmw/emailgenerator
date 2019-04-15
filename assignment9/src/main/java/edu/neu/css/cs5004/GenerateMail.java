package edu.neu.css.cs5004;


import java.io.IOException;
import java.util.List;


public class GenerateMail {

  private final String MEMBER_INFO_FILE = "insurance_company_members_copy.csv";


  private List<String> headers;
  private List<List<String>> members;
  private ReadTemplate newReadTemplate = new ReadTemplate();
  private CSVProcessor newCSVProcessor = new CSVProcessor(MEMBER_INFO_FILE);

  public GenerateMail() throws IOException {

  }


  public void generateMail(String templateName, String fileName, MailType mailType,
      String outputDir) {

    headers = newCSVProcessor.getHeaderArrayList();
    // System.out.println("printing header:");
    // System.out.println(headers);
    // System.out.println("Header Size :" + headers.size());

    // System.out.println("Start Get Member info");
    members = newCSVProcessor.getMemberInfoArrayList();
    //System.out.println("printing members");
    //System.out.println(members);
    // System.out.println("END Get Member info");

    String template = newReadTemplate.parseTemplate(templateName);

    // System.out.println(System.getProperty("user.dir"));

    for (List<String> member : members) {

      String memberMail = template;
      System.out.println("printing member : " + member);
      System.out.println("Member size :" + member.size());

      for (int i = 0; i < headers.size(); i++) {
        String currentHeader = headers.get(i);
        System.out.println("printing current header");
        System.out.println(currentHeader);
        String memberProperty = member.get(i);
        //System.out.println(memberProperty);
        String stringToReplace = "\\[\\[" + currentHeader + "\\]\\]";
        memberMail = memberMail.replaceAll(stringToReplace, memberProperty);

      }
      System.out.println( "printing member mail: ");
      System.out.println(memberMail);

    }

  }

}


