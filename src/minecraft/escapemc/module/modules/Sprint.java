package escapemc.module.modules;

import org.lwjgl.input.Keyboard;

import escapemc.module.Category;
import escapemc.module.Module;
import net.minecraft.network.play.client.CPacketPlayer;

public class Sprint extends Module {

	public Sprint() {
	
		super("Sprint", Keyboard.KEY_B, Category.Movement);

	}

	@Override
	public void Tick() {

		mc.thePlayer.setSprinting(true);
		this.setToggled(true);
		this.setColorToggle(true);

	}
		
	@Override
	public void onDisable() {
		
		mc.thePlayer.setSprinting(false);
		this.setToggled(false);
		this.setColorToggle(false);
		
	}	
	
}
