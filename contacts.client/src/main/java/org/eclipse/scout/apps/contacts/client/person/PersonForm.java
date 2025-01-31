package org.eclipse.scout.apps.contacts.client.person;

import org.eclipse.scout.apps.contacts.client.common.*;
import org.eclipse.scout.apps.contacts.client.person.PersonForm.MainBox.GroupBox;
import org.eclipse.scout.apps.contacts.shared.Icons;
import org.eclipse.scout.apps.contacts.shared.organization.OrganizationLookupCall;
import org.eclipse.scout.apps.contacts.shared.person.*;
import org.eclipse.scout.rt.client.dto.FormData;
import org.eclipse.scout.rt.client.ui.action.menu.AbstractMenu;
import org.eclipse.scout.rt.client.ui.form.AbstractForm;
import org.eclipse.scout.rt.client.ui.form.AbstractFormHandler;
import org.eclipse.scout.rt.client.ui.form.IForm;
import org.eclipse.scout.rt.client.ui.form.fields.IValueField;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractCancelButton;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractLinkButton;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractOkButton;
import org.eclipse.scout.rt.client.ui.form.fields.datefield.AbstractDateField;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.AbstractGroupBox;
import org.eclipse.scout.rt.client.ui.form.fields.imagefield.AbstractImageField;
import org.eclipse.scout.rt.client.ui.form.fields.radiobuttongroup.AbstractRadioButtonGroup;
import org.eclipse.scout.rt.client.ui.form.fields.sequencebox.AbstractSequenceBox;
import org.eclipse.scout.rt.client.ui.form.fields.smartfield.AbstractSmartField;
import org.eclipse.scout.rt.client.ui.form.fields.stringfield.AbstractStringField;
import org.eclipse.scout.rt.client.ui.form.fields.tabbox.AbstractTabBox;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.Order;
import org.eclipse.scout.rt.platform.exception.VetoException;
import org.eclipse.scout.rt.platform.text.TEXTS;
import org.eclipse.scout.rt.platform.util.StringUtility;
import org.eclipse.scout.rt.shared.services.common.code.ICodeType;
import org.eclipse.scout.rt.shared.services.lookup.ILookupCall;

import java.util.regex.Pattern;

@FormData(value = PersonFormData.class, sdkCommand = FormData.SdkCommand.CREATE)
public class PersonForm extends AbstractForm {

  private String personId;

  @FormData
  public String getPersonId() {
    return personId;
  }

  @FormData
  public void setPersonId(String personId) {
    this.personId = personId;
  }

  @Override
  public Object computeExclusiveKey() {
    return getPersonId();
  }

