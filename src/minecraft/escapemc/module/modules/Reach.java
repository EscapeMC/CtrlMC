package escapemc.module.modules;

import org.lwjgl.input.Keyboard;

import escapemc.module.Category;
import escapemc.module.Module;

public class Reach extends Module {

	public Reach() {

		super("Reach", Keyboard.KEY_H, Category.PLAYER);
	
	}

	public void onEnable() {
		
		this.setToggled(true);
		
	}
	
	public void onDisable() {
		
		this.setToggled(false);
		
	}
	
	
}