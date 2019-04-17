package edu.neu.css.cs5004;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GenerateMailTest {

  private GenerateMail newGenerateMail;
  private GenerateMail newGenerateMail1;
  private String letterTemplate;
  private String emailTemplate;
  private String csvFile;
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

  }

  @Test
  public void generateMailLetter() throws Exception {
    newGenerateMail.generateMail(letterTemplate, csvFile, mailTypeLetter, outputDirectoryLetter );

  }

  @Test
  public void generateEmailEmail() throws Exception {
    newGenerateMail.generateMail(emailTemplate, csvFile, mailTypeEmail, outputDirectoryEmail );

  }


  @Test
  public void testHashCode() throws Exception {
    newGenerateMail1 = new GenerateMail();
    newGenerateMail1.generateMail(emailTemplate, csvFile, mailTypeEmail, outputDirectoryEmail );
    assertNotEquals(newGenerateMail.hashCode(), newGenerateMail1.hashCode());
    assertEquals(newGenerateMail.hashCode(), newGenerateMail.hashCode() );

  }


  @Test
  public void testToString() throws Exception {

    String checkStr = "GenerateMail{MEMBER_INFO_FILE='insurance_company_members.csv', headers=null, members=null, newReadTemplate=ReadTemplate{templateToBeLoaded=}, newFileName='null'}";
    String checkStr1 = "";
    assertEquals(checkStr, newGenerateMail.toString());
    assertNotEquals(checkStr1, newGenerateMail.toString());

  }


  @Test
  public void testEquals() {

    assertTrue(newGenerateMail.equals(newGenerateMail));
    assertFalse(newGenerateMail.equals(newGenerateMail1));
  }


}