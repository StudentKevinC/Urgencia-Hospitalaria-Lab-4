import java.io.FileWriter;
import java.io.IOException;

public class GeneradorPacientes{
    private static final String[] nombres={"Juan","Valentina","Pedro","Javiera","Nicolas","Sofia","Carlos","Lucia"};
    private static final String[] apellidos={"Cornejo","Rodrguez","Perez","Sanchez","Ramirez","Torres","Flores","Vargas"};
    private static final String[] areas={"SAPU","urgencia_adulto","urgencia_infantil"};

    public static void generarPacientes(int cantidad, String archivoSalida){
        try (FileWriter writer=new FileWriter(archivoSalida)){
            long tiempoBase=0;
            for (int i =0; i<cantidad;i++){
                String nombre = nombres[i % nombres.length];
                String apellido = apellidos[i % apellidos.length];
                String id ="P" +(i + 1);
                int categoria = asignarCategoria(i);
                String area= areas[i % areas.length];
                writer.write(nombre +","+ apellido +"," + id+ ","+ categoria +"," +tiempoBase+ "," +area +"\n") ;
                tiempoBase += 600;
            }
        } catch (IOException e){
                e.printStackTrace();
            }
    }

    private static int asignarCategoria(int i){
        int mod=i % 100;
        if (mod<10) return 1 ;          // 10%
        else if (mod<25) return 2;     // 15%
        else if (mod<43) return 3;    // 18%
        else if (mod<70) return 4;   // 27%
        else return 5;              // 30%
    }
}