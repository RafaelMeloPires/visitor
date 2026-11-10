import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoTest {

    @Test
    void deveCriarProduto() {
        Livro livro = new Livro("Java Básico", 100.0);

        assertEquals("Java Básico", livro.getNome());
        assertEquals(100.0, livro.getPreco(), 0.001);
    }

    @Test
    void deveAlterarNomeEPreco() {
        Alimento alimento = new Alimento("Café", 40.0);
        alimento.setNome("Chá");
        alimento.setPreco(15.0);

        assertEquals("Chá", alimento.getNome());
        assertEquals(15.0, alimento.getPreco(), 0.001);
    }

    @Test
    void todosDevemSerProdutos() {
        assertTrue(new Livro("Java Básico", 100.0) instanceof Produto);
        assertTrue(new Eletronico("Fone", 200.0) instanceof Produto);
        assertTrue(new Alimento("Café", 40.0) instanceof Produto);
    }

    // ---------- Casos de erro ----------

    @Test
    void deveLancarExcecaoComNomeNulo() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new Livro(null, 100.0));
        assertEquals("Nome inválido", e.getMessage());
    }

    @Test
    void deveLancarExcecaoComNomeVazio() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new Eletronico("  ", 200.0));
        assertEquals("Nome inválido", e.getMessage());
    }

    @Test
    void deveLancarExcecaoComPrecoNegativo() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> new Alimento("Café", -1.0));
        assertEquals("Preço não pode ser negativo", e.getMessage());
    }

    @Test
    void deveLancarExcecaoAoAlterarPrecoParaNegativo() {
        Livro livro = new Livro("Java Básico", 100.0);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> livro.setPreco(-50.0));
        assertEquals("Preço não pode ser negativo", e.getMessage());
        assertEquals(100.0, livro.getPreco(), 0.001);
    }

    @Test
    void deveLancarExcecaoAoAlterarNomeParaVazio() {
        Livro livro = new Livro("Java Básico", 100.0);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> livro.setNome(""));
        assertEquals("Nome inválido", e.getMessage());
        assertEquals("Java Básico", livro.getNome());
    }

    @Test
    void deveLancarExcecaoAoAceitarVisitorNuloEmLivro() {
        Livro livro = new Livro("Java Básico", 100.0);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> livro.aceitar(null));
        assertEquals("Visitor não pode ser nulo", e.getMessage());
    }

    @Test
    void deveLancarExcecaoAoAceitarVisitorNuloEmEletronico() {
        Eletronico eletronico = new Eletronico("Fone", 200.0);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> eletronico.aceitar(null));
        assertEquals("Visitor não pode ser nulo", e.getMessage());
    }

    @Test
    void deveLancarExcecaoAoAceitarVisitorNuloEmAlimento() {
        Alimento alimento = new Alimento("Café", 40.0);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> alimento.aceitar(null));
        assertEquals("Visitor não pode ser nulo", e.getMessage());
    }
}