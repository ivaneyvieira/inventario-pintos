package br.com.astrosoft.inventario.model

import br.com.astrosoft.inventario.model.finder.LeituraFinder
import br.com.astrosoft.framework.model.BaseModel
import br.com.astrosoft.inventario.model.enums.EStatusLeitura
import io.ebean.annotation.Index
import java.time.LocalDate
import java.time.LocalTime
import javax.persistence.Entity
import javax.persistence.ManyToOne

@Entity
class Leitura(
  var data: LocalDate,
  var hora: LocalTime,
  var leitura: String,
  var observacao: String,
  var quant: Int,
  var status: EStatusLeitura,
  @Index
  @ManyToOne(optional = false)
  var coleta: Coleta,
  @Index
  @ManyToOne(optional = false)
  var produto: Produto
             ): BaseModel() {

  companion object Find : LeituraFinder()
}

