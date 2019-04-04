package edu.neu.ccs.cs5004.assignment8.problem2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class RideShareSystemTest {
  IRideShareSystem system;
  IName name;
  IDate birthday;
  IDriversLicense license;
  IVehicle vehicle;
  IDate issueDate;
  IDate expirationDate;
  IAddress address;
  IVehicleInsurance vehicleInsurance;
  ArrayList<IName> insuredDrivers;
  IName insured1;
  IName insured2;
  IHistory driverHistory;
  IHistory vehicleHistory;
  ArrayList<ITrafficViolation> driverViolations;
  ArrayList<ITrafficViolation> vehicleViolations;
  ITrafficViolation driverViolation;
  ITrafficViolation vehicleViolation;
  IDate violationDate;
  ArrayList<IVehicleCrash> crashes;
  IVehicleCrash crash;
  IAcceptedDriver acceptedDriver;


  @Before
  public void setUp() throws Exception {
    system = new RideShareSystem();

    // Creating vehicle insurance
    insuredDrivers = new ArrayList<>();
    name = new Name("Tommy", "Land");
    insured1 = new Name("Insured", "First");
    insured2 = new Name("Insured", "Second");
    insuredDrivers.add(insured1);
    insuredDrivers.add(insured2);
    birthday = new Date(3, 3, 1990);
    issueDate = new Date(15, 3, 2017);
    expirationDate = new Date(15, 5, 2019);
    //Creating vehicle and vehicle insurance
    vehicle = new Vehicle("Toyota", "Camry", 2017, name);
    vehicleInsurance = new VehicleInsurance(name, insuredDrivers, expirationDate, vehicle);

    // Creating Driver's License
    address = new Address("123 Made Up Street",
        "Seattle", "WA", "98008");
    license = new DriversLicense("1234567", name, address, birthday, Country.US,
        "Washington", issueDate, expirationDate);

    // Creating Driver Traffic Violations and History
    violationDate = new Date(10, 1, 2018);
    driverViolation =
        new MovingTrafficViolation(violationDate, MovingViolation.IGNORE_TRAFFIC_SIGNS);
    driverViolations = new ArrayList<>();
    driverViolations.add(driverViolation);
    driverHistory = new DriverHistory(driverViolations);

    // Creating Vehicle Traffic Violations, crashes, and history
    vehicleViolations = new ArrayList<>();
    vehicleViolation =
        new MovingTrafficViolation(violationDate, MovingViolation.IGNORE_TRAFFIC_SIGNS, name);
    vehicleViolations.add(vehicleViolation);
    crashes = new ArrayList<>();
    crash = new VehicleCrash(violationDate, Crash.FENDER_BENDER);
    crashes.add(crash);
    vehicleHistory = new VehicleHistory(vehicleViolations, crashes);

    // Creating accepted driver
    acceptedDriver = new AcceptedDriver(name, birthday, license, vehicle);
  }

  @Test
  public void registerAsProspectiveDriver() {
    assertEquals(true, system.registerAsProspectiveDriver(name, birthday, license, vehicle,
        vehicleInsurance, driverHistory, vehicleHistory));
  }

  @Test
  public void invalidCountry() {
    license = new DriversLicense("1234567", name, address, birthday, Country.MEXICO,
        "Washington", issueDate, expirationDate);

    assertEquals(false, system.registerAsProspectiveDriver(name, birthday, license, vehicle,
        vehicleInsurance, driverHistory, vehicleHistory));
  }

  @Test
  public void invalidVehicleAge() {
    // Vehicle more than 20 years old
    vehicle = new Vehicle("Toyota", "Camry", 1998, name);
    assertEquals(false, system.registerAsProspectiveDriver(name, birthday, license, vehicle,
        vehicleInsurance, driverHistory, vehicleHistory));
  }

  @Test
  public void invalidVehicleGivenAndLicense() {
    // Given vehicle doesn't match one on license
    vehicle = new Vehicle("Toyota", "Camry", 2016, name);
    assertEquals(false, system.registerAsProspectiveDriver(name, birthday, license, vehicle,
        vehicleInsurance, driverHistory, vehicleHistory));
  }

  @Test
  public void violationDriverHistory() {
    // Driver history includes DUI Moving Violation that gets the application rejected
    driverViolations = new ArrayList<>();
    ITrafficViolation driverViolation2 =
        new MovingTrafficViolation(violationDate, MovingViolation.DUI, name);
    driverViolations.add(driverViolation2);
    driverHistory = new DriverHistory(driverViolations);
    assertEquals(false, system.registerAsProspectiveDriver(name, birthday, license, vehicle,
        vehicleInsurance, driverHistory, vehicleHistory));

    // Driver history includes RECKLESS_DRIVING Moving Violation that gets the application rejected
    driverViolations = new ArrayList<>();
    ITrafficViolation driverViolation3 =
        new MovingTrafficViolation(violationDate, MovingViolation.RECKLESS_DRIVING , name);
    driverViolations.add(driverViolation3);
    driverHistory = new DriverHistory(driverViolations);
    assertEquals(false, system.registerAsProspectiveDriver(name, birthday, license, vehicle,
        vehicleInsurance, driverHistory, vehicleHistory));

    // Driver history includes SPEEDING Moving Violation that gets the application rejected
    driverViolations = new ArrayList<>();
    ITrafficViolation driverViolation4 =
        new MovingTrafficViolation(violationDate, MovingViolation.SPEEDING, name);
    driverViolations.add(driverViolation4);
    driverHistory = new DriverHistory(driverViolations);
    assertEquals(false, system.registerAsProspectiveDriver(name, birthday, license, vehicle,
        vehicleInsurance, driverHistory, vehicleHistory));

    // Driver history includes INVALID_LICENSE_OR_INSURANCE Moving Violation that gets the
    // application rejected
    driverViolations = new ArrayList<>();
    ITrafficViolation driverViolation5 =
        new MovingTrafficViolation(violationDate, MovingViolation.DUI, name);
    driverViolations.add(driverViolation5);
    driverHistory = new DriverHistory(driverViolations);
    assertEquals(false, system.registerAsProspectiveDriver(name, birthday, license, vehicle,
        vehicleInsurance, driverHistory, vehicleHistory));

  }

  @Test
  public void invalidTrafficViolationVehicleHistory() {

    // Traffic violation within six months
    vehicleViolations = new ArrayList<>();
    violationDate = new Date(30, 2, 2019);
    vehicleViolation =
        new MovingTrafficViolation(violationDate, MovingViolation.IGNORE_TRAFFIC_SIGNS, name);
    vehicleViolations.add(vehicleViolation);
    vehicleHistory = new VehicleHistory(vehicleViolations, crashes);
    assertEquals(false, system.registerAsProspectiveDriver(name, birthday, license, vehicle,
        vehicleInsurance, driverHistory, vehicleHistory));
  }

  @Test
  public void invalidCrashVehicleHistory() {

    // Traffic violation within six months
    violationDate = new Date(30, 2, 2019);
    crashes = new ArrayList<>();
    crash = new VehicleCrash(violationDate, Crash.FENDER_BENDER);
    crashes.add(crash);
    vehicleHistory = new VehicleHistory(vehicleViolations, crashes);
    assertEquals(false, system.registerAsProspectiveDriver(name, birthday, license, vehicle,
        vehicleInsurance, driverHistory, vehicleHistory));
  }

  @Test
  public void expiredVehicleInsurance() {
    // The insurance has expired
    expirationDate = new Date(30, 3, 2019);
    vehicleInsurance = new VehicleInsurance(name, insuredDrivers, expirationDate, vehicle);
    assertEquals(false, system.registerAsProspectiveDriver(name, birthday, license, vehicle,
        vehicleInsurance, driverHistory, vehicleHistory));
  }

  @Test
  public void invalidProspectiveDriverAndOwner() {
    // Given name doesn't match owner of vehicle and name not in insured list.
    IName name = new Name("Tom", "Tom");
    license = new DriversLicense("1234567", name, address, birthday, Country.US,
        "Washington", issueDate, expirationDate);
    assertEquals(false, system.registerAsProspectiveDriver(name, birthday, license, vehicle,
        vehicleInsurance, driverHistory, vehicleHistory));
  }


  @Test
  public void invalidOwnerValidProspectiveDriver() {
    // Given name doesn't match owner of vehicle but name in insured list.
    IName name = new Name("Tom", "Tom");
    license = new DriversLicense("1234567", name, address, birthday, Country.US,
        "Washington", issueDate, expirationDate);
    insuredDrivers.add(name);
    assertEquals(true, system.registerAsProspectiveDriver(name, birthday, license, vehicle,
        vehicleInsurance, driverHistory, vehicleHistory));
  }


  @Test
  public void invalidAge() {
    birthday = new Date(3, 3, 2000);
    assertEquals(false, system.registerAsProspectiveDriver(name, birthday, license, vehicle,
        vehicleInsurance, driverHistory, vehicleHistory));
  }

  @Test
  public void invalidLicenseAge() {
    // License issued less than six months
    issueDate = new Date(3, 5, 2019);
    license = new DriversLicense("1234567", name, address, birthday, Country.US,
        "Washington", issueDate, expirationDate);

    assertEquals(false, system.registerAsProspectiveDriver(name, birthday, license, vehicle,
        vehicleInsurance, driverHistory, vehicleHistory));
  }

  @Test
  public void expiredLicense() {
    // License already expired - year same, month different
    expirationDate = new Date(30, 3, 2019);
    license = new DriversLicense("1234567", name, address, birthday, Country.US,
        "Washington", issueDate, expirationDate);

    assertEquals(false, system.registerAsProspectiveDriver(name, birthday, license, vehicle,
        vehicleInsurance, driverHistory, vehicleHistory));

    // License has expired - year different
    expirationDate = new Date(30, 3, 2018);
    license = new DriversLicense("1234567", name, address, birthday, Country.US,
        "Washington", issueDate, expirationDate);

    assertEquals(false, system.registerAsProspectiveDriver(name, birthday, license, vehicle,
        vehicleInsurance, driverHistory, vehicleHistory));
  }

  @Test
  public void invalidBirthdayGivenAndLicense() {
    // Birthday given on application and on license doesn't match
    // License birthday = new Date(3, 3, 1990);

    assertEquals(true, system.registerAsProspectiveDriver(name, birthday, license, vehicle,
        vehicleInsurance, driverHistory, vehicleHistory));

    // Changing application birthday
    birthday = new Date(3, 4, 1990);

    assertEquals(false, system.registerAsProspectiveDriver(name, birthday, license, vehicle,
        vehicleInsurance, driverHistory, vehicleHistory));
  }


  @Test
  public void getAcceptedDriversList() {
    system.registerAsProspectiveDriver(name, birthday, license, vehicle,
        vehicleInsurance, driverHistory, vehicleHistory);

    // Using different vehicle adding 2nd accepted Driver
    vehicle = new Vehicle("Toyota", "Camry", 2018, name);
    vehicleInsurance = new VehicleInsurance(name, insuredDrivers, expirationDate, vehicle);
    system.registerAsProspectiveDriver(name, birthday, license, vehicle,
        vehicleInsurance, driverHistory, vehicleHistory);

    // Creating 2nd accepted driver
    IAcceptedDriver acceptedDriver2 = new AcceptedDriver(name, birthday, license, vehicle);

    // Getting accepted driver list
    ArrayList<IAcceptedDriver> drivers = system.getAcceptedDriversList();
    IAcceptedDriver driver = drivers.get(0);
    assertEquals(true, acceptedDriver.equals(drivers.get(0)));
    assertEquals(true, acceptedDriver2.equals(drivers.get(1)));

  }

  @Test
  public void testEquals() {
    system.registerAsProspectiveDriver(name, birthday, license, vehicle,
        vehicleInsurance, driverHistory, vehicleHistory);

    assertEquals(true, system.equals(system));

    IRideShareSystem newSystem = new RideShareSystem();
    newSystem.registerAsProspectiveDriver(name, birthday, license, vehicle,
        vehicleInsurance, driverHistory, vehicleHistory);
    assertEquals(true, system.equals(newSystem));

    name = new Name("Tommy", "Lan");
    IRideShareSystem different = new RideShareSystem();
    different.registerAsProspectiveDriver(name, birthday, license, vehicle,
        vehicleInsurance, driverHistory, vehicleHistory);

    assertEquals(false, system.equals(different));
    assertEquals(false, system.equals(name));
    assertEquals(false, system.equals(null));

  }

  @Test
  public void testHashCode() {
    system.registerAsProspectiveDriver(name, birthday, license, vehicle,
        vehicleInsurance, driverHistory, vehicleHistory);

    IRideShareSystem newSystem = new RideShareSystem();
    newSystem.registerAsProspectiveDriver(name, birthday, license, vehicle,
        vehicleInsurance, driverHistory, vehicleHistory);

    name = new Name("Tommy", "Lan");
    IRideShareSystem different = new RideShareSystem();
    different.registerAsProspectiveDriver(name, birthday, license, vehicle,
        vehicleInsurance, driverHistory, vehicleHistory);

    assertEquals(true, newSystem.hashCode() == system.hashCode());
    assertEquals(false, different.hashCode() == system.hashCode());
  }

  @Test
  public void testToString() {
    system.registerAsProspectiveDriver(name, birthday, license, vehicle,
        vehicleInsurance, driverHistory, vehicleHistory);
    assertEquals("RideShareSystem - acceptedDrivers = [Driver: Tommy Land, "
            + "Vehicle: 2017 Toyota Camry]",
        system.toString());
  }
}