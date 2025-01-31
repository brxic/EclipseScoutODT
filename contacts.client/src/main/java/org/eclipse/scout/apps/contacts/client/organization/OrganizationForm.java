package org.eclipse.scout.apps.contacts.client.organization;

import org.eclipse.scout.apps.contacts.client.common.*;
import org.eclipse.scout.apps.contacts.shared.Icons;
import org.eclipse.scout.apps.contacts.shared.organization.OrganizationFormData;
import org.eclipse.scout.apps.contacts.shared.person.CreatePersonPermission;
import org.eclipse.scout.apps.contacts.shared.organization.IOrganizationService;
import org.eclipse.scout.apps.contacts.shared.person.UpdatePersonPermission;
import org.eclipse.scout.rt.client.dto.FormData;
import org.eclipse.scout.rt.client.ui.form.AbstractForm;
import org.eclipse.scout.rt.client.ui.form.AbstractFormHandler;
import org.eclipse.scout.rt.client.ui.form.IForm;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractCancelButton;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractOkButton;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.AbstractGroupBox;
import org.eclipse.scout.rt.client.ui.form.fields.stringfield.AbstractStringField;
import org.eclipse.scout.rt.client.ui.form.fields.tabbox.AbstractTabBox;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.Order;
import org.eclipse.scout.rt.platform.exception.VetoException;
import org.eclipse.scout.rt.platform.text.TEXTS;
import org.eclipse.scout.rt.platform.util.StringUtility;

import java.util.regex.Pattern;

@FormData(value = OrganizationFormData.class, sdkCommand = FormData.SdkCommand.CREATE)
public class OrganizationForm extends AbstractForm {

  private String organizationId;

  @FormData
  public String getOrganizationId() {
    return organizationId;
  }

  @FormData
  public void setOrganizationId(String organizationId) {
    this.organizationId = organizationId;
  }

  @Override
  public Object computeExclusiveKey() {
    return getOrganizationId();
  }

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("Organization");
  }

  @Override
  protected int getConfiguredDisplayHint() {
    return IForm.DISPLAY_HINT_VIEW;
  }

  public OrganizationForm.MainBox getMainBox() {
    return getFieldByClass(OrganizationForm.MainBox.class);
  }

  public OrganizationForm.MainBox.GroupBox getGroupBox() {
    return getFieldByClass(OrganizationForm.MainBox.GroupBox.class);
  }

  public OrganizationForm.MainBox.GeneralBox.DetailsBox.ContactInfoBox.AddressBox getAddressBox() {
    return getFieldByClass(OrganizationForm.MainBox.GeneralBox.DetailsBox.ContactInfoBox.AddressBox.class);
  }

  public OrganizationForm.MainBox.GeneralBox.DetailsBox.NotesBox getNotesBox() {
    return getFieldByClass(OrganizationForm.MainBox.GeneralBox.DetailsBox.NotesBox.class);
  }

  public OrganizationForm.MainBox.OkButton getOkButton() {
    return getFieldByClass(OrganizationForm.MainBox.OkButton.class);
  }

  public OrganizationForm.MainBox.CancelButton getCancelButton() {
    return getFieldByClass(OrganizationForm.MainBox.CancelButton.class);
  }

  public OrganizationForm.MainBox.GeneralBox.DetailsBox getDetailsBox() {
    return getFieldByClass(OrganizationForm.MainBox.GeneralBox.DetailsBox.class);
  }

  public OrganizationForm.MainBox.GeneralBox getGeneralBox() {
    return getFieldByClass(OrganizationForm.MainBox.GeneralBox.class);
  }

  public OrganizationForm.MainBox.GeneralBox.NameField getNameField() {
    return getFieldByClass(OrganizationForm.MainBox.GeneralBox.NameField.class);
  }

  public MainBox.GeneralBox.PictureField getPictureField() {
    return getFieldByClass(MainBox.GeneralBox.PictureField.class);
  }


  @Order(10)
  public class MainBox extends AbstractGroupBox {

    @Order(10)
    public class GroupBox extends AbstractGroupBox {

    }

    @Order(20)
    public class GeneralBox extends AbstractGroupBox {

      @Order(15)
      public class PictureField extends AbstractUrlImageField { // <1>

        @Override
        protected int getConfiguredGridH() { // <2>
          return 4;
        }

        @Override
        protected double getConfiguredGridWeightY() { // <3>
          return 0;
        }

        @Override
        protected String getConfiguredImageId() {
          return Icons.Group;
        }
      }

      @Order(20)
      public class NameField extends AbstractStringField {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("Name");
        }

        @Override
        protected boolean getConfiguredMandatory() {
          return true;
        }
      }

      @Order(30)
      public class HomepageField extends AbstractStringField {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("Homepage");
        }
      }

      @Order(30)
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
            protected int getConfiguredGridH() {
              return 3;
            }

            @Override
            protected int getConfiguredGridW() {
              return 1;
            }

            @Override
            protected int getConfiguredGridColumnCount() {
              return 1;
            }

            @Order(20)
            public class PhoneField extends AbstractStringField {

              @Override
              protected String getConfiguredLabel() {
                return TEXTS.get("Phone");
              }
            }

            @Order(30)
            public class EmailField extends AbstractStringField {

              @Override
              protected int getConfiguredMaxLength() {
                return 64;
              }
            }

          }
        }

        @Order(20)
        public class NotesBox extends AbstractNotesBox {

          @Override
          protected String getConfiguredLabel() {
            return TEXTS.get("Notes");
          }

        }
      }

    }

    @Order(40)
    public class OkButton extends AbstractOkButton {
    }

    @Order(50)
    public class CancelButton extends AbstractCancelButton {
    }
  }

  public void startModify() {
    startInternalExclusive(new OrganizationForm.ModifyHandler());
  }

  public void startNew() {
    startInternal(new OrganizationForm.NewHandler());
  }

  public class NewHandler extends AbstractFormHandler {
    @Override
    protected void execLoad() {
      OrganizationFormData formData = new OrganizationFormData();
      exportFormData(formData);
      importFormData(formData);

      setEnabledPermission(new CreatePersonPermission());
    }

    @Override
    protected void execStore() {
      OrganizationFormData formData = new OrganizationFormData();
      exportFormData(formData);
      formData = BEANS.get(IOrganizationService.class).create(formData);
      importFormData(formData);
    }
  }

  public class ModifyHandler extends AbstractFormHandler {
    @Override
    protected void execLoad() {
      OrganizationFormData formData = new OrganizationFormData();
      exportFormData(formData);
      formData = BEANS.get(IOrganizationService.class).load(formData);
      importFormData(formData);

      setEnabledPermission(new UpdatePersonPermission());
    }

    @Override
    protected void execStore() {
      OrganizationFormData formData = new OrganizationFormData();
      exportFormData(formData);
      formData = BEANS.get(IOrganizationService.class).store(formData);
      importFormData(formData);
    }
  }

  protected boolean execValidate() {
    boolean noName = StringUtility.isNullOrEmpty(getNameField().getValue());

    if (noName) {
      getNameField().requestFocus();

      throw new VetoException(TEXTS.get("MissingName0"));
    }

    return true;
  }

}
