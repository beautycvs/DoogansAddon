package com.dungeonaddons.event


object MouseEventHandler {
    private var shouldCancelLeftClick = false
    private var shouldCancelRightClick = false

    fun setCancelLeftClick(cancel: Boolean) {
        shouldCancelLeftClick = cancel
    }

    fun setCancelRightClick(cancel: Boolean) {
        shouldCancelRightClick = cancel
    }

  @JvmStatic
  fun shouldCancelLeftClick(): Boolean = shouldCancelLeftClick
  fun shouldCancelRightClick(): Boolean = shouldCancelRightClick

  fun reset() {
        shouldCancelLeftClick = false
        shouldCancelRightClick = false
  }
}

