package com.bot.impl;

import java.util.ListIterator;

import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;

import com.bot.DatCreator;
import com.bot.generic.AbstractAnalyser;
import com.bot.utils.JarUtils;

public class ItemDefAna extends AbstractAnalyser {

	@Override
	protected boolean canRun(ClassNode node, Hooks hooks) {
		return node.name.equals("ItemDef");
	}

	@Override
	protected void analyse(ClassNode node, Hooks hooks) {
		System.out.println("Found Class: " + node.name);
		
	}

	@Override
	protected void AddHooks(ClassNode node, Hooks hooks) {
		JarUtils.injectInterface(node, "com/bot/accessors/RSItemDef"); 
		DatCreator.AddScring("injectinter com/bot/accessors/RSItemDef " + node.name );
		ListIterator<FieldNode> fnIt = node.fields.listIterator();		
		while (fnIt.hasNext()) {			
			FieldNode field = fnIt.next();
			if(field.name.equals("name")) {
				JarUtils.addGetterNonStatic(node, field, "getItemName", field.desc);
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getItemName " + field.desc);
			}	
			if(field.name.equals("stackAmounts")) {
				JarUtils.addGetterNonStatic(node, field, "getstackAmounts", field.desc);
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getstackAmounts " + field.desc);
			}			
			if(field.name.equals("totalItems")) {
				JarUtils.addGetterMethod(node, field, "gettotalItems", field.desc);
				DatCreator.AddScring("get " + node.name + " " + field.name + " gettotalItems " + field.desc);
			}
			
			if(field.name.equals("actions")) {
				JarUtils.addGetterMethod(node, field, "getActions", field.desc);
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getActions [Ljava/lang/String;");
			}
			
			if(field.name.equals("groundActions")) {
				JarUtils.addGetterMethod(node, field, "getGroundActions", field.desc);
				DatCreator.AddScring("getm " + node.name + " " + field.name + " getGroundActions [Ljava/lang/String;");
			}
			if(field.name.equals("id")) {
				JarUtils.addGetterNonStatic(node, field, "getID", field.desc);
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getID " + field.desc);
			}
			

		}
		
	}

}
