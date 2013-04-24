package com.bot.impl;

import java.awt.Component;
import java.util.ListIterator;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;

import com.bot.DatCreator;
import com.bot.generic.AbstractAnalyser;
import com.bot.utils.JarUtils;

public class PlayerAna extends AbstractAnalyser {

	@Override
	protected boolean canRun(ClassNode node, Hooks hooks) {
		return node.name.equals("Player");
	}

	@Override
	protected void analyse(ClassNode node, Hooks hooks) {
		System.out.println("Found Class: " + node.name);
		
	}

	@Override
	protected void AddHooks(ClassNode node, Hooks hooks) {
		JarUtils.injectInterface(node, "com/bot/accessors/PlayerAccessor"); 
		DatCreator.AddScring("injectinter com/bot/accessors/PlayerAccessor " + node.name );
					ListIterator<FieldNode> fnIt = node.fields.listIterator();		
					while (fnIt.hasNext()) {			
						FieldNode field = fnIt.next();
					if(field.desc.equals("Ljava/lang/String;")) {
						JarUtils.addGetterNonStatic(node, field, "getName", "Ljava/lang/String;");
						DatCreator.AddScring("getn " + node.name + " " + field.name + " getName " + field.desc);	
			}
					
					if(field.desc.equals("I") && field.name.equals("combatLevel")) {
						JarUtils.addGetterNonStatic(node, field, "getCombatLevel", field.desc);		
						DatCreator.AddScring("getn " + node.name + " " + field.name + " getCombatLevel " + field.desc);	
			}
					if(field.desc.equals("I") && field.name.equals("skullIcon")) {
						JarUtils.addGetterNonStatic(node, field, "getSkullIcon", field.desc);	
						DatCreator.AddScring("getn " + node.name + " " + field.name + " getSkullIcon " + field.desc);	
			}	
					
					if(field.desc.equals("Z") && field.name.equals("visible")) {
						JarUtils.addGetterNonStatic(node, field, "canBeVisible", field.desc);	
						DatCreator.AddScring("getn " + node.name + " " + field.name + " canBeVisible " + field.desc);	
			}		
					
					if(field.name.equals("desc")) {
						JarUtils.addGetterNonStatic(node, field, "getEntityDef", "Lcom/bot/accessors/EntityDef;");
						DatCreator.AddScring("getn " + node.name + " " + field.name + " getUID Lcom/bot/accessors/EntityDef;");	
			}		
					
					
					
				}
				
			}
			
			}