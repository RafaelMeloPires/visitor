import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FreteVisitorTest {

    @Test
    void deveCalcularFreteDeLivro() {
        Livro livro = new Livro("Java Básico", 100.0);

        assertEquals(10.0, livro.aceitar(new FreteVisitor()), 0.001);
    }

    @Test
    void deveCalcularFreteDeEletronico() {
        Eletronico eletronico = new Eletronico("Fone", 200.0);

        assertEquals(24.0, eletronico.aceitar(new FreteVisitor()), 0.001);
    }

    @Test
    void deveCalcularFreteDeAlimento() {
        Alimento alimento = new Alimento("Café", 40.0);

        assertEquals(8.0, alimento.aceitar(new FreteVisitor()), 0.001);
    }

    @Test
    void deveSomarFreteDeVariosProdutos() {
        Produto[] produtos = {
                new Livro("Java Básico", 100.0),
                new Eletronico("Fone", 200.0),
                new Alimento("Café", 40.0)
        };
        Visitor frete = new FreteVisitor();

        double total = 0;
        for (Produto produto : produtos) {
            total += produto.aceitar(frete);
        }

        assertEquals(42.0, total, 0.001);
    }
}