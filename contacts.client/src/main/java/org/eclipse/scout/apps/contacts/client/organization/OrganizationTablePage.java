package org.eclipse.scout.apps.contacts.client.organization;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.eclipse.scout.apps.contacts.client.common.CountryLookupCall;
import org.eclipse.scout.apps.contacts.client.organization.OrganizationTablePage.Table;
import org.eclipse.scout.apps.contacts.client.organization.OrganizationForm;
import org.eclipse.scout.apps.contacts.client.organization.OrganizationTablePage;
import org.eclipse.scout.apps.contacts.client.organization.OrganizationTablePage;
import org.eclipse.scout.apps.contacts.client.person.PersonTablePage;
import org.eclipse.scout.apps.contacts.shared.Icons;
import org.eclipse.scout.apps.contacts.shared.organization.IOrganizationService;
import org.eclipse.scout.apps.contacts.shared.organization.OrganizationTablePageData;
import org.eclipse.scout.rt.client.dto.Data;
import org.eclipse.scout.rt.client.ui.action.menu.AbstractMenu;
import org.eclipse.scout.rt.client.ui.action.menu.IMenu;
import org.eclipse.scout.rt.client.ui.action.menu.IMenuType;
import org.eclipse.scout.rt.client.ui.action.menu.TableMenuType;
import org.eclipse.scout.rt.client.ui.basic.table.AbstractTable;
import org.eclipse.scout.rt.client.ui.basic.table.ITableRow;
import org.eclipse.scout.rt.client.ui.basic.table.columns.AbstractStringColumn;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.AbstractPageWithTable;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.IPage;
import org.eclipse.scout.rt.client.ui.form.FormEvent;
import org.eclipse.scout.rt.client.ui.form.FormListener;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.Order;
import org.eclipse.scout.rt.platform.classid.ClassId;
import org.eclipse.scout.rt.platform.text.TEXTS;
import org.eclipse.scout.rt.platform.util.CollectionUtility;
import org.eclipse.scout.rt.shared.services.common.jdbc.SearchFilter;
import org.eclipse.scout.rt.shared.services.lookup.ILookupCall;

import java.util.Set;
import java.util.UUID;

@Data(OrganizationTablePageData.class)
@ClassId("f074181d-462a-40dc-b7cd-46bb4e50e7fb")
public class OrganizationTablePage extends AbstractPageWithTable<Table> {

