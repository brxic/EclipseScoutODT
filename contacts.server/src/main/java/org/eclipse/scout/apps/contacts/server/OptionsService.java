package org.eclipse.scout.apps.contacts.server;

import org.eclipse.scout.apps.contacts.shared.*;
import org.eclipse.scout.rt.platform.exception.VetoException;
import org.eclipse.scout.rt.platform.text.TEXTS;
import org.eclipse.scout.rt.security.ACCESS;

public class OptionsService implements IOptionsService {
    @Override
    public OptionsFormData prepareCreate(OptionsFormData formData) {
        if (!ACCESS.check(new CreateOptionsPermission())) {
            throw new VetoException(TEXTS.get("AuthorizationFailed"));
        }
// TODO [F04088] add business logic here.
        return formData;
    }

    @Override
    public OptionsFormData create(OptionsFormData formData) {
        if (!ACCESS.check(new CreateOptionsPermission())) {
            throw new VetoException(TEXTS.get("AuthorizationFailed"));
        }
// TODO [F04088] add business logic here.
        return formData;
    }

    @Override
    public OptionsFormData load(OptionsFormData formData) {
        if (!ACCESS.check(new ReadOptionsPermission())) {
            throw new VetoException(TEXTS.get("AuthorizationFailed"));
        }
// TODO [F04088] add business logic here.
        return formData;
    }

    @Override
    public OptionsFormData store(OptionsFormData formData) {
        if (!ACCESS.check(new UpdateOptionsPermission())) {
            throw new VetoException(TEXTS.get("AuthorizationFailed"));
        }
// TODO [F04088] add business logic here.
        return formData;
    }
}
