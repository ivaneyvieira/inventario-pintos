package br.com.astrosoft.inventario.model

import br.com.astrosoft.inventario.model.finder.FornecedorFinder
import br.com.astrosoft.framework.model.BaseModel
import io.ebean.annotation.Index
import javax.persistence.Entity

@Entity
class Fornecedor(
  @Index(unique = true)
  var codigo: Int,
  var fantazia: String,
  var razao: String
                ): BaseModel() {

  companion object Find : FornecedorFinder()
}
