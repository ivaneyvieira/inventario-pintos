package br.com.astrosoft.inventario.model.finder

import br.com.astrosoft.inventario.model.Leitura
import io.ebean.Finder

open class LeituraFinder : Finder<Long, Leitura>(Leitura::class.java)

