package br.com.astrosoft.inventario.model

import br.com.astrosoft.inventario.model.finder.LoteFinder
import br.com.astrosoft.framework.model.BaseModel
import io.ebean.annotation.Index
import javax.persistence.Entity
import javax.persistence.Lob
import javax.persistence.ManyToOne

@Entity
@Index(columnNames = ["loja_id", "numero"])
class Lote(
  var numero: Int,
  var descricao: String,
  @ManyToOne(optional = false)
  var loja: Loja
          ): BaseModel() {

  companion object Find : LoteFinder()
}
