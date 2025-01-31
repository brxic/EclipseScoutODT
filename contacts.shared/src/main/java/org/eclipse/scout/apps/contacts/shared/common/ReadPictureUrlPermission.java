package org.eclipse.scout.apps.contacts.shared.common;

import org.eclipse.scout.rt.api.data.security.PermissionId;
import org.eclipse.scout.rt.security.AbstractPermission;

public class ReadPictureUrlPermission extends AbstractPermission {
    private static final long serialVersionUID = 1L;
    public static final PermissionId ID = PermissionId.of("ReadPictureUrlPermission");

    public ReadPictureUrlPermission() {
        super(ID);
    }
}
