package com.moonblur.plugin;

import com.moonblur.module.Module;
import java.util.*;

public class PluginLoader {
    private final List<Module> loadedModules = new ArrayList<>();
    
    public void loadPlugin(Module module) {
        loadedModules.add(module);
    }
    
    public List<Module> getLoadedModules() {
        return new ArrayList<>(loadedModules);
    }
}