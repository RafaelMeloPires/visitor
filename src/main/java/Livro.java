public class Livro extends Produto {

    public Livro(String nome, double preco) {
        super(nome, preco);
    }

    @Override
    public double aceitar(Visitor visitor) {
        validarVisitor(visitor);
        return visitor.visitarLivro(this);
    }
}