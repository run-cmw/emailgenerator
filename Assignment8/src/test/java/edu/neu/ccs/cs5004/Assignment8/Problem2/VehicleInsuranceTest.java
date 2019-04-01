package edu.neu.ccs.cs5004.Assignment8.Problem2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class VehicleInsuranceTest {
  private VehicleInsurance vehicleInsurance;
  private IName owner;
  private ArrayList<IName> insuredDrivers;
  private IName insured1;
  private IName insured2;
  private Date expirationDate;
  private IVehicle vehicle;

  @Before
  public void setUp() throws Exception {
    insuredDrivers = new ArrayList<>();
    vehicle = new Vehicle("Space", "Machine", 2020, owner);
    owner = new Name("My", "Vehicle");
    insured1 = new Name("Avery", "Wells");
    insured2 = new Name("Chana", "Wells");
    insuredDrivers.add(insured1);
    insuredDrivers.add(insured2);
    expirationDate = new Date(30, 04, 2020);
    vehicleInsurance = new VehicleInsurance(owner, insuredDrivers, expirationDate, vehicle);
  }

  @Test
  public void getOwner() {
    String ownerAsString = "My Vehicle";

    assertEquals(ownerAsString, vehicleInsurance.getOwner().toString());
  }

  @Test
  public void getInsuredDrivers() {

    assertEquals("Avery Wells", vehicleInsurance.getInsuredDrivers().get(0).toString());
    assertEquals("Chana Wells", vehicleInsurance.getInsuredDrivers().get(1).toString());
  }

  @Test
  public void getExpirationDate() {
    assertEquals(30, vehicleInsurance.getExpirationDate().getDay());
    assertEquals(04, vehicleInsurance.getExpirationDate().getMonth());
    assertEquals(2020, vehicleInsurance.getExpirationDate().getYear());
  }
}