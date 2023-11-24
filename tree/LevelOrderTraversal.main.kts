#!/opt/homebrew/bin/kotlin

data class TreeNode(val `val`: Int) {
    val left: TreeNode? = null
    val right: TreeNode? = null
}

fun levelOder(node:TreeNode?):List<List<Int>>{
   val result =  addNode(node,0, emptyList<MutableList<Int>>().toMutableList())
    return result

}

fun addNode(node:TreeNode?,level:Int,result:MutableList<MutableList<Int>>):List<List<Int>>{
    if (node == null) return result
    if(level == result.size){
        result.add(mutableListOf())
    }
    result[level].add( node.`val`);
    addNode(node.left,level+1,result)
    addNode(node.right,level+1,result)
    return result

}


