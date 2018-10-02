package com.dev.honda;

import android.content.Context;
import android.content.res.Resources;

/**
 * Base class ImDroidApplication used in android manifest.xml file.
 */
public class Application extends android.app.Application {
    public static Context context;
    private static Application instance;
    public static String TAG = "Application";

    @Override
    public void onCreate() {
        super.onCreate();
    }

    /**
     * Instantiates a new Im droid application.
     */
    public Application() {
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static Application getInstance() {
        return Application.instance;
    }

    /**
     * Gets app context.
     *
     * @return the app context
     */
    public static Context getAppContext() {
        return instance;
    }

    /**
     * Gets app resources.
     *
     * @return the app resources
     */
    public static Resources getAppResources() {
        return instance.getResources();
    }

}