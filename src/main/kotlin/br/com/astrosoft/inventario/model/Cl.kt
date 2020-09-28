package br.com.astrosoft.inventario.model

import br.com.astrosoft.framework.model.BaseModel
import br.com.astrosoft.inventario.model.finder.ClFinder
import io.ebean.annotation.Index
import javax.persistence.Entity

@Entity
class Cl(
  @Index(unique = true)
  var clno: Int,
  var departamento: String,
  var grupo: String,
  var secao: String
        ): BaseModel() {
  companion object Find: ClFinder()
}
