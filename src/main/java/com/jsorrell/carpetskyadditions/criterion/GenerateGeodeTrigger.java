package com.jsorrell.carpetskyadditions.criterion;

import com.google.gson.JsonObject;
import com.jsorrell.carpetskyadditions.util.SkyAdditionsResourceLocation;
import net.minecraft.advancements.critereon.AbstractCriterionTriggerInstance;
import net.minecraft.advancements.critereon.DeserializationContext;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;

public class GenerateGeodeTrigger extends SimpleCriterionTrigger<GenerateGeodeTrigger.Conditions> {

    static final ResourceLocation ID = new SkyAdditionsResourceLocation("generate_geode");

    @Override
    public ResourceLocation getId() {
        return ID;
    }

    public void trigger(ServerPlayer player) {
        trigger(player, conditions -> true);
    }

    @Override
    public Conditions createInstance(
            JsonObject json, EntityPredicate.Composite player, DeserializationContext context) {
        return new Conditions(player);
    }

    public static class Conditions extends AbstractCriterionTriggerInstance {
        public Conditions(EntityPredicate.Composite player) {
            super(ID, player);
        }
    }
}
