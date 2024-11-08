import static org.lwjgl.glfw.GLFW.GLFW_FALSE;
import static org.lwjgl.glfw.GLFW.GLFW_RESIZABLE;
import static org.lwjgl.glfw.GLFW.GLFW_TRUE;
import static org.lwjgl.glfw.GLFW.GLFW_VISIBLE;
import static org.lwjgl.glfw.GLFW.glfwCreateWindow;
import static org.lwjgl.glfw.GLFW.glfwDefaultWindowHints;
import static org.lwjgl.glfw.GLFW.glfwInit;
import static org.lwjgl.glfw.GLFW.glfwMakeContextCurrent;
import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.glfw.GLFW.glfwShowWindow;
import static org.lwjgl.glfw.GLFW.glfwSwapBuffers;
import static org.lwjgl.glfw.GLFW.glfwSwapInterval;
import static org.lwjgl.glfw.GLFW.glfwWindowHint;
import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;

public class Main {

    final static int WIDTH = 1100;
    final static int HEIGHT = 900;

    public static void main(String[] args) {

        if (!glfwInit()) {
            throw new IllegalStateException("Unable to intialize GLFW");
        }

        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE); // Lets Users rezise the window
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); // Window stays hidden while OPENGL is setup 

        long window = glfwCreateWindow(WIDTH, HEIGHT, "Mincraft Clone", 0, 0);
        if ( window == 0 )
			throw new RuntimeException("Failed to create the GLFW window");

        glfwMakeContextCurrent(window);
        glfwSwapInterval(1); // This enables V-SYNC
        glfwShowWindow(window); // This is will make the window visible

        GL.createCapabilities();
        glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        
        // Run the program until the user clicks the clode window or esc key
        while (!glfwWindowShouldClose(window)) {

            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); //Clears the screen atht he beginning of each frame
            glfwSwapBuffers(window); // this swaps the color buffers

            glfwPollEvents(); // this process all event like mouse clicks or keyboard input


        }

        // This terminates the GLFW Window
        GLFW.glfwDestroyWindow(window);
        GLFW.glfwTerminate();


    }

}