package net.Cheesedude11.Ores_and_Bosses.event;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.InputEvent;
import org.lwjgl.glfw.GLFW;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class MagnetDashHandler {
    private static final HashMap<UUID, Long> lastSpaceTap = new HashMap<>();
    private static final HashMap<UUID, Long> cooldowns = new HashMap<>();
    private static final long DOUBLE_TAP_WINDOW_MS = 250;
    private static final long COOLDOWN_MS = 4000;

    @SubscribeEvent
    public static void onKeyInput(InputEvent.Key event) {
        if (event.getKey() != GLFW.GLFW_KEY_SPACE || event.getAction() != GLFW.GLFW_PRESS) return;

        Minecraft mc = Minecraft.getInstance();
        LocalPlayer player = mc.player;
        if (player == null || !isWearingFullSparkArmor(player)) return;

        UUID id = player.getUUID();
        long now = System.currentTimeMillis();

        if (cooldowns.containsKey(id) && now < cooldowns.get(id)) return;

        if (lastSpaceTap.containsKey(id)) {
            long lastTap = lastSpaceTap.get(id);
            if (now - lastTap <= DOUBLE_TAP_WINDOW_MS) {
                performDash(player);
                cooldowns.put(id, now + COOLDOWN_MS);
                lastSpaceTap.remove(id);
                return;
            }
        }

        lastSpaceTap.put(id, now);
    }

    private static void performDash(Player player) {
        Vec3 direction = player.getLookAngle().multiply(5, 0, 5);
        player.setDeltaMovement(direction);
        player.hurtMarked = true;

        // Sound
        player.level().playSound(null, player.blockPosition(), SoundEvents.ENDERMAN_TELEPORT, SoundSource.PLAYERS, 0.7f, 1.3f);

        // Particles
        for (int i = 0; i < 10; i++) {
            player.level().addParticle(ParticleTypes.ELECTRIC_SPARK,
                    player.getX(), player.getY() + 1, player.getZ(),
                    (Math.random() - 0.5) * 0.5, 0.1, (Math.random() - 0.5) * 0.5);
        }

        // Damage nearby enemies in path
        AABB area = player.getBoundingBox().inflate(2.5);
        List<LivingEntity> targets = player.level().getEntitiesOfClass(LivingEntity.class, area, e ->
                e != player && e.isAlive());

        for (LivingEntity target : targets) {
            target.hurt(player.damageSources().playerAttack(player), 6.0F);
        }
    }

    private static boolean isWearingFullSparkArmor(Player player) {
        for (ItemStack stack : player.getArmorSlots()) {
            if (stack.isEmpty()) return false;
            String id = stack.getItem().getDescriptionId();
            if (!(id.contains("spark_helmet") || id.contains("spark_chestplate") ||
                    id.contains("spark_leggings") || id.contains("spark_boots"))) {
                return false;
            }
        }
        return true;
    }
}