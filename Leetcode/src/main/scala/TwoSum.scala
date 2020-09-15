import scala.util.control.Breaks.{break, breakable}
object TwoSum {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    var map:Map[Int, Int] = Map.empty[Int, Int]
    var result:Array[Int] = Array(0,0)
    breakable(
      for(a <- nums.indices){
        if (map.contains(nums(a))){
          result = Array(map(nums(a)), a)
          break
        }
        map += (target - nums(a) -> a)
      }
    )
    result
  }

  def main(args: Array[String]): Unit = {
    val result = TwoSum.twoSum(Array(3, 3, 4), 6)
    println(result.mkString(" "))
  }
}
