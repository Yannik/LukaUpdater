package com.bot.impl;

import java.util.ListIterator;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;

import com.bot.DatCreator;
import com.bot.generic.AbstractAnalyser;
import com.bot.utils.JarUtils;

public class WorldControllerAna extends AbstractAnalyser implements Opcodes {
	protected boolean canRun(ClassNode node, Hooks hooks) {
		return node.name.equals("WorldController");
	}

	@Override
	protected void analyse(ClassNode node, Hooks hooks) {
		System.out.println("Found Class: " + node.name);
		
	}

	@Override
	protected void AddHooks(ClassNode node, Hooks hooks) {
		JarUtils.injectInterface(node, "com/bot/accessors/WorldController");
		DatCreator.AddScring("injectinter com/bot/accessors/WorldController " + node.name );
		ListIterator<FieldNode> fnIt = node.fields.listIterator();
		while (fnIt.hasNext()) {
			FieldNode field = fnIt.next();
			if(field.name.equals("obj5Cache")) {
				JarUtils.addGetterNonStatic(node, field, "getCache", "[Lcom/bot/accessors/PhysicalObject;");
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getCache [Lcom/bot/accessors/PhysicalObject;");	
			}
			
			if(field.name.equals("obj5CacheCurrPos")) {
				JarUtils.addGetterNonStatic(node, field, "getobj5CacheCurrPos", field.desc);
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getobj5CacheCurrPos " + field.desc);	
			}
			
			if(field.name.equals("groundArray")) {
				JarUtils.addGetterNonStatic(node, field, "getGroundArray", "[[[Lcom/bot/accessors/Ground;");
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getGroundArray " + field.desc);	
			//	field.access = ((field.access & ~ACC_PRIVATE) | ACC_PUBLIC)	;
				//		field.access = field.access | ACC_STATIC;
			}
		}

	}
}