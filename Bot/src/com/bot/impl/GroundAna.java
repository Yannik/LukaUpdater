package com.bot.impl;

import java.util.ListIterator;

import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;

import com.bot.DatCreator;
import com.bot.generic.AbstractAnalyser;
import com.bot.utils.JarUtils;

public class GroundAna  extends AbstractAnalyser {

	@Override
	protected boolean canRun(ClassNode node, Hooks hooks) {
		return node.name.equals("Ground");
	}

	@Override
	protected void analyse(ClassNode node, Hooks hooks) {
		System.out.println("Found Class: " + node.name);
		
	}

	@Override
	protected void AddHooks(ClassNode node, Hooks hooks) {
		JarUtils.injectInterface(node, "com/bot/accessors/Ground");
		DatCreator.AddScring("injectinter com/bot/accessors/Ground " + node.name );
		ListIterator<FieldNode> fnIt = node.fields.listIterator();
		while (fnIt.hasNext()) {
			FieldNode field = fnIt.next();
			if(field.name.equals("obj1")) {
				JarUtils.addGetterNonStatic(node, field, "getPhysicalObject1", "Lcom/bot/accessors/PhysicalObject;");
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getPhysicalObject1 Lcom/bot/accessors/PhysicalObject;");
			}
			
			if(field.name.equals("obj2")) {
				JarUtils.addGetterNonStatic(node, field, "getPhysicalObject2", "Lcom/bot/accessors/PhysicalObject;");
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getPhysicalObject2 Lcom/bot/accessors/PhysicalObject;");
			}
			
			if(field.name.equals("obj3")) {
				JarUtils.addGetterNonStatic(node, field, "getPhysicalObject3", "Lcom/bot/accessors/PhysicalObject;");
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getPhysicalObject3 Lcom/bot/accessors/PhysicalObject;");
			}
			
			if(field.name.equals("obj4")) {
				JarUtils.addGetterNonStatic(node, field, "getPhysicalObject4", "Lcom/bot/accessors/PhysicalObject;");
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getPhysicalObject4 Lcom/bot/accessors/PhysicalObject;");
			}
			
			if(field.name.equals("obj5Array")) {
				JarUtils.addGetterNonStatic(node, field, "getInteractivePhysicalObjects", "[Lcom/bot/accessors/PhysicalObject;");
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getInteractivePhysicalObjects [Lcom/bot/accessors/PhysicalObject;");
			}
		}
	}
}
