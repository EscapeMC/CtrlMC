package escapemc.module.modules;

import org.lwjgl.input.Keyboard;

import escapemc.module.Category;
import escapemc.module.Module;
import net.minecraft.network.play.client.CPacketPlayer;

public class NoFall extends Module{

	public NoFall() {
		super("Nofall", 0, Category.Player);
	}
	
	public void Tick(){
		if(mc.thePlayer.fallDistance > -5F){
			mc.thePlayer.connection.sendPacket(new CPacketPlayer(true));
		}
	}
	
	@Override
	public void onEnable() {

		this.setColorToggle(true);
	
	}
	
	public void onDisable() {

		this.setColorToggle(false);
		
	}
	
}