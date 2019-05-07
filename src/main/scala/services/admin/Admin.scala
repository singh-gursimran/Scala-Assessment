package services.admin

import model._

class Admin {
  def addItem(item: Item): Unit ={
    ItemList.items.+=(item)
  }

  def addDenomination(types:Money,denomination:Int): Unit ={
    types match {
      case Coins=>AcceptedDenominations.acceptedCoins.+=(denomination)
      case Notes=>AcceptedDenominations.acceptedNotes.+=(denomination)
    }
  }

}
