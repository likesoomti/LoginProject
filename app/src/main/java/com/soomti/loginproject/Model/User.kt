package com.soomti.loginproject.Model

import io.realm.RealmObject

open class User : RealmObject() {
    open var identify: String? = null
    open var  email: String? = null
    open var password: String? = null
}