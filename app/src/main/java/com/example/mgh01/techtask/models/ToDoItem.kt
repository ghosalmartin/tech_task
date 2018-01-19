package com.example.mgh01.techtask.models

import io.realm.RealmModel
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import java.util.*

@RealmClass
open class ToDoItem(
        @PrimaryKey var id: String = UUID.randomUUID().toString(),
        var item: String = "") : RealmModel