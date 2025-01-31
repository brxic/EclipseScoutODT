package org.eclipse.scout.apps.contacts.client.common;

import org.eclipse.scout.rt.platform.classid.ClassId;
import org.eclipse.scout.rt.shared.services.lookup.LocalLookupCall;
import org.eclipse.scout.rt.shared.services.lookup.LookupRow;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@ClassId("37736ea5-e861-43d8-a6bc-144dad3c208f")
public class CountryLookupCall extends LocalLookupCall<String> {

  private static final long serialVersionUID = 1L;

  @Override
  protected List<LookupRow<String>> execCreateLookupRows() {
    List<LookupRow<String>> rows = new ArrayList<>();

    rows.add(new LookupRow<>("CH", "Schweiz"));

    for (String countryCode : Locale.getISOCountries()) {
      Locale country = new Locale("", countryCode);
      if (country.getDisplayCountry().equals("Schweiz")) {
        continue;
      }
      rows.add(new LookupRow<>(countryCode, country.getDisplayCountry()));
    }

    return rows;
  }
}
