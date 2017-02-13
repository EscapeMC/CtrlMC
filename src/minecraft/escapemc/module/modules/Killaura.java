package escapemc.module.modules;

import org.lwjgl.input.Keyboard;

import escapemc.Event.Event;
import escapemc.Event.HookManager;
import escapemc.Event.events.EventPreMotion;
import escapemc.Util.Timer;
import escapemc.module.Category;
import escapemc.module.Mode;
import escapemc.module.Module;
import escapemc.module.ModuleManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.MathHelper;

public class Killaura extends Module {

	public Killaura() {

		super("Killaura", Keyboard.KEY_K, Category.Combat);
		this.setMode(Mode.Sword);
	}

	public static int Range = (int) 4.5;
	
	public Entity ClosestEntity() {
		Entity closest = null;
		for(Object o : mc.theWorld.loadedEntityList) {			
			Entity e = (Entity) o;
			if((!(o instanceof EntityPlayerSP) &&o instanceof EntityLivingBase && (!e.isDead) && e.getEntityId()< 1000000000 && mc.thePlayer.canEntityBeSeen(e))) {				
				if((!e.getName().equals(mc.thePlayer.getName())) && (closest == null) || mc.thePlayer.getDistanceToEntity(e) < mc.thePlayer.getDistanceToEntity(closest)) {					
					closest = e;
					
				}
				
			}
			
		}
			return closest;
		
	}
	
	
	
	private int delay;
	
	private Timer timer = new Timer();
	
	public Entity entity;
	public void Tick() {
		this.setColorToggle(true);
		entity = ClosestEntity();
		if(entity != null && !entity.isInvisible() !=entity.isDead) {						
			if(entity.getDistanceToEntity(mc.thePlayer) <= Range) {				
				if(this.getMode() == Mode.Sword) {	
					if(timer.hasReached(485)) {
						if(ModuleManager.criticals.isToggled()) {
							HookManager.doCrits();
						}
						mc.playerController.attackEntity(mc.thePlayer, entity);
						mc.thePlayer.swingArm(EnumHand.MAIN_HAND);
						timer.reset();
					}	
				}else if(this.getMode() == Mode.Axe){
					if(timer.hasReached(1050)) {
						if(ModuleManager.criticals.isToggled()) {
							HookManager.doCrits();
						}
						mc.playerController.attackEntity(mc.thePlayer, entity);
						mc.thePlayer.swingArm(EnumHand.MAIN_HAND);
						timer.reset();
					}	
				}
			
			}
			else if(entity != null && entity.isInvisible() && (entity instanceof EntityPlayer)) {						
				if(entity.getDistanceToEntity(mc.thePlayer) <= Range) {				
					if(this.getMode() == Mode.Sword) {	
						if(timer.hasReached(485)) {
							if(ModuleManager.criticals.isToggled()) {
								HookManager.doCrits();
							}
							mc.playerController.attackEntity(mc.thePlayer, entity);
							mc.thePlayer.swingArm(EnumHand.MAIN_HAND);
							timer.reset();
						}	
					}else if(this.getMode() == Mode.Axe){
						if(timer.hasReached(1100)) {
							if(ModuleManager.criticals.isToggled()) {
								HookManager.doCrits();
							}
							mc.playerController.attackEntity(mc.thePlayer, entity);
							mc.thePlayer.swingArm(EnumHand.MAIN_HAND);
							timer.reset();
						}	
					}
				
				}
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
	
	public void Event(Event e) {
		if(e instanceof EventPreMotion) {
			if(entity != null) {
				if(entity.getDistanceToEntity(mc.thePlayer) <= Range) {
					((EventPreMotion) e).rotationYaw = getYaw(entity);
					((EventPreMotion) e).rotationPitch = getPitch(entity);
			
				}
					
			}
		
		}
	
	}
	
	  public static float getYaw(Entity e)
	  {
	    double x = e.posX - Minecraft.getMinecraft().thePlayer.posX;
	    double z = e.posZ - Minecraft.getMinecraft().thePlayer.posZ;
	    
	    float yaw = (float)(Math.atan2(z, x) * 180.0D / 3.141592653589793D) - 90.0F;
	    if (yaw < 0.0F) {
	      yaw += 360.0F;
	    }
	    return yaw;
	  }
	  
	  public static float getPitch(Entity e)
	  {
	    double x = e.posX - Minecraft.getMinecraft().thePlayer.posX;
	    double z = e.posZ - Minecraft.getMinecraft().thePlayer.posZ;
	    
	    double d1 = Minecraft.getMinecraft().thePlayer.posY + Minecraft.getMinecraft().thePlayer.getEyeHeight() - (
	      e.posY + e.getEyeHeight());
	    double d3 = MathHelper.sqrt_double(x * x + z * z);
	    float f1 = (float)-(Math.atan2(d1, d3) * 180.0D / 3.141592653589793D);
	    
	    return -f1;
	  }	  
	
}
