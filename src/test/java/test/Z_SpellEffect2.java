package test;

import com.jme3.app.SimpleApplication;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Mesh;
import com.jme3.scene.Node;

import emitter.Emitter;
import emitter.EmitterMesh.DirectionType;
import emitter.Interpolation;
import emitter.influencers.AlphaInfluencer;
import emitter.influencers.ColorInfluencer;
import emitter.influencers.GravityInfluencer;
import emitter.influencers.GravityInfluencer.GravityAlignment;
import emitter.influencers.RotationInfluencer;
import emitter.influencers.SizeInfluencer;
import emitter.influencers.SpriteInfluencer;

/**
 * test
 * @author normenhansen
 */
public class Z_SpellEffect2 extends SimpleApplication {
	
	public static void main(String[] args) {
		Z_SpellEffect2 app = new Z_SpellEffect2();
		app.start();
	}

	@Override
	public void simpleInitApp() {
		
		flyCam.setMoveSpeed(10);
		
		/*
		effectring = new Emitter("effectringpe", assetManager, 100,
			new GravityInfluencer(),
			new ColorInfluencer(),
			new AlphaInfluencer(),
			new SizeInfluencer(),
			new VelocityInfluencer()
		);
		effectring.setShapeSimpleEmitter();
		effectring.setDirectionType(DirectionType.RandomNormalAligned);
		effectring.initParticles(ParticleDataTriMesh.class, null);
		effectring.setEmitterTestMode(false, false);
		effectring.setSprite("Textures/fire_4x.png", 100,100);
		effectring.setEmissionsPerSecond(90);
		effectring.setParticlesPerEmission(1);
		effectring.setForceMinMax(1.35f,2.35f);
		effectring.setLifeMinMax(1f,1f);
		effectring.setBillboardMode(Emitter.BillboardMode.Velocity_Z_Up_Y_Left);
		effectring.setUseRandomEmissionPoint(true);
		effectring.setUseVelocityStretching(true);
		
		effectring.getInfluencer(GravityInfluencer.class).setGravity(0,-43,0);
		effectring.getInfluencer(GravityInfluencer.class).setAlignment(GravityAlignment.World);
		effectring.getInfluencer(GravityInfluencer.class).setUseNegativeVelocity(true);
		effectring.getInfluencer(GravityInfluencer.class).setMagnitude(19);
		effectring.getInfluencer(GravityInfluencer.class).setEnabled(true);
		
		effectring.getInfluencer(VelocityInfluencer.class).setUseRadialVelocity(true);
		effectring.getInfluencer(VelocityInfluencer.class).setTangentForce(24);
		
		effectring.getInfluencer(ColorInfluencer.class).addColor(new ColorRGBA(1f,1f,1,1f));
		effectring.getInfluencer(ColorInfluencer.class).addColor(new ColorRGBA(0f,0f,1,0.25f));
		effectring.getInfluencer(ColorInfluencer.class).setEnabled(true);
		
		effectring.getInfluencer(AlphaInfluencer.class).addAlpha(1f);
		effectring.getInfluencer(AlphaInfluencer.class).setEnabled(false);
		
		effectring.getInfluencer(SizeInfluencer.class).addSize(new Vector3f(.3f,.3f,.3f));
		effectring.getInfluencer(SizeInfluencer.class).addSize(new Vector3f(.05f,.05f,.05f));
		effectring.getInfluencer(SizeInfluencer.class).setEnabled(false);
		
		effectring.setLocalScale(0.5f);
		
		rootNode.addControl(effectring);
		effectring.setEnabled(true);
		
		effectring.setLocalRotation(effectring.getLocalRotation().fromAngleAxis(90*FastMath.DEG_TO_RAD, Vector3f.UNIT_X));
		*/
		
		Emitter effectring2 = new Emitter();
		effectring2.setName("effectring2");
		effectring2.setMaxParticles(6);
		effectring2.addInfluencers(
			new GravityInfluencer(),
			new ColorInfluencer(),
			new AlphaInfluencer(),
			new SizeInfluencer(),
			new RotationInfluencer()
		);
		effectring2.setShapeSimpleEmitter();
	//	effectring2.setDirectionType(DirectionType.Normal);
	//	effectring2.initParticles(ParticleDataTriMesh.class, null);
		effectring2.setEmitterTestMode(false, false);
		effectring2.setSprite("Textures/halo.png");
		effectring2.setEmissionsPerSecond(2);
		effectring2.setParticlesPerEmission(1);
		effectring2.setForce(0.01f);
		effectring2.setLifeMinMax(1.25f,1.75f);
		effectring2.setBillboardMode(Emitter.BillboardMode.UNIT_Y);
		effectring2.setUseRandomEmissionPoint(false);
		effectring2.setUseVelocityStretching(false);
		
		effectring2.getInfluencer(GravityInfluencer.class).setGravity(new Vector3f(0f,0f,0f));
		
		effectring2.getInfluencer(ColorInfluencer.class).addColor(new ColorRGBA(0f,0f,1f,1f));
		effectring2.getInfluencer(ColorInfluencer.class).addColor(new ColorRGBA(0.75f,0.75f,1f,1f));
		effectring2.getInfluencer(ColorInfluencer.class).setEnabled(true);
		
		effectring2.getInfluencer(AlphaInfluencer.class).addAlpha(0, Interpolation.exp5In);
		effectring2.getInfluencer(AlphaInfluencer.class).addAlpha(1, Interpolation.exp5Out);
		effectring2.getInfluencer(AlphaInfluencer.class).addAlpha(0, Interpolation.exp5In);
		
		effectring2.getInfluencer(SizeInfluencer.class).addSize(new Vector3f(.05f,.05f,.05f));
		effectring2.getInfluencer(SizeInfluencer.class).addSize(new Vector3f(2f,2f,.5f));
		effectring2.getInfluencer(SizeInfluencer.class).setEnabled(true);
		
		
		effectring2.getInfluencer(RotationInfluencer.class).setUseRandomStartRotation(false, false, true);
		effectring2.getInfluencer(RotationInfluencer.class).addRotationSpeed(new Vector3f(0, 0, 0.25f));
		effectring2.getInfluencer(RotationInfluencer.class).setUseRandomDirection(true);
		effectring2.setLocalScale(0.5f);
		
		effectring2.setLocalTranslation(0, 0.01f, 0);
		effectring2.initialize(assetManager);
		rootNode.addControl(effectring2);
		effectring2.setEnabled(true);
		
		Emitter e2 = new Emitter();
		e2.setName("e2");
		e2.setMaxParticles(40);
		e2.addInfluencers(
			new GravityInfluencer(),
			new ColorInfluencer(),
			new AlphaInfluencer(),
			new SizeInfluencer()
		);
		e2.setShapeSimpleEmitter();
		e2.setDirectionType(DirectionType.RandomTangent);
	//	e2.initParticles(ParticleDataTriMesh.class, null);
		e2.setEmitterTestMode(false, false);
		e2.setSprite("Textures/smokes.png", 2, 2);
		e2.setEmissionsPerSecond(35);
		e2.setParticlesPerEmission(1);
		e2.setForce(.25f);
		e2.setLifeMinMax(.5f,1.3f);
		e2.setBillboardMode(Emitter.BillboardMode.Velocity_Z_Up_Y_Left);
		e2.setUseRandomEmissionPoint(false);
		e2.setUseVelocityStretching(false);
		
		e2.getInfluencer(GravityInfluencer.class).setGravity(new Vector3f(0f,0f,0f));
		
		e2.getInfluencer(ColorInfluencer.class).addColor(new ColorRGBA(0.25f,0.25f,1f,1f));
		e2.getInfluencer(ColorInfluencer.class).addColor(new ColorRGBA(0.75f,0.75f,1f,1f));
		e2.getInfluencer(ColorInfluencer.class).setEnabled(true);
		
		e2.getInfluencer(AlphaInfluencer.class).addAlpha(0, Interpolation.exp5In);
		e2.getInfluencer(AlphaInfluencer.class).addAlpha(0.1f, Interpolation.exp5In);
		e2.getInfluencer(AlphaInfluencer.class).addAlpha(0, Interpolation.exp5In);
		
		e2.getInfluencer(SizeInfluencer.class).addSize(new Vector3f(.05f,.05f,.05f));
		e2.getInfluencer(SizeInfluencer.class).addSize(new Vector3f(2f,2f,.5f));
		e2.getInfluencer(SizeInfluencer.class).setEnabled(true);
		
		e2.initialize(assetManager);
		rootNode.addControl(e2);
		e2.setEnabled(true);
		
		
		Emitter e3 = new Emitter();
		e3.setName("e3");
		e3.setMaxParticles(70);
		e3.addInfluencers(
			new GravityInfluencer(),
			new ColorInfluencer(),
			new AlphaInfluencer(),
			new SizeInfluencer()
		);
		e3.setShapeSimpleEmitter();
		e3.setDirectionType(DirectionType.RandomTangent);
	//	e3.initParticles(ParticleDataTriMesh.class, null);
		e3.setEmitterTestMode(false, false);
		e3.setSprite("Textures/glow.png");
		e3.setEmissionsPerSecond(60);
		e3.setParticlesPerEmission(1);
		e3.setForce(1.25f);
		e3.setLifeMinMax(1.15f,1.15f);
		e3.setBillboardMode(Emitter.BillboardMode.Velocity_Z_Up_Y_Left);
		e3.setUseRandomEmissionPoint(false);
		e3.setUseVelocityStretching(false);
		e3.setVelocityStretchFactor(3.65f);
		
		e3.getInfluencer(GravityInfluencer.class).setGravity(new Vector3f(0f,0f,0f));
		e3.getInfluencer(GravityInfluencer.class).setAlignment(GravityAlignment.Emission_Point);
		e3.getInfluencer(GravityInfluencer.class).setMagnitude(1.5f);
		
		e3.getInfluencer(ColorInfluencer.class).addColor(new ColorRGBA(0.75f,0.75f,1f,1f));
		e3.getInfluencer(ColorInfluencer.class).addColor(new ColorRGBA(0.75f,0.75f,1f,1f));
		e3.getInfluencer(ColorInfluencer.class).setEnabled(true);
		
		e3.getInfluencer(AlphaInfluencer.class).addAlpha(0f, Interpolation.exp5Out);
		e3.getInfluencer(AlphaInfluencer.class).addAlpha(0.35f, Interpolation.linear);
		e3.getInfluencer(AlphaInfluencer.class).addAlpha(0f, Interpolation.exp5In);
	//	e3.getInfluencer(AlphaInfluencer.class).addAlpha(.2f, Interpolation.exp5In);
		
		e3.getInfluencer(SizeInfluencer.class).addSize(new Vector3f(.015f,.015f,.015f));
		e3.getInfluencer(SizeInfluencer.class).addSize(new Vector3f(.015f,.015f,.015f));
		e3.getInfluencer(SizeInfluencer.class).setEnabled(true);
		
		e3.initialize(assetManager);
		rootNode.addControl(e3);
		e3.setEnabled(true);
		
		
		Node circle = (Node)assetManager.loadModel("Models/Circle.j3o");
		Mesh circleMesh = ((Geometry)circle.getChild(0)).getMesh();
		
		// Water spout
		Emitter e4 = new Emitter();
		e4.setName("e4");
		e4.setMaxParticles(110);
		e4.addInfluencers(
			new GravityInfluencer(),
			new ColorInfluencer(),
			new AlphaInfluencer(),
			new SizeInfluencer(),
			new SpriteInfluencer(),
			new RotationInfluencer()
		);
		e4.setShape(circleMesh);
		e4.setDirectionType(DirectionType.Normal);
	//	e4.initParticles(ParticleDataTriMesh.class, null);
		e4.setEmitterTestMode(false, false);
		e4.setSprite("Textures/smokes.png", 2, 2);
		e4.setEmissionsPerSecond(100);
		e4.setParticlesPerEmission(1);
		e4.setForceMinMax(2.25f, 3.75f);
		e4.setLifeMinMax(1.15f,1.15f);
		e4.setBillboardMode(Emitter.BillboardMode.Velocity_Z_Up);
		e4.setUseRandomEmissionPoint(false);
		e4.setUseVelocityStretching(true);
		e4.setVelocityStretchFactor(3.65f);
		
		e4.getInfluencer(GravityInfluencer.class).setGravity(new Vector3f(0f,0f,0f));
		e4.getInfluencer(GravityInfluencer.class).setAlignment(GravityAlignment.Emission_Point);
		e4.getInfluencer(GravityInfluencer.class).setMagnitude(1.5f);
		
		e4.getInfluencer(ColorInfluencer.class).addColor(new ColorRGBA(0.75f,0.75f,1f,1f));
		e4.getInfluencer(ColorInfluencer.class).addColor(new ColorRGBA(0.45f,0.45f,1f,1f));
		e4.getInfluencer(ColorInfluencer.class).setEnabled(true);
		
		e4.getInfluencer(AlphaInfluencer.class).addAlpha(0f, Interpolation.exp5Out);
		e4.getInfluencer(AlphaInfluencer.class).addAlpha(0.35f, Interpolation.linear);
		e4.getInfluencer(AlphaInfluencer.class).addAlpha(0f, Interpolation.exp5In);
	//	e4.getInfluencer(AlphaInfluencer.class).addAlpha(.2f, Interpolation.exp5In);
		
		e4.getInfluencer(SizeInfluencer.class).addSize(new Vector3f(.05f,.05f,.05f));
		e4.getInfluencer(SizeInfluencer.class).addSize(new Vector3f(.05f,.05f,.05f));
		e4.getInfluencer(SizeInfluencer.class).setEnabled(true);
		
		e4.getInfluencer(SpriteInfluencer.class).setUseRandomStartImage(true);
		e4.getInfluencer(SpriteInfluencer.class).setAnimate(false);
		
		e4.getInfluencer(RotationInfluencer.class).setUseRandomStartRotation(false, false, true);
		
		e4.setLocalScale(0.015f);
		
		e4.initialize(assetManager);
		rootNode.addControl(e4);
		e4.setEnabled(true);
		
		Node hemi = (Node)assetManager.loadModel("Models/SphereEmitter.j3o");
		Mesh hemiMesh = ((Geometry)hemi.getChild(0)).getMesh();
		
		Emitter e5 = new Emitter();
		e5.setName("e5");
		e5.setMaxParticles(110);
		e5.addInfluencers(
			new GravityInfluencer(),
			new ColorInfluencer(),
			new AlphaInfluencer(),
			new SizeInfluencer(),
			new SpriteInfluencer()
		);
		e5.setShape(hemiMesh);
		e5.setDirectionType(DirectionType.Normal);
	//	e5.initParticles(ParticleDataTriMesh.class, null);
		e5.setEmitterTestMode(false, false);
		e5.setSprite("Textures/smokes.png", 2, 2);
		e5.setEmissionsPerSecond(100);
		e5.setParticlesPerEmission(1);
		e5.setForceMinMax(0.55f, 1.25f);
		e5.setLifeMinMax(.5f,.5f);
		e5.setBillboardMode(Emitter.BillboardMode.Velocity_Z_Up);
		e5.setUseRandomEmissionPoint(true);
		e5.setUseVelocityStretching(true);
		e5.setVelocityStretchFactor(1.65f);
		
		e5.getInfluencer(GravityInfluencer.class).setGravity(new Vector3f(0f,2f,0f));
		e5.getInfluencer(GravityInfluencer.class).setAlignment(GravityAlignment.World);
		e5.getInfluencer(GravityInfluencer.class).setMagnitude(1.5f);
		
		e5.getInfluencer(ColorInfluencer.class).addColor(new ColorRGBA(0.75f,0.75f,1f,1f));
		e5.getInfluencer(ColorInfluencer.class).addColor(new ColorRGBA(0.45f,0.45f,1f,1f));
		e5.getInfluencer(ColorInfluencer.class).setEnabled(true);
		
		e5.getInfluencer(AlphaInfluencer.class).addAlpha(0.05f, Interpolation.exp5Out);
		e5.getInfluencer(AlphaInfluencer.class).addAlpha(0.35f, Interpolation.linear);
		e5.getInfluencer(AlphaInfluencer.class).addAlpha(0.1f, Interpolation.exp5In);
	//	e4.getInfluencer(AlphaInfluencer.class).addAlpha(.2f, Interpolation.exp5In);
		
		e5.getInfluencer(SizeInfluencer.class).addSize(new Vector3f(.075f,.075f,.075f));
		e5.getInfluencer(SizeInfluencer.class).addSize(new Vector3f(.015f,.015f,.015f));
		e5.getInfluencer(SizeInfluencer.class).setEnabled(true);
		
		e5.getInfluencer(SpriteInfluencer.class).setUseRandomStartImage(true);
		e5.getInfluencer(SpriteInfluencer.class).setAnimate(false);
		
		e5.initialize(assetManager);
		e5.setLocalScale(0.05f);
		rootNode.addControl(e5);
		e5.setEnabled(true);
		
		
		Emitter e6 = new Emitter();
		e6.setName("e6");
		e6.setMaxParticles(110);
		e6.addInfluencers(
			new GravityInfluencer(),
			new ColorInfluencer(),
			new AlphaInfluencer(),
			new SizeInfluencer(),
			new SpriteInfluencer(),
			new RotationInfluencer()
		);
		e6.setShape(hemiMesh);
		e6.setDirectionType(DirectionType.Normal);
	//	e6.initParticles(ParticleDataTriMesh.class, null);
		e6.setEmitterTestMode(false, false);
		e6.setSprite("Textures/smokes.png", 2, 2);
		e6.setEmissionsPerSecond(100);
		e6.setParticlesPerEmission(1);
		e6.setForceMinMax(.55f, 0.75f);
		e6.setLifeMinMax(.25f,.45f);
		e6.setBillboardMode(Emitter.BillboardMode.Velocity_Z_Up);
		e6.setUseRandomEmissionPoint(true);
		e6.setUseVelocityStretching(false);
		e6.setVelocityStretchFactor(1.65f);
		
		e6.getInfluencer(GravityInfluencer.class).setGravity(new Vector3f(0f,-7f,0f));
		e6.getInfluencer(GravityInfluencer.class).setAlignment(GravityAlignment.World);
		e6.getInfluencer(GravityInfluencer.class).setMagnitude(1.5f);
		
		e6.getInfluencer(ColorInfluencer.class).addColor(new ColorRGBA(0.75f,0.75f,1f,1f));
		e6.getInfluencer(ColorInfluencer.class).addColor(new ColorRGBA(0.45f,0.45f,1f,1f));
		e6.getInfluencer(ColorInfluencer.class).setEnabled(true);
		
		e6.getInfluencer(AlphaInfluencer.class).addAlpha(0.05f, Interpolation.exp5Out);
		e6.getInfluencer(AlphaInfluencer.class).addAlpha(0.35f, Interpolation.linear);
		e6.getInfluencer(AlphaInfluencer.class).addAlpha(0.1f, Interpolation.exp5In);
	//	e4.getInfluencer(AlphaInfluencer.class).addAlpha(.2f, Interpolation.exp5In);
		
		e6.getInfluencer(SizeInfluencer.class).addSize(new Vector3f(.075f,.075f,.075f));
		e6.getInfluencer(SizeInfluencer.class).addSize(new Vector3f(.115f,.115f,.015f));
		e6.getInfluencer(SizeInfluencer.class).addSize(new Vector3f(.075f,.075f,.075f));
		e6.getInfluencer(SizeInfluencer.class).setEnabled(true);
		
		e6.getInfluencer(SpriteInfluencer.class).setUseRandomStartImage(true);
		e6.getInfluencer(SpriteInfluencer.class).setAnimate(false);
		
		e6.getInfluencer(RotationInfluencer.class).setUseRandomStartRotation(false, false, false);
		e6.getInfluencer(RotationInfluencer.class).setEnabled(false);
		
		e6.initialize(assetManager);
		e6.setLocalScale(0.05f);
		e6.setLocalTranslation(0,0f,0);
		rootNode.addControl(e6);
		e6.setEnabled(true);
		
	}
}
