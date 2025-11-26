package actions;

public class DecisaoFactory {
    public static DecisaoStrategy getDecisao(String tipo) {
        return switch(tipo) {
            case "Marketing" -> new MarketingStrategy();
            case "Equipe" -> new EquipeStrategy();
            case "Produto" -> new ProdutoStrategy();
            case "Investidores" -> new InvestidoresStrategy();
            case "CortarCustos" -> new CortarCustosStrategy();
            default -> throw new IllegalArgumentException("Decisão desconhecida: " + tipo);
        };
    }
}
