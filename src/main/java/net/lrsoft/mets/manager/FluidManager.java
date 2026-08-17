package net.lrsoft.mets.manager;

import net.lrsoft.mets.MoreElectricTools;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class FluidManager {
    // 所有流体已移除

    public static void onFluidInit() {
        // No fluids to register
    }

    public static void onFluidBlockInit(RegistryEvent.Register<Block> event) {
        // No fluid blocks to register
    }

    public static void onRecipeInit() {
        // No fluid recipes
    }

    private static Fluid registerFluid(Fluid fluid) {
        if (!FluidRegistry.registerFluid(fluid)) {
            return FluidRegistry.getFluid(fluid.getName());
        }
        return fluid;
    }

    public static BlockFluidClassic getFluidBlock(Fluid fluid) {
        return null;
    }
}
