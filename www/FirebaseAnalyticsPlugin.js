var exec = require("cordova/exec");

exports.registerEvent = function (eventName, eventParams) {
    if (eventName === "" || eventName === null) {
        return;
    }

    var pluginParams = [eventName, eventParams || {}];
    var successCallback = function() { };
    var errorCallback = function() { };

    cordova.exec(successCallback, errorCallback, "FirebaseAnalyticsPlugin", "logEvent", pluginParams);
};
