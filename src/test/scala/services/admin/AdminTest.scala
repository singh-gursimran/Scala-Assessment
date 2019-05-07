package services.admin

import model._
import org.scalatest.{BeforeAndAfter, FunSuite}

class AdminTest extends FunSuite with BeforeAndAfter{


  val vendingMachine=new VendingMachine(new ItemList,new AcceptedDenominations)
  val admin=new Admin(vendingMachine)


  test("testAddItem") {
    val item=new Item(73,"Chips")
    admin.addItem(item,10)
    assert(vendingMachine.itemList.items.get(item).get===10)
  }

  test("testAddDenominationCoins") {
    admin.addDenomination(vendingMachine,Coins,78)
    assert(vendingMachine.acceptedDenominations.acceptedCoins===List[Int](78))
  }


  test("testAddDenominationNotes") {
    admin.addDenomination(vendingMachine,Notes,50)
    assert(vendingMachine.acceptedDenominations.acceptedNotes===List[Int](50))
  }

}
