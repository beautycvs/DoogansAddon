package com.dungeonaddons.util.helper

class Clock {

  private var endTime = System.currentTimeMillis()

  fun schedule(ms: Int) {
    endTime = System.currentTimeMillis() + ms
  }

  fun passed(): Boolean {
    return System.currentTimeMillis() >= endTime
  }

}
