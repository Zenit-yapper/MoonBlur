package com.moonblur.event;

public class TickEvent {
    private int tick;
    
    public TickEvent(int tick) {
        this.tick = tick;
    }
    
    public int getTick() {
        return tick;
    }
}