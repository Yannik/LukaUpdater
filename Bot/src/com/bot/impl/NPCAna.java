package com.bot.impl;

import java.awt.Component;
import java.util.ListIterator;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;

import com.bot.DatCreator;
import com.bot.generic.AbstractAnalyser;
import com.bot.utils.JarUtils;

public class NPCAna extends AbstractAnalyser {

	
	@Override
	protected boolean canRun(ClassNode node, Hooks hooks) {
		return node.name.equals("NPC");
	}

	@Override
	protected void analyse(ClassNode node, Hooks hooks) {
		System.out.println("Found Class: " + node.name);
		
	}

	@Override
	protected void AddHooks(ClassNode node, Hooks hooks) {
		JarUtils.injectInterface(node, "com/bot/accessors/NPC"); 
		DatCreator.AddScring("injectinter com/bot/accessors/NPC " + node.name );
					ListIterator<FieldNode> fnIt = node.fields.listIterator();		
					while (fnIt.hasNext()) {			
						FieldNode field = fnIt.next();
					if(field.desc.equals("LEntityDef;")) {
						JarUtils.addGetterNonStatic(node, field, "getEntityDef", "Lcom/bot/accessors/EntityDef;");
						DatCreator.AddScring("getn " + node.name + " " + field.name + " getEntityDef Lcom/bot/accessors/EntityDef; ");	 
				}
					
				}
				
			}
			
			}