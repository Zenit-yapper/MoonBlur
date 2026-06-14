package com.moonblur.setting;

public class ColorSetting extends Setting<Integer> {
    public ColorSetting(String name, Integer defaultValue) {
        super(name, defaultValue);
    }
    
    public int getRed() {
        return (value >> 16) & 0xFF;
    }
    
    public int getGreen() {
        return (value >> 8) & 0xFF;
    }
    
    public int getBlue() {
        return value & 0xFF;
    }
    
    public int getAlpha() {
        return (value >> 24) & 0xFF;
    }
    
    public void setRGB(int r, int g, int b) {
        value = (getAlpha() << 24) | (r << 16) | (g << 8) | b;
    }
}