package test;

import java.io.File;
import java.io.IOException;

import com.jme3.animation.LoopMode;
import com.jme3.app.SimpleApplication;
import com.jme3.export.binary.BinaryExporter;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.material.RenderState;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.scene.shape.Sphere;

import emitter.Emitter;
import emitter.Emitter.BillboardMode;
import emitter.EmitterMesh.DirectionType;
import emitter.Interpolation;
import emitter.influencers.AlphaInfluencer;
import emitter.influencers.ColorInfluencer;
import emitter.influencers.GravityInfluencer;
import emitter.influencers.RotationInfluencer;
import emitter.influencers.SizeInfluencer;
import emitter.influencers.SpriteInfluencer;

/**
 * test
 * @author normenhansen
 */
public class SaveTest extends SimpleApplication {
	
    public static void main(String[] args) {
        SaveTest app = new SaveTest();
        app.start();
    }

    @Override
    public void simpleInitApp() {
		viewPort.setBackgroundColor(ColorRGBA.Black);
		
		flyCam.setDragToRotate(true);
		flyCam.setMoveSpeed(15f);
		inputManager.setCursorVisible(true);
		
        AmbientLight al = new AmbientLight();
		al.setColor(new ColorRGBA(1f, 1f, 1f, 1f));
		rootNode.addLight(al);
		
		DirectionalLight sun = new DirectionalLight();
		sun.setDirection(new Vector3f(-.5f,-.5f,-.5f).normalizeLocal());
		sun.setColor(new ColorRGBA(1f,1f,1f,1f));
		rootNode.addLight(sun);

		
		Emitter e1 = new Emitter();
		e1.setName("e1");
		e1.addInfluencers(
			new ColorInfluencer(),
			new AlphaInfluencer(),
			new SizeInfluencer(),
			new SpriteInfluencer(),
			new RotationInfluencer(),
			new GravityInfluencer()
		);
		e1.setMaxParticles(15);
		
		e1.setShapeSimpleEmitter();
	//	
		Sphere e1ES = new Sphere(16, 16, 0.5f);
		e1.setShape(e1ES);
	//	e1.setShape(emitterNode, false);
	//	e1.setParticleType(ParticleDataTemplateMesh.class, particleNode);
		
		e1.setDirectionType(DirectionType.Normal);
		e1.setEmissionsPerSecond(15);
		e1.setParticlesPerEmission(1);
		e1.setBillboardMode(BillboardMode.Camera);
		e1.setForceMinMax(2.25f,5.0f);
		e1.setLifeMinMax(0.999f,0.999f);
	//	e1.setParticlesFollowEmitter(true);
		e1.setUseSequentialEmissionFace(true);
		e1.setUseSequentialSkipPattern(true);
		
		e1.setSprite("Textures/Character-HMN-FEM.png", 1, 1);
		
		// Lighting test
		Material mat = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
		mat.setBoolean("UseVertexColor", true);
		mat.getAdditionalRenderState().setFaceCullMode(RenderState.FaceCullMode.Off);
		mat.getAdditionalRenderState().setBlendMode(RenderState.BlendMode.Alpha);
		mat.setFloat("AlphaDiscardThreshold", 0.15f);
		e1.setMaterial(mat, "DiffuseMap", true);
		
		e1.setEmitterTestMode(true, false);
	//	e1.setUseSequentialEmissionFace(true);
	//	e1.setUseSequentialSkipPattern(true);
		
		// Color Influencer
		e1.getInfluencer(ColorInfluencer.class).addColor(new ColorRGBA(1.0f,1.0f,1.0f,1.0f));
		e1.getInfluencer(ColorInfluencer.class).addColor(new ColorRGBA(1.0f,1.0f,1.0f,0.0f));

		// Alpha Influencer
		e1.getInfluencer(AlphaInfluencer.class).addAlpha(1.0f, Interpolation.exp5In);
		e1.getInfluencer(AlphaInfluencer.class).addAlpha(0.0f);
		
		// Size Influencer
		e1.getInfluencer(SizeInfluencer.class).addSize(new Vector3f(0.5f,0.5f,0.5f));
		e1.getInfluencer(SizeInfluencer.class).addSize(new Vector3f(0.1f,0.1f,0.1f));
		
		// Sprite Influencer
		// Rotation Influencer
		e1.getInfluencer(RotationInfluencer.class).addRotationSpeed(new Vector3f(0.0f,0.0f,0.0f));
		e1.getInfluencer(RotationInfluencer.class).setUseRandomStartRotation(false,false,false);
		e1.getInfluencer(RotationInfluencer.class).setUseRandomDirection(true);
		e1.getInfluencer(RotationInfluencer.class).setUseRandomSpeed(true);
		
		// RadialVelocity Influencer
	//	e1.getInfluencer(RadialVelocityInfluencer.class).setTangentForce(4.0f);
	//	e1.getInfluencer(RadialVelocityInfluencer.class).setRadialPull(3.0f);
	//	e1.getInfluencer(RadialVelocityInfluencer.class).setRadialPullAlignment(RadialPullAlignment.Emitter_Center);
	//	e1.getInfluencer(RadialVelocityInfluencer.class).setUseRandomDirection(true);

		// Gravity Influencer
		e1.getInfluencer(GravityInfluencer.class).setGravity(new Vector3f(0.0f,4.0f,0.0f));

		// Set transforms and add to scene
		e1.setLocalTranslation(0.0f, 0.0f, 0.0f);
		e1.setLocalScale(1.0f, 1.0f, 1.0f);
		e1.setLocalRotation(new Quaternion().fromAngles(0.0f,0.0f,0.0f));
		
		e1.initialize(assetManager);
		rootNode.addControl(e1);
		e1.setEnabled(true);
		
		e1.setEmitterAnimation("run", 1, 1, LoopMode.Loop);
		e1.setParticleAnimation("kick", 1, 1, LoopMode.Loop);
		
		String userHome = System.getProperty("user.home");
		BinaryExporter exporter = BinaryExporter.getInstance();
		File file = new File(userHome+"/Models/"+"FX1.j3o");
		System.out.println(userHome+"/Models/"+"FX1.j3o");
		try {
			exporter.save(e1, file);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
