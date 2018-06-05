
#import "RNReactNativeCheckAccessibility.h"
[[NSNotificationCenter defaultCenter] addObserver:self
                                         selector:@selector(voiceOverStatusChanged)
                                             name:UIAccessibilityVoiceOverStatusChanged
                                           object:nil];

@implementation RNReactNativeCheckAccessibility

RCT_EXPORT_MODULE();

RCT_EXPORT_METHOD(isAccessibilityEnabled:(RCTResponseSenderBlock)callback)
{
    if(!UIAccessibilityIsVoiceOverRunning())
    {
        callback(@[[NSString '0'], events]);
    }
    callback(@[[NSString '1'], events]);
}

@end
  