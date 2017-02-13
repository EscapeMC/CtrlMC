package escapemc.Gui.Ingame;

import escapemc.main.Reference;
import escapemc.module.Category;
import escapemc.module.Module;
import escapemc.module.ModuleManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;

public class CtrlMCOverlay {

	static Minecraft mc = Minecraft.getMinecraft();
		
	
	public static void drawOverlay() {
		
		mc.fontRendererObj.drawString("�3Ctrl�bMC �5"+Reference.VERSION, 0, 0, 0xffffffff);
		DrawModBox();
		DrawModList();
		//Gui.drawRect(left, top, right, bottom, color);
		
	}
	
	private static void DrawModList() {
		
		int y = 28;
		for(Module m : ModuleManager.Modules) {
			
			if(m.isToggled()) {
				mc.fontRendererObj.drawString("Active Mods:", 149, 17, 0xffffff00);
				if(m.getMode() == null) {
				mc.fontRendererObj.drawString("�c"+m.getName(), 136, y, 0xffffffff);
				}else{
				mc.fontRendererObj.drawString("�c"+m.getName() + " (" + m.getMode() + ")", 136, y, 0xffffffff);
				//mc.fontRendererObj.drawString(text, x, y, color)	
				}
				y += 9;				
			}
			
		}
		
	}
	
	private static void DrawModBox() {
		
		int y = 39;
		for(Module m : ModuleManager.Modules) {
			
			if(m.isToggled()) {
				
				Gui.drawRect(132, 14, 228, y, 0xff444444);
				y += 9;

				
			}
			
		}
		
	}
	
}
