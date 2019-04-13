package edu.neu.css.cs5004;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class CSVProcessorTest {
  private final String MEMBER_INFO_FILE = "insurance_company_members.csv";
  private CSVProcessor processor;
  private List<List<String>> headerArrayList;
  private List<List<String>> memberInfoArrayList;
  private List<List<String>> sameHeaderList;
  private List<List<String>> differentHeaderList;
  private List<List<String>> sameMemberInfoList;
  private List<List<String>> differentMemberInfoList;

  @Before
  public void setUp() throws Exception {
    processor = new CSVProcessor(MEMBER_INFO_FILE);
  }

  @Test
  public void testParseHeader() {
    final String HEADER_STRING = "[first_name, last_name, company_name, address, city, county, state, zip, phone1, phone2, email, web]";
    System.out.println(headerArrayList);

    assertEquals(HEADER_STRING, headerArrayList.toString());
  }

//  @Test
//  public void testParseMemberInfo() {
//    final String MEMBER_INFO_STRING = "James, Butt, Benton, John B Jr, 6649 N Blue Gum St, New Orleans, Orleans, LA, 70116, 504-621-8927, 504-845-1427, jbutt@gmail.com, http://www.bentonjohnbjr.com";
//    final String MEMBER_COMPANY_STRING = "Benton, John B Jr";
//
//    assertEquals(MEMBER_INFO_STRING, memberInfoArrayList.get(0).toString());
//    assertEquals(MEMBER_COMPANY_STRING, memberInfoArrayList.get(0).get(2));
//  }
//
//  @Test
//  public void testHeaderEquals() {
//  }
//
//  @Test
//  public void testInfoEquals() {
//  }
}