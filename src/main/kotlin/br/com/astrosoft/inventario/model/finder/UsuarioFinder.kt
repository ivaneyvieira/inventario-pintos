package br.com.astrosoft.inventario.model.finder

import br.com.astrosoft.inventario.model.Usuario
import io.ebean.Finder

open class UsuarioFinder : Finder<Long, Usuario>(Usuario::class.java)

