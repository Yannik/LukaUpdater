package com.bot.impl;

import java.util.ListIterator;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.MethodNode;

import com.bot.DatCreator;
import com.bot.generic.AbstractAnalyser;
import com.bot.utils.JarUtils;

public class ObjectAna extends AbstractAnalyser implements Opcodes {

	@Override
	protected boolean canRun(ClassNode node, Hooks hooks) {
		return node.name.equals("ObjectDef");
	}

	@Override
	protected void analyse(ClassNode node, Hooks hooks) {
		System.out.println("Found Class: " + node.name);
		
	}

	@Override
	protected void AddHooks(ClassNode node, Hooks hooks) {
		JarUtils.injectInterface(node, "com/bot/accessors/RSObjectDef");
		DatCreator.AddScring("injectinter com/bot/accessors/RSObjectDef " + node.name );
		ListIterator<FieldNode> fnIt = node.fields.listIterator();		
		while (fnIt.hasNext()) {			
			FieldNode field = fnIt.next();
			if(field.name.equals("cache")){
			field.access = ((field.access & ~ACC_PRIVATE) | ACC_PUBLIC);
			}
			if(field.name.equals("name")) {
				JarUtils.addGetterNonStatic(node, field, "getName", field.desc);
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getName " + field.desc);	 
			}
			
			if(field.name.equals("type")) {
				JarUtils.addGetterNonStatic(node, field, "getType", field.desc);
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getType " + field.desc);	 
			}
			
			if(field.name.equals("itemActions")) {
				JarUtils.addGetterNonStatic(node, field, "getActions", field.desc);
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getActions " + field.desc);	
			}
		
		}
		/*
		ListIterator<MethodNode> mnIt = node.methods.listIterator();		
		while (mnIt.hasNext()) {			
			MethodNode method = mnIt.next();
			
		}
		*/
	}

}
