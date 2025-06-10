public class SimuladorUrgencia{
    private Hospital hospital;

    public SimuladorUrgencia(Hospital hospital){
        this.hospital=hospital;
    }

    public void simular(int pacientesPorDia){
        long tiempoActual= 0;

        for (int i =0;i<pacientesPorDia; i++){
            tiempoActual=i*600;
            Paciente p = generarPacienteAleatorio(i, tiempoActual);
            hospital.registrarPaciente(p);

            if (tiempoActual %900 == 0 && i>0){
                Paciente atendido = hospital.atenderSiguiente();
                if (atendido != null) {
                    atendido.setEstado("atendido");
                }
            }

            if (i % 3 == 0 && i>0){
                for (int j=0; j<2;j++){
                    Paciente atendido = hospital.atenderSiguiente();
                    if (atendido !=null){
                        atendido.setEstado("atendido");
                    }
                    }
            }
        }
    }

    private Paciente generarPacienteAleatorio(int idSecuencial,long tiempoLlegada){
        String id="P"+idSecuencial;
        String nombre="Nombre"+idSecuencial;
        String apellido="Apellido"+idSecuencial;
        int categoria=asignarCategoriaAleatoria();
        String area="urgencia_adulto";
        return new Paciente(nombre,apellido, id, categoria,tiempoLlegada, area);
    }

    private int asignarCategoriaAleatoria(){
        double r = Math.random();
        if (r < 0.10) return 1;
        else if (r <0.25) return 2;
        else if (r <0.43) return 3;
        else if (r <0.70) return 4;
            else return 5;
    }
}