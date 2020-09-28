package br.com.astrosoft.inventario.model.finder

import br.com.astrosoft.inventario.model.Estoque
import io.ebean.Finder

open class EstoqueFinder : Finder<Long, Estoque>(Estoque::class.java)

