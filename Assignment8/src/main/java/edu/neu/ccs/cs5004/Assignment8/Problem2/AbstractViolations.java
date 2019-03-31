package edu.neu.ccs.cs5004.Assignment8.Problem2;

/**
 * This abstract class implements IViolations and represents the types of violations a vehicle or driver may have.
 */
public class AbstractViolations implements IViolations {
  private MovingViolation movingViolation;
  private NonMovingViolation nonMovingViolation;

  /**
   * Construct a Violation given the MovingViolation.
   *
   * @param movingViolation - type of moving violation
   */
  public AbstractViolations(MovingViolation movingViolation) {
    this.movingViolation = movingViolation;
  }

  /**
   * Construct a Violation given the NonMovinViolation.
   *
   * @param nonMovingViolation - type of non-moving violation
   */
  public AbstractViolations(
      NonMovingViolation nonMovingViolation) {
    this.nonMovingViolation = nonMovingViolation;
  }

  /**
   * Return description of moving violation.
   *
   * @return description of moving violation
   */
  public MovingViolation getMoving() {
    return movingViolation;
  }

  /**
   * Return description of non-moving violation.
   *
   * @return description of non-moving violation
   */
  public NonMovingViolation getNonMoving() {
    return nonMovingViolation;
  }
}
