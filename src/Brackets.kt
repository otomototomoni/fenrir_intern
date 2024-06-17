class Brackets(val l1:Char='(',val l2:Char = ')',val l3:Char = '('){
    val B_l1 : Char = l1;
    val B_l2 : Char = l2;
    val B_l3 : Char = l3;

    fun decision(mlist:MutableList<Char>):MutableList<Char>{

        //例：classMainの「c1」の先頭が'('の場合
        //mlist[0]が')'かどうかをみる。
        // ')'の場合はmlist[0]をremoveで取り除く。
        // '}'か']'が入っている場合にはmlist[0]に'1'を入れてfalseを返す。
        //どれにも該当しない場合はそのまま返す。
        if(mlist[0] == B_l1){
            mlist.removeAt(0);
        }else if (mlist[0] == B_l2 || mlist[0] == B_l3){
            mlist.add(0,'1');
        }

        return mlist;

    }
}