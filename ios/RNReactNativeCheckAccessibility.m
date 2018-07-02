
#import "RNReactNativeCheckAccessibility.h"
#import "RCTAccessibilityManager.h"
#import "RCTUIManager.h"


@implementation RNReactNativeCheckAccessibility

RCT_EXPORT_MODULE();

RCT_EXPORT_METHOD(announce:(NSString *)message)
{
     UIAccessibilityPostNotification(UIAccessibilityAnnouncementNotification, @"message");
}

- (NSDictionary *)constantsToExport
{
    BOOL isVoiveOverRunning = (UIAccessibilityIsVoiceOverRunning() ? 1 : 0);
    
    if(!isVoiveOverRunning)
    {
        return @{ @"isAccessibilityEnabled": @"0" };
    }
    
    return @{ @"isAccessibilityEnabled": @"1" };
}

@end
  
