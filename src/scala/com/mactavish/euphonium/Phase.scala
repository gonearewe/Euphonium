package com.mactavish.euphonium

trait Phase[-T,+U] extends Function[T,Option[U]]{
  def |>[R](next:Phase[U,R]):Phase[T,R] = x=>this(x) flatMap next
}

object Phase{

}
