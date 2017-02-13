package escapemc.module;

import java.util.ArrayList;

import escapemc.module.modules.AutoArmor;
import escapemc.module.modules.Criticals;
import escapemc.module.modules.Fly;
import escapemc.module.modules.FreeCam;
import escapemc.module.modules.Fullbright;
import escapemc.module.modules.Glide;
import escapemc.module.modules.JesusWalk;
import escapemc.module.modules.Killaura;
import escapemc.module.modules.NoFall;
import escapemc.module.modules.Panic;
import escapemc.module.modules.Parkour;
import escapemc.module.modules.Phase;
import escapemc.module.modules.Speed;
import escapemc.module.modules.Spider;
import escapemc.module.modules.Sprint;
import escapemc.module.modules.Step;
import escapemc.module.modules.Tracers;
import escapemc.module.modules.Xray;
import escapemc.module.modules.Zoom;
import net.minecraft.client.Minecraft;

public class ModuleManager {

	public static ArrayList<Module> Modules = new ArrayList<Module>();
	
	public static Criticals criticals = new Criticals();
	public static Killaura killaura = new Killaura();
	public static Xray xray = new Xray();
	
	
	public static ArrayList<Module> getModules(){
	
		return Modules;
	
	}

	
	private static void addModule(Module m) {
		
		Modules.add(m);
		
	}


	public static void registerModules() {

		addModule(new AutoArmor());
		addModule(criticals);
		addModule(new Fly());
		addModule(new FreeCam());
		addModule(new Fullbright());
		addModule(new Glide());
		addModule(new JesusWalk());
		addModule(killaura);
		addModule(new NoFall());
		addModule(new Panic());
		addModule(new Parkour());
		addModule(new Phase());
		addModule(new Speed());
		addModule(new Spider());
		addModule(new Sprint());
		addModule(new Step());
		addModule(new Tracers());
		addModule(xray);
		addModule(new Zoom());
		
		
	}
	
	
	public static void onUpdate(){
		for(Module m: Modules){
			m.onUpdate();
		}
	}
	
	public static void onRender(){
		for(Module m: Modules){
			m.onRender2D(Minecraft.getMinecraft().timer.renderPartialTicks);
		}
	}
	
	public static void onKeyPressed(int k){
		for(Module m: Modules){
			if(m.getKey() == k){
				m.toggle();
			}
		}
	}	
}

