package passphrase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class PassphraseGeneratorTests {

  private final List<String> lowers;
  private final List<String> uppers;
  private final List<String> numbers;

  PassphraseGeneratorTests() {
    this.lowers = Arrays.asList("a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z".split(","));
    this.uppers = Arrays.asList("A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z".split(","));
    this.numbers = Arrays.asList("1,2,3,4,5,6,7,8,9,0".split(","));
  }

  @Test
  void generatePassphraseNotContainUppers() {
    var gen = new PassphraseGenerator(true, false, true);
    IntStream.range(0, 10000)
        .mapToObj(i -> gen.generate(1024))
        .forEach(pass -> uppers.stream()
            .map(pass::contains)
            .forEach(Assertions::assertFalse));
  }

  @Test
  void generatePassphraseBySpecifiedLength() {
    final int length = 1024;
    String pass = new PassphraseGenerator(true, true, true).generate(length);
    Assertions.assertEquals(pass.length(), length);
  }

  @Test
  void generateEmptyWhenAllConfigIsFalse() {
    String pass = new PassphraseGenerator(false, false, false).generate(1024);
    Assertions.assertTrue(pass.isEmpty());
  }

}
