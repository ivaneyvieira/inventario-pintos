package br.com.astrosoft.inventario.model

import br.com.astrosoft.inventario.model.finder.TransferenciaFinder
import br.com.astrosoft.framework.model.BaseModel
import io.ebean.annotation.Index
import javax.persistence.Entity
import javax.persistence.ManyToOne

@Entity
class Transferencia(
  var quant: Int,
  @Index
  @ManyToOne(optional = false)
  var lojaO: Loja,
  @Index
  @ManyToOne(optional = false)
  var lojaD: Loja,
  @Index
  @ManyToOne(optional = false)
  var prdO: Produto,
  @Index
  @ManyToOne(optional = false)
  var prdD: Produto,
  @Index
  @ManyToOne(optional = false)
  var grupo: GrupoInventario
                   ): BaseModel() {

  companion object Find : TransferenciaFinder()
}
