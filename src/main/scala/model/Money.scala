package model

sealed trait Money

case object Coins extends Money
case object Notes extends Money
