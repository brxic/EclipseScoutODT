package org.eclipse.scout.apps.contacts.shared;

import org.eclipse.scout.rt.api.data.security.PermissionId;
import org.eclipse.scout.rt.security.AbstractPermission;

public class ReadOptionsPermission extends AbstractPermission {
    private static final long serialVersionUID = 1L;
    public static final PermissionId ID = PermissionId.of("ReadOptionsPermission");

    public ReadOptionsPermission() {
        super(ID);
    }
}
