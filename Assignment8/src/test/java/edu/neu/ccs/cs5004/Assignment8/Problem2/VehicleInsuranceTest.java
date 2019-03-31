package edu.neu.ccs.cs5004.Assignment8.Problem2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class VehicleInsuranceTest {
  private VehicleInsurance vehicleInsurance;
  private Name owner;
  private ArrayList<AbstractName> insuredDrivers;
  private AbstractName insured1;
  private AbstractName insured2;
  private Date expirationDate;

  @Before
  public void setUp() throws Exception {
    vehicleInsurance = new VehicleInsurance(owner, insuredDrivers, expirationDate);
    owner = new Name("My", "Vehicle");
    insuredDrivers.add(insured1);
    insuredDrivers.add(insured2);
    insured1 = new AbstractName("Avery", "Wells");
    insured2 = new AbstractName("Chana", "Wells");
    expirationDate = new Date(30, 04, 2020);
  }

  @Test
  public void getOwner() {                       // update after toString()
    String ownerAsString = "MyVehicle";

    assertEquals(ownerAsString, vehicleInsurance.getOwner().toString());
  }

  @Test                                          // update after toString()
  public void getInsuredDrivers() {
    String additionalInsuredAsList = "AveryWells, ChanaWells";

    assertEquals(additionalInsuredAsList, vehicleInsurance.getInsuredDrivers().toString());
  }

  @Test
  public void getExpirationDate() {
    assertEquals(30, vehicleInsurance.getExpirationDate().getDay());
    assertEquals(04, vehicleInsurance.getExpirationDate().getMonth());
    assertEquals(2020, vehicleInsurance.getExpirationDate().getYear());
  }
}