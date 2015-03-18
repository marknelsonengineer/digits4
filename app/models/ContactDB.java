package models;

import views.formdata.ContactFormData;

import java.util.ArrayList;
import java.util.List;

/**
 * Container/manager for all of the contacts in the application.
 */
public class ContactDB {
  private static List<Contact> contacts = new ArrayList<Contact>();

  /**
   * Add a contact from HTML form data to the database.
   *
   * @param contactFormData A populated HTML form containing contact information.
   * @return The contact object that was added to the database.
   */
  public static Contact newContact(ContactFormData contactFormData) {
    Contact contact = new Contact(contactFormData.firstName, contactFormData.lastName, contactFormData.phone);

    contacts.add(contact);

    return contact;
  }

  /**
   * Get all of the contacts.
   *
   * @return A list of the contacts.
   */
  public static List<Contact> getContacts() {
    return contacts;
  }
}
