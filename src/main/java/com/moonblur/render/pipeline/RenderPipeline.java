package com.moonblur.render.pipeline;

import org.lwjgl.opengl.GL30C;
import org.lwjgl.opengl.GL11C;

public class RenderPipeline {
    private int framebuffer;
    private int colorTexture;
    private int depthTexture;
    private int width;
    private int height;
    
    public RenderPipeline(int width, int height) {
        this.width = width;
        this.height = height;
        init();
    }
    
    private void init() {
        framebuffer = GL30C.glGenFramebuffers();
        colorTexture = createTexture();
        depthTexture = createTexture();
        
        GL30C.glBindFramebuffer(GL30C.GL_FRAMEBUFFER, framebuffer);
        GL30C.glFramebufferTexture2D(GL30C.GL_FRAMEBUFFER, GL30C.GL_COLOR_ATTACHMENT0, GL11C.GL_TEXTURE_2D, colorTexture, 0);
        GL30C.glFramebufferTexture2D(GL30C.GL_FRAMEBUFFER, GL30C.GL_DEPTH_ATTACHMENT, GL11C.GL_TEXTURE_2D, depthTexture, 0);
        GL30C.glBindFramebuffer(GL30C.GL_FRAMEBUFFER, 0);
    }
    
    private int createTexture() {
        int texture = GL11C.glGenTextures();
        GL11C.glBindTexture(GL11C.GL_TEXTURE_2D, texture);
        GL11C.glTexImage2D(GL11C.GL_TEXTURE_2D, 0, GL30C.GL_RGBA8, width, height, 0, GL11C.GL_RGBA, GL11C.GL_UNSIGNED_BYTE, 0);
        GL11C.glTexParameteri(GL11C.GL_TEXTURE_2D, GL11C.GL_TEXTURE_MIN_FILTER, GL11C.GL_LINEAR);
        GL11C.glTexParameteri(GL11C.GL_TEXTURE_2D, GL11C.GL_TEXTURE_MAG_FILTER, GL11C.GL_LINEAR);
        GL11C.glBindTexture(GL11C.GL_TEXTURE_2D, 0);
        return texture;
    }
    
    public void bind() {
        GL30C.glBindFramebuffer(GL30C.GL_FRAMEBUFFER, framebuffer);
    }
    
    public void unbind() {
        GL30C.glBindFramebuffer(GL30C.GL_FRAMEBUFFER, 0);
    }
    
    public int getColorTexture() {
        return colorTexture;
    }
    
    public void cleanup() {
        GL11C.glDeleteTextures(colorTexture);
        GL11C.glDeleteTextures(depthTexture);
        GL30C.glDeleteFramebuffers(framebuffer);
    }
}