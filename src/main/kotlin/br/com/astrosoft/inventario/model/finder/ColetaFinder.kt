package br.com.astrosoft.inventario.model.finder

import br.com.astrosoft.inventario.model.Coleta
import io.ebean.Finder

open class ColetaFinder : Finder<Long, Coleta>(Coleta::class.java)

