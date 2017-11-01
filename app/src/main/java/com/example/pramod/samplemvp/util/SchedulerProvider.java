package com.example.pramod.samplemvp.util;

import io.reactivex.Scheduler;

/**
 * Created by pramod on 01/11/17.
 */

public interface SchedulerProvider {
    Scheduler mainThread();

    Scheduler backgroundThread();
}
