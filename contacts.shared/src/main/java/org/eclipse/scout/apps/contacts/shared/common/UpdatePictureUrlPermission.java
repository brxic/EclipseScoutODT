package org.eclipse.scout.apps.contacts.shared.common;

import org.eclipse.scout.rt.api.data.security.PermissionId;
import org.eclipse.scout.rt.security.AbstractPermission;

public class UpdatePictureUrlPermission extends AbstractPermission {
    private static final long serialVersionUID = 1L;
    public static final PermissionId ID = PermissionId.of("UpdatePictureUrlPermission");

    public UpdatePictureUrlPermission() {
        super(ID);
    }
}
