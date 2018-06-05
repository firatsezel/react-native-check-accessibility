
# react-native-react-native-check-accessibility

## Getting started

`$ npm install react-native-check-accessibility --save`

### Mostly automatic installation

`$ react-native link react-native-check-accessibility`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-react-native-check-accessibility` and add `RNReactNativeCheckAccessibility.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNReactNativeCheckAccessibility.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNReactNativeCheckAccessibilityPackage;` to the imports at the top of the file
  - Add `new RNReactNativeCheckAccessibilityPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-react-native-check-accessibility'
  	project(':react-native-react-native-check-accessibility').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-react-native-check-accessibility/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-react-native-check-accessibility')
  	```
## Usage
```javascript
import RNReactNativeCheckAccessibility from 'react-native-react-native-check-accessibility';

RNReactNativeCheckAccessibility.isAccessibilityEnabled((result) => {
	if (result === '1') {
		... // Accessibility Enabled
	}
});
```
  
