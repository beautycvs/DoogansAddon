package com.example

import com.example.command.ExampleCommand
import com.example.module.ExampleModule
import org.cobalt.api.addon.Addon
import org.cobalt.api.command.CommandManager
import org.cobalt.api.module.Module

object DungeonAddon : Addon() {

  override fun onLoad() {
    CommandManager.register(ExampleCommand)
    println("DungeonAddon loaded!")
  }

  override fun onUnload() {
    println("DungeonAddon unloaded!")
  }

  override fun getModules(): List<Module> {
    return listOf(LC Etherwarp)
  }

}
