public interface Visitor {

    double visitarLivro(Livro livro);

    double visitarEletronico(Eletronico eletronico);

    double visitarAlimento(Alimento alimento);

}