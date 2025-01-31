package org.eclipse.scout.apps.contacts.shared.person;

import org.eclipse.scout.rt.api.data.security.PermissionId;
import org.eclipse.scout.rt.security.AbstractPermission;

public class UpdatePersonPermission extends AbstractPermission {
    private static final long serialVersionUID = 1L;
    public static final PermissionId ID = PermissionId.of("UpdatePersonPermission");

    public UpdatePersonPermission() {
        super(ID);
    }
}
