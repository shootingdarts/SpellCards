package net.bovid.spellcards.event;


import net.bovid.spellcards.SpellCards;
import net.bovid.spellcards.particle.ModParticles;
import net.bovid.spellcards.particle.custom.ManaParticles;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.vehicle.Minecart;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SpellCards.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerParticleFactories(final RegisterParticleProvidersEvent event){
        event.register(ModParticles.MANA_PARTICLES.get(),
                ManaParticles.Provider::new);
    }

}