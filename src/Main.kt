fun isValid(s:String,Brackets1:Brackets,Brackets2:Brackets,Brackets3:Brackets):Boolean{
    val list: List<Char> = s.toList();//変数sを一文字ずつlistに入れる
    var mlist:MutableList<Char> = list.toMutableList();//listを変更可能な形にする
    var ml_judge:Char = '(';//mlistの先頭と要素が一緒かどうかを判定する
    var c1 :MutableList<Char> = mutableListOf();//listの先頭要素を入れる

    //mlistの先頭要素を取り出していき、要素数が0になるまで繰り返す。途中で※１の条件に合致した場合にはfalseを返し、それ以外の時にはtrueを返す。
    while(mlist.size != 0) {

        if(mlist[0] != ')' && mlist[0] != '}' && mlist[0] != ']') {
            //c1の先頭にmlistの先頭を入れる
            c1.add(0, (mlist.removeAt(0)));
        }
        //ml_judgeにmlist[0]を入れて、下の方で判定する。
        ml_judge = mlist[0];

        if(c1.size != 0) {
            if (c1[0] == '(') {
                //c1に'('が入っているならmlist[0]に')'が入っていないかを見る
                mlist = Brackets1.decision(mlist);

            } else if (c1[0] == '{') {
                //c1に'｛'が入っているならmlist[0]に'}'が入っていないかを見る
                mlist = Brackets2.decision(mlist);

            } else if (c1[0] == '[') {
                //c1に'['が入っているならmlist[0]に']'が入っていないかを見る
                mlist = Brackets3.decision(mlist);
            }
        }else{
            return false;
        }

        //※１
        //mlistのsizeが0でなく、先頭が１の時にfalseを返す。
        if(mlist.size != 0){
            if(mlist[0] == '1'){
                return false;
            }
            //mlistとml_judgeを比較し、違う場合にc1の先頭を消す。
            //c1のlistが[(,{]などになっているときに（を消して{の判定に映るため
            if (mlist[0] != ml_judge) {
                c1.removeAt(0);
            }
        }

    }
    return true;
}

fun main() {
    val Brackets1 = Brackets(')','}',']');
    val Brackets2 = Brackets('}',')',']');
    val Brackets3 = Brackets(']',')','}');
    var s : String = "()";
    println(isValid(s,Brackets1,Brackets2,Brackets3));
    s = "({})"
    println(isValid(s,Brackets1,Brackets2,Brackets3));
    s = "({})[]"
    println(isValid(s,Brackets1,Brackets2,Brackets3));
    s = "({)}"
    println(isValid(s,Brackets1,Brackets2,Brackets3));
    s = "()}}"
    println(isValid(s,Brackets1,Brackets2,Brackets3));
    s = ")"
    println(isValid(s,Brackets1,Brackets2,Brackets3));
    s = "(){}[](())"
    println(isValid(s,Brackets1,Brackets2,Brackets3));
    s = "({}) []"
    println(isValid(s,Brackets1,Brackets2,Brackets3));
}