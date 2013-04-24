package com.bot.impl;

import java.util.ListIterator;

import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;

import com.bot.DatCreator;
import com.bot.generic.AbstractAnalyser;
import com.bot.utils.JarUtils;

public class RS2Applet extends AbstractAnalyser {

	@Override
	protected boolean canRun(ClassNode node, Hooks hooks) {
		return node.name.equals("RSApplet");
	}

	@Override
	protected void analyse(ClassNode node, Hooks hooks) {
		System.out.println("Found Class: " + node.name);
		
	}

	@Override
	protected void AddHooks(ClassNode node, Hooks hooks) {
		JarUtils.injectInterface(node, "com/bot/accessors/Client");
		JarUtils.injectInterface(node, "com/bot/accessors/GameApplet"); 
		DatCreator.AddScring("injectinter com/bot/accessors/GameApplet " + node.name );
		DatCreator.AddScring("injectinter com/bot/accessors/Client " + node.name );

		ListIterator<FieldNode> fnIt = node.fields.listIterator();
		while (fnIt.hasNext()) {
			FieldNode field = fnIt.next();
		if(field.name.equals("graphics")) {
			JarUtils.addGetterNonStatic(node, field, "getRealGraphics", field.desc);
		
		}
		}
		
	}
	

}
