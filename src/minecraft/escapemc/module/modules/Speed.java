package escapemc.module.modules;

import org.lwjgl.input.Keyboard;

import escapemc.module.Category;
import escapemc.module.Module;

public class Speed extends Module {

	public Speed() {
		super("Speed", Keyboard.KEY_V, Category.Movement);
	}

	@Override
	public void Tick()
	{
		// return if sneaking or not walking
		if(mc.thePlayer.isSneaking() || mc.thePlayer.moveForward == 0 && mc.thePlayer.moveStrafing == 0)
			return;
		
		// activate sprint if walking forward
		if(mc.thePlayer.moveForward > 0 && !mc.thePlayer.isCollidedHorizontally)
			mc.thePlayer.setSprinting(true);
		
		// activate mini jump if on ground
		if(mc.thePlayer.onGround)
		{
			mc.thePlayer.motionY += 0.1;
			mc.thePlayer.motionX *= 1.8;
			mc.thePlayer.motionZ *= 1.8;
			double currentSpeed = Math.sqrt(Math.pow(mc.thePlayer.motionX, 2) + Math.pow(mc.thePlayer.motionZ, 2));
			double maxSpeed = 0.99F;
			if(currentSpeed > maxSpeed)
			{
				mc.thePlayer.motionX =
					mc.thePlayer.motionX / currentSpeed * maxSpeed;
				mc.thePlayer.motionZ =
					mc.thePlayer.motionZ / currentSpeed * maxSpeed;
			}
		}
	}
	
	@Override
	public void onDisable() {

		this.setColorToggle(false);
		
	
	}
	
	@Override
	public void onEnable() {

		this.setColorToggle(true);
	
	}
	
}
