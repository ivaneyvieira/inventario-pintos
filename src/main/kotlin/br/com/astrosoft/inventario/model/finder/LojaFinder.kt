package br.com.astrosoft.inventario.model.finder

import br.com.astrosoft.inventario.model.Loja
import io.ebean.Finder

open class LojaFinder : Finder<Long, Loja>(Loja::class.java)

