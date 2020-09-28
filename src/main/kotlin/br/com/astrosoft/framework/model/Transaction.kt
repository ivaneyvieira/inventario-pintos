package br.com.astrosoft.framework.model

import io.ebean.DB
import io.ebean.Query
import io.ebean.SqlQuery
import io.ebean.SqlUpdate

object Transaction {
  private fun inTransaction(): Boolean {
    return DB.currentTransaction() != null
  }
  
  fun <T> execTransacao(lambda: () -> T): T {
    return if(inTransaction()) lambda()
    else DB.beginTransaction().use {transaction ->
      val ret = lambda()
      transaction.commit()
      ret
    }
  }
  
  fun createSqlUpdate(sql: String): SqlUpdate? {
    return DB.sqlUpdate(sql)
  }

  inline fun <reified T> find(): Query<T>? {
    return DB.find(T::class.java)
  }

  fun createSqlQuery(sql: String): SqlQuery? {
    return DB.sqlQuery(sql)
  }
}
