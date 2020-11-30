package html;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

/**
 * Htmlの{@code <meta>}で使用するformat-detectionの値を管理するクラス
 *
 * @author oketa216 you
 * @version 1.0
 * @since 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormatDetection {

    /**
     * 電話番号にリンクを作成する
     * {@code yes}, {@code no}
     */
    private String telephone;

    /**
     * 住所にリンクを作成する
     * {@code yes}, {@code no}
     */
    private String address;

    /**
     * メールアドレスにリンクを作成する
     * {@code yes}, {@code no}
     */
    private String email;

}
