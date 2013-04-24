package com.bot.impl;

import java.awt.Component;
import java.util.ListIterator;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.MethodNode;

import com.bot.DatCreator;
import com.bot.generic.AbstractAnalyser;
import com.bot.utils.JarUtils;

public class Item extends AbstractAnalyser {

	
	@Override
	protected boolean canRun(ClassNode node, Hooks hooks) {
		return node.name.equals("Item");
	}

	@Override
	protected void analyse(ClassNode node, Hooks hooks) {
		System.out.println("Found Class: " + node.name);
		
	}

	@Override
	protected void AddHooks(ClassNode node, Hooks hooks) {
		JarUtils.injectInterface(node, "com/bot/accessors/RSItem"); 
		DatCreator.AddScring("injectinter com/bot/accessors/RSItem " + node.name );
					ListIterator<FieldNode> fnIt = node.fields.listIterator();		
					while (fnIt.hasNext()) {			
						FieldNode field = fnIt.next();
						if(field.desc.equals("I") && field.name.equals("x")) {
							JarUtils.addGetterNonStatic(node, field, "getItemX", field.desc);
							DatCreator.AddScring("getn " + node.name + " " + field.name + " getItemX " + field.desc);
						}
						if(field.desc.equals("I") && field.name.equals("y")) {
							JarUtils.addGetterNonStatic(node, field, "getItemY", field.desc);
							DatCreator.AddScring("getn " + node.name + " " + field.name + " getItemY " + field.desc);
						}
						if(field.desc.equals("I") && field.name.equals("ID")) {
							JarUtils.addGetterNonStatic(node, field, "getItemID", field.desc);
							DatCreator.AddScring("getn " + node.name + " " + field.name + " getItemID " + field.desc);
						}
					}
					
				
			}
			
	}