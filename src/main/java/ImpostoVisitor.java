public class ImpostoVisitor implements Visitor {

    @Override
    public double visitarLivro(Livro livro) {
        return 0.0;
    }

    @Override
    public double visitarEletronico(Eletronico eletronico) {
        return eletronico.getPreco() * 0.15;
    }

    @Override
    public double visitarAlimento(Alimento alimento) {
        return alimento.getPreco() * 0.05;
    }
}
