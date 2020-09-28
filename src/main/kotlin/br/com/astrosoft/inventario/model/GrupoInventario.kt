package br.com.astrosoft.inventario.model

import br.com.astrosoft.inventario.model.finder.GrupoInventarioFinder
import br.com.astrosoft.framework.model.BaseModel
import io.ebean.annotation.Index
import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.Lob

@Entity
class GrupoInventario(
  @Index(unique = false)
  var  nome: String,
  var descricao : String,
  var dataInicio : LocalDate
                     ) : BaseModel() {

  companion object Find : GrupoInventarioFinder()
}

