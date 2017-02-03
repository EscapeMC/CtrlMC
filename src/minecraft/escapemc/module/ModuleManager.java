package escapemc.module;

import java.util.ArrayList;

import escapemc.module.modules.Criticals;
import escapemc.module.modules.Fly;
import escapemc.module.modules.Fullbright;
import escapemc.module.modules.Killaura;
import escapemc.module.modules.Reach;
import escapemc.module.modules.Speed;
import escapemc.module.modules.Sprint;

public class ModuleManager {

	public static ArrayList<Module> Modules = new ArrayList<Module>();
	
	public static Criticals criticals = new Criticals();
	public static Reach reach = new Reach();
	
	
	public static ArrayList<Module> getModules(){
	
		return Modules;
	
	}

	
	private static void addModule(Module m) {
		
		Modules.add(m);
		
	}


	public static void registerModules() {

		addModule(new Fly());
		addModule(new Fullbright());
		addModule(new Sprint());
		addModule(new Speed());
		addModule(new Killaura());
		addModule(criticals);
		addModule(reach);
		
		
	}
	
	
	public static void onUpdate(){
		for(Module m: Modules){
			m.onUpdate();
		}
	}
	
	public static void onRender(){
		for(Module m: Modules){
			m.onRender();
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

