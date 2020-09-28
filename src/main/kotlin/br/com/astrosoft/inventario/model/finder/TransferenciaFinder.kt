package br.com.astrosoft.inventario.model.finder

import br.com.astrosoft.inventario.model.Transferencia
import io.ebean.Finder

open class TransferenciaFinder : Finder<Long, Transferencia>(Transferencia::class.java)

