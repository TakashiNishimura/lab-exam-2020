package passphrase;

import java.util.Random;

/**
 * パスワードを生成するクラス
 *
 * <code>
 *     var generator = new PassphraseGenerator(true, true, true);
 *     var passphrase = generator.generate(8);
 * </code>
 *
 * @author oketa216 you
 * @version 1.0
 * @since 1.0
 */
public class PassphraseGenerator {

    private final boolean useLowerCase;
    private final boolean useUpperCase;
    private final boolean useNumber;

    /**
     * コンストラクタ
     *
     * @param useLowerCase 小文字を使用するか否か
     * @param useUpperCase 大文字を使用するか否か
     * @param useNumber 数字を使用するか否か
     */
    public PassphraseGenerator(boolean useLowerCase, boolean useUpperCase, boolean useNumber) {
        this.useLowerCase = useLowerCase;
        this.useUpperCase = useUpperCase;
        this.useNumber = useNumber;
    }

    /**
     * パスワードを生成する
     * {@code useLowerCase}, {@code useUpperCase}, {@code useNumber} 全てがfalseのとき、空白文字を返す
     *
     * @param length 生成するパスワードの長さ
     * @return 生成したパスワード
     */
    public String generate(int length) {
        var useChars = new StringBuilder();

        if (!useLowerCase && !useUpperCase && !useNumber) {
            return "";
        }

        if (useLowerCase) {
            for (var i = 0x61; i < 0x7b; i++) {
                useChars.append((char) i);
            }
        }
        if (useUpperCase) {
            for (var i = 0x41; i < 0x5b; i++) {
                useChars.append((char) i);
            }
        }
        if (useNumber) {
            for (var i = 0x30; i < 0x3A; i++) {
                useChars.append((char) i);
            }
        }

        var random = new Random();
        var passphrase = "";
        for (var i = 0; i < length; i++) {
            passphrase += useChars.charAt(Math.abs(random.nextInt() % useChars.length()));
        }
        return passphrase;
    }
}
