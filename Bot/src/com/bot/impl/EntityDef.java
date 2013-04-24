package com.bot.impl;

import java.util.ListIterator;

import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;

import com.bot.DatCreator;
import com.bot.generic.AbstractAnalyser;
import com.bot.utils.JarUtils;

public class EntityDef extends AbstractAnalyser {

	@Override
	protected boolean canRun(ClassNode node, Hooks hooks) {
		return node.name.equals("EntityDef");
	}

	@Override
	protected void analyse(ClassNode node, Hooks hooks) {
		System.out.println("Found Class: " + node.name);
		
	}

	@Override
	protected void AddHooks(ClassNode node, Hooks hooks) {
		JarUtils.injectInterface(node, "com/bot/accessors/EntityDef"); 
		DatCreator.AddScring("injectinter com/bot/accessors/EntityDef " + node.name );
		ListIterator<FieldNode> fnIt = node.fields.listIterator();
		while (fnIt.hasNext()) {
			FieldNode field = fnIt.next();
			if(field.desc.equals("Ljava/lang/String;")) {
				JarUtils.addGetterNonStatic(node, field, "getName ", "Ljava/lang/String;");
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getName " + field.desc);
	}
			
			if(field.desc.equals("I") && field.name.equals("walkAnim")) {
				JarUtils.addGetterNonStatic(node, field, "getwalkAnimation ", field.desc);
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getwalkAnimation " + field.desc);
				
	}
			
			if(field.desc.equals("I") && field.name.equals("standAnim")) {
				JarUtils.addGetterNonStatic(node, field, "getStandAnimation ", field.desc);
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getStandAnimation " + field.desc);
	}
			
			if(field.desc.equals("I") && field.name.equals("combatLevel")) {
				JarUtils.addGetterNonStatic(node, field, "getcombatLevel ", field.desc);	
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getcombatLevel " + field.desc);
	}
			
			if(field.name.equals("type")) {
				JarUtils.addGetterNonStatic(node, field, "getID ", field.desc);		
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getID " + field.desc);
	}
			
			
			if(field.name.equals("actions")) {
				JarUtils.addGetterNonStatic(node, field, "getActions ", field.desc);	
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getActions " + field.desc);
	}	
		
			
			
	}
	
}
}