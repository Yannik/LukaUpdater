package com.bot.generic;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.MethodNode;

import com.bot.impl.Hooks;

public abstract class AbstractAnalyser {
	
	public void run(ClassNode node, Hooks hooks) {
		if(this.canRun(node, hooks)) {
			this.analyse(node, hooks);
			this.AddHooks(node, hooks);
		}
	}

	protected abstract boolean canRun(ClassNode node, Hooks hooks);
	protected abstract void analyse(ClassNode node, Hooks hooks);
	protected abstract void AddHooks(ClassNode node, Hooks hooks); 

}
