package br.com.astrosoft.inventario.model.finder

import br.com.astrosoft.inventario.model.Produto
import io.ebean.Finder

open class ProdutoFinder : Finder<Long, Produto>(Produto::class.java)

