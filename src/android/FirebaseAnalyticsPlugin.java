package cl.kunder.firebaseanalytics;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.analytics.FirebaseAnalytics;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class FirebaseAnalyticsPlugin extends CordovaPlugin {
    public static final String TAG = "FirebaseAnalyticsPlugin";
    public FirebaseAnalytics firebaseAnalytics;
    public static final String LOG_EVENT = "logEvent";

    @Override
    public boolean execute(String action, JSONArray options, CallbackContext callbackContex) {
        this.firebaseAnalytics = FirebaseAnalytics.getInstance(cordova.getActivity());
        if (LOG_EVENT.equals(action)) {
            List list = new ArrayList();
            int l = options.length();
            try {
                for (int i = 0; i<l; i++){
                    list.add(options.get(i));
                }
                logEvent(String.valueOf(list.get(0)), options.optJSONObject(1), callbackContex);
            } catch (JSONException e) {
                Log.w(TAG, "error: " + e);
            }
        }
        return true;
    }

    public void logEvent(String name, JSONObject params, CallbackContext callbackContext) throws JSONException {
        Bundle bundle = new Bundle();
        Iterator<String> it = params.keys();
        while (it.hasNext()) {
            String key = it.next();
            Object value = params.get(key);
            if (value instanceof String) {
                bundle.putString(key, (String)value);
            } else if (value instanceof Integer) {
                bundle.putInt(key, (Integer)value);
            } else if (value instanceof Double) {
                bundle.putDouble(key, (Double)value);
            } else if (value instanceof Long) {
                bundle.putLong(key, (Long)value);
            } else {
                Log.w(TAG, "Value for key " + key + " not one of (String, Integer, Double, Long)");
            }
        }
        firebaseAnalytics.logEvent(name, bundle);
        callbackContext.success();
    }
}