package html;

import lombok.Builder;
import lombok.Value;

/**
 * HTMLの{@code meta}タグを管理するクラス
 *
 * @author oketa216 you
 * @version 1.0
 * @since 1.0
 */
@Value
@Builder
public class Meta {

  /**
   * ページがどこの言葉で書かれているか
   * ja, en, etc...
   **/
  String lang;

  /**
   * ページの文書の形式
   * text/html, text/plain, etc...
   **/
  String contentType;

  /**
   * ページがどの文字セットで書かれているか
   * UTF-8, Shift-JIS, etc...
   **/
  String charset;

  /**
   * ページを書いたのは誰か
   **/
  String author;

  /**
   * ページの説明
   **/
  String description;

  /**
   * ページの自動リンクの設定
   *
   * @see FormatDetection
   **/
  FormatDetection formatDetection;

  /**
   * 検索エンジンに対してURLをインデックスするか
   * noindex, unfollow
   **/
  String robots;

  // TODO Q2.2にてこのコンストラクタは削除する

  /**
   * metaタグを生成する
   * フィールドが{@code null}のものは生成されない
   *
   * <code>
   * // lang = "ja", contentType = "text/html", charset = "UTF-8",
   * // その他フィールドは{@code null}のMetaのインスタンスmetaがあるとき
   * var metaLines = meta.getStringFormedHtml()
   * System.out.println(metaLines)
   * <p>
   * // 出力結果は以下となる
   * // <meta lang="ja" />
   * // <meta contentType="text/html" />
   * // <meta charset="UTF-8" />
   * </code>
   *
   * @return contentに値が入力された{@code meta}タグ
   **/
  public String getStringAsHtml() {
    var metas = "";
    if (lang != null) {
      metas += "<meta lang=\"" + lang + "\"/>\n";
    }
    metas += "<meta contentType=\"" + contentType + "\"/>\n";
    metas += "<meta charset=\"" + charset + "\"/>\n";
    if (author != null) {
      metas += "<meta author=\"" + author + "\"/>\n";
    }
    if (description != null) {
      metas += "<meta name=\"description\" content=\"" + description + "\"/>\n";
    }
    if (formatDetection != null) {
      metas += "<meta name=\"format-detection\" " +
               "content=\"email=" + formatDetection.getEmail() + "," +
               "telephone=" + formatDetection.getTelephone() + "," +
               "address=" + formatDetection.getAddress() + "\"/>\n";
    }
    if (robots != null) {
      metas += "<meta name=\"robots\" content=\"" + robots + "\"/>\n";
    }
    return metas;
  }

}