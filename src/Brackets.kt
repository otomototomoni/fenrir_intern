class Brackets(val l1:Char='(',val l2:Char = ')',val l3:Char = '('){
    val B_l1 : Char = l1;
    val B_l2 : Char = l2;
    val B_l3 : Char = l3;

    fun decision(mlist:MutableList<Char>):MutableList<Char>{

        if(mlist[0] == B_l1){
            mlist.removeAt(0);
        }else if (mlist[0] == B_l2 || mlist[0] == B_l3){
            mlist.add(0,'1');
        }

        return mlist;

    }
}