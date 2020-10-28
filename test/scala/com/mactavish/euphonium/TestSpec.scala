package com.mactavish.euphonium

import org.scalatest.flatspec.AnyFlatSpecLike
import org.scalatest.matchers.should

sealed trait TestSpec

trait UnitTestSpec extends TestSpec with AnyFlatSpecLike with should.Matchers
