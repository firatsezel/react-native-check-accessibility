
package com.kentkart.checkaccessibility;


import android.content.Context;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.view.accessibility.AccessibilityEvent;
import com.facebook.react.bridge.Callback;
import android.view.accessibility.AccessibilityManager;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Promise;

public class RNReactNativeCheckAccessibilityModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNReactNativeCheckAccessibilityModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNReactNativeCheckAccessibility";
  }

  @ReactMethod
  public void isAccessibilityEnabled(Callback callback) {
      final AccessibilityManager accessibilityManager = (AccessibilityManager) this.reactContext.getSystemService(Context.ACCESSIBILITY_SERVICE);
      if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
          callback.invoke("0", null);
          return;
      }
      callback.invoke("1", null);
  }

  @ReactMethod
  public void isVoiceOverRunning(Promise promise) {
    try {
      final AccessibilityManager accessibilityManager = (AccessibilityManager) this.reactContext.getSystemService(Context.ACCESSIBILITY_SERVICE);
      if (accessibilityManager == null || !accessibilityManager.isEnabled() || !accessibilityManager.isTouchExplorationEnabled()) {
          promise.resolve("0");
          return;
      }
      promise.resolve("1"); 
    } catch (Exception e) {
      promise.reject("IS_VOICE_OVER_RUNNING_ERROR", e); 
    }
  }

  @ReactMethod
  void announce(String message) {
      final AccessibilityManager accessibilityManager = (AccessibilityManager) this.reactContext.getSystemService(Context.ACCESSIBILITY_SERVICE);
      if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
          return;
      }

      final int eventType = AccessibilityEventCompat.TYPE_ANNOUNCEMENT;
      final AccessibilityEvent event = AccessibilityEvent.obtain(eventType);
      event.getText().add(message);
      event.setClassName(RNReactNativeCheckAccessibilityModule.class.getName());
      event.setPackageName(this.reactContext.getPackageName());

      accessibilityManager.sendAccessibilityEvent(event);
  }

}
