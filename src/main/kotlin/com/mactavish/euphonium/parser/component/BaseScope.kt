package com.mactavish.euphonium.parser.component

abstract class BaseScope {
    val environment:Environment
}

typealias Symbol=String
class Environment:HashMap<Symbol,Value> {

}
