package gay.object.ioticblocks.mixin.actions;

import at.petrak.hexcasting.api.casting.castables.ConstMediaAction;
import at.petrak.hexcasting.api.casting.eval.CastingEnvironment;
import at.petrak.hexcasting.api.casting.iota.Iota;
import at.petrak.hexcasting.common.casting.actions.rw.OpTheCoolerWritable;
import gay.object.ioticblocks.casting.actions.mixin.OpWritableBlock;
import gay.object.ioticblocks.utils.IoticBlocksUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(OpTheCoolerWritable.class)
public abstract class MixinOpTheCoolerWritable implements ConstMediaAction {
    @Inject(method = "execute", at = @At("HEAD"), cancellable = true, remap = false)
    private void ioticblocks$handleBlock(
        List<? extends Iota> args,
        CastingEnvironment env,
        CallbackInfoReturnable<List<Iota>> cir
    ) {
        IoticBlocksUtils.getEntityOrBlockPos(args, 0, getArgc()).ifRight(blockPos ->
            cir.setReturnValue(OpWritableBlock.execute(args, env))
        );
    }
}
