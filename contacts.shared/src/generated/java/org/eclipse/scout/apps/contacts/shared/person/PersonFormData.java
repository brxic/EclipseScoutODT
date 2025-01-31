package org.eclipse.scout.apps.contacts.shared.person;

import jakarta.annotation.Generated;
import org.eclipse.scout.apps.contacts.shared.common.AbstractAddressBoxData;
import org.eclipse.scout.apps.contacts.shared.common.AbstractNotesBoxData;
import org.eclipse.scout.apps.contacts.shared.common.AbstractUrlImageFieldData;
import org.eclipse.scout.rt.shared.data.form.AbstractFormData;
import org.eclipse.scout.rt.shared.data.form.fields.AbstractValueFieldData;
import org.eclipse.scout.rt.shared.data.form.properties.AbstractPropertyData;

import java.util.Date;

/**
 * <b>NOTE:</b><br>
 * This class is auto generated by the Scout SDK. No manual modifications recommended.
 */
@Generated(value = "org.eclipse.scout.apps.contacts.client.person.PersonForm", comments = "This class is auto generated by the Scout SDK. No manual modifications recommended.")
public class PersonFormData extends AbstractFormData {
    private static final long serialVersionUID = 1L;

    public AddressBox getAddressBox() {
        return getFieldByClass(AddressBox.class);
    }

    public DateOfBirth getDateOfBirth() {
        return getFieldByClass(DateOfBirth.class);
    }

    public EmailWork getEmailWork() {
        return getFieldByClass(EmailWork.class);
    }

    public FirstName getFirstName() {
        return getFieldByClass(FirstName.class);
    }

    public GenderGroup getGenderGroup() {
        return getFieldByClass(GenderGroup.class);
    }

    public LastName getLastName() {
        return getFieldByClass(LastName.class);
    }

    public NotesBox getNotesBox() {
        return getFieldByClass(NotesBox.class);
    }

    public Organization getOrganization() {
        return getFieldByClass(Organization.class);
    }

    /**
     * access method for property PersonId.
     */
    public String getPersonId() {
        return getPersonIdProperty().getValue();
    }

    /**
     * access method for property PersonId.
     */
    public void setPersonId(String personId) {
        getPersonIdProperty().setValue(personId);
    }

    public PersonIdProperty getPersonIdProperty() {
        return getPropertyByClass(PersonIdProperty.class);
    }

    public PhoneWork getPhoneWork() {
        return getFieldByClass(PhoneWork.class);
    }

    public Picture getPicture() {
        return getFieldByClass(Picture.class);
    }

    public PictureUrl getPictureUrl() {
        return getFieldByClass(PictureUrl.class);
    }

    public Position getPosition() {
        return getFieldByClass(Position.class);
    }

    public static class AddressBox extends AbstractAddressBoxData {
        private static final long serialVersionUID = 1L;

        public Email getEmail() {
            return getFieldByClass(Email.class);
        }

        public Mobile getMobile() {
            return getFieldByClass(Mobile.class);
        }

        public Phone getPhone() {
            return getFieldByClass(Phone.class);
        }

        public static class Email extends AbstractValueFieldData<String> {
            private static final long serialVersionUID = 1L;
        }

        public static class Mobile extends AbstractValueFieldData<String> {
            private static final long serialVersionUID = 1L;
        }

        public static class Phone extends AbstractValueFieldData<String> {
            private static final long serialVersionUID = 1L;
        }
    }

    public static class DateOfBirth extends AbstractValueFieldData<Date> {
        private static final long serialVersionUID = 1L;
    }

    public static class EmailWork extends AbstractValueFieldData<String> {
        private static final long serialVersionUID = 1L;
    }

    public static class FirstName extends AbstractValueFieldData<String> {
        private static final long serialVersionUID = 1L;
    }

    public static class GenderGroup extends AbstractValueFieldData<String> {
        private static final long serialVersionUID = 1L;
    }

    public static class LastName extends AbstractValueFieldData<String> {
        private static final long serialVersionUID = 1L;
    }

    public static class NotesBox extends AbstractNotesBoxData {
        private static final long serialVersionUID = 1L;
    }

    public static class Organization extends AbstractValueFieldData<String> {
        private static final long serialVersionUID = 1L;
    }

    public static class PersonIdProperty extends AbstractPropertyData<String> {
        private static final long serialVersionUID = 1L;
    }

    public static class PhoneWork extends AbstractValueFieldData<String> {
        private static final long serialVersionUID = 1L;
    }

    public static class Picture extends AbstractUrlImageFieldData {
        private static final long serialVersionUID = 1L;
    }

    public static class PictureUrl extends AbstractValueFieldData<String> {
        private static final long serialVersionUID = 1L;
    }

    public static class Position extends AbstractValueFieldData<String> {
        private static final long serialVersionUID = 1L;
    }
}
