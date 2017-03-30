package com.example.tolmachenko.playservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Olga Tolmachenko on 30.03.17.
 */

public class PlayReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("SERVICES", "onReceive: ");
        context.startService(new Intent(context, PlayService.class));
    }
}
