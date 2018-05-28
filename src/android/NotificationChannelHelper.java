package bid.maireo.android.notification;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;

import org.apache.cordova.CordovaInterface;

public class NotificationChannelHelper  implements  INotificationChannelHelper {
    private final CordovaInterface _cordova;

    public NotificationChannelHelper() {
       this(null);
    }
    public NotificationChannelHelper(CordovaInterface cordova) {
        this._cordova = cordova;
    }

    protected  <T> T getSystemService(String name) {
        if (this._cordova == null) return null;
        Activity activity = this._cordova.getActivity();
        if(activity == null) return null;
        Object _object =  activity.getSystemService(name);
        if (_object == null) return null;
        return (T)_object;
    }

    public boolean createChannel(String id, String name, String description) {
        if (id == null)  return false;
        if (name == null)  return false;
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.O) return false;
        int importance = NotificationManager.IMPORTANCE_HIGH;
        NotificationChannel notificationChannel = new NotificationChannel(id, name, importance);
        if (description != null && !description.isEmpty()) notificationChannel.setDescription(description);
        notificationChannel.enableLights(true);
        notificationChannel.setLightColor(Color.BLUE);
        NotificationManager notificationManager = this.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.createNotificationChannel(notificationChannel);
        return  true;
    }
}
