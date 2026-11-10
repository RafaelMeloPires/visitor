import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImpostoVisitorTest {

    @Test
    void livroDeveSerIsentoDeImposto() {
        Livro livro = new Livro("Java Básico", 100.0);

        assertEquals(0.0, livro.aceitar(new ImpostoVisitor()), 0.001);
    }

    @Test
    void deveCalcularImpostoDeEletronico() {
        Eletronico eletronico = new Eletronico("Fone", 200.0);

        assertEquals(30.0, eletronico.aceitar(new ImpostoVisitor()), 0.001);
    }

    @Test
    void deveCalcularImpostoDeAlimento() {
        Alimento alimento = new Alimento("Café", 40.0);

        assertEquals(2.0, alimento.aceitar(new ImpostoVisitor()), 0.001);
    }

    @Test
    void deveCalcularImpostoZeroParaProdutoDePrecoZero() {
        Eletronico eletronico = new Eletronico("Brinde", 0.0);

        assertEquals(0.0, eletronico.aceitar(new ImpostoVisitor()), 0.001);
    }

    @Test
    void deveSomarImpostoDeVariosProdutos() {
        Produto[] produtos = {
                new Livro("Java Básico", 100.0),
                new Eletronico("Fone", 200.0),
                new Alimento("Café", 40.0)
        };
        Visitor imposto = new ImpostoVisitor();

        double total = 0;
        for (Produto produto : produtos) {
            total += produto.aceitar(imposto);
        }

        assertEquals(32.0, total, 0.001);
    }
}