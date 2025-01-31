package org.eclipse.scout.apps.contacts.shared;

import org.eclipse.scout.rt.platform.service.IService;
import org.eclipse.scout.rt.shared.TunnelToServer;

@TunnelToServer
public interface IOptionsService extends IService {
    OptionsFormData prepareCreate(OptionsFormData formData);

    OptionsFormData create(OptionsFormData formData);

    OptionsFormData load(OptionsFormData formData);

    OptionsFormData store(OptionsFormData formData);
}
