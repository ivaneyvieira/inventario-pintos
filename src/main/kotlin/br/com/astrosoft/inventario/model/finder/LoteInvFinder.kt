package br.com.astrosoft.inventario.model.finder

import br.com.astrosoft.inventario.model.LoteInv
import io.ebean.Finder

open class LoteInvFinder : Finder<Long, LoteInv>(LoteInv::class.java)

