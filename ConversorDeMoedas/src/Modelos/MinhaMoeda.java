package Modelos;

public class MinhaMoeda {

        private String moedaInicio;
        private String moedaFinal;
        private String resultadoConversao;
        private String taxaDeConversao;

        public MinhaMoeda(LeituraApi moeda) {
            this.moedaInicio = moeda.base_code();
            this.moedaFinal = moeda.target_code();
            this.resultadoConversao = moeda.conversion_result();
            this.taxaDeConversao = moeda.conversion_rate();
        }

        public String getMoedaInicio() {
            return moedaInicio;
        }

        public String getMoedaFinal() {
            return moedaFinal;
        }

        public String getResultadoConversao() {
            return resultadoConversao;
        }

        public String getTaxaDeConversao() {
            return taxaDeConversao;
        }

        @Override
        public String toString() {
            return "Modelos.Moeda Início: " + moedaInicio + ", Modelos.Moeda Final: " + moedaFinal + ", Resultado da conversão: " + resultadoConversao;
        }
    }

