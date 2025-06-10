import java.util.*;

public class Hospital{
    private Map<String, Paciente> pacientesTotales;
    private PriorityQueue<Paciente> colaAtencion;
    private Map<String, AreaAtencion> areasAtencion;
    private List<Paciente> pacientesAtendidos;

    public Hospital(){
        this.pacientesTotales=new HashMap<>();
        this.colaAtencion=new PriorityQueue<>();
        this.areasAtencion=new HashMap<>();
        this.pacientesAtendidos=new ArrayList<>();
    }

    public int getTotalPacientesAtendidos() {
    return pacientesAtendidos.size();
}

    public void registrarPaciente(Paciente p){
        pacientesTotales.put(p.getId(),p);
        colaAtencion.offer(p);
    }

    public void reasignarCategoria(String id,int nuevaCategoria){
        Paciente p =pacientesTotales.get(id);
        if (p !=null){
            p.setCategoria(nuevaCategoria);
            p.registrarCambio("Categoría reasignada a "+nuevaCategoria);
        }
    }

    public Paciente atenderSiguiente(){
        Paciente siguiente=colaAtencion.poll();
        if (siguiente!=null) {
            siguiente.setEstado("atendido");
            pacientesAtendidos.add(siguiente);
        }
        return siguiente;
    }

    public List<Paciente> obtenerPacientesPorCategoria(int categoria){
        List<Paciente> lista = new ArrayList<>();
        for (Paciente p : colaAtencion){
            if (p.getCategoria() ==categoria){
                lista.add(p);
            }
        }
        return lista;
    }

    public AreaAtencion obtenerArea(String nombre){
        return areasAtencion.get(nombre);
    }

    public void agregarArea(AreaAtencion area){
        areasAtencion.put(area.getNombre(), area);
    }
}