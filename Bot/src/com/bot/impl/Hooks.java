package com.bot.impl;

import org.objectweb.asm.tree.ClassNode;

public class Hooks {
	
	private static Hooks hooks;
	

	private Hooks() {
	}
	
	public static Hooks getHooks() {
		if (hooks == null) {
			hooks = new Hooks();
		}
		return hooks;
	}
	
	public String actor, player, npc, npcDef, client, node, canvas, playerDef, SceneGraph, tileintarray,byteintarra;
	
	public ClassNode clientnode;
	
	//////Leech Hooks/////////////
	
	public String SceneFlagField = "f";
	public String SceneFlagNode = "k";
	
	
}
