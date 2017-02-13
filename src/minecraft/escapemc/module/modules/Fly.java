package escapemc.module.modules;

import org.lwjgl.input.Keyboard;

import escapemc.Event.events.EventPreMotion;
import escapemc.module.Category;
import escapemc.module.Mode;
import escapemc.module.Module;
import escapemc.module.ModuleManager;

public class Fly extends Module{

	public Fly() {
		super("Fly", Keyboard.KEY_Y, Category.Movement);
		this.setMode(Mode.Slow);
	}

	double startY;
	
	@Override
	public void Tick() {
			
		mc.thePlayer.capabilities.isFlying = true;
		this.setToggled(true);
		for(Module m : ModuleManager.Modules) {
			
			if(m.getMode() == Mode.Slow) {
				
				mc.thePlayer.capabilities.setFlySpeed(0.05F);
				
			}else if(m.getMode() == Mode.Fast) {
				
				mc.thePlayer.capabilities.setFlySpeed(0.3F);
				
			}else if(m.getMode() == Mode.SuperFast) {
				
				mc.thePlayer.capabilities.setFlySpeed(1.4F);
				
			}
			
			
		}

	}	
	
	@Override
	public void onEnable() {
		
		startY = mc.thePlayer.posY;
		this.setColorToggle(true);
		
	}
	
	@Override
	public void onDisable() {
		
		mc.thePlayer.capabilities.isFlying = false;
		this.setColorToggle(false);
		
	}
	
	@Override
	public void Event(escapemc.Event.Event e) {
		
		if(e instanceof EventPreMotion) {
			
			((EventPreMotion) e).onGround = true;
			
		}
		
	}
	
		
}		

