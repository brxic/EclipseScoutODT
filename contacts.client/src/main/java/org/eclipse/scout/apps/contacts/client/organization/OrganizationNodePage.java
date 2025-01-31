package org.eclipse.scout.apps.contacts.client.organization;

import org.eclipse.scout.apps.contacts.client.person.PersonTablePage;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.AbstractPageWithNodes;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.IPage;
import org.eclipse.scout.rt.platform.classid.ClassId;

import java.util.List;

@ClassId("f074181d-462a-40dc-b7cd-46bb4e50e7fc")
public class OrganizationNodePage extends AbstractPageWithNodes {

  private String organizationId;

  public String getOrganizationId() {
    return organizationId;
  }

  public void setOrganizationId(String organizationId) {
    this.organizationId = organizationId;
  }

  @Override
  protected void execCreateChildPages(List<IPage<?>> pageList) {
    PersonTablePage personTablePage = new PersonTablePage();
    personTablePage.setOrganizationId(getOrganizationId());
    pageList.add(personTablePage);
  }
}
