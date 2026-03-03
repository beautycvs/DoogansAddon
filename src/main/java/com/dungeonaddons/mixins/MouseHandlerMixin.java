package com.dungeonaddons.mixins;

import net.minecraft.client.MouseHandler;
import net.minecraft.client.input.MouseButtonInfo;
import org.cobalt.api.event.impl.client.MouseEvent;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import com.dungeonaddons.event.MouseEventHandler;

@Mixin(MouseHandler.class)
public class MouseHandlerMixin {
  @Inject(method = "onButton", at = @At("HEAD"), cancellable = true)
  private void onButton(long window, MouseButtonInfo buttonInfo, int action, CallbackInfo ci) {
    if (buttonInfo.input() == GLFW.GLFW_MOUSE_BUTTON_LEFT) {
      if (MouseEventHandler.shouldCancelLeftClick()) {
        ci.cancel();
      }
    }
  }
}

