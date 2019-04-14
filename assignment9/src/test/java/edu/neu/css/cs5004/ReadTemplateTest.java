package edu.neu.css.cs5004;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ReadTemplateTest {
  ReadTemplate newTemplateRead;

  StringBuilder templateToBeLoaded;
  String templateName;
  String corruptedFileName;
  String EmptyFile;
  //String line;


  @Before
  public void setUp() throws Exception {
    templateToBeLoaded = new StringBuilder();
    templateName = "custom-email-template.txt";
    corruptedFileName = "noTemplate.txt";
    newTemplateRead = new ReadTemplate();
  }

  @Test
  public void parseTemplate() {
    System.out.println(newTemplateRead.parseTemplate("custom-email-template.txt"));




  }
}