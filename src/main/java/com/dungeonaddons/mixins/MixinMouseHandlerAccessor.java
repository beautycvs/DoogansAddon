package com.dungeonaddons.mixins;

import net.minecraft.client.MouseHandler;
import net.minecraft.client.input.MouseButtonInfo;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(MouseHandler.class)
public interface MixinMouseHandlerAccessor {
  @Invoker("onButton")
  abstract void invokeOnMouseButton(long window, MouseButtonInfo buttonInfo, int action);
}
