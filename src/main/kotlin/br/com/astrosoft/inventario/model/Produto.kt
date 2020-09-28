package br.com.astrosoft.inventario.model

import br.com.astrosoft.inventario.model.finder.ProdutoFinder
import br.com.astrosoft.framework.model.BaseModel
import io.ebean.annotation.Index
import javax.persistence.Entity
import javax.persistence.ManyToOne

@Entity
@Index(columnNames = ["codigo", "grade"])
class Produto(
  @Index(unique = true)
  var barcode: String,
  var codigo: String,
  var grade: String,
  var foraLinha: Boolean,
  var usoConsumo: Boolean,
  var custo: Double,
  @Index
  @ManyToOne(optional = false)
  var fornecedor: Fornecedor,
  @ManyToOne(optional = false)
  var cl: Cl
             ): BaseModel() {

  companion object Find : ProdutoFinder()
}
