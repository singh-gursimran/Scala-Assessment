package services.user

import model.{Cart, Item, VendingMachine}

import scala.collection.mutable

class User(vendingMachine: VendingMachine){

  val cart=new Cart(vendingMachine)

  def getAvailableItems(): List[Item] ={
    vendingMachine.itemList.items.keySet.toList
  }

  def selectItems(items:mutable.HashMap[Item,Int]) ={
    cart.addItems(items)
    for((k,v) <- items) yield (k,k.price*v)
  }

  def pay(amountPaid:Int): Unit ={
    cart.pay(amountPaid)
  }

  def placeOrder(): Unit ={
    cart.placeorder()
  }

  def cancelOrder(): Int ={
    cart.cancelOrder
  }

}
