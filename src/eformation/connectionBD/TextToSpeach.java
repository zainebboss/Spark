/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piprojet.connectionBD;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

/**
 *
 * @author user
 */
public class TextToSpeach {
    
    public static void speak(String text){
            
        Voice voice;
        VoiceManager vm = VoiceManager.getInstance();
        voice = vm.getVoice("kevin");
        voice.allocate();
        try{
        voice.speak(text);
        }catch(Exception e){

        }
    }
}

