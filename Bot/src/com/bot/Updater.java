package com.bot;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

import com.bot.generic.AbstractAnalyser;
import com.bot.impl.ClientAna;
import com.bot.impl.EntityAna;
import com.bot.impl.EntityDef;
import com.bot.impl.GroundAna;
import com.bot.impl.Hooks;
import com.bot.impl.Item;
import com.bot.impl.ItemDefAna;
import com.bot.impl.NPCAna;
import com.bot.impl.NodeAna;
import com.bot.impl.NodeListAna;
import com.bot.impl.ObjectAna;
import com.bot.impl.PhysicalObjectAna;
import com.bot.impl.PhysicalObjectAnalyser1;
import com.bot.impl.PhysicalObjectAnalyser2;
import com.bot.impl.PhysicalObjectAnalyser3;
import com.bot.impl.PhysicalObjectAnalyser4;
import com.bot.impl.PlayerAna;
import com.bot.impl.RS2Applet;
import com.bot.impl.RSinterfaceAna;
import com.bot.impl.WorldControllerAna;

import com.bot.utils.JarUtils;

public class Updater  {

	public static HashMap<String, ClassNode> CLASSES = new HashMap<>();
	private ArrayList<AbstractAnalyser> analysers = new ArrayList<AbstractAnalyser>();
	public static int fieldsHooked = 0;

	public Updater()  throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, InterruptedException {
		System.out.println("Updater");
		CLASSES = JarUtils.parseJar(new JarFile(""));
		System.out.println("UpdaterLog: " + CLASSES.values().size() + " Classes parsed\n");	
		this.loadAnaylsers();
		this.runAnaysers();
		DatCreator.WriteToFile();
		System.out.println("Fields Hooked: "  + fieldsHooked);

	}


	private void loadAnaylsers() {
		this.analysers.add(new WorldControllerAna());
		this.analysers.add(new ObjectAna());
		this.analysers.add(new EntityAna());
		this.analysers.add(new EntityDef());
		this.analysers.add(new NPCAna());
		this.analysers.add(new Item());
		this.analysers.add(new PlayerAna());
		this.analysers.add(new ItemDefAna());
		this.analysers.add(new RSinterfaceAna());
		this.analysers.add(new RS2Applet());
		this.analysers.add(new ClientAna());
		this.analysers.add(new NodeListAna());
		this.analysers.add(new GroundAna());
		this.analysers.add(new PhysicalObjectAna());
		this.analysers.add(new NodeAna());
		this.analysers.add(new PhysicalObjectAnalyser1());
		this.analysers.add(new PhysicalObjectAnalyser2());
		this.analysers.add(new PhysicalObjectAnalyser3());
		this.analysers.add(new PhysicalObjectAnalyser4());

	}




	private void runAnaysers() {
		final Hooks hooks = Hooks.getHooks();
		for(ClassNode node : CLASSES.values()) {
			for(AbstractAnalyser analyser : this.analysers) {
				analyser.run(node, hooks);

			}
		} 
	}



	public void print(String t) {
		System.out.println(t);
	}
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, InterruptedException {
		new Updater();
	}



}
