package com.mactavish.euphonium


sealed abstract class Result[+T, +F] extends Product with Serializable

final case class Success[+T, +F](res: T) extends Result[T, F]

final case class Failure[+T, +F](msg: F) extends Result[T, F]

