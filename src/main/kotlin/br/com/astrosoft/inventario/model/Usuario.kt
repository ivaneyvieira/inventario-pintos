package br.com.astrosoft.inventario.model

import br.com.astrosoft.inventario.model.finder.UsuarioFinder
import br.com.astrosoft.framework.model.BaseModel
import io.ebean.annotation.Index
import io.ebean.annotation.Length
import javax.persistence.Entity

@Entity
class Usuario(
  @Index(unique = true)
  var matricula: Int,
  var nome: String,
  var senha: String,
  var apelido: String
             ): BaseModel() {

  companion object Find : UsuarioFinder()
}
