package br.com.astrosoft.inventario.model

import br.com.astrosoft.inventario.model.finder.InventarioFinder
import br.com.astrosoft.framework.model.BaseModel
import br.com.astrosoft.inventario.model.enums.EStatusInventario
import br.com.astrosoft.inventario.model.enums.ETipoInventario
import io.ebean.annotation.Index
import java.time.LocalDate
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.Lob
import javax.persistence.ManyToMany
import javax.persistence.ManyToOne

@Entity
@Index(columnNames = ["loja_id", "data"])
class Inventario(
  @Index(unique = true)
  var numero: Int,
  @Index
  var data: LocalDate,
  @Lob
  var observacao: String,
  var tipoInventario: ETipoInventario,
  var statusInventario: EStatusInventario,
  @ManyToOne(optional = false)
  var loja: Loja,
  @Index
  @ManyToOne ( optional = false )
  var grupoInventario: GrupoInventario
                ): BaseModel() {
  @ManyToMany(cascade = [CascadeType.ALL])
  var cls : MutableList<Cl> = mutableListOf()
  @ManyToMany(cascade = [CascadeType.ALL])
  var fornecedores : MutableList<Fornecedor> = mutableListOf()

  companion object Find : InventarioFinder()
}

