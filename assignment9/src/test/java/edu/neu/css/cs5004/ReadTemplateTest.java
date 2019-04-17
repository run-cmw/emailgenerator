package edu.neu.css.cs5004;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ReadTemplateTest {
  ReadTemplate newTemplateRead;
  ReadTemplate newTemplateRead1;

  StringBuilder templateToBeLoaded;
  String templateName;
  String corruptedFileName;
  String EmptyFile;
  String temp;
  String temp1;



  @Before
  public void setUp() throws Exception {
    templateToBeLoaded = new StringBuilder();
    templateName = "custom-email-template.txt";
    corruptedFileName = "noTemplate.txt";
    newTemplateRead = new ReadTemplate();
    newTemplateRead1 = new ReadTemplate();
    String temp = newTemplateRead.parseTemplate("custom-email-template.txt");
    String temp1 = newTemplateRead1.parseTemplate("custom-letter-template.txt");
  }

  @Test
  public void parseTemplate() {
    System.out.println(newTemplateRead.parseTemplate("custom-email-template.txt"));
    String checkString = newTemplateRead.parseTemplate("custom-email-template.txt");


  }


  @Test
  public void testToString(){

    ReadTemplate testTemplate = new ReadTemplate();
    String check = testTemplate.parseTemplate("test_custom_letter.txt");
    System.out.println(check);
    //System.out.println(testTemplate.parseTemplate("test_custom_letter.txt"));
    String checkStr = "We are truly sorry this incident occurred, and we sincerely regret any anxiety it may cause.\r\n";
    assertEquals(checkStr,testTemplate.parseTemplate("test_custom_letter.txt").toString() );

  }


   @Test
  public void testHashCode(){
    assertNotEquals(newTemplateRead1.hashCode(), newTemplateRead.hashCode());
    assertEquals(newTemplateRead.hashCode(), newTemplateRead.hashCode());
   }



   @Test
  public void testEquals(){
    assertTrue(newTemplateRead.equals(newTemplateRead));
    assertFalse(newTemplateRead.equals(newTemplateRead1));

   }



}