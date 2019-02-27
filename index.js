
import { NativeModules, Platform } from 'react-native';

const { RNReactNativeCheckAccessibility } = NativeModules;

// export const isVoiceOverRunning = () => {
//     return new Promise(function(resolve, reject) {
//         if (Platform.OS === "android") {
//             RNReactNativeCheckAccessibility.isTouchExplorationEnabled(
//                 (result, error) => {
//                     console.log("isTouchExplorationEnabled", { result, error });
//                     if (!error) {
//                         resolve(result === "1");
//                     } else {
//                         reject(error);
//                     }
//                 }
//             );
//         } else {
//             RNReactNativeCheckAccessibility.isVoiceOverRunning(
//                 (error, result) => {
//                     console.log("isVoiceOverRunning", { error, result });
//                     if (!error) {
//                         resolve(result === "1");
//                     } else {
//                         reject(error);
//                     }
//                 }
//             );
//         }
//     });
// }

export default RNReactNativeCheckAccessibility;
