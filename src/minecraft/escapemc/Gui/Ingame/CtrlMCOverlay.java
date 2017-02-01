package escapemc.Gui.Ingame;

import escapemc.module.Category;
import escapemc.module.Module;
import escapemc.module.ModuleManager;
import net.minecraft.client.Minecraft;

public class CtrlMCOverlay {

	static Minecraft mc = Minecraft.getMinecraft();
	
	
	public static void drawOverlay() {
		
		mc.fontRendererObj.drawString("�3Ctrl�bMC �51.0", 0, 0, 0xffffffff);
		DrawModList();
		
	}
	
	private static void DrawModList() {
		
		int y = 20;
		for(Module m : ModuleManager.Modules) {
			
			if(m.isToggled() && m.getCategory() != Category.Hidden) {
				
				mc.fontRendererObj.drawString(m.getName(), 1, y, 0xffffffff);
				y += 9;
				
			}
			
		}
		
	}
	
	
	
}
