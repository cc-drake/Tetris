package de.drake.tetris.input;

import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JComponent;

import de.drake.tetris.input.util.JInputLoader;
import de.drake.tetris.input.util.Key;
import de.drake.tetris.input.util.KeyListener;
import net.java.games.input.Controller;
import net.java.games.input.Controller.Type;
import net.java.games.input.ControllerEnvironment;

public abstract class InputDevice implements FocusListener {
	
	public final static ArrayList<Gamepad> gamepads = new ArrayList<Gamepad>();
	
	public final static Mouse mouse = new Mouse();
	
	public final static Keyboard keyboard = new Keyboard();
	
	public final static ArrayList<InputDevice> allInputdevices = new ArrayList<InputDevice>();
	
	public final static int MOUSE = 1;
	
	public final static int KEYBOARD = 2;
	
	public final static int GAMEPAD = 3;
	
	public InputDevice(final int type) {
		this.type = type;
	}
	
	private final int type;
	
	private final Set<KeyListener> listeners = Collections.synchronizedSet(new HashSet<KeyListener>());
	
	public final void addKeyListener(final KeyListener listener) {
		this.listeners.add(listener);
	}
	
	protected final void keyPressed(final Key key) {
		HashSet<KeyListener> currentListener;
		synchronized (this.listeners) {
			currentListener = new HashSet<KeyListener>(this.listeners);
		}
		for (KeyListener listener : currentListener) {
			listener.keyPressed(key);
		}
	}
	
	protected final void keyReleased(final Key key) {
		HashSet<KeyListener> currentListener;
		synchronized (this.listeners) {
			currentListener = new HashSet<KeyListener>(this.listeners);
		}
		for (KeyListener listener : currentListener) {
			listener.keyReleased(key);
		}
	}
	
	public static void registerInputDevices(final JComponent component) {
		component.addMouseListener(InputDevice.mouse);
		component.addMouseWheelListener(InputDevice.mouse);
		component.addKeyListener(InputDevice.keyboard);
		component.addFocusListener(InputDevice.keyboard);
		component.addFocusListener(InputDevice.mouse);
		for (InputDevice gamepad : InputDevice.gamepads) {
			component.addFocusListener(gamepad);
		}
	}
	
	public static void init() throws Exception {
		InputDevice.allInputdevices.add(InputDevice.keyboard);
		InputDevice.allInputdevices.add(InputDevice.mouse);
		
		JInputLoader.load();
		int lfdNr = 0;
		for (Controller controller : ControllerEnvironment.getDefaultEnvironment().getControllers()) {
			if (controller.getType().equals(Type.GAMEPAD) || controller.getType().equals(Type.STICK)) {
				Gamepad gamepad = new Gamepad(controller, lfdNr);
				InputDevice.gamepads.add(gamepad);
				InputDevice.allInputdevices.add(gamepad);
				lfdNr++;
			}
		}
	}
	
	public static void removeInputManagers() {
		InputDevice mouse = InputDevice.mouse;
		mouse.listeners.clear();
		
		InputDevice keyboard = InputDevice.keyboard;
		keyboard.listeners.clear();
		
		for (InputDevice gamepad : InputDevice.gamepads) {
			gamepad.listeners.clear();
		}
	}
	
	public abstract String toString();

	public final int getType() {
		return this.type;
	}
	
}