package org.eclipse.scout.apps.contacts.shared.common;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.platform.classid.ClassId;
import org.eclipse.scout.rt.shared.data.form.fields.AbstractFormFieldData;
import org.eclipse.scout.rt.shared.data.form.fields.AbstractValueFieldData;

/**
 * <b>NOTE:</b><br>
 * This class is auto generated by the Scout SDK. No manual modifications recommended.
 */
@ClassId("ea38d806-a38b-4511-bbda-ecb2fe694e70-formdata")
@Generated(value = "org.eclipse.scout.apps.contacts.client.common.AbstractNotesBox", comments = "This class is auto generated by the Scout SDK. No manual modifications recommended.")
public class AbstractNotesBoxData extends AbstractFormFieldData {
    private static final long serialVersionUID = 1L;

    public Notes getNotes() {
        return getFieldByClass(Notes.class);
    }

    @ClassId("eb26a2e8-f717-4762-9563-c4136e84b61d-formdata")
    public static class Notes extends AbstractValueFieldData<String> {
        private static final long serialVersionUID = 1L;
    }
}
