package edu.neu.css.cs5004;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class GenerateMail {

  private final String MEMBER_INFO_FILE = "insurance_company_members_copy.csv";

  private List<List<String>> rawHeaders;
  private List<String> headers;
  private List<List<String>> members;
  private ReadTemplate newReadTemplate = new ReadTemplate();
  private CSVProcessor newCSVProcessor = new CSVProcessor(MEMBER_INFO_FILE);

  public GenerateMail() throws IOException {

  }


  public void generateMail(String templateName, String fileName, MailType mailType,
      String outputDir) {

    rawHeaders = newCSVProcessor.getHeaderArrayList();
    System.out.println("printing raw header");
    System.out.println(rawHeaders);
    headers = Arrays.asList(rawHeaders.get(0).get(0).split(","));
    System.out.println("ptingting headers");
    System.out.println(headers);


    members = newCSVProcessor.getMemberInfoArrayList();
    //System.out.println("printing members");
    //System.out.println(members);

    String template = newReadTemplate.parseTemplate(templateName);

    // System.out.println(System.getProperty("user.dir"));

    for (List<String> member : members) {

      String memberMail = template;
      System.out.println("printing member : " + member);

      for (int i = 0; i < headers.size(); i++) {
        String currentHeader = headers.get(i);
        System.out.println("printing current header");
        System.out.println(currentHeader);
        String memberProperty = member.get(i);
        //System.out.println(memberProperty);
        String stringToReplace = "[[" + currentHeader + "]]";
        memberMail = memberMail.replaceAll(stringToReplace, memberProperty);

      }
      System.out.println( "printing member mail: ");
      System.out.println(memberMail);

    }

  }

}


