package com.moonblur.render.motion;

import net.minecraft.client.MinecraftClient;
import org.joml.Vector3f;

public class MotionVectorCalculator {
    private Vector3f lastPosition;
    private Vector3f currentPosition;
    private Vector3f motionVector;
    
    public MotionVectorCalculator() {
        this.lastPosition = new Vector3f();
        this.currentPosition = new Vector3f();
        this.motionVector = new Vector3f();
    }
    
    public void update() {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player != null) {
            lastPosition.set(currentPosition);
            currentPosition.set(
                (float) client.player.getX(),
                (float) client.player.getY(),
                (float) client.player.getZ()
            );
            
            motionVector.set(currentPosition);
            motionVector.sub(lastPosition);
        }
    }
    
    public Vector3f getMotionVector() {
        return motionVector;
    }
    
    public float getMotionMagnitude() {
        return motionVector.length();
    }
    
    public Vector3f getCurrentPosition() {
        return currentPosition;
    }
    
    public Vector3f getLastPosition() {
        return lastPosition;
    }
}