package core;

import paulscode.sound.Library;
import paulscode.sound.SoundSystem;
import paulscode.sound.SoundSystemConfig;
import paulscode.sound.SoundSystemException;
import paulscode.sound.codecs.CodecWav;
import paulscode.sound.libraries.LibraryJavaSound;
import paulscode.sound.libraries.LibraryLWJGLOpenAL;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Daniel on 9/17/14.
 */
public class Main
{

    public static SoundSystem soundSystem = new SoundSystem();

    public static void main(String[] args)
    {
        soundSystem = setupSoundSystem();
        AudioPlaybackSystem.loadClip("20CenFox.mid", "F:\\Documents\\Workspace\\MusicSampleGrid\\ext\\20CenFox.mid");
        AudioPlaybackSystem.playClip("20CenFox.mid");
        //System.exit(0);
    }

    public static SoundSystem setupSoundSystem()
    {
        try
        {
            SoundSystemConfig.addLibrary(LibraryJavaSound.class);
        }
        catch( SoundSystemException e )
        {
            System.err.println( "error linking with the LibraryJavaSound plug-in" );
        }
        try
        {
            SoundSystemConfig.addLibrary(LibraryLWJGLOpenAL.class);
        }
        catch (SoundSystemException e) {
            e.printStackTrace();
        }
        try
        {
            SoundSystemConfig.setCodec( "wav", CodecWav.class );
        }
        catch( SoundSystemException e )
        {
            System.err.println("error linking with the CodecWav plug-in" );
        }
        boolean aLCompatible = SoundSystem.libraryCompatible( LibraryLWJGLOpenAL.class );
        boolean jSCompatible = SoundSystem.libraryCompatible( LibraryJavaSound.class );
        java.lang.Class libraryType = null;

        if( aLCompatible )
            libraryType = LibraryLWJGLOpenAL.class; // OpenAL
        else if( jSCompatible )
            libraryType = LibraryJavaSound.class; // Java Sound
        else
            libraryType = Library.class; // "No Sound, Silent Mode"
        SoundSystem mySoundSystem = null;
        try
        {
            mySoundSystem = new SoundSystem(libraryType);
        }
        catch( SoundSystemException sse )
        {
            // Shouldn’t happen, but it is best to prepare for anything
            sse.printStackTrace();
            return null;
        }
        return mySoundSystem;
    }

    public static void testPlay()
    {
        //soundSystem = setupSoundSystem();
        URL url = null;
        File file =  new File("F:\\Documents\\Workspace\\MusicSampleGrid\\ext\\20CenFox.mid");
        if (file.exists()) {
            try {
                url = file.toURI().toURL();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        //soundSystem.loadSound(url, "20CenFox.midi");
        //soundSystem.newSource(false, "20CenFox.midi", url, "20CenFox", false, 0, 0, 0, SoundSystemConfig.ATTENUATION_NONE, SoundSystemConfig.getDefaultRolloff());
        //soundSystem.play("20CenFox.midi");
        //soundSystem.play("20CenFox");
        System.out.println("Playing....");
        soundSystem.quickPlay(false, url, "20CenFox.midi", false, 0, 0, 0, SoundSystemConfig.ATTENUATION_NONE, SoundSystemConfig.getDefaultRolloff());
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        soundSystem.cleanup();
    }
}
