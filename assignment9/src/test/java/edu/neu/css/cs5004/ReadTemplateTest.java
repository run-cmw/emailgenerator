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
  //String line;


  @Before
  public void setUp() throws Exception {
    templateToBeLoaded = new StringBuilder();
    templateName = "custom-email-template.txt";
    corruptedFileName = "noTemplate.txt";
    newTemplateRead = new ReadTemplate();
    String temp = newTemplateRead.parseTemplate("custom-email-template.txt");
  }

  @Test
  public void parseTemplate() {
    System.out.println(newTemplateRead.parseTemplate("custom-email-template.txt"));

  }





  @Test
  public void testToString(){

    System.out.println(newTemplateRead.parseTemplate("custom-email-template.txt"));

    newTemplateRead1 = new ReadTemplate();
    String temp1 = newTemplateRead1.parseTemplate("custom-email-template.txt");
    System.out.println(temp1);

    //assertEquals(temp, temp1);

  }


   @Test
  public void testHashCode(){



   }



   @Test
  public void testEquals(){


   }
}