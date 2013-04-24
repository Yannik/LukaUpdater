package com.bot.impl;

import java.util.ListIterator;

import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;

import com.bot.DatCreator;
import com.bot.generic.AbstractAnalyser;
import com.bot.utils.JarUtils;

public class NodeAna  extends AbstractAnalyser {

	@Override
	protected boolean canRun(ClassNode node, Hooks hooks) {
		return node.name.equals("Node");
	}

	@Override
	protected void analyse(ClassNode node, Hooks hooks) {
		System.out.println("Found Class: " + node.name);
		
	}

	@Override
	protected void AddHooks(ClassNode node, Hooks hooks) {
		JarUtils.injectInterface(node, "com/bot/accessors/Node");
		DatCreator.AddScring("injectinter com/bot/accessors/Node " + node.name );
		ListIterator<FieldNode> fnIt = node.fields.listIterator();
		while (fnIt.hasNext()) {
			FieldNode field = fnIt.next();
			if(field.name.equals("next")) {
				JarUtils.addGetterNonStatic(node, field, "getNext", "Lcom/bot/accessors/Node;");
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getNext Lcom/bot/accessors/Node; ");
			}
		}
	}
}
