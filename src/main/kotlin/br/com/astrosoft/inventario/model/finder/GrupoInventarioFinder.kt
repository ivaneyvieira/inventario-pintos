package br.com.astrosoft.inventario.model.finder

import br.com.astrosoft.inventario.model.GrupoInventario
import io.ebean.Finder

open class GrupoInventarioFinder : Finder<Long, GrupoInventario>(GrupoInventario::class.java)

