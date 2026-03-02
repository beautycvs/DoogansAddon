package com.dungeonaddons.module

import net.minecraft.client.Minecraft
import org.cobalt.api.event.annotation.SubscribeEvent
import org.cobalt.api.module.Module
import org.cobalt.api.module.setting.impl.CheckboxSetting
import org.cobalt.api.util.InventoryUtils
import org.cobalt.api.event.impl.client.MouseEvent
import org.cobalt.api.util.MouseUtils


object QOL : Module(
  name = "QOL",
) {
  var mc = Minecraft.getInstance()
  var leftclickEtherwarp by CheckboxSetting(
    name ="left click etherwarp",
    description = "left click etherwarp(does not crouch for you)",
    defaultValue = false
  )
  @SubscribeEvent
  fun leftEtherwarp(){
    var currentSlot = mc.player?.inventory?.selectedSlot
    var etherwarpSlot = InventoryUtils.findItemInInventoryWithLore("Etherwarp")
    if (!leftclickEtherwarp && currentSlot == etherwarpSlot) return

    if (MouseEvent.PRESS == 0) {
      // idk if i should cancel it or not you decide
      MouseUtils.rightClick()
    }
  }
}
