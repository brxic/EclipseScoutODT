package org.eclipse.scout.apps.contacts.server.organization;

import org.eclipse.scout.apps.contacts.shared.organization.OrganizationLookupCall;
import org.eclipse.scout.rt.server.IServerSession;
import org.eclipse.scout.rt.shared.services.lookup.ILookupRow;
import org.eclipse.scout.rt.testing.platform.runner.RunWithSubject;
import org.eclipse.scout.rt.testing.server.runner.RunWithServerSession;
import org.eclipse.scout.rt.testing.server.runner.ServerTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

@RunWithSubject("anonymous")
@RunWith(ServerTestRunner.class)
@RunWithServerSession(IServerSession.class)
public class OrganizationLookupCallTest {
// TODO [F04088] add test cases

  protected OrganizationLookupCall createLookupCall() {
    return new OrganizationLookupCall();
  }

  @Test
  public void testGetDataByAll() {
    OrganizationLookupCall call = createLookupCall();
// TODO [F04088] fill call
    List<? extends ILookupRow<String>> data = call.getDataByAll();
// TODO [F04088] verify data
  }

  @Test
  public void testGetDataByKey() {
    OrganizationLookupCall call = createLookupCall();
// TODO [F04088] fill call
    List<? extends ILookupRow<String>> data = call.getDataByKey();
// TODO [F04088] verify data
  }

  @Test
  public void testGetDataByText() {
    OrganizationLookupCall call = createLookupCall();
// TODO [F04088] fill call
    List<? extends ILookupRow<String>> data = call.getDataByText();
// TODO [F04088] verify data
  }
}
