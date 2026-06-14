package com.moonblur.setting;

import java.util.*;

public class ModeSetting extends Setting<String> {
    private final List<String> modes;
    
    public ModeSetting(String name, String defaultValue, String... modes) {
        super(name, defaultValue);
        this.modes = Arrays.asList(modes);
    }
    
    public List<String> getModes() {
        return new ArrayList<>(modes);
    }
    
    public void cycle() {
        int index = modes.indexOf(value);
        int nextIndex = (index + 1) % modes.size();
        value = modes.get(nextIndex);
    }
}