package services.user

import model.{AcceptedDenominations, Item, ItemList, VendingMachine}
import org.scalatest.FunSuite
import services.admin.Admin

class UserTest extends FunSuite {
  val vendingMachine=new VendingMachine(new ItemList,new AcceptedDenominations)
  val admin=new Admin(vendingMachine)
  val item=new Item(73,"Chips")

  admin.addItem(item,10)

  val user=new User(vendingMachine)

  test("testSelectItems") {
    assert(user.getAvailableItems()===vendingMachine.itemList.items.keySet.toList)
  }

  test("testGetAvailableItems") {

  }

}
