package edu.neu.ccs.cs5004.Assignment8.Problem2;

/**
 * This class extends AbstractViolations and represents the types of violations a vehicle or
 * driver may have.
 */
public class Violations extends AbstractViolations {

  /**
   * Construct a Violation given the MovingViolation.
   *
   * @param movingViolation - type of moving violation
   */
  public Violations(MovingViolation movingViolation) {
    super(movingViolation);
  }

  /**
   * Construct a Violation given the NonMovinViolation.
   *
   * @param nonMovingViolation - type of non-moving violation
   */
  public Violations(
      NonMovingViolation nonMovingViolation) {
    super(nonMovingViolation);
  }
}
