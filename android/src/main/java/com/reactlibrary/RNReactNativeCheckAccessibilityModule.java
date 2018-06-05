
package com.reactlibrary;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

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
}