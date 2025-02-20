// Do not change the line below. It lets Gradle find your 
// Classes to build the project
package a1template;

import org.junit.Test;
import static org.junit.Assert.*;

public class YourTests {
    // test with negative shifts
    @Test
    public void encodeTest(){
        CaesarCipher classUnderTest = new CaesarCipher(-8);
        assertEquals("bpqa qa i amkzmb umaaiom", classUnderTest.encode("this is a secret message"));
        
        classUnderTest = new CaesarCipher(-3);
        assertEquals("wklv lv d whvw phvvdjh.", classUnderTest.encode("this isn't very secret."));
    }

    @Test
    public void decodeTest(){
        CaesarCipher classUnderTest = new CaesarCipher(-8);
        assertEquals("this is a secret message", classUnderTest.decode("bpqa qa i amkzmb umaaiom"));
        
        classUnderTest = new CaesarCipher(-3);
        assertEquals("this isn't very secret.", classUnderTest.decode("wklv lv d whvw phvvdjh."));

    }
}