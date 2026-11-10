public class Alimento extends Produto {

    public Alimento(String nome, double preco) {
        super(nome, preco);
    }

    @Override
    public double aceitar(Visitor visitor) {
        validarVisitor(visitor);
        return visitor.visitarAlimento(this);
    }
}