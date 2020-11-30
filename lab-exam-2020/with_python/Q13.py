import MeCab

def print_words_and_results(raw_text: str = 'すもももももももものうち'):
    t = MeCab.Tagger('')
    print(t.parse(raw_text))


def print_morpheme(raw_text: str = 'すもももももももものうち'):
    t = MeCab.Tagger('-Ochasen')
    n = t.parseToNode(raw_text)
    while n:
        if "名詞" == n.feature.split(",")[0]:
            print(n.feature)
        n = n.next


if __name__ == '__main__':
    print("形態素解析")
    print_words_and_results()
    print("名詞のみ")
    print_morpheme()