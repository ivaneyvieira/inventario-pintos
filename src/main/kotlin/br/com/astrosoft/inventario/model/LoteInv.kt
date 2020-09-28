package br.com.astrosoft.inventario.model

import br.com.astrosoft.inventario.model.finder.LoteInvFinder
import br.com.astrosoft.framework.model.BaseModel
import br.com.astrosoft.inventario.model.enums.ETipoLote
import io.ebean.annotation.Index
import javax.persistence.Entity
import javax.persistence.ManyToOne

@Entity
@Index(columnNames = ["inventario_id", "lote_id"])
class LoteInv(
  var descricao: String,
  var tipoLote: ETipoLote,
  @ManyToOne(optional = false)
  var inventario: Inventario,
  @Index
  @ManyToOne(optional = false)
  var lote: Lote
             ): BaseModel() {

  companion object Find : LoteInvFinder()
}

