package services.admin

import model._

class Admin(vendingMachine: VendingMachine){
  def addItem(item: Item,quantity:Int): Unit ={
    vendingMachine.itemList.items.+=((item,quantity))
  }

  def addDenomination(vendingMachine: VendingMachine,types:Money,denomination:Int): Unit ={
    types match {
      case Coins=>vendingMachine.acceptedDenominations.acceptedCoins.+=(denomination)
      case Notes=>vendingMachine.acceptedDenominations.acceptedNotes.+=(denomination)
    }
  }

}
