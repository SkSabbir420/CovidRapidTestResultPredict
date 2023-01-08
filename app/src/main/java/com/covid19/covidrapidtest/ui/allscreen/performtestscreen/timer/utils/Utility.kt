
package com.covid19.covidrapidtest.ui.allscreen.performtestscreen.timer.utils

import java.util.concurrent.TimeUnit

object Utility {

    // time to countdown - 1hr - 60secs
    const val TIME_COUNTDOWN: Long = 900000L
    private const val TIME_FORMAT = "%02d:%02d"

    // convert time to milli seconds
    fun Long.formatTime(): String = String.format(
        TIME_FORMAT,
        TimeUnit.MILLISECONDS.toMinutes(this),
        TimeUnit.MILLISECONDS.toSeconds(this) % 60
    )
}
