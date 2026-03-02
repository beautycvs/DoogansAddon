package com.dungeonaddons


import com.dungeonaddons.module.QOL
import org.cobalt.api.addon.Addon
import org.cobalt.api.event.EventBus
import org.cobalt.api.module.Module

object DungeonAddon : Addon() {

  override fun onLoad() {
    listOf(
      QOL
    ).forEach(EventBus::register)
    println("DungeonAddon loaded!")
  }

  override fun onUnload() {
    println("DungeonAddon unloaded!")
  }

  override fun getModules(): List<Module> {
    return listOf(QOL)
  }

}
