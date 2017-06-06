package test;

import com.jme3.app.SimpleApplication;
import com.jme3.asset.plugins.FileLocator;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;

import emitter.Emitter;
import tonegod.gui.core.Screen;

/**
 * test
 * @author normenhansen
 */
public class LoadTest extends SimpleApplication {
	
	private Screen screen;
	
    public static void main(String[] args) {
        LoadTest app = new LoadTest();
        app.start();
    }

    @Override
    public void simpleInitApp() {
		viewPort.setBackgroundColor(ColorRGBA.Black);
		
		flyCam.setDragToRotate(true);
		flyCam.setMoveSpeed(15f);
		inputManager.setCursorVisible(true);
		
		screen = new Screen(this, "tonegod/gui/style/atlasdef/style_map.gui.xml");
		screen.setUseTextureAtlas(true, "tonegod/gui/style/atlasdef/atlas.png");
		guiNode.addControl(screen);
		
        AmbientLight al = new AmbientLight();
		al.setColor(new ColorRGBA(1f, 1f, 1f, 1f));
		rootNode.addLight(al);
		
		DirectionalLight sun = new DirectionalLight();
		sun.setDirection(new Vector3f(-.5f,-.5f,-.5f).normalizeLocal());
		sun.setColor(new ColorRGBA(1f,1f,1f,1f));
		rootNode.addLight(sun);
		
		String userHome = System.getProperty("user.home");
		assetManager.registerLocator(userHome, FileLocator.class);
		Emitter e1 = (Emitter)assetManager.loadAsset("Models/FX1.j3o");
		e1.initialize(assetManager);
		
		rootNode.addControl(e1);
		
		System.out.println(e1.getShape().getMesh().getClass().getSimpleName());
	}
	
}
