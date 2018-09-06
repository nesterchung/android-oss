package com.kickstarter.services.firebase;


import com.google.firebase.messaging.FirebaseMessagingService;

import timber.log.Timber;

public class TokenListenerService extends FirebaseMessagingService {
  /**
   * Called if the InstanceID token is updated. This can occur in a variety of scenarios - the
   * InstanceID service might periodically request that we refresh a token every 6 months, or
   * it could force a refresh if a token is invalidated (e.g. security issues, device information
   * is no longer valid. When a token refresh event is received, we create a new register intent
   * to fetch the latest token and update it on the backend.
   * <p>
   * This call is generated by the InstanceID service, not by the app.
   */
  @Override
  public void onNewToken(final String s) {
    super.onNewToken(s);
    Timber.d(s + "Token refreshed, creating new RegisterService intent");
    DispatcherKt.dispatchTokenJob(this, DispatcherKt.REGISTER_SERVICE);
  }
}
