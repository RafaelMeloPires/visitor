public abstract class Produto {

    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        setNome(nome);
        setPreco(preco);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome inválido");
        }
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco < 0) {
            throw new IllegalArgumentException("Preço não pode ser negativo");
        }
        this.preco = preco;
    }

    public abstract double aceitar(Visitor visitor);

    protected void validarVisitor(Visitor visitor) {
        if (visitor == null) {
            throw new IllegalArgumentException("Visitor não pode ser nulo");
        }
    }
}