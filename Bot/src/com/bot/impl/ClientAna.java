package com.bot.impl;

import java.lang.reflect.Method;
import java.util.ListIterator;

import javax.xml.crypto.Data;

import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;

import com.bot.DatCreator;
import com.bot.Updater;
import com.bot.generic.AbstractAnalyser;
import com.bot.utils.JarUtils;

public class ClientAna extends AbstractAnalyser {

	@Override
	protected boolean canRun(ClassNode node, Hooks hooks) {
		return node.name.equals("client");
	}

	@Override
	protected void analyse(ClassNode node, Hooks hooks) {
		System.out.println("Found Class: " + node.name);

	}

	@Override
	protected void AddHooks(ClassNode node, Hooks hooks) {
		JarUtils.injectInterface(node, "com/bot/accessors/Client"); 
		DatCreator.AddScring("injectinter com/bot/accessors/Client " + node.name );
		ListIterator<FieldNode> fnIt = node.fields.listIterator();
		while (fnIt.hasNext()) {
			FieldNode field = fnIt.next();



			if(field.name.equals("loggedIn") && field.desc.equals("Z")) {
				DatCreator.AddScring("get " + node.name + " " + field.name + " isloggedIn " + field.desc);
			}

			if(field.name.equals("intGroundArray") && field.desc.equals("[[[I")) {
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getintGroundArray " + field.desc);
			}
			if(field.name.equals("xCameraPos") && field.desc.equals("I")) {
				JarUtils.addGetterNonStatic(node, field, "getCameraX", "I");
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getCameraX " + field.desc);
			}

			if(field.name.equals("yCameraPos") && field.desc.equals("I")) {
				JarUtils.addGetterNonStatic(node, field, "getCameraY", "I");
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getCameraY " + field.desc);
			}

			if(field.name.equals("zCameraPos") && field.desc.equals("I")) {
				JarUtils.addGetterNonStatic(node, field, "getCameraZ", "I");
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getCameraZ " + field.desc);
			}

			if(field.name.equals("yCameraCurve") && field.desc.equals("I")) {
				JarUtils.addGetterNonStatic(node, field, "getyCameraCurve", "I");
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getyCameraCurve "  + field.desc);
			}
			if(field.name.equals("xCameraCurve") && field.desc.equals("I")) {
				JarUtils.addGetterNonStatic(node, field, "getxCameraCurve", "I");
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getxCameraCurve " + field.desc);
			}

			if(field.name.equals("byteGroundArray") && field.desc.equals("[[[B")) {
				JarUtils.addGetterNonStatic(node, field, "getbyteGroundArray", "[[[B");
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getbyteGroundArray [[[B");
			}

			if(field.name.equals("zoom") && field.desc.equals("I")) {
				JarUtils.addGetterNonStatic(node, field, "getCameraZoom", "I");
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getCameraZoom " + field.desc);
			}


			if(field.name.equals("plane") && field.desc.equals("I")) {
				JarUtils.addGetterNonStatic(node, field, "getPlane", "I");
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getPlane " + field.desc);
			}

			if(field.name.equals("npcArray") && field.desc.equals("[LNPC;")) {
				JarUtils.addGetterNonStatic(node, field, "getNPCArray", "[Lcom/bot/accessors/NPC;");
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getNPCArray [Lcom/bot/accessors/NPC;");
			}

			if(field.name.equals("playerArray") && field.desc.equals("[LPlayer;")) {
				JarUtils.addGetterNonStatic(node, field, "getPlayerArray", "[Lcom/bot/accessors/PlayerAccessor;");
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getPlayerArray [Lcom/bot/accessors/PlayerAccessor;");
			}


			if(field.name.equals("myPlayer")) {
				JarUtils.addGetterMethod(node, field, "getLocalPlayer", "Lcom/bot/accessors/PlayerAccessor;");
				DatCreator.AddScring("get " + node.name + " " + field.name + " getLocalPlayer Lcom/bot/accessors/PlayerAccessor;");
			}

			if(field.name.equals("itemSelected")) {
				JarUtils.addGetterNonStatic(node, field, "getitemSelected", field.desc);
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getitemSelected " + field.desc);
			}

			if(field.name.equals("selectedItemName")) {
				JarUtils.addGetterNonStatic(node, field, "getselectedItemName", field.desc);
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getselectedItemName " + field.desc);
			}


			if(field.name.equals("npcIndices")) {
				JarUtils.addGetterNonStatic(node, field, "getnpcIndices", field.desc);
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getnpcIndices " + field.desc);
			}

			if(field.name.equals("playerIndices")) {
				JarUtils.addGetterNonStatic(node, field, "getplayerIndices", field.desc);
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getplayerIndices " + field.desc);

			}

			if(field.name.equals("groundArray")) {
				JarUtils.addGetterNonStatic(node, field, "getObjects", "[[[Lcom/bot/accessors/NodeList;");
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getObjects " + "[[[Lcom/bot/accessors/NodeList;");
			}

			if(field.name.equals("baseX")) {
				JarUtils.addGetterNonStatic(node, field, "getBaseX", field.desc);
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getBaseX "  + field.desc);
			}

			if(field.name.equals("baseY")) {
				JarUtils.addGetterNonStatic(node, field, "getBaseY", field.desc);
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getBaseY " + field.desc);
			}

			if(field.name.equals("worldController")) {
				JarUtils.addGetterNonStatic(node, field, "getWorldController", "Lcom/bot/accessors/WorldController;");
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getplayerIndices Lcom/bot/accessors/WorldController;");
			}

			if(field.name.equals("openInterfaceID")) {
				JarUtils.addGetterMethod(node, field, "getopenInterfaceID", field.desc);
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getopenInterfaceID " + field.desc);
			}


			if(field.name.equals("menuScreenArea")) {
				JarUtils.addGetterNonStatic(node, field, "getMenuScreenArea", field.desc);
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getMenuScreenArea " + field.desc);
			}

			if(field.name.equals("menuOffsetX")) {
				JarUtils.addGetterNonStatic(node, field, "getMenuOffsetX", field.desc);
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getMenuOffsetX " + field.desc);
			}

			if(field.name.equals("menuOffsetY")) {
				JarUtils.addGetterNonStatic(node, field, "getMenuOffsetY", field.desc);
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getMenuOffsetY " + field.desc);
			}


			if(field.name.equals("menuWidth")) {
				JarUtils.addGetterNonStatic(node, field, "getMenuWidth", field.desc);
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getMenuWidth " + field.desc);
			}

			if(field.name.equals("menuHeight")) {
				JarUtils.addGetterNonStatic(node, field, "getMenuHeight", field.desc);
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getMenuHeight " + field.desc);
			}

			if(field.name.equals("menuActionCmd1")) {
				JarUtils.addGetterNonStatic(node, field, "menuAction1", field.desc);
				DatCreator.AddScring("getn " + node.name + " " + field.name + " menuAction1 " + field.desc);
			}
			if(field.name.equals("menuActionCmd2")) {
				JarUtils.addGetterNonStatic(node, field, "menuAction2", field.desc);					
				DatCreator.AddScring("getn " + node.name + " " + field.name + " menuAction2 " + field.desc);
			}
			if(field.name.equals("menuActionCmd3")) {
				JarUtils.addGetterNonStatic(node, field, "menuAction3", field.desc);
				DatCreator.AddScring("getn " + node.name + " " + field.name + " menuAction3 " + field.desc);
			}
			if(field.name.equals("menuActionID")) {
				JarUtils.addGetterNonStatic(node, field, "menuActionId", field.desc);
				DatCreator.AddScring("getn " + node.name + " " + field.name + " menuActionId " + field.desc);
			}

			if(field.name.equals("menuActionRow")) {
				JarUtils.addGetterNonStatic(node, field, "getMenuActionRow", field.desc);
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getMenuActionRow " + field.desc);
			}
			if(field.name.equals("menuActionName")) {
				JarUtils.addGetterNonStatic(node, field, "getMenuActionNames", field.desc);
				DatCreator.AddScring("getn " + node.name + " " + field.name + " getMenuActionNames " + field.desc);
			}
			if(field.name.equals("menuOpen")) {
				JarUtils.addGetterNonStatic(node, field, "isMenuOpen", field.desc);
				DatCreator.AddScring("getn " + node.name + " " + field.name + " isMenuOpen " + field.desc);
			}



		}	
		//	JarUtils.addStaticFieldAccessor(node, "ItemDef", "[Lcom/bot/accessors/ItemDef;", "LItemDef;", "cache", "getItems");
		JarUtils.addStaticFieldAccessor(node, "RSInterface", "[Lcom/bot/accessors/RSInterface;", "[LRSInterface;", "interfaceCache", "getInterfaceCache");	
		DatCreator.AddScring("get " + node.name + " RSInterface " + " interfaceCache " + " [LRSInterface; " + " getInterfaceCache " + " [Lcom/bot/accessors/RSInterface; ");


		JarUtils.addStaticFieldAccessor(node, "ObjectDef", "[Lcom/bot/accessors/RSObjectDef;", "[LObjectDef;", "cache", "getCache");		
		DatCreator.AddScring("get " + node.name + " ObjectDef " + " cache " + " [LObjectDef; " + " getCache " + " [[Lcom/bot/accessors/RSObjectDef; ");



		JarUtils.addStaticFieldAccessor(node, "ItemDef", "[Lcom/bot/accessors/RSItemDef;", "[LItemDef;", "cache", "getItemCache");		
		DatCreator.AddScring("get " + node.name + " ItemDef " + " cache " + " [LItemDef; " + " getItemCache " + " [Lcom/bot/accessors/RSItemDef; ");



		JarUtils.addMethodGetter(node, Updater.CLASSES.get("ObjectDef"), "forID", "getObjectCache", "Lcom/bot/accessors/RSObjectDef;", "(I)");
		DatCreator.AddScring("getMethod " + node.name + " ObjectDef " + " forID " + " getObjectCache " + " Lcom/bot/accessors/RSObjectDef; (I) ");

		//	JarUtils.addStaticFieldAccessor(node, "ObjectDef", "[Lcom/bot/accessors/RSObjectDef", "(I) Lcom/bot/accessors/RSObjectDef;", "forID", "getObjectDefCache");
	}

}
