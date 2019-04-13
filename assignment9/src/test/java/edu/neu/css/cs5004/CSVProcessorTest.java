package edu.neu.css.cs5004;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class CSVProcessorTest {
  protected CSVProcessor processor;
  protected List<List<String>> headerArrayList;
  protected List<String> headerString;
  protected List<List<String>> memberInfoArrayList;
  protected List<String> memberInfoString;
  protected List<List<String>> sameHeaderList; // !!!!!!! move this and following 3 vars to respective equals testers?
  protected List<List<String>> differentHeaderList;
  protected List<List<String>> sameMemberInfoList;
  protected List<List<String>> differentMemberInfoList;

  @Before
  public void setUp() throws Exception {
    final String MEMBER_INFO_FILE = "insurance_company_members.csv";
    processor = new CSVProcessor(MEMBER_INFO_FILE);

    sameHeaderList = new ArrayList<>(); // !!!!!!! correctly populate this and following three vars
    differentHeaderList = new ArrayList<>();
    sameMemberInfoList = new ArrayList<>();
    differentMemberInfoList = new ArrayList<>();
  }

  @Test
  public void testParseHeader() {
    final String HEADER_STRING = "[first_name, last_name, company_name, address, city, county, "
        + "state, zip, phone1, phone2, email, web]";
    System.out.println(headerString);
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
//    final String DIFFERENT_DATA_TYPE1 = "first_name, last_name, company_name, address, city, county, "
//        + "state, zip, phone1, phone2, email, web";
//    final int DIFFERENT_DATA_TYPE2 = 0;
//    final float DIFFERENT_DATA_TYPE3 = 0.5f;
//    final CSVProcessor DIFFERENT_DATA_TYPE4 = processor;
//
//    assertEquals(headerArrayList, sameHeaderList);
//    assertEquals(headerArrayList, headerArrayList);
//    assertEquals(sameHeaderList, sameHeaderList);
//    assertEquals(differentHeaderList, differentHeaderList);
//    assertNotEquals(headerArrayList, differentHeaderList);
//    assertNotEquals(headerArrayList, DIFFERENT_DATA_TYPE1);
//    assertNotEquals(headerArrayList, DIFFERENT_DATA_TYPE2);
//    assertNotEquals(headerArrayList, DIFFERENT_DATA_TYPE3);
//    assertNotEquals(headerArrayList, DIFFERENT_DATA_TYPE4);
//  }
//
//  @Test
//  public void testInfoEquals() {
//    final String DIFFERENT_DATA_TYPE1 = "James, Butt, Benton, John B Jr, 6649 N Blue Gum St, "
//        + "New Orleans, Orleans, LA, 70116, 504-621-8927, 504-845-1427, "
//        + "jbutt@gmail.com, http://www.bentonjohnbjr.com";
//    final int DIFFERENT_DATA_TYPE2 = 0;
//    final float DIFFERENT_DATA_TYPE3 = 0.5f;
//    final CSVProcessor DIFFERENT_DATA_TYPE4 = processor;
//
//
//    assertEquals(memberInfoArrayList, sameMemberInfoList);
//    assertEquals(memberInfoArrayList, memberInfoArrayList);
//    assertEquals(sameMemberInfoList, sameMemberInfoList);
//    assertEquals(differentMemberInfoList, differentMemberInfoList);
//    assertNotEquals(memberInfoArrayList, differentMemberInfoList);
//    assertNotEquals(memberInfoArrayList, DIFFERENT_DATA_TYPE1);
//    assertNotEquals(memberInfoArrayList, DIFFERENT_DATA_TYPE2);
//    assertNotEquals(memberInfoArrayList, DIFFERENT_DATA_TYPE3);
//    assertNotEquals(memberInfoArrayList, DIFFERENT_DATA_TYPE4);
//  }
}