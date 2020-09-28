package br.com.astrosoft.inventario.model

import br.com.astrosoft.framework.model.BaseModel
import br.com.astrosoft.inventario.model.finder.LojaFinder
import br.com.astrosoft.inventario.model.query.QColeta
import io.ebean.annotation.Index
import javax.persistence.Entity

@Entity
class Loja(
  @Index(unique = true)
  var storeno: Int,
  var endereco: String,
  var nome: String,
  var sigla: String
          ): BaseModel() {
  companion object Find: LojaFinder() {
    fun coleta() {
      //QColeta().query().where().
    }
  }
}
