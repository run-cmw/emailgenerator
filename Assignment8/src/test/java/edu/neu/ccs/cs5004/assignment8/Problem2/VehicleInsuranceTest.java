package edu.neu.ccs.cs5004.assignment8.Problem2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class VehicleInsuranceTest {
  private VehicleInsurance vehicleInsurance;
  private VehicleInsurance same;
  private VehicleInsurance different;

  @Before
  public void setUp() throws Exception {
    ArrayList<IName> insuredDrivers = new ArrayList<>();
    IName owner = new Name("My", "Vehicle");
    IName insured1 = new Name("Avery", "Wells");
    IName insured2 = new Name("Chana", "Wells");
    Date expirationDate = new Date(30, 4, 2020);
    IVehicle vehicle = new Vehicle("Space", "Machine", 2020, owner);

    insuredDrivers.add(insured1);
    insuredDrivers.add(insured2);

    vehicleInsurance = new VehicleInsurance(owner, insuredDrivers, expirationDate, vehicle);

    Date differentExpDate = new Date (31, 7, 2020);
    same = new VehicleInsurance(owner, insuredDrivers, expirationDate, vehicle);
    different = new VehicleInsurance(owner, insuredDrivers, differentExpDate, vehicle);
  }

  @Test
  public void getOwner() {
    final String OWNER_AS_STRING = "My Vehicle";

    assertEquals(OWNER_AS_STRING, vehicleInsurance.getOwner().toString());
  }

  @Test
  public void getInsuredDrivers() {
    final String INSURED_1_AS_STRING = "Avery Wells";
    final String INSURED_2_AS_STRING = "Chana Wells";

    assertEquals(INSURED_1_AS_STRING, vehicleInsurance.getInsuredDrivers().get(0).toString());
    assertEquals(INSURED_2_AS_STRING, vehicleInsurance.getInsuredDrivers().get(1).toString());
  }

  @Test
  public void getExpirationDate() {
    final String DATE_AS_STRING = "4/30/2020";

    assertEquals(30, vehicleInsurance.getExpirationDate().getDay());
    assertEquals(4, vehicleInsurance.getExpirationDate().getMonth());
    assertEquals(2020, vehicleInsurance.getExpirationDate().getYear());
    assertEquals(DATE_AS_STRING, vehicleInsurance.getExpirationDate().toString());
  }

  @Test
  public void getVehicle() {
    final String VEHICLE_AS_STRING = "2020 Space Machine";

    assertEquals(VEHICLE_AS_STRING, vehicleInsurance.getVehicle().toString());
  }

  @Test
  public void equals() {
    assertTrue(same.equals(vehicleInsurance));
    assertTrue(same.equals(same));
    assertFalse(different.equals(vehicleInsurance));
    assertFalse(same.equals(2));
  }

  @Test
  public void equalHashCode() {
    assertEquals(same.hashCode(),vehicleInsurance.hashCode());
  }

  @Test
  public void differentHashCode() {
    assertNotEquals(different.hashCode(), vehicleInsurance.hashCode());
  }

  @Test
  public void testToString() {
    final String INSURANCE_AS_STRING = "Owner: My Vehicle, Additional Insured: [Avery Wells, Chana Wells]";

    assertEquals(INSURANCE_AS_STRING, vehicleInsurance.toString());
  }
}