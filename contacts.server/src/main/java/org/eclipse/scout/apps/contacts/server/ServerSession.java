package org.eclipse.scout.apps.contacts.server;

import org.eclipse.scout.rt.server.AbstractServerSession;
import org.eclipse.scout.rt.server.session.ServerSessionProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author F04088
 */
public class ServerSession extends AbstractServerSession {

  private static final long serialVersionUID = 1L;
  private static final Logger LOG = LoggerFactory.getLogger(ServerSession.class);

  public ServerSession() {
    super(true);
  }

  /**
   * @return The {@link ServerSession} which is associated with the current thread, or {@code null} if not found.
   */
  public static ServerSession get() {
    return ServerSessionProvider.currentSession(ServerSession.class);
  }

  @Override
  protected void execLoadSession() {
    LOG.info("created a new session for {}", getUserId());
  }
}
