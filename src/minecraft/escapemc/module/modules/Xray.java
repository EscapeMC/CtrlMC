package escapemc.module.modules;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;

import escapemc.module.Category;
import escapemc.module.Module;
import net.minecraft.block.Block;

public class Xray extends Module {
	
	public Xray() {
	
		super("Xray", Keyboard.KEY_X, Category.Render);

	}

	public static ArrayList<Block> xrayBlocks = new ArrayList<Block>();
		
	@Override
	public void onEnable()
	{
		mc.renderGlobal.loadRenderers();
	}
	
	@Override
	public void onDisable() {

		mc.renderGlobal.loadRenderers();
		
	}
}