package br.com.astrosoft.inventario.model.finder

import br.com.astrosoft.inventario.model.Fornecedor
import io.ebean.Finder

open class FornecedorFinder : Finder<Long, Fornecedor>(Fornecedor::class.java)

