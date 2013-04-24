package com.bot.impl;

import java.util.ListIterator;

import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;

import com.bot.DatCreator;
import com.bot.generic.AbstractAnalyser;
import com.bot.utils.JarUtils;

public class RSinterfaceAna extends AbstractAnalyser {


	@Override
	protected boolean canRun(ClassNode node, Hooks hooks) {
		return node.name.equals("RSInterface");
	}

	@Override
	protected void analyse(ClassNode node, Hooks hooks) {
		System.out.println("Found Class: " + node.name);

	}

	@Override
	protected void AddHooks(ClassNode node, Hooks hooks) {
		JarUtils.injectInterface(node, "com/bot/accessors/RSInterface"); 
		DatCreator.AddScring("injectinter com/bot/accessors/RSInterface " + node.name );

		ListIterator<FieldNode> fnIt = node.fields.listIterator();		
		while (fnIt.hasNext()) {			
			FieldNode field = fnIt.next();

			if(field.name.equals("message")) {
				JarUtils.addGetterNonStatic(node, field, "getMessage", field.desc);
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getMessage " + field.desc);	
			}

			if(field.name.equals("inv") && field.desc.equals("[I")) {
				JarUtils.addGetterNonStatic(node, field, "getItems", field.desc);
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getItems " + field.desc);	
			}
			if(field.name.equals("id") && field.desc.equals("I")) {
				JarUtils.addGetterNonStatic(node, field, "getId", field.desc);
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getId " + field.desc);	
			}

			if(field.name.equals("children") && field.desc.equals("[I")) {
				JarUtils.addGetterNonStatic(node, field, "getChildren", field.desc);
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getChildren " + field.desc);	
			}

			if(field.name.equals("childX") && field.desc.equals("[I")) {
				JarUtils.addGetterNonStatic(node, field, "getChildY", field.desc);
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getChildY " + field.desc);	
			}

			if(field.name.equals("childY") && field.desc.equals("[I")) {
				JarUtils.addGetterNonStatic(node, field, "getChildX", field.desc);
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getChildX " + field.desc);	
			}

			if(field.name.equals("width") && field.desc.equals("I")) {
				JarUtils.addGetterNonStatic(node, field, "getWidth", field.desc);
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getWidth " + field.desc);	
			}

			if(field.name.equals("height") && field.desc.equals("I")) {
				JarUtils.addGetterNonStatic(node, field, "getHeight", field.desc);
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getHeight " + field.desc);	
			}

			if(field.name.equals("parentID") && field.desc.equals("I")) {
				JarUtils.addGetterNonStatic(node, field, "getParent", field.desc);
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getParent " + field.desc);	
			}
			if(field.name.equals("hoverText")) {
				JarUtils.addGetterNonStatic(node, field, "gethoverText", field.desc);
				DatCreator.AddScring("getn " + node.name + " " + field.name + " gethoverText " + field.desc);	
			}

			if(field.name.equals("valueIndexArray")) {
				JarUtils.addGetterNonStatic(node, field, "getvalueIndexArray", field.desc);
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getvalueIndexArray " + field.desc);	
			}

			if(field.name.equals("spellName")) {
				JarUtils.addGetterNonStatic(node, field, "getSpellName", field.desc);
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getSpellName " + field.desc);	
			}
			if(field.name.equals("actions")) {
				JarUtils.addGetterNonStatic(node, field, "getActions", field.desc);
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getActions " + field.desc);	
			}

			if(field.name.equals("tooltip")) {
				JarUtils.addGetterNonStatic(node, field, "getTooltip", field.desc);
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getTooltip " + field.desc);	
			}

			if(field.name.equals("popupString")) {
				JarUtils.addGetterNonStatic(node, field, "getPopup", field.desc);
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getPopup " + field.desc);	
			}

			if(field.name.equals("selectedActionName")) {
				JarUtils.addGetterNonStatic(node, field, "getSelectedActionName", field.desc);
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getSelectedActionName " + field.desc);	
			}

			if(field.name.equals("isInventoryInterface")) {
				JarUtils.addGetterNonStatic(node, field, "isInventory", field.desc);
				DatCreator.AddScring("getn " + node.name + " " + field.name + " isInventory " + field.desc);	
			}

			if(field.name.equals("invStackSizes")) {
				JarUtils.addGetterNonStatic(node, field, "getStackSize", field.desc);
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getStackSize " + field.desc);	
			}


			if(field.name.equals("spritesX")) {
				JarUtils.addGetterNonStatic(node, field, "getSpriteX", field.desc);
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getSpriteX " + field.desc);	
			}


			if(field.name.equals("spritesY")) {
				JarUtils.addGetterNonStatic(node, field, "getSpriteY", field.desc);
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getSpriteY " + field.desc);	
			}


		}

	}
}