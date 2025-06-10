import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;

public class AreaAtencion{
    private String nombre;
    private PriorityQueue<Paciente> pacientesHeap;
    private int capacidadMaxima;

    public AreaAtencion(String nombre,int capacidadMaxima){
        this.nombre=nombre;
        this.capacidadMaxima=capacidadMaxima;
        this.pacientesHeap=new PriorityQueue<>();
    }

    public String getNombre(){
    return nombre;
    }

    public void ingresarPaciente(Paciente p){
        if (!estaSaturada()){
            pacientesHeap.offer(p);
        }
    }

    public Paciente atenderPaciente(){
        return pacientesHeap.poll();
    }

    public boolean estaSaturada(){
        return pacientesHeap.size()>=capacidadMaxima;
    }

    public List<Paciente> obtenerPacientesPorHeapSort(){
        List<Paciente> lista = new ArrayList<>(pacientesHeap);
        lista.sort(null);
        return lista;
    }
}
