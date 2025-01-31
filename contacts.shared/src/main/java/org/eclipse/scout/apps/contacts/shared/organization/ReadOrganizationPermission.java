package org.eclipse.scout.apps.contacts.shared.organization;

import org.eclipse.scout.rt.api.data.security.PermissionId;
import org.eclipse.scout.rt.security.AbstractPermission;

public class ReadOrganizationPermission extends AbstractPermission {
    private static final long serialVersionUID = 1L;
    public static final PermissionId ID = PermissionId.of("ReadOrganizationPermission");

    public ReadOrganizationPermission() {
        super(ID);
    }
}
