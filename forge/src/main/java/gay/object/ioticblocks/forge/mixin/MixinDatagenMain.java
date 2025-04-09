package gay.object.ioticblocks.forge.mixin;

import gay.object.ioticblocks.IoticBlocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// scuffed workaround for https://github.com/architectury/architectury-loom/issues/189
@Mixin(net.minecraft.data.Main.class)
public class MixinDatagenMain {
    @Inject(method = "main", at = @At("TAIL"), remap = false)
    private static void ioticblocks$systemExitAfterDatagenFinishes(String[] strings, CallbackInfo ci) {
        IoticBlocks.LOGGER.info("Terminating datagen.");
        System.exit(0);
    }
}
