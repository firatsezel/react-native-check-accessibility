
#import "RNReactNativeCheckAccessibility.h"
#import "RCTAccessibilityManager.h"
#import "RCTUIManager.h"


@implementation RNReactNativeCheckAccessibility

RCT_EXPORT_MODULE();

RCT_EXPORT_METHOD(announce:(NSString *)message)
{
     UIAccessibilityPostNotification(UIAccessibilityAnnouncementNotification, @"message");
}

RCT_EXPORT_METHOD(isVoiceOverRunning:(RCTPromiseResolveBlock)resolve rejecter:(RCTPromiseRejectBlock)reject)
{
    @try {
        resolve(UIAccessibilityIsVoiceOverRunning() ? @"1" : @"0");
    }
    @catch(NSException *exception) {
        NSError *error = [NSError errorWithDomain:@"com.kentkart.checkaccessibility" code:0 userInfo:@{@"Error reason": exception.reason}];
        reject(@"error", @"isVoiceOverRunning threw exception", error);
    }
}

- (NSDictionary *)constantsToExport
{
    BOOL isVoiceOverRunning = (UIAccessibilityIsVoiceOverRunning() ? 1 : 0);
    
    if(!isVoiceOverRunning)
    {
        return @{ @"isAccessibilityEnabled": @"0" };
    }
    
    return @{ @"isAccessibilityEnabled": @"1" };
}

+ (BOOL)requiresMainQueueSetup
{
    return YES;
}

@end
  
