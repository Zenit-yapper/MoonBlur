package com.moonblur.event;

public class Render2DEvent {
    private float partialTicks;
    
    public Render2DEvent(float partialTicks) {
        this.partialTicks = partialTicks;
    }
    
    public float getPartialTicks() {
        return partialTicks;
    }
}