package org.eclipse.scout.apps.contacts.client.contact;

import java.util.List;

import org.eclipse.scout.apps.contacts.client.organization.OrganizationTablePage;
import org.eclipse.scout.apps.contacts.client.person.PersonTablePage;
import org.eclipse.scout.rt.platform.Order;
import org.eclipse.scout.rt.client.ui.desktop.outline.AbstractOutline;
import org.eclipse.scout.rt.client.ui.desktop.outline.pages.IPage;
import org.eclipse.scout.rt.platform.classid.ClassId;
import org.eclipse.scout.rt.platform.text.TEXTS;

import org.eclipse.scout.apps.contacts.shared.Icons;

/**
 * @author F04088
 */
@Order(1000)
@ClassId("303c0267-3c99-4736-a7f5-3097c5e011b6")
public class ContactOutline extends AbstractOutline {

  @Override
  protected void execCreateChildPages(List<IPage<?>> pageList) {
    pageList.add(new PersonTablePage());
    pageList.add(new OrganizationTablePage());
  }

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("Contacts");
  }

  @Override
  protected String getConfiguredIconId() {
    return Icons.Folder;
  }
}
