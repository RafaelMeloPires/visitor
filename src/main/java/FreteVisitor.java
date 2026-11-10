public class FreteVisitor implements Visitor {

    @Override
    public double visitarLivro(Livro livro) {
        return 10.0;
    }

    @Override
    public double visitarEletronico(Eletronico eletronico) {
        return 20.0 + eletronico.getPreco() * 0.02;
    }

    @Override
    public double visitarAlimento(Alimento alimento) {
        return 8.0;
    }
}