package br.com.astrosoft.inventario.model.finder

import br.com.astrosoft.inventario.model.Lote
import io.ebean.Finder

open class LoteFinder : Finder<Long, Lote>(Lote::class.java)

