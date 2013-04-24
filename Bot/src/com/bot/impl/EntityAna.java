package com.bot.impl;

import java.util.ListIterator;

import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;

import com.bot.DatCreator;
import com.bot.generic.AbstractAnalyser;
import com.bot.utils.JarUtils;

public class EntityAna  extends AbstractAnalyser {

	@Override
	protected boolean canRun(ClassNode node, Hooks hooks) {
		return node.name.equals("Entity");
	}

	@Override
	protected void analyse(ClassNode node, Hooks hooks) {
		System.out.println("Found Class: " + node.name);
		
	}

	@Override
	protected void AddHooks(ClassNode node, Hooks hooks) {
		JarUtils.injectInterface(node, "com/bot/accessors/NPC"); 
		JarUtils.injectInterface(node, "com/bot/accessors/PlayerAccessor");
		JarUtils.injectInterface(node, "com/bot/accessors/RSObjectDef");
		DatCreator.AddScring("injectinter com/bot/accessors/NPC " + node.name );
		DatCreator.AddScring("injectinter com/bot/accessors/PlayerAccessor " + node.name );
		DatCreator.AddScring("injectinter com/bot/accessors/RSObjectDef " + node.name );
		ListIterator<FieldNode> fnIt = node.fields.listIterator();
		while (fnIt.hasNext()) {
			FieldNode field = fnIt.next();
			if(field.desc.equals("I") && field.name.equals("currentHealth")) {
				JarUtils.addGetterNonStatic(node, field, "getCurrentHp", field.desc);
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getCurrentHp " + field.desc);
			}
			if(field.desc.equals("I") && field.name.equals("maxHealth")) {
				JarUtils.addGetterNonStatic(node, field, "getmaxHealth", field.desc);
				DatCreator.AddScring("getn " + node.name + " " + field.name + " maxHealth " + field.desc);
			}
			
			if(field.desc.equals("I") && field.name.equals("anim")) {
				JarUtils.addGetterNonStatic(node, field, "getAnimimation", field.desc);
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getAnimimation "  + field.desc);
			}
		
			if(field.name.equals("actions")) {
				JarUtils.addGetterNonStatic(node, field, "getActions", field.desc);
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getActions " + field.desc);
			}
			
			if(field.desc.equals("I") && field.name.equals("x")) {
				JarUtils.addGetterNonStatic(node, field, "getX", field.desc);
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getX " + field.desc);
			}
			
			if(field.desc.equals("I") && field.name.equals("y")) {
				JarUtils.addGetterNonStatic(node, field, "getY", field.desc);
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getY " + field.desc);
			}
			
			if(field.desc.equals("I") && field.name.equals("height")) {
				JarUtils.addGetterNonStatic(node, field, "getHeight", field.desc);
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getHeight " + field.desc);
			}
			if(field.desc.equals("I") && field.name.equals("interactingEntity")) {
				JarUtils.addGetterNonStatic(node, field, "getInteractingNPC", field.desc);
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getInteractingNPC " + field.desc);
			}
			
		}
	}
}
