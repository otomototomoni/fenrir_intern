fun isValid(s:String,b1:Brackets,b2:Brackets,b3:Brackets):Boolean{
    val list: List<Char> = s.toList();//変数sを一文字ずつlistに入れる
    var mlist:MutableList<Char> = list.toMutableList();//listを変更可能な形にする
    var ml_judge:Char = '(';//mlistの先頭と要素が一緒かどうかを判定する用
    var result: Boolean = true;//true.falseを返す
    var c1 :MutableList<Char> = mutableListOf();//listの先頭要素を入れる

    while(mlist.size != 0) {

        if(mlist[0] != ')' && mlist[0] != '}' && mlist[0] != ']') {
            //c1の先頭にmlistの先頭を入れる
            c1.add(0, (mlist.removeAt(0)));
        }

        ml_judge = mlist[0];

        if(c1.size != 0) {
            if (c1[0] == '(') {
                mlist = b1.decision(mlist);
            } else if (c1[0] == '{') {
                mlist = b2.decision(mlist);
            } else if (c1[0] == '[') {
                mlist = b3.decision(mlist);
            }
        }else{
            result = false;
            return result;
        }

        //mlistのsizeが0でなく、先頭が１の時にfalseを返す。
        if(mlist.size != 0){
            if(mlist[0] == '1'){
                result = false;
                return result;
            }
        }

        //mlistとml_judgeを比較し、違う場合にc1の先頭を消す。
        //c1のlistが[(,{]などになっているときに（を消して{の判定に映るため
        if(mlist.size != 0) {
            if (mlist[0] != ml_judge) {
                c1.removeAt(0);
            }
        }

    }
    return result;
}

fun main() {
    val b1 = Brackets(')','}',']');
    val b2 = Brackets('}',')',']');
    val b3 = Brackets(']',')','}');
    var s : String = "()";
    println(isValid(s,b1,b2,b3));
    s = "({})"
    println(isValid(s,b1,b2,b3));
    s = "({})[]"
    println(isValid(s,b1,b2,b3));
    s = "({)}"
    println(isValid(s,b1,b2,b3));
    s = "()}}"
    println(isValid(s,b1,b2,b3));
    s = ")"
    println(isValid(s,b1,b2,b3));
    s = "(){}[](())"
    println(isValid(s,b1,b2,b3));
    s = "({}) []"
    println(isValid(s,b1,b2,b3));
}