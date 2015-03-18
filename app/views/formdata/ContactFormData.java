package views.formdata;

import play.data.validation.ValidationError;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mark on 3/18/15.
 */
public class ContactFormData {
  /** The first name. */
  public String firstName = "";

  /** The second name. */
  public String lastName = "";

  /** The phone number. */
  public String phone = "";

  /** The minimum phone number length. */
  public static final int MIN_PHONE_NUMBER_LENGTH = 12;


  /**
   * Validate the form data.
   *
   * @return An array of errors (if any) or null if there are no errors.
   */
  public List<ValidationError> validate() {
    List<ValidationError> errors = new ArrayList<>();

    if (firstName == null || firstName.length() <= 0) {
      errors.add(new ValidationError("firstName", "First name is required."));
    }

    if (lastName == null || lastName.length() <= 0) {
      errors.add(new ValidationError("lastName", "Last name is required."));
    }

    if (phone == null || phone.length() <= 0) {
      errors.add(new ValidationError("phone", "Phone number is required."));
    }

    if (phone == null || phone.length() < MIN_PHONE_NUMBER_LENGTH) {
      errors.add(new ValidationError("phone", "At least " + MIN_PHONE_NUMBER_LENGTH + " digits are required."));
    }

    return errors.isEmpty() ? null : errors;
  }

}
