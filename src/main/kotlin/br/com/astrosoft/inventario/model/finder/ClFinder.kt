package br.com.astrosoft.inventario.model.finder

import br.com.astrosoft.inventario.model.Cl
import io.ebean.Finder

open class ClFinder : Finder<Long, Cl>(Cl::class.java)

