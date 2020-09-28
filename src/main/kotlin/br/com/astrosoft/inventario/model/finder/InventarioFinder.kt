package br.com.astrosoft.inventario.model.finder

import br.com.astrosoft.inventario.model.Inventario
import io.ebean.Finder

open class InventarioFinder : Finder<Long, Inventario>(Inventario::class.java)

