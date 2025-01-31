package org.eclipse.scout.apps.contacts.client.common;

import org.eclipse.scout.apps.contacts.shared.Icons;
import org.eclipse.scout.apps.contacts.shared.common.PictureUrlFormData;
import org.eclipse.scout.rt.client.dto.FormData;
import org.eclipse.scout.rt.client.ui.form.AbstractForm;
import org.eclipse.scout.rt.client.ui.form.AbstractFormHandler;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractCancelButton;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractOkButton;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.AbstractGroupBox;
import org.eclipse.scout.rt.client.ui.form.fields.htmlfield.AbstractHtmlField;
import org.eclipse.scout.rt.client.ui.form.fields.stringfield.AbstractStringField;
import org.eclipse.scout.rt.platform.Order;
import org.eclipse.scout.rt.platform.html.HTML;
import org.eclipse.scout.rt.platform.text.TEXTS;

@FormData(value = PictureUrlFormData.class, sdkCommand = FormData.SdkCommand.CREATE)
public class PictureUrlForm extends AbstractForm {

    public MainBox getMainBox() {
        return getFieldByClass(MainBox.class);
    }

    protected String getConfiguredTitle() {
    return TEXTS.get("PictureURL");
    }

    public void startModify() {
      startInternal(new ModifyHandler());
    }

    public MainBox.UrlBox.UrlField getUrlField() {
      return getFieldByClass(MainBox.UrlBox.UrlField.class);
    }

    public MainBox.UrlBox.InfoField getInfoField() {
      return getFieldByClass(MainBox.UrlBox.InfoField.class);
    }

  @Order(10)
  public class MainBox extends AbstractGroupBox {

    @Order(10)
    public class UrlBox extends AbstractGroupBox {

      @Order(10)
      public class UrlField extends AbstractStringField {

        @Override
        protected boolean getConfiguredLabelVisible() {
          return false;
        }

        @Override
        protected boolean getConfiguredStatusVisible() {
          return false;
        }

        @Override
        protected int getConfiguredGridW() {
          return 2;
        }
      }

      @Order(20)
      public class InfoField extends AbstractHtmlField {

        @Override
        protected boolean getConfiguredLabelVisible() {
          return false;
        }

        @Override
        protected boolean getConfiguredStatusVisible() {
          return false;
        }

        @Override
        protected int getConfiguredGridW() {
          return 2;
        }

        @Override
        protected boolean getConfiguredGridUseUiHeight() {
          return true;
        }

        @Override
        protected void execInitField() {
          setValue(HTML.fragment(HTML.icon(Icons.Info), HTML.bold(" " + TEXTS.get("PleaseNote") + ": "), TEXTS.get("SecurityUrlRestrictedMsg0")).toHtml());
        }
      }
    }

    @Order(20)
    public class OkButton extends AbstractOkButton {
    }

    @Order(30)
    public class CancelButton extends AbstractCancelButton {
    }
  }

  public class ModifyHandler extends AbstractFormHandler {
  }
}
