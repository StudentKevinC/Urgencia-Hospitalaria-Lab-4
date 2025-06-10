public class Main {
    public static void main(String[] args){
        Hospital hospital= new Hospital();
        SimuladorUrgencia simulador= new SimuladorUrgencia(hospital);

        simulador.simular(144);

        System.out.println("Simulación completada");
        System.out.println("Total de pacientes atendidos: " + hospital.getTotalPacientesAtendidos());
    }
}