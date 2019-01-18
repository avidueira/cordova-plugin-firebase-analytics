var exec = require("cordova/exec");

exports.registerEvent = function (eventName, eventParams) {
    if (eventName === "" || eventName === null) {
        return;
    }

    var pluginParams = [eventName, eventParams || {}];

    cordova.exec(function() { }, function() { }, "FirebaseAnalyticsPlugin", "logEvent", pluginParams);
};