  @Override
  protected void execLoadData(SearchFilter filter) {
    importPageData(BEANS.get(IOrganizationService.class).getOrganizationTableData(filter));
  }

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("Organizations");
  }

  @Override
  protected IPage<?> execCreateChildPage(ITableRow row) {
    OrganizationNodePage childPage = new OrganizationNodePage();
    childPage.setOrganizationId(getTable().getOrganizationIdColumn().getValue(row));
    return childPage;
  }

  public class Table extends AbstractTable {

    public CityColumn getCityColumn() {
      return getColumnSet().getColumnByClass(CityColumn.class);
    }

    public CountryColumn getCountryColumn() {
      return getColumnSet().getColumnByClass(CountryColumn.class);
    }

    public HomepageColumn getHomepageColumn() {
      return getColumnSet().getColumnByClass(HomepageColumn.class);
    }

    public NameColumn getNameColumn() {
      return getColumnSet().getColumnByClass(NameColumn.class);
    }

    @Override
    protected Class<? extends IMenu> getConfiguredDefaultMenu() {
      return EditOrganizationMenu.class;
    }

    private OrganizationTablePage.Table.OrganizationIdColumn getOrganizationIdColumn() {
      return getColumnSet().getColumnByClass(OrganizationTablePage.Table.OrganizationIdColumn.class);
    }

    @Order(1000)
    @ClassId("7aa50584-fe01-48bd-ab6d-a7eb59ff265a")
    public class OrganizationIdColumn extends AbstractStringColumn {
      @Override
      protected String getConfiguredHeaderText() {
        return TEXTS.get("OrganizationID");
      }

      @Override
      protected int getConfiguredWidth() {
        return 100;
      }

      @Override
      protected boolean getConfiguredDisplayable() {
        return false;
      }

      @Override
      protected boolean getConfiguredPrimaryKey() {
        return true;
      }
    }

    @Order(2000)
    @ClassId("1feae9a2-e836-499e-bb7e-3b6c1a69ea17")
    public class NameColumn extends org.eclipse.scout.rt.client.ui.basic.table.columns.AbstractStringColumn {
      @Override
      protected String getConfiguredHeaderText() {
        return TEXTS.get("Name");
      }

      @Override
      protected int getConfiguredWidth() {
        return 100;
      }
    }

    @Order(3000)
    @ClassId("6e0ac5e7-3f95-4971-9312-48299329803c")
    public class CityColumn extends org.eclipse.scout.rt.client.ui.basic.table.columns.AbstractStringColumn {
      @Override
      protected String getConfiguredHeaderText() {
        return TEXTS.get("City");
      }

      @Override
      protected int getConfiguredWidth() {
        return 100;
      }
    }

    @Order(4000)
    @ClassId("ed3f226c-33e8-41ac-ae27-4e86c4f7729b")
    public class CountryColumn extends org.eclipse.scout.rt.client.ui.basic.table.columns.AbstractStringColumn {
      @Override
      protected String getConfiguredHeaderText() {
        return TEXTS.get("Country");
      }

      @Override
      protected int getConfiguredWidth() {
        return 100;
      }

      protected Class<? extends ILookupCall<String>> getConfiguredLookupCall() {
        return CountryLookupCall.class;
      }
    }

    @Order(5000)
    @ClassId("316e3085-3438-4fba-8464-e14eb8e8122d")
    public class HomepageColumn extends org.eclipse.scout.rt.client.ui.basic.table.columns.AbstractStringColumn {
      @Override
      protected String getConfiguredHeaderText() {
        return TEXTS.get("Homepage");
      }

      @Override
      protected int getConfiguredWidth() {
        return 100;
      }
    }

    @Order(100)
    public class EditOrganizationMenu extends AbstractMenu {
      @Override
      protected String getConfiguredText() {
        return TEXTS.get("EditOrganization0");
      }

      @Override
      protected String getConfiguredIconId() {
        return Icons.Pencil;
      }

      @Override
      protected void execAction() {
        OrganizationForm form = new OrganizationForm();
        form.setOrganizationId(getOrganizationIdColumn().getSelectedValue());
        form.addFormListener(new OrganizationTablePage.Table.OrganizationFormListener());
        // start the form using its modify handler
        form.startModify();
      }
    }

    @Order(110)
    public class NewMenu extends AbstractMenu {

      @Override
      protected String getConfiguredText() {
        return TEXTS.get("CreateNewOrganization0");
      }

      @Override
      protected String getConfiguredIconId() {
        return Icons.Plus;
      }

      @Override
      protected Set<? extends IMenuType> getConfiguredMenuTypes() {
        return CollectionUtility.<IMenuType>hashSet(
          TableMenuType.EmptySpace, TableMenuType.SingleSelection);
      }

      @Override
      protected void execAction() {
        OrganizationForm form = new OrganizationForm();
        form.addFormListener(new OrganizationTablePage.Table.OrganizationFormListener());
        // start the form using its new handler
        form.startNew();
      }
    }

    private class OrganizationFormListener implements FormListener {

      @Override
      public void formChanged(FormEvent e) {
        // reload page to reflect new/changed data after saving any changes
        if (FormEvent.TYPE_CLOSED == e.getType() && e.getForm().isFormStored()) {
          reloadPage();
        }
      }
    }
  }

  @Override
  protected String getConfiguredIconId() {
    return Icons.Target;
  }

  @Override
  protected String getConfiguredOverviewIconId() {
    return Icons.Target;
  }

}

