import java.util.Stack;
public class Paciente implements Comparable<Paciente>{
    private String nombre;
    private String apellido;
    private String id;
    private int categoria;
    private long tiempoLlegada;
    private String estado;
    private String area;
    private Stack<String> historialCambios;

    public Paciente(String nombre,String apellido,String id,int categoria,long tiempoLlegada,String area){
        this.nombre=nombre;
        this.apellido=apellido;
        this.id=id;
        this.categoria=categoria;
        this.tiempoLlegada=tiempoLlegada;
        this.estado="en_espera";
        this.area=area;
        this.historialCambios=new Stack<>();
    }

    public long tiempoEsperaActual(long tiempoActual){
        return (tiempoActual - this.tiempoLlegada)/60;
    }

    public void registrarCambio(String descripcion){
        historialCambios.push(descripcion);
    }

    public String obtenerUltimoCambio(){
        return historialCambios.isEmpty() ? null : historialCambios.pop();
    }

    public int getCategoria(){
        return categoria;
    }

    public long getTiempoLlegada(){
        return tiempoLlegada;
    }

    public String getId(){
        return id;
    }

    public void setCategoria(int nuevaCategoria){
        this.categoria=nuevaCategoria;
    }

    public void setEstado(String nuevoEstado){
        this.estado=nuevoEstado;
    }

    @Override
    public int compareTo(Paciente otro){
        if (this.categoria != otro.categoria){
            return Integer.compare(this.categoria,otro.categoria);
        } else {
            return Long.compare(this.tiempoLlegada,otro.tiempoLlegada);
        }
    }
}
