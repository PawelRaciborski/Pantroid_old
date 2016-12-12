package com.wildeastcoders.pantroid.utils;

import rx.Scheduler;
import rx.android.plugins.RxAndroidPlugins;
import rx.android.plugins.RxAndroidSchedulersHook;
import rx.schedulers.Schedulers;

/**
 * Created by Majfrendmartin on 2016-11-18.
 */

public abstract class TestUtils {
    private TestUtils() {
        //no-op
    }

    public static final void setupRxAndroid() {
        RxAndroidPlugins.getInstance().registerSchedulersHook(new RxAndroidSchedulersHook() {
            @Override
            public Scheduler getMainThreadScheduler() {
                return Schedulers.immediate();
            }
        });
    }

    public static final void tearDownRxAndroid() {
        RxAndroidPlugins.getInstance().reset();
    }

    /**
     * This is just a workaround for test of Subscribers
     * @throws InterruptedException
     */
    public static final void waitForAsyncOperationCompleted() throws InterruptedException {
        Thread.sleep(50);
    }
}
