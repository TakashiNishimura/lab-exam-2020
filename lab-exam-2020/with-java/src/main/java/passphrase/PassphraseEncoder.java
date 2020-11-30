package passphrase;

public class PassphraseEncoder {

  public static String encode(String st) {
    String encodeSt = "";
    for (int i = 0; i < st.length(); i++) {
      if (Character.isUpperCase(st.charAt(i))) {
        encodeSt += String.valueOf(st.charAt(i)).toLowerCase();
      } else {
        encodeSt += String.valueOf(st.charAt(i)).toUpperCase();
      }
    }
    return encodeSt;
  }

  public static String decode(String st) {
    return encode(st);
  }

}
