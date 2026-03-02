package com.dungeonaddons.module

import net.minecraft.client.Minecraft
import com.dungeonaddons.util.helper.Clock
import org.cobalt.api.event.annotation.SubscribeEvent
import org.cobalt.api.module.Module
import org.cobalt.api.module.setting.impl.CheckboxSetting
import org.cobalt.api.util.InventoryUtils
import org.cobalt.api.event.impl.client.MouseEvent
import org.cobalt.api.util.MouseUtils
import org.cobalt.api.util.ui.NVGRenderer


object QOL : Module(
  name = "QOL",
) {
  var mc = Minecraft.getInstance()
  private val clock = Clock()

  var leftclickEtherwarp by CheckboxSetting(
    name ="left click etherwarp",
    description = "left click etherwarp(does not crouch for you)",
    defaultValue = false
  )

  @SubscribeEvent
  fun leftEtherwarp(event: MouseEvent) {
    var currentSlot = mc.player?.inventory?.selectedSlot
    var etherwarpSlot = InventoryUtils.findItemInInventoryWithLore("Etherwarp")
    if (!leftclickEtherwarp && currentSlot == etherwarpSlot) return

    if (event is MouseEvent.LeftClick) {
      // IDK if I should cancel it or not you decide
      event.setCancelled(true)
      clock.schedule(50)
      MouseUtils.rightClick()
    }
  }
  var dungeonMap by CheckboxSetting(
    name = "dungeon map",
    description = "shows the dungeon map",
    defaultValue = false
  )
  fun onMapRender(event: NVGRenderer) {
    if (!dungeonMap) return
    var width = mc.getWindow().getWidth().toFloat()
    var height = mc.getWindow().getHeight().toFloat()
    NVGRenderer.beginFrame(width, height)
    // render map here


    NVGRenderer.endFrame()
  }

}
