package com.dungeonaddons.mixins;

import net.minecraft.client.MouseHandler;
import net.minecraft.client.input.MouseButtonInfo;
import org.cobalt.api.event.impl.client.MouseEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MouseHandler.class)
public class MouseHandlerMixin {
  @Inject(method = "onButton", at = @At("HEAD"), cancellable = true)
  private void onButton(long window, MouseButtonInfo buttonInfo, int action, CallbackInfo ci) {
    if (action == MouseEvent.PRESS) {
      MouseEvent event = new MouseEvent.LeftClick(action);
      event.post();
      if (event.isCancelled()) {
        ci.cancel();
      }
    } else if (action == MouseEvent.RELEASE) {
      MouseEvent event = new MouseEvent.LeftRelease(action);
      event.post();
      if (event.isCancelled()) {
        ci.cancel();
      }
    }
  }
}

