package model

import exceptions.myExceptions

import scala.collection.mutable

class Cart(vendingMachine: VendingMachine){
  var selectedItems=new mutable.HashMap[Item,Int]()
  var amountPaid=0
  def addItems(items:mutable.HashMap[Item,Int]): Unit ={
   for((item,quantity)<-items) {
     val availableQuantity:Int=vendingMachine.itemList.items.get(item).getOrElse(0)
     try{
       if (vendingMachine.itemList.items.get(item).getOrElse(0)<quantity ){
         throw new myExceptions("Item not available")
       }else{
         vendingMachine.itemList.items.update(item,availableQuantity-quantity)
       }
     }
     selectedItems.update(item,quantity)}
  }
  def getPrice(): Int ={
    var sum=0
    for((item,quantity)<-selectedItems) sum+(item.price*quantity)
    sum
  }
  def placeorder(): Boolean ={
    if((getPrice()-amountPaid)<0){
      throw new myExceptions("Amount Insufficient")
    }else{
      selectedItems.clear()
      amountPaid=0
      true
    }
  }
  def pay(amount:Int): Unit ={
    amountPaid=amount
  }

  def cancelOrder(): Int ={
    selectedItems.clear()
    getRefund()
    amountPaid
  }

  def getRefund(): Unit ={
    amountPaid=0
  }
}
