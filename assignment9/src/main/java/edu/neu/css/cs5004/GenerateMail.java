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
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GenerateMail{
  private final String MEMBER_INFO_FILE = "insurance_company_members.csv";

  private List<List<String>> headers;
  private List<String> result;
  private List<List<String>> currentCSVline;
  private List<String> curCSVresult;
  private ReadTemplate newReadTemplate = new ReadTemplate();
  private CSVProcessor newCSVProcessor = new CSVProcessor(MEMBER_INFO_FILE);

  public GenerateMail() throws IOException {

  }


  private List<String> convert(List<List<String>> headers){
    for (List<String> list : headers) {
      result.addAll(list);

    }
    return result;

  }



  public void generateMail(String templateName, String fileName, String mailType, String outputDirectory, String outputDir) throws Exception{

    try {

      headers = newCSVProcessor.parseHeader();
      result = convert(headers);


      System.out.println(System.getProperty("user.dir"));

      BufferedReader inputFile = null;
      inputFile = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

      String eachCSVline;
      inputFile.readLine();
      while((eachCSVline = inputFile.readLine()) != null){
        System.out.println("Read: " + eachCSVline);
        currentCSVline = newCSVProcessor.parseHeader();
        curCSVresult = convert(currentCSVline);


        StringBuilder newGroup = new StringBuilder();
        Pattern re;

        String template = newReadTemplate.parseTemplate(templateName);

        for (int i = 0; i < result.size(); i++) {
          newGroup.append("\\[\\[").append(result.get(i).replace("\"", "")).append("\\]\\]");
          re = Pattern.compile(newGroup.toString());
          Matcher newMatcher = re.matcher(template);
          if (newMatcher.find()) {
            template = template.replace(newMatcher.group(),
                curCSVresult.get(i).replace("\"", ""));
          }
          newGroup.setLength(0);
        }

        String outputFileName = mailType;
        outputFileName = outputFileName + "_"
            + curCSVresult.get(0).replace("\"", "") + " "
            + curCSVresult.get(1).replace("\"", "") + ".txt";
        BufferedWriter outputFile = new BufferedWriter(
            new OutputStreamWriter(
                new FileOutputStream(outputDir + File.separator + outputFileName)));
        outputFile.write(template);
        outputFile.flush();
        outputFile.close();


      }

      inputFile.close();

    } catch (FileNotFoundException fnfe) {
      System.out.println("*** OOPS! A file was not found : " + fnfe.getMessage());
      fnfe.printStackTrace();
    } catch (IOException ioe) {
      System.out.println("Something went wrong! : " + ioe.getMessage());
      ioe.printStackTrace();
    }

  }

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
        result.equals(that.result) &&
        currentCSVline.equals(that.currentCSVline) &&
        curCSVresult.equals(that.curCSVresult) &&
        newReadTemplate.equals(that.newReadTemplate) &&
        newCSVProcessor.equals(that.newCSVProcessor);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(MEMBER_INFO_FILE, headers, result, currentCSVline, curCSVresult, newReadTemplate,
            newCSVProcessor);
  }


  @Override
  public String toString() {
    return "GenerateMail{" +
        "MEMBER_INFO_FILE='" + MEMBER_INFO_FILE + '\'' +
        ", headers=" + headers +
        ", result=" + result +
        ", currentCSVline=" + currentCSVline +
        ", curCSVresult=" + curCSVresult +
        ", newReadTemplate=" + newReadTemplate +
        ", newCSVProcessor=" + newCSVProcessor +
        '}';
  }
}
