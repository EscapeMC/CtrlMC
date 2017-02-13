package escapemc.Command.commands;

import escapemc.Command.Command;
import escapemc.Util.ChatUtil;
import escapemc.module.Module;
import escapemc.module.ModuleManager;

public class CommandListModules extends Command {

	@Override
	public String getName() {

		return "listmods";
	
	}

	@Override
	public String getDescription() {

		return "Lists all the modules and their keybinds.";
	
	}

	@Override
	public String getSyntax() {

		return "-listmods";
	
	}

	@Override
	public void onCommand(String command, String[] args) throws Exception {

		for(Module m : ModuleManager.Modules) {
			
			ChatUtil.SendChatMessage(m.getName());
			
		}

	
	}

}