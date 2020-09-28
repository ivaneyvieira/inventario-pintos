package br.com.astrosoft.inventario.model

import br.com.astrosoft.inventario.model.finder.EstoqueFinder
import br.com.astrosoft.framework.model.BaseModel
import io.ebean.annotation.Index
import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.ManyToOne

@Entity
@Index(columnNames = ["inventario_id", "produto_id"])
class Estoque(
  var utmdata: LocalDate,
  var filtro: Boolean,
  var inv: Boolean,
  var qtSaldo: Int,
  var qtInv: Int,
  var transferencia: Boolean,
  @Index
  @ManyToOne ( optional = false )
  var produto: Produto,
  @ManyToOne(optional = false)
  var inventario: Inventario
             ): BaseModel() {

  companion object Find : EstoqueFinder()
}
