package org.eclipse.scout.apps.contacts.shared.organization;

import org.eclipse.scout.rt.platform.service.IService;
import org.eclipse.scout.rt.shared.TunnelToServer;
import org.eclipse.scout.rt.shared.data.page.AbstractTablePageData;
import org.eclipse.scout.rt.shared.services.common.jdbc.SearchFilter;

@TunnelToServer
public interface IOrganizationService extends IService {

  OrganizationFormData create(OrganizationFormData formData);

  OrganizationFormData load(OrganizationFormData formData);

  OrganizationFormData store(OrganizationFormData formData);

  AbstractTablePageData getOrganizationTableData(SearchFilter filter);
}
