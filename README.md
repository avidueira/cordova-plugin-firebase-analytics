# cordova-plugin-firebase-analytics<br>[![NPM version][npm-version]][npm-url] [![NPM downloads][npm-downloads]][npm-url]
> Cordova Plugin for logging events in [Firebase Analytics](https://firebase.google.com/docs/analytics/)

## Installation

    cordova plugin add https://github.com/kunder-lab/cordova-plugin-firebase-analytics.git --save

## Supported Platforms

- iOS
- Android

NOTE: iOS needs `CocoaPods` to manage `Firebase` libs 

## Methods

### registerEvent(_name_, _params_)
Logs an app event.
```js
cordova.plugins.FirebaseAnalyticsPlugin.registerEvent("event_name", {param: "value"});
```