package edu.neu.css.cs5004;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GenerateMailTest {

  private GenerateMail newGenerateMail;
  private String letterTemplate;
  private String emailTemplate;
  private String csvFile;

  //private String corruptFileName;
  private String outputDirectoryEmail;
  private String outputDirectoryLetter;
  MailType mailTypeLetter;
  MailType mailTypeEmail;

  @Before
  public void setUp() throws Exception {

    newGenerateMail = new GenerateMail();
    letterTemplate = "custom-letter-template.txt";
    emailTemplate = "custom-email-template.txt";
    csvFile = "insurance_company_members.csv";
    outputDirectoryEmail = "email";
    outputDirectoryLetter = "letter";
    mailTypeLetter =  MailType.LETTER;
    mailTypeEmail =  MailType.EMAIL;
    //corruptFileName = "fileDoesNotExist.csv";

  }

  @Test
  public void generateMail() throws Exception {
    newGenerateMail.generateMail(letterTemplate, csvFile, mailTypeLetter, outputDirectoryLetter );

  }

  @Test
  public void generateEmail() throws Exception {
    newGenerateMail.generateMail(emailTemplate, csvFile, mailTypeEmail, outputDirectoryEmail );

  }






}