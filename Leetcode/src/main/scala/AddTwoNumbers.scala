object AddTwoNumbers {

  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    var l3 = l1
    var l4 = l2
    var carry_bit = 0
    var sum = new ListNode(0)
    val result:ListNode = sum
    while(l3!=null ||l4!=null){
      val real_sum = Option(l3).map(_.x).getOrElse(0) + Option(l4).map(_.x).getOrElse(0) + carry_bit
      carry_bit = real_sum /10
      sum.x = real_sum % 10
      if(l3 !=null) l3 = l3.next
      if(l4 !=null) l4 = l4.next
      if(l3 !=null || l4!=null){
        sum.next = new ListNode(0)
        sum = sum.next
      }
    }
    if(carry_bit!=0){
      sum.next = new ListNode(carry_bit)
    }
    result
  }

  def createListNode(array: Array[Int]):ListNode = {
    var result = new ListNode(0)
    val fix_result = result
    for(a <- array){
      result.next = new ListNode(0)
      result.next.x = a
      result = result.next
    }
    fix_result.next
  }

  def main(args: Array[String]): Unit = {
    var l1 = createListNode(Array(2,4,3))
    var l2 = createListNode(Array(5,6,4))

    var result = addTwoNumbers(l1, l2)
    while(result!=null){
      println(result.x)
      result = result.next
    }
  }
}
