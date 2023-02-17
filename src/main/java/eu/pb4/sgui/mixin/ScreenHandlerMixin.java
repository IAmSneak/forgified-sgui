package eu.pb4.sgui.mixin;

import eu.pb4.sgui.virtual.inventory.VirtualInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ScreenHandler.class)
public class ScreenHandlerMixin {

    @Inject(method = "canInsertIntoSlot(Lnet/minecraft/screen/slot/Slot;)Z", at = @At("HEAD"), cancellable = true)
    private static void blockIfVirtual(Slot slot, CallbackInfoReturnable<Boolean> cir) {
        if (slot.inventory instanceof VirtualInventory) {
            cir.setReturnValue(false);
        }
    }
}
