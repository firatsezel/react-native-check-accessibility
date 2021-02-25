
package com.kentkart.checkaccessibility;


import android.content.Context;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import android.view.accessibility.AccessibilityEvent;
import com.facebook.react.bridge.Callback;
import android.view.accessibility.AccessibilityManager;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Promise;

import android.text.TextUtils;
import android.provider.Settings;

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
  
   

    private boolean isAccessibilitySettingsOn(Context mContext) {
      int accessibilityEnabled = 0;
      final String service = this.reactContext.getPackageName() + "/" + RNReactNativeCheckAccessibilityModule.class.getCanonicalName();
      try {
        accessibilityEnabled = Settings.Secure.getInt(
                mContext.getApplicationContext().getContentResolver(),
                android.provider.Settings.Secure.ACCESSIBILITY_ENABLED);
      } catch (Settings.SettingNotFoundException e) {
      }
      TextUtils.SimpleStringSplitter mStringColonSplitter = new TextUtils.SimpleStringSplitter(':');
  
      if (accessibilityEnabled == 1) {
        String settingValue = Settings.Secure.getString(
                mContext.getApplicationContext().getContentResolver(),
                Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES);
  
        if (settingValue != null) {
          if (settingValue.indexOf(this.reactContext.getPackageName()) > -1) {
            return true;
          }
        }
      }
  
      return false;
    }
  
    @ReactMethod
    public void isAccessibilityEnabled(Callback callback) {
      if (!isAccessibilitySettingsOn(this.reactContext.getApplicationContext())) {
        callback.invoke("0", null);
      } else {
        callback.invoke("1", null);
      }
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
