package com.firebase4s

import com.google.firebase.database.FirebaseDatabase


/**
  * Represents a Database instance
  * @param db
  */
class Database(private val db: FirebaseDatabase) {
  def ref(path: String): DatabaseReference = new DatabaseReference(path, db.getReference(path))
}

/**
  * Provides access to an instance of a Database
  */
object Database {
  def getInstance(): Database = {
    require(App.initialized, "Firebase4S App must be initialized before accessing Database")
    new Database(FirebaseDatabase.getInstance())
  }
}