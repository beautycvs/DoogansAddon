package com.dungeonaddons.module

import com.dungeonaddons.event.MouseEventHandler
import com.dungeonaddons.util.dungeons.isInDungeon
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
  var currentSlot: Int? = mc.player?.inventory?.selectedSlot
  var etherwarpSlot: Int = InventoryUtils.findItemInInventoryWithLore("Etherwarp")

  var leftclickEtherwarp by CheckboxSetting(
    name ="left click etherwarp",
    description = "left click etherwarp(does not crouch for you)",
    defaultValue = false
  )

  @SubscribeEvent
  fun leftEtherwarp(event: MouseEvent) {
    if (!leftclickEtherwarp) return
    if (!clock.passed()) return
    var playerCrouched = mc.player?.isCrouching
    if (currentSlot == etherwarpSlot && playerCrouched == true) {
      MouseEventHandler.setCancelLeftClick(true)
      MouseUtils.rightClick()
    }
  }

  var dungeonMap by CheckboxSetting(
    name = "dungeon map",
    description = "shows the dungeon map",
    defaultValue = false
  )
  @SubscribeEvent
  fun onMapRender(event: NVGRenderer) {
    var width = mc.window.width.toFloat()
    var height = mc.window.height.toFloat()
    if (isInDungeon().isInDungeon() && !dungeonMap) {
      NVGRenderer.beginFrame(width, height)
      // render map here


      NVGRenderer.endFrame()
    }
  }

}
