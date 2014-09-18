package core;

import paulscode.sound.Library;
import paulscode.sound.SoundSystem;
import paulscode.sound.SoundSystemConfig;
import paulscode.sound.SoundSystemException;
import paulscode.sound.codecs.CodecWav;
import paulscode.sound.libraries.LibraryJavaSound;
import paulscode.sound.libraries.LibraryLWJGLOpenAL;


/**
 * Created by Daniel on 9/17/14.
 */
public class Main
{

    public static SoundSystem soundSystem;

    public static void main(String[] args)
    {
        soundSystem = setupSoundSystem();
        soundSystem.backgroundMusic("background", "/Users/Daniel/Downloads/maroon_5-maps.mid", false);
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        soundSystem.cleanup();
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
}
