package org.eclipse.scout.apps.contacts.client;

import org.eclipse.scout.apps.contacts.client.contact.ContactOutline;
import org.eclipse.scout.apps.contacts.client.organization.OrganizationForm;
import org.eclipse.scout.apps.contacts.client.person.PersonForm;
import org.eclipse.scout.apps.contacts.client.search.SearchOutline;
import org.eclipse.scout.apps.contacts.shared.Icons;
import org.eclipse.scout.rt.client.ui.action.keystroke.IKeyStroke;
import org.eclipse.scout.rt.client.ui.action.menu.AbstractMenu;
import org.eclipse.scout.rt.client.ui.desktop.AbstractDesktop;
import org.eclipse.scout.rt.client.ui.desktop.notification.NativeNotificationDefaults;
import org.eclipse.scout.rt.client.ui.desktop.outline.AbstractOutlineViewButton;
import org.eclipse.scout.rt.client.ui.desktop.outline.IOutline;
import org.eclipse.scout.rt.platform.Order;
import org.eclipse.scout.rt.platform.classid.ClassId;
import org.eclipse.scout.rt.platform.text.TEXTS;
import org.eclipse.scout.rt.platform.util.CollectionUtility;

import java.util.List;

/**
 * @author F04088
 */
public class Desktop extends AbstractDesktop {

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("ApplicationTitle");
  }

  @Override
  protected String getConfiguredLogoId() {
    return Icons.AppLogo;
  }

  @Override
  protected NativeNotificationDefaults getConfiguredNativeNotificationDefaults() {
    return super.getConfiguredNativeNotificationDefaults().withIconId("application_logo.png");
  }

  @Override
  protected List<Class<? extends IOutline>> getConfiguredOutlines() {
    return CollectionUtility.<Class<? extends IOutline>>arrayList(
      ContactOutline.class, SearchOutline.class);
  }

  @Override
  protected void execDefaultView() {
    selectFirstVisibleOutline();
  }

  protected void selectFirstVisibleOutline() {
    for (IOutline outline : getAvailableOutlines()) {
      if (outline.isEnabled() && outline.isVisible()) {
        setOutline(outline.getClass());
        return;
      }
    }
  }

  @Order(1000)
  public class ContactOutlineViewButton extends AbstractOutlineViewButton {

    public ContactOutlineViewButton() {
      this(ContactOutline.class);
    }

    protected ContactOutlineViewButton(Class<? extends ContactOutline> outlineClass) {
      super(Desktop.this, outlineClass);
    }

    @Override
    protected String getConfiguredKeyStroke() {
      return IKeyStroke.F2;
    }
  }

  @Order(2000)
  public class SearchOutlineViewButton extends AbstractOutlineViewButton {

    public SearchOutlineViewButton() {
      this(SearchOutline.class);
    }

    protected SearchOutlineViewButton(Class<? extends SearchOutline> outlineClass) {
      super(Desktop.this, outlineClass);
    }

    @Override
    protected DisplayStyle getConfiguredDisplayStyle() {
      return DisplayStyle.TAB;
    }

    @Override
    protected String getConfiguredKeyStroke() {
      return IKeyStroke.F3;
    }
  }

//  @Override
//  protected IViewButton.DisplayStyle getConfiguredDisplayStyle() {
//    return IViewButton.DisplayStyle.TAB;
//  }


//  @Override
//  protected String getConfiguredKeyStroke() {
//    return IKeyStroke.F10;
//  }


  @Order(10)
  @ClassId("50df7a9d-dd3c-40a3-abc4-4619eff8d841")
  public class QuickAccessMenu extends AbstractMenu {

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("QuickAccess");
    }

    @Order(10)
    @ClassId("effb3b69-f488-4aed-8923-d430a5f1fd97")
    public class NewPersonMenu extends AbstractMenu {

      @Override
      protected String getConfiguredText() {
        return TEXTS.get("NewPersonMenu");
      }

      @Override
      protected void execAction() {
        new PersonForm().startNew();
      }
    }

    @Order(10)
    @ClassId("effb3b69-f488-4aed-8923-d430a5f1fd97")
    public class NewOrganizationMenu extends AbstractMenu {

      @Override
      protected String getConfiguredText() {
        return TEXTS.get("CreateNewOrganization");
      }

      @Override
      protected void execAction() {
        new OrganizationForm().startNew();
      }
    }

  }

  @Order(20)
  @ClassId("4fce42bf-85f9-4892-96a2-2e89e18eeaee")
  public class OptionsMenu extends AbstractMenu {

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("Options");
    }

    @Override
    protected String getConfiguredIconId() {
      return Icons.Gear;
    }

  }

  @Order(30)
  @ClassId("8dbfbe9d-0382-471a-ae43-3178f7a9e720")
  public class UserMenu extends AbstractMenu {

    @Override
    protected String getConfiguredIconId() {
      return Icons.PersonSolid;
    }

    @Override
    protected String getConfiguredCssClass() {
      return "profile-menu";
    }

  }

}
