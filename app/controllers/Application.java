/**
 * The Controller leg for this Model-View-Controller application.
 *
 * @author Mark Nelson
 * @since 6.0
 * @see https://www.playframework.com
 */

package controllers;

import models.Contact;
import models.ContactDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.formdata.ContactFormData;
import views.html.Home;
import views.html.NewContact;


/**
 * Controllers for the application.
 */
public class Application extends Controller {

  /**
   * Application home page.
   *
   * @return HTTP OK with page content.
   */
  public static Result home() {
    return ok(Home.render("Home page successful.", ContactDB.getContacts()));
  }


  /**
   * Contact add/edit page for the application.
   *
   * @return HTTP OK with page content.
   */
  public static Result newContact() {
    Form<ContactFormData> contact = Form.form(ContactFormData.class);

    return ok(NewContact.render("Contact page successful.", contact));
  }


  /**
   * Process new contact information.
   *
   * @return HTTP OK with page content.
   */
  public static Result postNewContact() {
    Form<ContactFormData> contactForm = Form.form(ContactFormData.class).bindFromRequest();

    if (contactForm.hasErrors()) {
      System.out.printf("Error in newContact page.\n");
      return badRequest(NewContact.render("Error in newContact page.", contactForm));
    }

    ContactFormData contactFormData = contactForm.get();

    System.out.printf("Data from the HTML Contact Form ::");
    System.out.printf("  First: [%s]", contactFormData.firstName);
    System.out.printf("  Last: [%s]", contactFormData.lastName);
    System.out.printf("  Phone: [%s]", contactFormData.phone);
    System.out.printf("\n");

    Contact contact = ContactDB.newContact(contactFormData);

    System.out.printf("Data from the Contact object ::");
    System.out.printf("  First: [%s]", contact.getFirstName());
    System.out.printf("  Last: [%s]", contact.getLastName());
    System.out.printf("  Phone: [%s]", contact.getPhone());
    System.out.printf("\n");

    return ok(NewContact.render("Contact page successful.", contactForm));
  }

}
