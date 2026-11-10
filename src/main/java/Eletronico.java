public class Eletronico extends Produto {

    public Eletronico(String nome, double preco) {
        super(nome, preco);
    }

    @Override
    public double aceitar(Visitor visitor) {
        validarVisitor(visitor);
        return visitor.visitarEletronico(this);
    }
}