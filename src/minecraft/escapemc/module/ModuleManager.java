package escapemc.module;

import java.util.ArrayList;

import escapemc.Command.CommandManager;
import escapemc.module.modules.Fly;
import escapemc.module.modules.Fullbright;
import net.minecraft.client.Minecraft;
import net.minecraft.network.play.server.SPacketChat;
import net.minecraft.util.text.ITextComponent;

public class ModuleManager {

	public static ArrayList<Module> Modules = new ArrayList<Module>();
	
	
	public static ArrayList<Module> getModules(){
	
		return Modules;
	
	}

	
	private static void addModule(Module m) {
		
		Modules.add(m);
		
	}


	public static void registerModules() {

		addModule(new Fly());
		addModule(new Fullbright());
		
		
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
	
	public static boolean onSendChatMessage(String s){//EntityPlayerSP
		if(s.startsWith(".")){
			CommandManager.callCommand(s.substring(1));
			return false;
		}
		for(Module m: getModules()){
			if(m.isToggled()){
				return m.onSendChatMessage(s);
			}
		}
		return true;
	}
	
	public static boolean onRecieveChatMessage(SPacketChat packet){
		for(Module m: getModules()){
			if(m.isToggled()){
				return m.onRecieveChatMessage(packet);
			}
		}
		return true;
	}
	
}

