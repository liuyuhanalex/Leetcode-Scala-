import scala.collection.mutable
object LongestSubstringWithoutRepeating {
  def lengthOfLongestSubstring(s: String): Int = {
    val hashset = new mutable.HashSet[Char]()
    var i, j = 0
    var max_length = 0
    while(i<s.length && j < s.length){
      if(!hashset.contains(s.charAt(j))){
        hashset.add(s.charAt(j))
        j+=1
        if(hashset.size>max_length){
          max_length = hashset.size
        }
      }else{
        hashset.remove(s.charAt(i))
        i+=1
      }
    }
    max_length
  }

  def main(args: Array[String]): Unit = {
    println(lengthOfLongestSubstring("abcbbacbc"))
  }
}
