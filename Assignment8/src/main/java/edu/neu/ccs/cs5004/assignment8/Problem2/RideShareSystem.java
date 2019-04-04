
package edu.neu.ccs.cs5004.assignment8.Problem2;

 import java.util.ArrayList;
 import java.time.LocalDateTime;
 import java.util.Objects;

 /**
 * This class implements IRideShareSystem and represents a ride share system.
 */
 public class RideShareSystem implements IRideShareSystem {

  /**
   * Array List of accepted drivers that meet the acceptance requirements
   * (unique list of AcceptedDrivers).
   */
  private ArrayList<IAcceptedDriver> acceptedDrivers;
  /**
   * Minimum age that a driver has to be to be accepted.
   */
  private static final int MINIMUM_AGE = 21;
  /**
   * The maximum age of a driver's vehicle that the vehicle can be.
   */
  private static final int MAX_VEHICLE_AGE = 20;
  /**
   * The Country US - the only country that a license can be from to be accepted.
   */
  private static final Country VALID_COUNTRY = Country.US;
  /**
   * The minimum month of 6 months.
   */
  private static final int MIN_MONTH = 6;

  /**
   * Constructor
   */
  public RideShareSystem() {
   this.acceptedDrivers = new ArrayList<>();
  }

  /**
   * A method that allows a person to register as a prospective driver. Returns true if the driver
   * is accepted to be a driver and false it not.
   *
   * @param name - applicant's name
   * @param birthDate - applicant's birth date
   * @param driversLicense - applicant's driver's license
   * @param vehicle - vehicle information
   * @param vehicleInsurance - vehicle insurance information
   * @param driverHistory - applicant's driver history
   * @param vehicleHistory - vehicle's history
   * @return true if the driver is accepted to be a driver and false it not.
   */
  @Override
  public boolean registerAsProspectiveDriver(IName name, IDate birthDate,
      IDriversLicense driversLicense, IVehicle vehicle, IVehicleInsurance vehicleInsurance,
      IHistory driverHistory, IHistory vehicleHistory) {
   return validateRegistration(name, birthDate, driversLicense, vehicle,
       vehicleInsurance, driverHistory, vehicleHistory);
  }

  /**
   * Validate information to determine if the driver meets ride share acceptance requirements.
   * @param name - applicant's name
   * @param birthDate - applicant's birth date
   * @param driversLicense - applicant's driver's license
   * @param vehicle - vehicle information
   * @param vehicleInsurance - vehicle insurance information
   * @param driverHistory - applicant's driver history
   * @param vehicleHistory - vehicle's history
   * @return true if applicant meets all requirements, false if missing at least one requirement
   */
  private boolean validateRegistration(IName name, IDate birthDate, IDriversLicense driversLicense,
      IVehicle vehicle, IVehicleInsurance vehicleInsurance, IHistory driverHistory,
      IHistory vehicleHistory) {
   boolean accept = this.validAge(birthDate)
       && this.validLicenseInformation(name, birthDate, driversLicense)
       && this.validVehicleInformation(vehicle)
       && this.validInsuranceInformation(name, vehicle, vehicleInsurance)
       && this.validDriverHistory(driverHistory)
       && this.validVehicleHistory(vehicleHistory);
   if (accept) {
    this.addAcceptedDriver(name, birthDate, driversLicense, vehicle);
   }
   return accept;
  }

  /**
   * If the driver (name, birth date, license) and vehicle information combination does not already
   * exist in the ride share system (in the ArrayList acceptedDrivers), add the AcceptedDriver
   * to the accepted drivers list. Else, return and do nothing.
   * @param name - Driver's name
   * @param birthDate - Driver's birth date
   * @param driversLicense - Driver license of the driver.
   * @param vehicle - Vehicle information of the driver.
   */
  private void addAcceptedDriver(IName name, IDate birthDate, IDriversLicense driversLicense,
      IVehicle vehicle) {
   IAcceptedDriver newDriver = new AcceptedDriver(name, birthDate, driversLicense, vehicle);
   int size = this.acceptedDrivers.size();

   for (int i = 0; i < size; i++) {
    // If the Driver and the vehicle combination (AcceptedDriver) already exists in the system as
    // an accepted driver, exit the method and do nothing.
    if (this.acceptedDrivers.get(i).equals(newDriver)) {
     return;
    }
   }

   // If the Driver and vehicle combination does not already exit in the system as an
   // accepted driver, add the AcceptedDriver to the system (in the ArrayList acceptedDrivers).
   this.acceptedDrivers.add(newDriver);
  }

  /**
   * Helper to check whether or not the driver is over the minimum age. Returns false if younger
   * than 21. Returns true if 21 or over.
   *
   * @param birthday - The birthday of the driver.
   * @return - True if the driver is 21 or over, false if under 21.
   */
  private boolean validAge(IDate birthday) {
   int currentMonth = LocalDateTime.now().getMonthValue();
   int currentDay = LocalDateTime.now().getDayOfMonth();
   int currentYear = LocalDateTime.now().getYear();

   // If the current month is greater than the birthday month (birthday month hasn't passed yet)
   // or if the current month is equal to the birthday month and the current date is greater
   // than the birthday day (birthday day and month haven't passed yet), subtract one year
   // from the current year since the birthday hasn't happened for this year yet.
   if ((currentMonth > birthday.getMonth()) ||
       (currentMonth == birthday.getMonth() && currentDay > birthday.getDay())) {
    currentYear--;
   }

   if (currentYear - birthday.getYear() >= MINIMUM_AGE) {
    return true;
   } else {
    return false;
   }
  }

  /**
   * Helper method that checks four of the following information on the driver's license. 1. If the
   * name on the license doesn't match the name provided on the application. 2. If there are
   * differences between the birthday provided on the application and that of the license. 3. If the
   * license was not issued in the United States. 4. If the driver license was issued less than six
   * months ago. 5. If the driver license has expired. If any of the above are true, this method
   * will return false and the application will be rejected.
   *
   * @param license - The driver license of the applicant.
   * @return - True if none of the conditions above are true, false if any of the conditions are
   * true.
   */
  private boolean validLicenseInformation(IName name, IDate birthday, IDriversLicense license) {

   // If the name on application and license aren't equal, return false.
   if (!name.equals(license.getDriverName())) {
    return false;
   }
   // If the birthday given on application and license aren't equal, return false.
   if (!birthday.equals(license.getDriverBirthDate())) {
    return false;
   }

   // If the driver license was issued less than six months ago, return false.
   IDate issued = license.getIssueDate();
   if (!this.pastSixMonths(issued)) {
    return false;
   }

   IDate expiration = license.getExpirationDate();
   // If the license has expired, return false.
   if (this.hasExpired(expiration)) {
    return false;
   }

   // If the license if not issued in the US, return false.
   if (license.getIssuingCountry() != VALID_COUNTRY) {
    return false;
   }
   // If none of the conditions above are true, return true.
   return true;
  }


  /**
   * Helper that returns false if the given date has not expired and true if it has expired.
   * @param expiration - Date of expiration.
   * @return true if expired, false if not.
   */
  private boolean hasExpired (IDate expiration) {
   int currentMonth = LocalDateTime.now().getMonthValue();
   int currentDay = LocalDateTime.now().getDayOfMonth();
   int currentYear = LocalDateTime.now().getYear();

   // Checking if license has expired. If the current year > expiration year,
   // has expired.
   if (currentYear > expiration.getYear()) {
    return true;
   }

   //Checking if current year == expiration year.
   if (currentYear == expiration.getYear()) {
    if (currentMonth > expiration.getMonth()) {
     // If current month > expiration month and current year == expiration year,
     // license has expired, so return false.
     return true;
    }
    // If current month and year == expiration month and year,
    // checking if the current day is greater than the expiration day.
    // If so, return false as license has expired.
    if (currentMonth == expiration.getMonth()
        && currentDay > expiration.getDay()) {
     return true;
    }
   }
   return false;
  }

  /**
   * Helper that checks if the vehicle is older than 20 years. If the vehicle is older than
   * 20 years, this driver application is not valid and will return false.
   * @param vehicle - Vehicle of the driver.
   * @return True if the vehicle is 20 years or less, false if the vehicle is older than 20 years.
   */
  private boolean validVehicleInformation(IVehicle vehicle) {
   int currentYear = LocalDateTime.now().getYear();
   int vehicleYear = vehicle.getYear();

   if (currentYear - vehicleYear > MAX_VEHICLE_AGE) {
    return false;
   } else {
    return true;
   }
  }


  /**
   * Helper method that checks the following
   * 1. If the prospective driver is the owner of the vehicle.
   * 2. If the prospective driver is not the owner of the vehicle, if the driver
   * is listed as an insured driver.
   * 3. If the insurance has not expired.
   * 4. The vehicle of the prospective driver matches that of the application.
   * If none of the above are true, return false and application is rejected.
   * @param name - Name of the prospective driver.
   * @param vehicle - Vehicle of the prospective driver.
   * @param vehicleInsurance - Vehicle insurance of the prospective driver.
   * @return - True if above is true, false if one of the above is not true.
   */
  private boolean validInsuranceInformation(IName name, IVehicle vehicle,
      IVehicleInsurance vehicleInsurance){
   IName owner = vehicle.getOwner();
   ArrayList<IName> insuredDrivers = vehicleInsurance.getInsuredDrivers();

   // If the vehicle doesn't match the one in the vehicle insurance, return false.
   if (!vehicle.equals(vehicleInsurance.getVehicle())) {
    return false;
   }

   // If the owner of the vehicle doesn't match the prospective driver in the application.
   if (!name.equals(owner)) {
    int length = insuredDrivers.size();
    boolean insured = false;
    for (int i = 0; i < length; i++) {
     if (insuredDrivers.get(i).equals(name)) {
      insured = true;
      break;
     }
    }
    // If the driver is not listed as an insured driver (and not the owner of the vehicle.
    if (!insured) {
     return false;
    }
   }

   // If the vehicle has expired, return false.
   if (this.hasExpired(vehicleInsurance.getExpirationDate())) {
    return false;
   }

   // If none of the above, return true.
   return true;
  }

  /**
   * Helper that checks if the prospective driver has any moving violations.
   * If yes, if those moving violations includes driving, speeding, DUI,
   * or driving without valid license/insurance, return false. Otherwise, return true.
   * @param history - The driving history of the driver.
   * @return - True if driver doesn't have moving violations listed above. False if the driver does.
   */
  private boolean validDriverHistory(IHistory history) {
   ArrayList<ITrafficViolation> violations = history.getTrafficViolations();
   int size = violations.size();

   for (int i = 0; i < size; i++) {
    if (violations.get(i) instanceof MovingTrafficViolation) {
     MovingViolation violation = (MovingViolation) violations.get(i).getType();
     if (violation == MovingViolation.RECKLESS_DRIVING ||
         violation == MovingViolation.SPEEDING ||
         violation == MovingViolation.DUI ||
         violation == MovingViolation.INVALID_LICENSE_OR_INSURANCE) {
      return false;
     }
    }
   }
   return true;
  }

  /**
   * Helper that checks the vehicle history. If there are any crashes or moving violations
   * committed with this vehicle in the last six months, return false. Otherwise, return true.
   * @param history - Vehicle history of the vehicle.
   * @return True if no crashes or moving violations within the past six months.
   * False if there are any.
   */
  private boolean validVehicleHistory(IHistory history) {

   ArrayList<ITrafficViolation> violations = history.getTrafficViolations();
   ArrayList<IVehicleCrash> crashes = history.getCrashes();
   int violationSize = violations.size();
   int crashSize = crashes.size();

   // Iterating through traffic violations to see if there are any moving violations
   // committed within six months.
   for (int i = 0; i < violationSize; i++) {
    if (violations.get(i) instanceof MovingTrafficViolation) {
     IDate violationDate = violations.get(i).getDate();
     if (!this.pastSixMonths(violationDate)) {
      return false;
     }
    }
   }

   // Iterating through vehicle crashes to see if there are any crashes within six months.
   for (int i = 0; i < crashSize; i++) {
     IDate crashDate = crashes.get(i).getCrashDate();
     if (!this.pastSixMonths(crashDate)) {
      return false;
     }
    }
   return true;
  }


  /**
   * Helper that returns true if it has been over six months since the given date.
   * Returns true if yes, false if no.
   * @param date - The date to compare.
   * @return True if it has been more than 6 months past the given date, false if not.
   */
   private boolean pastSixMonths(IDate date) {
    int currentMonth = LocalDateTime.now().getMonthValue();
    int currentDay = LocalDateTime.now().getDayOfMonth();
    int currentYear = LocalDateTime.now().getYear();

    if (currentYear == date.getYear()) {
     // If date less than six months ago, return false.
     if (currentMonth - date.getMonth() < MIN_MONTH) {
      return false;
     }
     // If date equals six months based on current month, but
     // current day < given day. Return false.
     // Ex. Today is 7/13. License issued 1/14. Would return false.
     if (currentMonth - date.getMonth() == MIN_MONTH
         && currentDay < date.getDay()) {
      return false;
     }
    }
    return true;
   }

  /**
   * Returns a list of the accepted drivers of the ride share system.
   * @return list of the accepted drivers of the ride share system.
   */
  @Override
  public ArrayList<IAcceptedDriver> getAcceptedDriversList() {
   return this.acceptedDrivers;
  }

  /**
   * Returns true if the objects are equal, false if not.
   * @param obj - The object to compare.
   * @return true if the objects are equal, false if not.
   */
  @Override
  public boolean equals(Object obj) {
   if (this == obj) {
    return true;
   }
   if (obj == null || getClass() != obj.getClass()) {
    return false;
   }
   RideShareSystem that = (RideShareSystem) obj;
   return acceptedDrivers.equals(that.acceptedDrivers);
  }

  /**
   * Returns a hash code value for the object.
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
   return Objects.hash(acceptedDrivers);
  }

  /**
   * Returns a string representation of the Ride Share System.
   * @return string representation of the Ride Share System.
   */
  @Override
  public String toString() {
   return "RideShareSystem - " +
       "acceptedDrivers = " + acceptedDrivers;
  }
 }
