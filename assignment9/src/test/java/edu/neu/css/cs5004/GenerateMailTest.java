package edu.neu.css.cs5004;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GenerateMailTest {

  private GenerateMail newGenerateMail;
  private String emailTemplate;
  private String csvFile;

  private String corruptFileName;
  private String outputDirectory;
  MailType mailType;

  @Before
  public void setUp() throws Exception {

    newGenerateMail = new GenerateMail();
    emailTemplate = "custom-letter-template.txt";
    csvFile = "insurance_company_members.csv";
    outputDirectory = "email";
    mailType =  MailType.EMAIL;
    corruptFileName = "fileDoesNotExist.csv";

  }

  @Test
  public void generateMail() throws Exception {
    newGenerateMail.generateMail(emailTemplate, csvFile, mailType, outputDirectory );

  }
}