  @Override
  protected int getConfiguredDisplayHint() {
    return IForm.DISPLAY_HINT_VIEW;
  }

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("Person");
  }

  public MainBox getMainBox() {
    return getFieldByClass(MainBox.class);
  }

  public GroupBox getGroupBox() {
    return getFieldByClass(GroupBox.class);
  }

  public MainBox.OkButton getOkButton() {
    return getFieldByClass(MainBox.OkButton.class);
  }

  public MainBox.CancelButton getCancelButton() {
    return getFieldByClass(MainBox.CancelButton.class);
  }

  public MainBox.GeneralBox.DetailsBox getDetailsBox() {
    return getFieldByClass(MainBox.GeneralBox.DetailsBox.class);
  }

  public MainBox.GeneralBox getGeneralBox() {
    return getFieldByClass(MainBox.GeneralBox.class);
  }

  public MainBox.GeneralBox.FirstNameField getFirstNameField() {
    return getFieldByClass(MainBox.GeneralBox.FirstNameField.class);
  }

  public MainBox.GeneralBox.LastNameField getLastNameField() {
    return getFieldByClass(MainBox.GeneralBox.LastNameField.class);
  }

  public MainBox.GeneralBox.DetailsBox.WorkBox.OrganizationField getOrganizationField() {
    return getFieldByClass(MainBox.GeneralBox.DetailsBox.WorkBox.OrganizationField.class);
  }

  public MainBox.GeneralBox.PictureUrlField getPictureUrlField() {
    return getFieldByClass(MainBox.GeneralBox.PictureUrlField.class);
  }

  @Order(1000)
  public class MainBox extends AbstractGroupBox {
    @Order(1000)
    public class GroupBox extends AbstractGroupBox {

    }


    @Order(1500)
    public class GeneralBox extends AbstractGroupBox {

      @Override
      protected String getConfiguredLabel() {
        return TEXTS.get("General");
      }

      @Override
      protected double getConfiguredGridWeightY() {
        return 0;
      }

      @Override
      protected boolean getConfiguredLabelVisible() {
        return false;
      }

      @Order(10)
      public class PictureUrlField extends AbstractStringField {

        @Override
        protected boolean getConfiguredVisible() {
          return false;
        }
      }

      @Order(20)
      public class PictureField extends AbstractUrlImageField {

        @Override
        protected Class<PictureUrlField> getConfiguredMasterField() {
          return PictureUrlField.class;
        }

      }

      @Order(30)
      public class FirstNameField extends AbstractStringField {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("FirstName");
        }
      }

      @Order(40)
      public class LastNameField extends AbstractStringField {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("LastName");
        }
      }

      @Order(60)
      public class DateOfBirthField extends AbstractDateField {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("DateOfBirth");
        }
      }

      @Order(50)
      public class GenderGroup extends AbstractRadioButtonGroup<String> {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("Gender");
        }

        @Override
        protected Class<? extends ICodeType<?, String>> getConfiguredCodeType() {
          return GenderCodeType.class;
        }
      }

      @Order(1750)
      public class DetailsBox extends AbstractTabBox {
        @Order(10)
        public class ContactInfoBox extends AbstractGroupBox {

          @Override
          protected String getConfiguredLabel() {
            return TEXTS.get("ContactInfo");
          }

          @Order(10)
          public class AddressBox extends AbstractAddressBox {

            @Override
            protected boolean getConfiguredBorderVisible() {
              return false;
            }

            @Override
            protected int getConfiguredGridH() { // <1>
              return 3;
            }

            @Override
            protected int getConfiguredGridW() { // <1>
              return 1;
            }

            @Override
            protected int getConfiguredGridColumnCount() { // <2>
              return 1;
            }

            protected void validateAddressFields() {
              boolean hasStreet = StringUtility.hasText(getStreetField().getValue());
              boolean hasCity = StringUtility.hasText(getCityField().getValue());

              getCityField().setMandatory(hasStreet); // <3>
              getCountryField().setMandatory(hasStreet || hasCity);
            }

            @Order(20)
            public class PhoneField extends AbstractStringField {

              @Override
              protected String getConfiguredLabel() {
                return TEXTS.get("Phone");
              }
            }

            @Order(30)
            public class MobileField extends AbstractStringField {

              @Override
              protected String getConfiguredLabel() {
                return TEXTS.get("Mobile");
              }
            }

            @Order(40)
            public class EmailField extends AbstractEmailField {

              @Override
              protected int getConfiguredMaxLength() {
                return 64;
              }

            }

          }
        }

        @Order(20)
        public class WorkBox extends AbstractGroupBox {

          @Override
          protected String getConfiguredLabel() {
            return TEXTS.get("Work0");
          }

          @Order(10)
          public class PositionField extends AbstractStringField {

            @Override
            protected String getConfiguredLabel() {
              return TEXTS.get("Position");
            }
          }

          @Order(20)
          public class OrganizationField extends AbstractSmartField<String> {

            @Override
            protected String getConfiguredLabel() {
              return TEXTS.get("Organization");
            }

            @Override
            protected Class<? extends ILookupCall<String>> getConfiguredLookupCall() {
              return (Class<? extends ILookupCall<String>>) OrganizationLookupCall.class;
            }
          }


          @Order(30)
          public class PhoneWorkField extends AbstractStringField {

            @Override
            protected String getConfiguredLabel() {
              return TEXTS.get("Phone");
            }
          }

          @Order(40)
          public class EmailWorkField extends AbstractEmailField {

            @Override
            protected int getConfiguredMaxLength() {
              return 64;
            }

          }
        }

        @Order(30)
        public class NotesBox extends AbstractNotesBox {

          @Override
          protected String getConfiguredLabel() {
            return TEXTS.get("Notes");
          }

        }

      }
    }

    @Order(30)
    public class OkButton extends AbstractOkButton {
    }

    @Order(40)
    public class CancelButton extends AbstractCancelButton {
    }
  }


  public void startModify() {
    startInternalExclusive(new ModifyHandler());
  }

  public void startNew() {
    startInternal(new NewHandler());
  }

  public class NewHandler extends AbstractFormHandler {
    @Override
    protected void execLoad() {
      PersonFormData formData = new PersonFormData();
      exportFormData(formData);
      importFormData(formData);

      setEnabledPermission(new CreatePersonPermission());
    }

    @Override
    protected void execStore() {
      PersonFormData formData = new PersonFormData();
      exportFormData(formData);
      formData = BEANS.get(IPersonService.class).create(formData);
      importFormData(formData);
    }
  }

  public class ModifyHandler extends AbstractFormHandler {
    @Override
    protected void execLoad() {
      PersonFormData formData = new PersonFormData();
      exportFormData(formData);
      formData = BEANS.get(IPersonService.class).load(formData);
      importFormData(formData);

      setEnabledPermission(new UpdatePersonPermission());
    }

    @Override
    protected void execStore() {
      PersonFormData formData = new PersonFormData();
      exportFormData(formData);
      formData = BEANS.get(IPersonService.class).store(formData);
      importFormData(formData);
    }
  }

  protected boolean execValidate() {
    boolean noFirstName = StringUtility.isNullOrEmpty(getFirstNameField().getValue());
    boolean noLastName = StringUtility.isNullOrEmpty(getLastNameField().getValue());

    if (noFirstName && noLastName) {
      getFirstNameField().requestFocus();

      throw new VetoException(TEXTS.get("MissingName0"));
    }

    return true;
  }

}
