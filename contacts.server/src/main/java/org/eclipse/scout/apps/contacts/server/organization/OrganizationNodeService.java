package org.eclipse.scout.apps.contacts.server.organization;

import org.eclipse.scout.apps.contacts.shared.organization.IOrganizationNodeService;
import org.eclipse.scout.apps.contacts.shared.organization.OrganizationNodeTablePageData;
import org.eclipse.scout.rt.shared.services.common.jdbc.SearchFilter;

public class OrganizationNodeService implements IOrganizationNodeService {
    @Override
    public OrganizationNodeTablePageData getOrganizationNodeTableData(SearchFilter filter) {

        OrganizationNodeTablePageData pageData = new OrganizationNodeTablePageData();
// TODO [F04088] fill pageData.
        return pageData;
    }
}
