package me.blueishberry.vitalitysmp;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class VitalitySMPClient implements ClientModInitializer {

	private static KeyBinding primaryAbilityKeybind;
	private static KeyBinding secondaryAbilityKeybind;
	private static KeyBinding tertiaryAbilityKeybind;
	private static KeyBinding uniqueAbilityKeybind;
	private static KeyBinding modMenuKeybind;

	@Override
	public void onInitializeClient() {
		// Register the first keybind
		primaryAbilityKeybind = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"key.vitalitysmp.primary_ability",
				InputUtil.Type.KEYSYM,
				GLFW.GLFW_KEY_U,
				"category.vitalitysmp"
		));

		secondaryAbilityKeybind = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"key.vitalitysmp.secondary_ability",
				InputUtil.Type.KEYSYM,
				GLFW.GLFW_KEY_I,
				"category.vitalitysmp"
		));

		tertiaryAbilityKeybind = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"key.vitalitysmp.tertiary_ability",
				InputUtil.Type.KEYSYM,
				GLFW.GLFW_KEY_O,
				"category.vitalitysmp"
		));

		uniqueAbilityKeybind = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"key.vitalitysmp.unique_ability",
				InputUtil.Type.KEYSYM,
				GLFW.GLFW_KEY_LEFT_BRACKET,
				"category.vitalitysmp"
		));

		modMenuKeybind = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"key.vitalitysmp.mod_menu",
				InputUtil.Type.KEYSYM,
				GLFW.GLFW_KEY_P,
				"category.vitalitysmp"
		));

		ClientTickEvents.END_CLIENT_TICK.register(minecraftClient -> {
			if(primaryAbilityKeybind.wasPressed()) {
				if(minecraftClient.player != null) {
					String command = "/vprimary";
					minecraftClient.player.networkHandler.sendChatCommand(command.substring(1));
				}
			}

			if(secondaryAbilityKeybind.wasPressed()) {
				if(minecraftClient.player != null) {
					String command = "/vsecondary";
					minecraftClient.player.networkHandler.sendChatCommand(command.substring(1));
				}
			}

			if(tertiaryAbilityKeybind.wasPressed()) {
				if(minecraftClient.player != null) {
					String command = "/vtertiary";
					minecraftClient.player.networkHandler.sendChatCommand(command.substring(1));
				}
			}

			if(uniqueAbilityKeybind.wasPressed()) {
				if(minecraftClient.player != null) {
					String command = "/vunique";
					minecraftClient.player.networkHandler.sendChatCommand(command.substring(1));
				}
			}

			if(modMenuKeybind.wasPressed()) {
				if(minecraftClient.player != null) {
					String command = "/modmenu";
					minecraftClient.player.networkHandler.sendChatCommand(command.substring(1));
				}
			}
		});
	}
}