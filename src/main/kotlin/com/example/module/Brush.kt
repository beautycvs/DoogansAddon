package com.example.module

import java.awt.Color
import org.cobalt.api.module.Module
import org.cobalt.api.module.setting.impl.*
import org.cobalt.api.util.helper.KeyBind
import org.lwjgl.glfw.GLFW

object ExampleModule : Module(
  name = "Brush",
) {

  val checkbox by CheckboxSetting(
    name = "Enable?",
    description = " ",
    defaultValue = false
  )

