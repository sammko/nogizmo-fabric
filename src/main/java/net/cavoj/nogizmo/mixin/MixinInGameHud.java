package net.cavoj.nogizmo.mixin;

import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.options.GameOptions;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(InGameHud.class)
public class MixinInGameHud {
    @Redirect(method = "renderCrosshair", at = @At(value = "FIELD", target = "Lnet/minecraft/client/options/GameOptions;debugEnabled:Z", opcode = Opcodes.GETFIELD))
    private boolean mixinRenderCrosshairDebug(final GameOptions options) {
        return false;
    }
}
