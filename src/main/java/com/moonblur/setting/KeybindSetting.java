package com.moonblur.setting;

import org.lwjgl.glfw.GLFW;

public class KeybindSetting extends Setting<Integer> {
    private String displayName;
    
    public KeybindSetting(String name, int defaultKey) {
        super(name, defaultKey);
        this.displayName = getKeyName(defaultKey);
    }
    
    public void setKey(int keyCode) {
        this.value = keyCode;
        this.displayName = getKeyName(keyCode);
    }
    
    public String getDisplayName() {
        return displayName;
    }
    
    private static String getKeyName(int keyCode) {
        if (keyCode == GLFW.GLFW_KEY_M) return "M";
        if (keyCode == GLFW.GLFW_KEY_ESCAPE) return "ESC";
        if (keyCode == GLFW.GLFW_KEY_ENTER) return "ENTER";
        if (keyCode == GLFW.GLFW_KEY_SPACE) return "SPACE";
        if (keyCode == GLFW.GLFW_KEY_LEFT_SHIFT) return "LSHIFT";
        if (keyCode == GLFW.GLFW_KEY_LEFT_CONTROL) return "LCTRL";
        if (keyCode == GLFW.GLFW_KEY_LEFT_ALT) return "LALT";
        return "KEY_" + keyCode;
    }
}