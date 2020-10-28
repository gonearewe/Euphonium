package com.mactavish.euphonium

trait Phase[-T, +U, F] extends Function[T, Result[U, F]] {
  def |>[R](next: Phase[U, R, F]): Phase[T, R, F] = x => this (x) match {
    case Success(res) => next(res)
    case Failure(msg) => Failure(msg)
  }
}

object Phase {

}
