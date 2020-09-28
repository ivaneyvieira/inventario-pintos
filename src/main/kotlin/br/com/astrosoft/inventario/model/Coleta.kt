package br.com.astrosoft.inventario.model

import br.com.astrosoft.inventario.model.finder.ColetaFinder
import br.com.astrosoft.framework.model.BaseModel
import br.com.astrosoft.inventario.model.enums.EStatusColetor
import io.ebean.annotation.Index
import javax.persistence.Entity
import javax.persistence.ManyToOne

@Entity
class Coleta(
  var numColeta: Int,
  var coletor: Int,
  var status: EStatusColetor,
  @Index
  @ManyToOne(optional = false)
  var loteinv: LoteInv,
  @Index
  @ManyToOne(optional = false)
  var usuario: Usuario
            ): BaseModel() {

  companion object Find : ColetaFinder()
}

