package net.lrsoft.mets.manager;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;

@JEIPlugin
public class JeiManager implements IModPlugin{
    @Override
    public void register(IModRegistry registry) {
        IModPlugin.super.register(registry);
        // 所有机器JEI已移除
    }
}
